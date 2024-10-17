package org.motins.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.motins.dao.ClienteDao;
import org.motins.entity.factoryCliente.Cliente;
import org.motins.exception.dao.ClienteDaoException;
import org.motins.exception.service.ClienteServiceException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClienteServiceTest {

    @Mock
    private ClienteDao clienteDao;

    @InjectMocks
    private ClienteService clienteService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testCreateSuccess() throws ClienteDaoException, ClienteServiceException {

        Cliente cliente = new Cliente(1, "PESSOA FÍSICA", "Ativo");

        doNothing().when(clienteDao).create(cliente);

        clienteService.create(cliente);

        verify(clienteDao, times(1)).create(cliente);
    }


    @Test
    public void testCreateFailure() throws ClienteDaoException {

        Cliente cliente = new Cliente(1, "PESSOA FÍSICA", "Ativo");


        doThrow(new ClienteDaoException("Erro ao criar o cliente")).when(clienteDao).create(cliente);


        assertThrows(ClienteServiceException.class, () -> clienteService.create(cliente));
    }


    @Test
    public void testCreateWithNullCliente() {
        assertThrows(NullPointerException.class, () -> clienteService.create(null));
    }

    @Test
    public void testListAllSuccess() throws ClienteDaoException, ClienteServiceException {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1, "Pessoa Física", "Ativo"));
        clientes.add(new Cliente(2, "Pessoa Jurídica", "Inativo"));

        when(clienteDao.readAll()).thenReturn(clientes);

        List<Cliente> result = clienteService.listAll();
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(clienteDao, times(1)).readAll();
    }

    @Test
    public void testListAllFailure() throws ClienteDaoException {
        when(clienteDao.readAll()).thenThrow(new ClienteDaoException("Erro ao listar"));

        ClienteServiceException exception = assertThrows(ClienteServiceException.class, () -> {
            clienteService.listAll();
        });

        assertEquals("Não foi possível listar em T_CON_CLIENTE", exception.getMessage());
        verify(clienteDao, times(1)).readAll();
    }

    @Test
    public void testListAllEmpty() throws ClienteDaoException, ClienteServiceException {
        List<Cliente> emptyList = new ArrayList<>();
        when(clienteDao.readAll()).thenReturn(emptyList);

        List<Cliente> result = clienteService.listAll();
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(clienteDao, times(1)).readAll();
    }

    @Test
    public void testUpdateSuccess() throws ClienteDaoException, ClienteServiceException {
        Cliente cliente = new Cliente(1, "Pessoa Física", "Inativo");

        doNothing().when(clienteDao).update(cliente);

        assertDoesNotThrow(() -> clienteService.update(cliente));
        verify(clienteDao, times(1)).update(cliente);
    }

    @Test
    public void testUpdateFailure() throws ClienteDaoException {
        Cliente cliente = new Cliente(1, "Pessoa Física", "Inativo");

        doThrow(new ClienteDaoException("Erro ao atualizar o cliente")).when(clienteDao).update(cliente);

        ClienteServiceException exception = assertThrows(ClienteServiceException.class, () -> {
            clienteService.update(cliente);
        });

        assertEquals("Não foi possível atualizar em T_CON_CLIENTE", exception.getMessage());
        verify(clienteDao, times(1)).update(cliente);
    }

    @Test
    public void testUpdateWithNullCliente() {
        assertThrows(NullPointerException.class, () -> clienteService.update(null));
    }

    @Test
    public void testDeleteSuccess() throws ClienteDaoException, ClienteServiceException {
        int idCliente = 1;

        doNothing().when(clienteDao).delete(idCliente);

        assertDoesNotThrow(() -> clienteService.delete(idCliente));
        verify(clienteDao, times(1)).delete(idCliente);
    }

    @Test
    public void testDeleteFailure() throws ClienteDaoException {
        int idCliente = 1;

        doThrow(new ClienteDaoException("Erro ao excluir o cliente")).when(clienteDao).delete(idCliente);

        ClienteServiceException exception = assertThrows(ClienteServiceException.class, () -> {
            clienteService.delete(idCliente);
        });

        assertEquals("Não foi possível atualizar em T_CON_CLIENTE", exception.getMessage());
        verify(clienteDao, times(1)).delete(idCliente);
    }
}
