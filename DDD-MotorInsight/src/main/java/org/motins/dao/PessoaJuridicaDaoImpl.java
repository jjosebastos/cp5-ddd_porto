package org.motins.dao;

import org.motins.config.DatabaseConfig;
import org.motins.dao.PessoaJuridicaDao;
import org.motins.entity.PessoaJuridica;
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

    // Implementação Singleton
    public static synchronized PessoaJuridicaDaoImpl getInstance(DatabaseConfig db) {
        if (instance == null) {
            instance = new PessoaJuridicaDaoImpl(db);
        }
        return instance;
    }

    @Override
    public void create(PessoaJuridica pessoaJuridica) throws PessoaJuridicaDaoException {
        String sqlCliente = "INSERT INTO T_CON_CLIENTE (id_cliente, tp_cliente, st_cliente) VALUES (?, ?, ?)";
        String sqlPessoaJuridica = "INSERT INTO T_CON_PESSOA_JURIDICA (id_cliente, nr_cnpj, nm_razao_social, nm_fantasia) VALUES (?, ?, ?, ?)";

        try (Connection connection = db.getConnection()) {
            connection.setAutoCommit(false);  // Início da transação

            // Inserindo dados na tabela T_CON_CLIENTE
            try (PreparedStatement pstmtCliente = connection.prepareStatement(sqlCliente)) {
                pstmtCliente.setInt(1, pessoaJuridica.getIdCliente());
                pstmtCliente.setString(2, "PJ"); // Definindo o tipo como 'PJ'
                pstmtCliente.setString(3, pessoaJuridica.getStatusCliente());
                pstmtCliente.executeUpdate();
            }

            // Inserindo dados na tabela T_CON_PESSOA_JURIDICA
            try (PreparedStatement pstmtPessoaJuridica = connection.prepareStatement(sqlPessoaJuridica)) {
                pstmtPessoaJuridica.setInt(1, pessoaJuridica.getIdCliente());
                pstmtPessoaJuridica.setString(2, pessoaJuridica.getCnpj());
                pstmtPessoaJuridica.setString(3, pessoaJuridica.getRazaoSocial());
                pstmtPessoaJuridica.setString(4, pessoaJuridica.getNomeFantasia());
                pstmtPessoaJuridica.executeUpdate();
            }

            connection.commit();  // Finaliza a transação

        } catch (SQLException e) {
            throw new PessoaJuridicaDaoException("Erro ao criar a pessoa jurídica: " + e.getMessage(), e);
        }
    }

    @Override
    public List<PessoaJuridica> readAll() throws PessoaJuridicaDaoException {
        List<PessoaJuridica> pessoas = new ArrayList<>();
        String sql = "SELECT pj.id_cliente, c.tp_cliente, c.st_cliente, pj.nr_cnpj, pj.nm_razao_social, pj.nm_fantasia " +
                "FROM T_CON_PESSOA_JURIDICA pj " +
                "JOIN T_CON_CLIENTE c ON pj.id_cliente = c.id_cliente";

        try (Connection connection = db.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                pessoas.add(new PessoaJuridica(
                        rs.getInt("id_cliente"),
                        rs.getString("tp_cliente"),
                        rs.getString("st_cliente"),
                        rs.getString("nr_cnpj"),
                        rs.getString("nm_razao_social"),
                        rs.getString("nm_fantasia"),
                        null  // Não temos o campo inscrição estadual na tabela
                ));
            }
        } catch (SQLException e) {
            throw new PessoaJuridicaDaoException("Erro ao ler as pessoas jurídicas: " + e.getMessage(), e);
        }
        return pessoas;
    }


    @Override
    public void update(PessoaJuridica pessoaJuridica) throws PessoaJuridicaDaoException {
        String sqlCliente = "UPDATE T_CON_CLIENTE SET st_cliente = ? WHERE id_cliente = ?";
        String sqlPessoaJuridica = "UPDATE T_CON_PESSOA_JURIDICA SET nr_cnpj = ?, nm_razao_social = ?, nm_fantasia = ? WHERE id_cliente = ?";

        try (Connection connection = db.getConnection()) {
            connection.setAutoCommit(false);  // Início da transação

            // Atualizando dados na tabela T_CON_CLIENTE
            try (PreparedStatement pstmtCliente = connection.prepareStatement(sqlCliente)) {
                pstmtCliente.setString(1, pessoaJuridica.getStatusCliente());
                pstmtCliente.setInt(2, pessoaJuridica.getIdCliente());
                pstmtCliente.executeUpdate();
            }

            // Atualizando dados na tabela T_CON_PESSOA_JURIDICA
            try (PreparedStatement pstmtPessoaJuridica = connection.prepareStatement(sqlPessoaJuridica)) {
                pstmtPessoaJuridica.setString(1, pessoaJuridica.getCnpj());
                pstmtPessoaJuridica.setString(2, pessoaJuridica.getRazaoSocial());
                pstmtPessoaJuridica.setString(3, pessoaJuridica.getNomeFantasia());
                pstmtPessoaJuridica.setInt(4, pessoaJuridica.getIdCliente());
                pstmtPessoaJuridica.executeUpdate();
            }

            connection.commit();  // Finaliza a transação

        } catch (SQLException e) {
            throw new PessoaJuridicaDaoException("Erro ao atualizar a pessoa jurídica: " + e.getMessage(), e);
        }
    }

    @Override
    public void delete(int id) throws PessoaJuridicaDaoException {
        String sqlPessoaJuridica = "DELETE FROM T_CON_PESSOA_JURIDICA WHERE id_cliente = ?";
        String sqlCliente = "DELETE FROM T_CON_CLIENTE WHERE id_cliente = ?";

        try (Connection connection = db.getConnection()) {
            connection.setAutoCommit(false);  // Início da transação

            // Deletando dados da tabela T_CON_PESSOA_JURIDICA
            try (PreparedStatement pstmtPessoaJuridica = connection.prepareStatement(sqlPessoaJuridica)) {
                pstmtPessoaJuridica.setInt(1, id);
                pstmtPessoaJuridica.executeUpdate();
            }

            // Deletando dados da tabela T_CON_CLIENTE
            try (PreparedStatement pstmtCliente = connection.prepareStatement(sqlCliente)) {
                pstmtCliente.setInt(1, id);
                pstmtCliente.executeUpdate();
            }

            connection.commit();  // Finaliza a transação

        } catch (SQLException e) {
            throw new PessoaJuridicaDaoException("Erro ao deletar a pessoa jurídica: " + e.getMessage(), e);
        }
    }
}
