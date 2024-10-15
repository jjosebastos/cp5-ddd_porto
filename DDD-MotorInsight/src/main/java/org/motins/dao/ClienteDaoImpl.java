package org.motins.dao;

import org.motins.config.DatabaseConfig;
import org.motins.entity.Cliente;
import org.motins.exception.ClienteDaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoImpl implements ClienteDao {
    private static ClienteDaoImpl instance;
    private final DatabaseConfig db;

    private ClienteDaoImpl(DatabaseConfig db) {
        this.db = db;
    }

    public static ClienteDaoImpl getInstance(DatabaseConfig db) {
        if (instance == null) {
            instance = new ClienteDaoImpl(db);
        }
        return instance;
    }

    @Override
    public void create(Cliente cliente) throws ClienteDaoException {
        String sql = "INSERT INTO T_CON_CLIENTE (id_cliente, tp_cliente, st_cliente) VALUES (?, ?, ?)";
        try (Connection connection = db.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, cliente.getIdCliente());
            pstmt.setString(2, cliente.getTipoCliente());
            pstmt.setString(3, cliente.getStatusCliente());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new ClienteDaoException("Erro ao criar o cliente: " + e.getMessage());
        }
    }

    @Override
    public List<Cliente> readAll() throws ClienteDaoException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM T_CON_CLIENTE";

        try (Connection connection = db.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String tipoCliente = rs.getString("tp_cliente");
                Cliente cliente;
                cliente = new Cliente(rs.getInt("id_cliente"), tipoCliente, rs.getString("st_cliente"));

                clientes.add(cliente);
            }
        } catch (SQLException e) {
            throw new ClienteDaoException("Erro ao ler os clientes: " + e.getMessage());
        }
        return clientes;
    }

    @Override
    public void update(Cliente cliente) throws ClienteDaoException {
        String sql = "UPDATE T_CON_CLIENTE SET tp_cliente = ?, st_cliente = ? WHERE id_cliente = ?";
        try (Connection connection = db.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, cliente.getTipoCliente());
            pstmt.setString(2, cliente.getStatusCliente());
            pstmt.setInt(3, cliente.getIdCliente());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new ClienteDaoException("Erro ao atualizar o cliente: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) throws ClienteDaoException {
        String sql = "DELETE FROM T_CON_CLIENTE WHERE id_cliente = ?";
        try (Connection connection = db.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new ClienteDaoException("Erro ao deletar o cliente: " + e.getMessage());
        }
    }
}
