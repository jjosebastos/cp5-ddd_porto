package org.motins.dao;

import config.DatabaseConfig;
import entity.PessoaFisica;
import org.motins.exception.PessoaFisicaDaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaDaoImpl implements PessoaFisicaDao {
    private final DatabaseConfig db;

    public PessoaFisicaDaoImpl() {
        this.db = DatabaseConfig.getInstance();
    }

    @Override
    public void create(PessoaFisica pessoaFisica) throws PessoaFisicaDaoException {
        String sql = "INSERT INTO T_CON_PESSOA_FISICA (id_cliente, nm_cliente, dt_nascimento, nr_cpf, ds_genero) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = db.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, pessoaFisica.getIdCliente());
            pstmt.setString(2, pessoaFisica.getNome());
            pstmt.setDate(3, Date.valueOf(pessoaFisica.getDataNascimento()));
            pstmt.setString(4, pessoaFisica.getCpf());
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

            while (rs.next()) {
                pessoas.add(new PessoaFisica(
                        rs.getInt("id_cliente"),
                        rs.getString("nm_cliente"),
                        rs.getDate("dt_nascimento").toLocalDate(),
                        rs.getString("nr_cpf"),
                        rs.getString("ds_genero")
                ));
            }
        } catch (SQLException e) {
            throw new PessoaFisicaDaoException("Erro ao ler as pessoas físicas: " + e.getMessage(), e);
        }
        return pessoas;
    }

    @Override
    public PessoaFisica readById(int id) throws PessoaFisicaDaoException {
        String sql = "SELECT * FROM T_CON_PESSOA_FISICA WHERE id_cliente = ?";
        try (Connection connection = db.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new PessoaFisica(
                        rs.getInt("id_cliente"),
                        rs.getString("nm_cliente"),
                        rs.getDate("dt_nascimento").toLocalDate(),
                        rs.getString("nr_cpf"),
                        rs.getString("ds_genero")
                );
            }
        } catch (SQLException e) {
            throw new PessoaFisicaDaoException("Erro ao ler a pessoa física: " + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public void update(PessoaFisica pessoaFisica) throws PessoaFisicaDaoException {
        String sql = "UPDATE T_CON_PESSOA_FISICA SET nm_cliente = ?, dt_nascimento = ?, nr_cpf = ?, ds_genero = ? WHERE id_cliente = ?";
        try (Connection connection = db.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, pessoaFisica.getNome());
            pstmt.setDate(2, Date.valueOf(pessoaFisica.getDataNascimento()));
            pstmt.setString(3, pessoaFisica.getCpf());
            pstmt.setString(4, pessoaFisica.getGenero());
            pstmt.setInt(5, pessoaFisica.getIdCliente());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new PessoaFisicaDaoException("Erro ao atualizar a pessoa física: " + e.getMessage(), e);
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
            throw new PessoaFisicaDaoException("Erro ao deletar a pessoa física: " + e.getMessage(), e);
        }
    }
}

