package org.motins.dao;

import org.motins.config.DatabaseConfig;
import org.motins.entity.factoryEndereco.Endereco;
import org.motins.exception.dao.EnderecoDaoException;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDaoImpl implements EnderecoDao {
    private final DatabaseConfig db;
    private static EnderecoDaoImpl instance;
    private EnderecoDaoImpl(DatabaseConfig db) {
        this.db = db;
    }

    public static EnderecoDaoImpl getInstance(DatabaseConfig db) {
        if (instance == null) {
            instance = new EnderecoDaoImpl(db);
        }
        return instance;
    }

    @Override
    public void create(Endereco endereco) throws EnderecoDaoException {
        String sql = "INSERT INTO ENDERECO (D_ENDERECO, NM_RUA, NR_ENDERECO, NM_BAIRRO, NM_CIDADE, SG_UNIDADE_FEDERATIVA, DS_COMPLEMENTO, ID_CLIENTE, ID_SEGURADORA, ID_AUTORIZADA, CEP) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = db.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            connection.setAutoCommit(false); // Inicia a transação

            pstmt.setInt(1, endereco.getIdEndereco());
            pstmt.setString(2, endereco.getRua());
            pstmt.setString(3, endereco.getNumeroEndereco());
            pstmt.setString(4, endereco.getBairro());
            pstmt.setString(5, endereco.getCidade());
            pstmt.setString(6, endereco.getUf());
            pstmt.setString(7, endereco.getCep());
            pstmt.setString(8, endereco.getComplemento());
            pstmt.setObject(9, endereco.getIdCliente(), Types.INTEGER);
            pstmt.setObject(10, endereco.getIdSeguradora(), Types.INTEGER);
            pstmt.setObject(11, endereco.getIdAutorizada(), Types.INTEGER);


            pstmt.executeUpdate();
            connection.commit(); // Confirma a transação

        } catch (SQLException e) {
            throw new EnderecoDaoException("Erro ao inserir o endereço: " + e.getMessage());
        }
    }

    @Override
    public List<Endereco> readAll() throws EnderecoDaoException {
        List<Endereco> result = new ArrayList<>();
        String sql = "SELECT * FROM ENDERECO";

        try (Connection connection = db.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                result.add(new Endereco(
                        rs.getInt("ID_ENDERECO"),
                        rs.getString("NM_RUA"),
                        rs.getString("NR_ENDERECO"),
                        rs.getString("NM_BAIRRO"),
                        rs.getString("NM_CIDADE"),
                        rs.getString("SG_UF"),
                        rs.getString("CEP"),
                        rs.getString("DS_COMPLEMENTO"),
                        rs.getInt("ID_CLIENTE"),
                        rs.getInt("ID_SEGURADORA"),
                        rs.getInt("ID_AUTORIZADA")

                ));
            }
        } catch (SQLException e) {
            throw new EnderecoDaoException("Erro ao ler os endereços: " + e.getMessage());
        }

        return result;
    }

    @Override
    public void update(Endereco endereco) throws EnderecoDaoException {
        String sql = "UPDATE ENDERECO SET NM_RUA = ?, NR_ENDERECO = ?, NM_BAIRRO = ?, NM_CIDADE = ?, SG_UNIDADE_FEDERATIVA = ?, DS_COMPLEMENTO = ?, ID_CLIENTE = ?, ID_SEGURADORA = ?, ID_AUTORIZADA = ?, CEP = ? WHERE D_ENDERECO = ?";

        try (Connection connection = db.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            connection.setAutoCommit(false); // Inicia a transação

            pstmt.setString(1, endereco.getRua());
            pstmt.setString(2, endereco.getNumeroEndereco());
            pstmt.setString(3, endereco.getBairro());
            pstmt.setString(4, endereco.getCidade());
            pstmt.setString(5, endereco.getUf());
            pstmt.setString(6, endereco.getCep());
            pstmt.setString(7, endereco.getComplemento());
            pstmt.setObject(8, endereco.getIdCliente(), Types.INTEGER);
            pstmt.setObject(9, endereco.getIdSeguradora(), Types.INTEGER);
            pstmt.setObject(10, endereco.getIdAutorizada(), Types.INTEGER);
            pstmt.setString(11, endereco.getCep());
            pstmt.setInt(12, endereco.getIdEndereco());

            pstmt.executeUpdate();
            connection.commit(); // Confirma a transação

        } catch (SQLException e) {
            throw new EnderecoDaoException("Erro ao atualizar o endereço: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) throws EnderecoDaoException {
        String sql = "DELETE FROM ENDERECO WHERE D_ENDERECO = ?";

        try (Connection connection = db.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new EnderecoDaoException("Erro ao excluir o endereço: " + e.getMessage());
        }
    }
}
