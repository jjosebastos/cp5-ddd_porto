package org.motins.dao;

import org.motins.config.DatabaseConfig;
import org.motins.entity.HistoricoVeiculo;
import org.motins.exception.dao.HistoricoVeiculoDaoException;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HistoricoVeiculoDaoImpl implements HistoricoVeiculoDao {
    private final DatabaseConfig db;
    private static HistoricoVeiculoDaoImpl instance;

    private HistoricoVeiculoDaoImpl(DatabaseConfig db) {
        this.db = db;
    }

    public static HistoricoVeiculoDaoImpl getInstance(DatabaseConfig db) {
        if (instance == null) {
            instance = new HistoricoVeiculoDaoImpl(db);
        }
        return instance;
    }

    @Override
    public void create(HistoricoVeiculo historicoVeiculo) throws HistoricoVeiculoDaoException {
        String sql = "INSERT INTO T_CON_HISTORICO_VEICULO (ID_HISTORICO, DT_AQUISICAO, DT_VENDA, ID_CLIENTE, ID_VEICULO) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = db.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, historicoVeiculo.getIdHistorico());
            pstmt.setDate(2, Date.valueOf(historicoVeiculo.getDataAquisicao()));
            pstmt.setDate(3, historicoVeiculo.getDataVenda() != null ? Date.valueOf(historicoVeiculo.getDataVenda()) : null);
            pstmt.setObject(4, historicoVeiculo.getIdCliente(), Types.INTEGER);
            pstmt.setObject(5, historicoVeiculo.getIdVeiculo(), Types.INTEGER);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new HistoricoVeiculoDaoException("Erro ao inserir o histórico do veículo: " + e.getMessage());
        }
    }

    @Override
    public List<HistoricoVeiculo> readAll() throws HistoricoVeiculoDaoException {
        List<HistoricoVeiculo> result = new ArrayList<>();
        String sql = "SELECT * FROM T_CON_HISTORICO_VEICULO";

        try (Connection connection = db.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int idHistorico = rs.getInt("ID_HISTORICO");
                LocalDate dataAquisicao = rs.getDate("DT_AQUISICAO").toLocalDate();
                LocalDate dataVenda = rs.getDate("DT_VENDA") != null ? rs.getDate("DT_VENDA").toLocalDate() : null;
                Integer idCliente = rs.getObject("ID_CLIENTE", Integer.class);
                Integer idVeiculo = rs.getObject("ID_VEICULO", Integer.class);

                result.add(new HistoricoVeiculo(idHistorico, dataAquisicao, dataVenda, idCliente, idVeiculo));
            }
        } catch (SQLException e) {
            throw new HistoricoVeiculoDaoException("Erro ao ler os históricos de veículos: " + e.getMessage());
        }

        return result;
    }

    @Override
    public void update(HistoricoVeiculo historicoVeiculo) throws HistoricoVeiculoDaoException {
        String sql = "UPDATE T_CON_HISTORICO_VEICULO SET DT_AQUISICAO = ?, DT_VENDA = ?, ID_CLIENTE = ?, ID_VEICULO = ? WHERE ID_HISTORICO = ?";

        try (Connection connection = db.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setDate(1, Date.valueOf(historicoVeiculo.getDataAquisicao()));
            pstmt.setDate(2, historicoVeiculo.getDataVenda() != null ? Date.valueOf(historicoVeiculo.getDataVenda()) : null);
            pstmt.setObject(3, historicoVeiculo.getIdCliente(), Types.INTEGER);
            pstmt.setObject(4, historicoVeiculo.getIdVeiculo(), Types.INTEGER);
            pstmt.setInt(5, historicoVeiculo.getIdHistorico());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new HistoricoVeiculoDaoException("Erro ao atualizar o histórico do veículo: " + e.getMessage());
        }
    }

    @Override
    public void delete(int idHistorico) throws HistoricoVeiculoDaoException {
        String sql = "DELETE FROM T_CON_HISTORICO_VEICULO WHERE ID_HISTORICO = ?";

        try (Connection connection = db.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, idHistorico);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new HistoricoVeiculoDaoException("Erro ao excluir o histórico do veículo: " + e.getMessage());
        }
    }
}