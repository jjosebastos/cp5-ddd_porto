package org.motins.dao;

import config.DatabaseConfig;
import entity.PessoaJuridica;
import org.motins.exception.PessoaJuridicaDaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaDaoImpl implements PessoaJuridicaDao {
    private static PessoaJuridicaDaoImpl instance;

    private final DatabaseConfig db;

    private PessoaJuridicaDaoImpl(DatabaseConfig db) {
        this.db = db;
    }

    public static synchronized PessoaJuridicaDaoImpl getInstance(DatabaseConfig db) {
        if (instance == null) {
            instance = new PessoaJuridicaDaoImpl(db);
        }
        return instance;
    }

    @Override
    public void create(PessoaJuridica pessoaJuridica) throws PessoaJuridicaDaoException {
        String sql = "INSERT INTO T_CON_PESSOA_JURIDICA (id_cliente, nm_cliente, nr_cnpj, ds_tipo) VALUES (?, ?, ?, ?)";
        try (Connection connection = db.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, pessoaJuridica.getIdCliente());
            pstmt.setString(2, pessoaJuridica.getNome());
            pstmt.setString(3, pessoaJuridica.getCnpj());
            pstmt.setString(4, pessoaJuridica.getTipo());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new PessoaJuridicaDaoException("Erro ao criar a pessoa jurídica: " + e.getMessage(), e);
        }
    }

    @Override
    public List<PessoaJuridica> readAll() throws PessoaJuridicaDaoException {
        List<PessoaJuridica> pessoas = new ArrayList<>();
        String sql = "SELECT * FROM T_CON_PESSOA_JURIDICA";

        try (Connection connection = db.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                pessoas.add(new PessoaJuridica(
                        rs.getInt("id_cliente"),
                        rs.getString("nm_cliente"),
                        rs.getString("nr_cnpj"),
                        rs.getString("ds_tipo")
                ));
            }
        } catch (SQLException e) {
            throw new PessoaJuridicaDaoException("Erro ao ler as pessoas jurídicas: " + e.getMessage(), e);
        }
        return pessoas;
    }

    @Override
    public PessoaJuridica readById(int id) throws PessoaJuridicaDaoException {
        String sql = "SELECT * FROM T_CON_PESSOA_JURIDICA WHERE id_cliente = ?";
        try (Connection connection = db.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new PessoaJuridica(
                        rs.getInt("id_cliente"),
                        rs.getString("nm_cliente"),
                        rs.getString("nr_cnpj"),
                        rs.getString("ds_tipo")
                );
            }
        } catch (SQLException e) {
            throw new PessoaJuridicaDaoException("Erro ao ler a pessoa jurídica: " + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public void update(PessoaJuridica pessoaJuridica) throws PessoaJuridicaDaoException {
        String sql = "UPDATE T_CON_PESSOA_JURIDICA SET nm_cliente = ?, nr_cnpj = ?, ds_tipo = ? WHERE id_cliente = ?";
        try (Connection connection = db.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, pessoaJuridica.getNome());
            pstmt.setString(2, pessoaJuridica.getCnpj());
            pstmt.setString(3, pessoaJuridica.getTipo());
            pstmt.setInt(4, pessoaJuridica.getIdCliente());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new PessoaJuridicaDaoException("Erro ao atualizar a pessoa jurídica: " + e.getMessage(), e);
        }
    }

    @Override
    public void delete(int id) throws PessoaJuridicaDaoException {
        String sql = "DELETE FROM T_CON_PESSOA_JURIDICA WHERE id_cliente = ?";
        try (Connection connection = db.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new PessoaJuridicaDaoException("Erro ao deletar a pessoa jurídica: " + e.getMessage(), e);
        }
    }
}

