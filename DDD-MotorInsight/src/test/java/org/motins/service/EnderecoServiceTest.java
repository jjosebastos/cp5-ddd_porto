package org.motins.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.motins.dao.EnderecoDao;
import org.motins.entity.factoryEndereco.Endereco;
import org.motins.exception.dao.EnderecoDaoException;
import org.motins.exception.service.EnderecoServiceException;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EnderecoServiceTest {

    @InjectMocks
    private EnderecoService enderecoService;

    @Mock
    private EnderecoDao enderecoDao;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateEnderecoSuccess() throws EnderecoDaoException, EnderecoServiceException {
        // Arrange
        Endereco endereco = new Endereco(1, "Rua Teste", "123", "Bairro Teste", "Cidade Teste", "SP", "12345-678", "Complemento Teste", 1, 1, 1);

        // Não faz nada quando create() é chamado no mock do Dao
        doNothing().when(enderecoDao).create(endereco);

        // Act
        enderecoService.create(endereco);

        // Assert
        verify(enderecoDao, times(1)).create(endereco); // Verifica que o método foi chamado uma vez
    }

    @Test
    public void testCreateEnderecoThrowsException() throws EnderecoDaoException {
        // Arrange
        Endereco endereco = new Endereco(1, "Rua Teste", "123", "Bairro Teste", "Cidade Teste", "SP", "12345-678", "Complemento Teste", 1, 1, 1);

        // Simula a exceção no mock do Dao
        doThrow(new EnderecoDaoException("Erro ao inserir o endereço")).when(enderecoDao).create(endereco);

        // Act & Assert
        EnderecoServiceException exception = assertThrows(EnderecoServiceException.class, () -> {
            enderecoService.create(endereco);
        });

        assertEquals("Não foi possivel criar em T_CON_ENDERECO", exception.getMessage());
        verify(enderecoDao, times(1)).create(endereco); // Verifica que o método foi chamado uma vez
    }

    @Test
    public void testListAllEnderecosSuccess() throws EnderecoDaoException, EnderecoServiceException, SQLException {
        // Arrange
        List<Endereco> enderecos = Arrays.asList(
                new Endereco(1, "Rua Teste 1", "123", "Bairro 1", "Cidade 1", "SP", "12345-678", "Complemento 1", 1, 1, 1),
                new Endereco(2, "Rua Teste 2", "456", "Bairro 2", "Cidade 2", "SP", "23456-789", "Complemento 2", 2, 2, 2)
        );

        when(enderecoDao.readAll()).thenReturn(enderecos);

        // Act
        List<Endereco> result = enderecoService.listAll();

        // Assert
        assertEquals(2, result.size());
        verify(enderecoDao, times(1)).readAll(); // Verifica que o método foi chamado uma vez
    }

    @Test
    public void testListAllEnderecosThrowsException() throws EnderecoDaoException, SQLException {
        // Arrange
        when(enderecoDao.readAll()).thenThrow(new EnderecoDaoException("Erro ao ler os endereços"));

        // Act & Assert
        EnderecoServiceException exception = assertThrows(EnderecoServiceException.class, () -> {
            enderecoService.listAll();
        });

        assertEquals("Não foi possivel listar em T_CON_ENDERECO", exception.getMessage());
        verify(enderecoDao, times(1)).readAll(); // Verifica que o método foi chamado uma vez
    }

    @Test
    public void testUpdateEnderecoSuccess() throws EnderecoDaoException, EnderecoServiceException {
        // Arrange
        Endereco endereco = new Endereco(1, "Rua Atualizada", "999", "Bairro Atualizado", "Cidade Atualizada", "SP", "99999-999", "Complemento Atualizado", 1, 1, 1);

        doNothing().when(enderecoDao).update(endereco);

        // Act
        enderecoService.update(endereco);

        // Assert
        verify(enderecoDao, times(1)).update(endereco); // Verifica que o método foi chamado uma vez
    }

    @Test
    public void testUpdateEnderecoThrowsException() throws EnderecoDaoException {
        // Arrange
        Endereco endereco = new Endereco(1, "Rua Atualizada", "999", "Bairro Atualizado", "Cidade Atualizada", "SP", "99999-999", "Complemento Atualizado", 1, 1, 1);

        doThrow(new EnderecoDaoException("Erro ao atualizar o endereço")).when(enderecoDao).update(endereco);

        // Act & Assert
        EnderecoServiceException exception = assertThrows(EnderecoServiceException.class, () -> {
            enderecoService.update(endereco);
        });

        assertEquals("Não foi possivel atualizar em T_CON_ENDERECO", exception.getMessage());
        verify(enderecoDao, times(1)).update(endereco); // Verifica que o método foi chamado uma vez
    }

    @Test
    public void testDeleteEnderecoSuccess() throws EnderecoDaoException, EnderecoServiceException {
        // Arrange
        int id = 1;
        doNothing().when(enderecoDao).delete(id);

        // Act
        enderecoService.delete(id);

        // Assert
        verify(enderecoDao, times(1)).delete(id); // Verifica que o método foi chamado uma vez
    }

    @Test
    public void testDeleteEnderecoThrowsException() throws EnderecoDaoException {
        // Arrange
        int id = 1;
        doThrow(new EnderecoDaoException("Erro ao excluir o endereço")).when(enderecoDao).delete(id);

        // Act & Assert
        EnderecoServiceException exception = assertThrows(EnderecoServiceException.class, () -> {
            enderecoService.delete(id);
        });

        assertEquals("Não foi possivel excluir em T_CON_ENDERECO", exception.getMessage());
        verify(enderecoDao, times(1)).delete(id); // Verifica que o método foi chamado uma vez
    }
}
