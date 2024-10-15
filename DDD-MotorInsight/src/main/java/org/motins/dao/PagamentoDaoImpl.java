package org.motins.dao;

import org.motins.config.DatabaseConfig;
import org.motins.entity.Pagamento;
import org.motins.exception.dao.PagamentoDaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PagamentoDaoImpl implements PagamentoDao {
    private static PagamentoDaoImpl instance; // Singleton instance
    private final DatabaseConfig db;

    // Construtor privado para impedir instância externa
    private PagamentoDaoImpl(DatabaseConfig db) {
        this.db = db;
    }

    // Método para obter a única instância do DAO
    public static synchronized PagamentoDaoImpl getInstance(DatabaseConfig db) {
        if (instance == null) {
            instance = new PagamentoDaoImpl(db);
        }
        return instance;
    }

    @Override
    public void create(Pagamento pagamento) throws PagamentoDaoException {
        String sql = "INSERT INTO T_CON_PAGAMENTO (ID_PAGAMENTO, DT_PAGAMENTO, VL_PAGAMENTO, ST_PAGAMENTO, " +
                "ID_CLIENTE, ID_SEGURADORA, ID_AUTORIZADA, TP_PAGAMENTO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = db.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            connection.setAutoCommit(false);

            pstmt.setInt(1, pagamento.getIdPagamento());
            pstmt.setDate(2, Date.valueOf(pagamento.getDataPagamento()));
            pstmt.setDouble(3, pagamento.getValor());
            pstmt.setString(4, pagamento.getStatus());
            pstmt.setInt(5, pagamento.getIdCliente());

            if (pagamento.getIdSeguradora() != null) {
                pstmt.setInt(6, pagamento.getIdSeguradora());
            } else {
                pstmt.setNull(6, Types.INTEGER);
            }

            if (pagamento.getIdAutorizada() != null) {
                pstmt.setInt(7, pagamento.getIdAutorizada());
            } else {
                pstmt.setNull(7, Types.INTEGER);
            }

            pstmt.setString(8, pagamento.getTipoPagamento());

            pstmt.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new PagamentoDaoException("Erro ao inserir dados na tabela T_CON_PAGAMENTO");
        }
    }

    @Override
    public List<Pagamento> readAll() throws PagamentoDaoException {
        List<Pagamento> result = new ArrayList<>();
        String sql = "SELECT * FROM T_CON_PAGAMENTO";

        try (Connection connection = db.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                result.add(new Pagamento(
                        rs.getInt("ID_PAGAMENTO"),
                        rs.getDate("DT_PAGAMENTO").toLocalDate(),
                        rs.getDouble("VL_PAGAMENTO"),
                        rs.getString("ST_PAGAMENTO"),
                        rs.getInt("ID_CLIENTE"),
                        rs.getObject("ID_SEGURADORA", Integer.class),
                        rs.getObject("ID_AUTORIZADA", Integer.class),
                        rs.getString("TP_PAGAMENTO")
                ));
            }
        } catch (SQLException e) {
            throw new PagamentoDaoException("Erro ao consultar dados na tabela T_CON_PAGAMENTO");
        }
        return result;
    }

    @Override
    public void update(Pagamento pagamento) throws PagamentoDaoException {
        String sql = "UPDATE T_CON_PAGAMENTO SET DT_PAGAMENTO = ?, VL_PAGAMENTO = ?, ST_PAGAMENTO = ?, " +
                "ID_CLIENTE = ?, ID_SEGURADORA = ?, ID_AUTORIZADA = ?, TP_PAGAMENTO = ? WHERE ID_PAGAMENTO = ?";
        try (Connection connection = db.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            connection.setAutoCommit(false);

            pstmt.setDate(1, Date.valueOf(pagamento.getDataPagamento()));
            pstmt.setDouble(2, pagamento.getValor());
            pstmt.setString(3, pagamento.getStatus());
            pstmt.setInt(4, pagamento.getIdCliente());

            if (pagamento.getIdSeguradora() != null) {
                pstmt.setInt(5, pagamento.getIdSeguradora());
            } else {
                pstmt.setNull(5, Types.INTEGER);
            }

            if (pagamento.getIdAutorizada() != null) {
                pstmt.setInt(6, pagamento.getIdAutorizada());
            } else {
                pstmt.setNull(6, Types.INTEGER);
            }

            pstmt.setString(7, pagamento.getTipoPagamento());
            pstmt.setInt(8, pagamento.getIdPagamento());

            pstmt.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new PagamentoDaoException("Erro ao atualizar dados na tabela T_CON_PAGAMENTO");
        }
    }

    @Override
    public void delete(int id) throws PagamentoDaoException {
        String sql = "DELETE FROM T_CON_PAGAMENTO WHERE ID_PAGAMENTO = ?";
        try (Connection connection = db.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            connection.setAutoCommit(false);

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            throw new PagamentoDaoException("Erro ao excluir dados na tabela T_CON_PAGAMENTO");
        }
    }
}

