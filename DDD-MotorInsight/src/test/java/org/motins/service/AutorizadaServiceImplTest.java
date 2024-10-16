package org.motins.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.motins.config.DatabaseConfig;
import org.motins.dao.AutorizadaDao;
import org.motins.entity.Autorizada;
import org.motins.exception.dao.AutorizadaDaoException;
import org.motins.exception.service.AutorizadaServiceException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

class AutorizadaServiceImplTest {

    @Mock
    private AutorizadaDao autorizadaDao;

    @InjectMocks
    private AutorizadaServiceImpl autorizadaService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateSuccess() throws AutorizadaDaoException, AutorizadaServiceException {
        Autorizada autorizada = new Autorizada(1, "Autorizada Teste", "12345678000100");

        // Simula a criação sem exceções
        doNothing().when(autorizadaDao).create(autorizada);

        assertDoesNotThrow(() -> autorizadaService.create(autorizada));
        verify(autorizadaDao, times(1)).create(autorizada);
    }

    @Test
    public void testCreateFailure() throws AutorizadaDaoException {
        Autorizada autorizada = new Autorizada(1, "Autorizada Teste", "12345678000100");

        // Simula uma exceção ao tentar criar
        doThrow(new AutorizadaDaoException("Erro ao criar autorizada")).when(autorizadaDao).create(autorizada);

        AutorizadaServiceException exception = assertThrows(AutorizadaServiceException.class, () -> {
            autorizadaService.create(autorizada);
        });

        assertEquals("Erro ao criar em autorizada", exception.getMessage());
        verify(autorizadaDao, times(1)).create(autorizada);
    }

    @Test
    public void testListAllSuccess() throws AutorizadaDaoException, AutorizadaServiceException, SQLException {
        List<Autorizada> autorizadas = new ArrayList<>();
        autorizadas.add(new Autorizada(1, "Autorizada A", "12345678000100"));
        autorizadas.add(new Autorizada(2, "Autorizada B", "98765432000111"));

        when(autorizadaDao.readAll()).thenReturn(autorizadas);

        List<Autorizada> result = autorizadaService.listAll();
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(autorizadaDao, times(1)).readAll();
    }

    @Test
    public void testListAllFailure() throws AutorizadaDaoException, SQLException {
        when(autorizadaDao.readAll()).thenThrow(new AutorizadaDaoException("Erro ao listar"));

        AutorizadaServiceException exception = assertThrows(AutorizadaServiceException.class, () -> {
            autorizadaService.listAll();
        });

        assertEquals("Erro ao listar em autorizada", exception.getMessage());
        verify(autorizadaDao, times(1)).readAll();
    }

    @Test
    public void testUpdateSuccess() throws AutorizadaDaoException, AutorizadaServiceException {
        Autorizada autorizada = new Autorizada(1, "Autorizada Atualizada", "12345678000100");

        // Simula atualização sem exceção
        doNothing().when(autorizadaDao).update(autorizada);

        assertDoesNotThrow(() -> autorizadaService.update(autorizada));
        verify(autorizadaDao, times(1)).update(autorizada);
    }

    @Test
    public void testUpdateFailure() throws AutorizadaDaoException {
        Autorizada autorizada = new Autorizada(1, "Autorizada Atualizada", "12345678000100");

        // Simula uma exceção ao tentar atualizar
        doThrow(new AutorizadaDaoException("Erro ao atualizar autorizada")).when(autorizadaDao).update(autorizada);

        AutorizadaServiceException exception = assertThrows(AutorizadaServiceException.class, () -> {
            autorizadaService.update(autorizada);
        });

        assertEquals("Erro ao atualizar em autorizada", exception.getMessage());
        verify(autorizadaDao, times(1)).update(autorizada);
    }

    @Test
    public void testDeleteSuccess() throws AutorizadaDaoException, AutorizadaServiceException {
        int idAutorizada = 1;

        // Simula exclusão sem exceção
        doNothing().when(autorizadaDao).delete(idAutorizada);

        assertDoesNotThrow(() -> autorizadaService.delete(idAutorizada));
        verify(autorizadaDao, times(1)).delete(idAutorizada);
    }

    @Test
    public void testDeleteFailure() throws AutorizadaDaoException {
        int idAutorizada = 1;

        // Simula uma exceção ao tentar deletar
        doThrow(new AutorizadaDaoException("Erro ao excluir autorizada")).when(autorizadaDao).delete(idAutorizada);

        AutorizadaServiceException exception = assertThrows(AutorizadaServiceException.class, () -> {
            autorizadaService.delete(idAutorizada);
        });

        assertEquals("Erro ao atualizar em autorizada", exception.getMessage());
        verify(autorizadaDao, times(1)).delete(idAutorizada);
    }





}







