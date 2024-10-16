package org.motins.service;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.motins.dao.HistoricoVeiculoDao;
import org.motins.entity.HistoricoVeiculo;
import org.motins.exception.service.HistoricoVeiculoServiceException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class HistoricoVeiculoServiceTest {

    @InjectMocks
    private HistoricoVeiculoService historicoVeiculoService;

    @Mock
    private HistoricoVeiculoDao historicoVeiculoDao;

    private HistoricoVeiculo historicoVeiculo;

    @Before
    public void setUp() {
        historicoVeiculo = new HistoricoVeiculo(1, LocalDate.now(), null, 1, 1);
    }

    @Test
    public void testCreateHistoricoVeiculoSuccess() throws Exception {
        doNothing().when(historicoVeiculoDao).create(historicoVeiculo);
        historicoVeiculoService.create(historicoVeiculo);
        verify(historicoVeiculoDao, times(1)).create(historicoVeiculo);
    }

    @Test(expected = HistoricoVeiculoServiceException.class)
    public void testCreateHistoricoVeiculoException() throws Exception {
        doThrow(new RuntimeException("Erro ao criar o histórico")).when(historicoVeiculoDao).create(historicoVeiculo);
        historicoVeiculoService.create(historicoVeiculo);
    }

    @Test
    public void testListAllHistoricoVeiculosSuccess() throws Exception {
        List<HistoricoVeiculo> historicos = Arrays.asList(historicoVeiculo);
        when(historicoVeiculoDao.readAll()).thenReturn(historicos);
        List<HistoricoVeiculo> result = historicoVeiculoService.listAll();
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(historicoVeiculoDao, times(1)).readAll();
    }

    @Test(expected = HistoricoVeiculoServiceException.class)
    public void testListAllHistoricoVeiculosException() throws Exception {
        when(historicoVeiculoDao.readAll()).thenThrow(new RuntimeException("Erro ao listar históricos"));
        historicoVeiculoService.listAll();
    }

    @Test
    public void testUpdateHistoricoVeiculoSuccess() throws Exception {
        doNothing().when(historicoVeiculoDao).update(historicoVeiculo);
        historicoVeiculoService.update(historicoVeiculo);
        verify(historicoVeiculoDao, times(1)).update(historicoVeiculo);
    }

    @Test(expected = HistoricoVeiculoServiceException.class)
    public void testUpdateHistoricoVeiculoException() throws Exception {
        doThrow(new RuntimeException("Erro ao atualizar o histórico")).when(historicoVeiculoDao).update(historicoVeiculo);
        historicoVeiculoService.update(historicoVeiculo);
    }

    @Test
    public void testDeleteHistoricoVeiculoSuccess() throws Exception {
        doNothing().when(historicoVeiculoDao).delete(historicoVeiculo.getIdHistorico());
        historicoVeiculoService.delete(historicoVeiculo.getIdHistorico());
        verify(historicoVeiculoDao, times(1)).delete(historicoVeiculo.getIdHistorico());
    }

    @Test(expected = HistoricoVeiculoServiceException.class)
    public void testDeleteHistoricoVeiculoException() throws Exception {
        doThrow(new RuntimeException("Erro ao excluir o histórico")).when(historicoVeiculoDao).delete(historicoVeiculo.getIdHistorico());
        historicoVeiculoService.delete(historicoVeiculo.getIdHistorico());
    }
}
