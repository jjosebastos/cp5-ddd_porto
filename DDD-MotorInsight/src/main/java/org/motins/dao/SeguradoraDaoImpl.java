package org.motins.dao;

import org.motins.config.DatabaseConfig;
import org.motins.entity.Seguradora;
import org.motins.exception.SeguradoraDaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeguradoraDaoImpl implements SeguradoraDao {
    private static SeguradoraDaoImpl instance;
    private final DatabaseConfig db;

    private SeguradoraDaoImpl(DatabaseConfig db) {
        this.db = db;
    }

    public static synchronized SeguradoraDaoImpl getInstance(DatabaseConfig db) {
        if (instance == null) {
            instance = new SeguradoraDaoImpl(db);
        }
        return instance;
    }

    @Override
    public void create(Seguradora seguradora) throws SeguradoraDaoException {
        String sql = "INSERT INTO T_CON_SEGURADORA (ID_SEGURADORA, NM_SEGURADORA, NR_CNPJ, ID_VEICULO) VALUES (?, ?, ?, ?)";
        try (Connection connection = db.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            connection.setAutoCommit(false);
            pstmt.setInt(1, seguradora.getIdSeguradora());
            pstmt.setString(2, seguradora.getNome());
            pstmt.setString(3, seguradora.getCnpj());
            pstmt.setInt(4, seguradora.getIdVeiculo());
            pstmt.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new SeguradoraDaoException("Erro ao inserir dados na T_CON_SEGURADORA");
        }
    }

    @Override
    public List<Seguradora> readAll() throws SeguradoraDaoException {
        List<Seguradora> result = new ArrayList<>();
        String sql = "SELECT * FROM T_CON_SEGURADORA";

        try (Connection connection = db.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int idSeguradora = rs.getInt("ID_SEGURADORA");
                String nome = rs.getString("NM_SEGURADORA");
                String cnpj = rs.getString("NR_CNPJ");
                int idVeiculo = rs.getInt("ID_VEICULO");

                result.add(new Seguradora(idSeguradora, nome, cnpj, idVeiculo));
            }
        } catch (SQLException e) {
            throw new SeguradoraDaoException("Erro ao consultar dados na T_CON_SEGURADORA");
        }

        return result;
    }

    @Override
    public void update(Seguradora seguradora) throws SeguradoraDaoException {
        String sql = "UPDATE T_CON_SEGURADORA SET NM_SEGURADORA = ?, NR_CNPJ = ?, ID_VEICULO = ? WHERE ID_SEGURADORA = ?";
        try (Connection connection = db.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            connection.setAutoCommit(false);
            pstmt.setString(1, seguradora.getNome());
            pstmt.setString(2, seguradora.getCnpj());
            pstmt.setInt(3, seguradora.getIdVeiculo());
            pstmt.setInt(4, seguradora.getIdSeguradora());
            pstmt.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new SeguradoraDaoException("Erro ao atualizar dados na T_CON_SEGURADORA");
        }
    }

    @Override
    public void delete(int id) throws SeguradoraDaoException {
        String sql = "DELETE FROM T_CON_SEGURADORA WHERE ID_SEGURADORA = ?";
        try (Connection connection = db.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            connection.setAutoCommit(false);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new SeguradoraDaoException("Erro ao excluir dados da T_CON_SEGURADORA");
        }
    }
}
