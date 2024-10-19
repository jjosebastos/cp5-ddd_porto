package org.motins.dao.impl;

import org.motins.config.DatabaseConfig;
import org.motins.dao.interfaces.PessoaFisicaDao;
import org.motins.entity.cliente.PessoaFisica;
import org.motins.exception.dao.PessoaFisicaDaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaDaoImpl implements PessoaFisicaDao {

    private final DatabaseConfig db;
    private static PessoaFisicaDaoImpl instance;

    private PessoaFisicaDaoImpl(DatabaseConfig db) {
        this.db = db;
    }

    // Implementação Singleton
    public static synchronized PessoaFisicaDaoImpl getInstance(DatabaseConfig db) {
        if (instance == null) {
            instance = new PessoaFisicaDaoImpl(db);
        }
        return instance;
    }

    @Override
    public void create(PessoaFisica pessoaFisica) throws PessoaFisicaDaoException {
        String sql = "INSERT INTO T_CON_PESSOA_FISICA (id_cliente, nm_cliente, dt_nascimento, nr_cpf, ds_genero) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = db.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, pessoaFisica.getIdCliente());
            pstmt.setString(2, pessoaFisica.getNome());
            pstmt.setDate(3, Date.valueOf(pessoaFisica.getDataNascimento()));
            pstmt.setString(4, pessoaFisica.getNumeroCpf());
            pstmt.setString(5, pessoaFisica.getGenero());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new PessoaFisicaDaoException("Erro ao criar a pessoa física: " + e.getMessage(), e);
        }
    }

    @Override
    public List<PessoaFisica> readAll() throws PessoaFisicaDaoException {
        List<PessoaFisica> pessoas = new ArrayList<>();
        String sql = "SELECT * FROM T_CON_PESSOA_FISICA";

        try (Connection connection = db.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

//            while (rs.next()) {
//                pessoas.add(new PessoaFisica(
//                        rs.getInt("id_cliente"),
//                        rs.getString("nm_cliente"),
//                        rs.getDate("dt_nascimento").toLocalDate(),
//                        rs.getString("nr_cpf"),
//                        rs.getString("ds_genero")
//                ));
//            }
        } catch (SQLException e) {
            throw new PessoaFisicaDaoException("Erro ao ler as pessoas físicas: " + e.getMessage());
        }
        return pessoas;
    }



    @Override
    public void update(PessoaFisica pessoaFisica) throws PessoaFisicaDaoException {
        String sql = "UPDATE T_CON_PESSOA_FISICA SET nm_cliente = ?, dt_nascimento = ?, nr_cpf = ?, ds_genero = ? WHERE id_cliente = ?";
        try (Connection connection = db.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, pessoaFisica.getNome());
            pstmt.setDate(2, Date.valueOf(pessoaFisica.getDataNascimento()));
            pstmt.setString(3, pessoaFisica.getNumeroCpf());
            pstmt.setString(4, pessoaFisica.getGenero());
            pstmt.setInt(5, pessoaFisica.getIdCliente());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new PessoaFisicaDaoException("Erro ao atualizar a pessoa física: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) throws PessoaFisicaDaoException {
        String sql = "DELETE FROM T_CON_PESSOA_FISICA WHERE id_cliente = ?";
        try (Connection connection = db.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new PessoaFisicaDaoException("Erro ao deletar a pessoa física: " + e.getMessage());
        }
    }
}

