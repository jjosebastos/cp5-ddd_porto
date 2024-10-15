package org.motins.dao;

import org.motins.config.DatabaseConfig;
import org.motins.entity.Reparo;
import org.motins.exception.dao.ReparoDaoException;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReparoDaoImpl implements ReparoDao {
    private static ReparoDaoImpl instance;
    private final DatabaseConfig dbConfig;

    private ReparoDaoImpl(DatabaseConfig dbConfig) {
        this.dbConfig = dbConfig;
    }

    public static ReparoDaoImpl getInstance(DatabaseConfig dbConfig) {
        if (instance == null) {
            instance = new ReparoDaoImpl(dbConfig);
        }
        return instance;
    }

    @Override
    public void create(Reparo reparo) throws ReparoDaoException {
        String sql = "INSERT INTO T_CON_REPARO (id_reparo, dt_inicio_reparo, dt_fim_reparo, ds_servico, vl_servico, id_tecnico, id_orcamento) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = dbConfig.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, reparo.getIdReparo());
            pstmt.setDate(2, java.sql.Date.valueOf(reparo.getDataInicio()));
            pstmt.setDate(3, reparo.getDataFim() != null ? java.sql.Date.valueOf(reparo.getDataFim()) : null);
            pstmt.setString(4, reparo.getDescricao());
            pstmt.setDouble(5, reparo.getValorServico());
            pstmt.setInt(6, reparo.getIdTecnico());
            pstmt.setNull(7, Types.INTEGER); // Se id_orcamento for nulo

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new ReparoDaoException("Erro ao criar reparo");
        }
    }


    @Override
    public List<Reparo> readAll() throws ReparoDaoException {
        String sql = "SELECT * FROM T_CON_REPARO";
        List<Reparo> listaReparos = new ArrayList<>();
        try (Connection connection = dbConfig.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                listaReparos.add(mapResultSetToReparo(rs));
            }
        } catch (SQLException e) {
            throw new ReparoDaoException("Erro ao ler todos os reparos");
        }
        return listaReparos;
    }

    @Override
    public void update(Reparo reparo) throws ReparoDaoException {
        String sql = "UPDATE T_CON_REPARO SET dt_inicio_reparo = ?, dt_fim_reparo = ?, ds_servico = ?, vl_servico = ?, id_tecnico = ?, id_orcamento = ? WHERE id_reparo = ?";
        try (Connection connection = dbConfig.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setDate(1, java.sql.Date.valueOf(reparo.getDataInicio()));
            pstmt.setDate(2, reparo.getDataFim() != null ? java.sql.Date.valueOf(reparo.getDataFim()) : null);
            pstmt.setString(3, reparo.getDescricao());
            pstmt.setDouble(4, reparo.getValorServico());
            pstmt.setInt(5, reparo.getIdTecnico());
            pstmt.setNull(6, Types.INTEGER); // Se id_orcamento for nulo
            pstmt.setInt(7, reparo.getIdReparo());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new ReparoDaoException("Erro ao atualizar reparo");
        }
    }

    @Override
    public void delete(int idReparo) throws ReparoDaoException {
        String sql = "DELETE FROM T_CON_REPARO WHERE id_reparo = ?";
        try (Connection connection = dbConfig.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, idReparo);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new ReparoDaoException("Erro ao deletar reparo");
        }
    }

    private Reparo mapResultSetToReparo(ResultSet rs) throws SQLException {
        int idReparo = rs.getInt("id_reparo");
        LocalDate dataInicio = rs.getDate("dt_inicio_reparo").toLocalDate();
        LocalDate dataFim = rs.getDate("dt_fim_reparo") != null ? rs.getDate("dt_fim_reparo").toLocalDate() : null;
        String descricao = rs.getString("ds_servico");
        Double valorServico = rs.getDouble("vl_servico");
        Integer idTecnico = rs.getInt("id_tecnico");

        return new Reparo(idReparo, dataInicio, dataFim, descricao, valorServico, idTecnico);
    }
}
