package org.motins.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.motins.config.DatabaseConfig;
import org.motins.dao.interfaces.PagamentoDao;
import org.motins.entity.pagamento.Pagamento;
import org.motins.exception.service.PagamentoServiceException;
import org.motins.service.impl.PagamentoServiceImpl;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PagamentoServiceImplTest {

    private PagamentoServiceImpl pagamentoService;
    private PagamentoDao pagamentoDaoMock;
    private Pagamento pagamento;

    @BeforeEach
    public void setUp() {
        DatabaseConfig dbConfigMock = mock(DatabaseConfig.class);
        pagamentoDaoMock = mock(PagamentoDao.class);
        pagamentoService = PagamentoServiceImpl.getInstance();
        pagamentoService.pagamentoDao = pagamentoDaoMock;

        pagamento = new Pagamento(1, LocalDate.now(), 1000.00, "PAGO", 1, 2, 3, "CARTÃO");
    }

    @Test
    public void testCreatePagamentoSuccess() throws Exception {
        doNothing().when(pagamentoDaoMock).create(pagamento);

        assertDoesNotThrow(() -> pagamentoService.create(pagamento));
        verify(pagamentoDaoMock, times(1)).create(pagamento);
    }

    @Test
    public void testCreatePagamentoFailure() throws Exception {
        doThrow(new RuntimeException()).when(pagamentoDaoMock).create(any(Pagamento.class));

        PagamentoServiceException exception = assertThrows(PagamentoServiceException.class,
                () -> pagamentoService.create(pagamento));

        assertEquals("Não foi possivel criar em T_CON_PAGAMENTO", exception.getMessage());
    }

    @Test
    public void testListAllPagamentosSuccess() throws Exception {
        List<Pagamento> mockPagamentos = List.of(pagamento);
        when(pagamentoDaoMock.readAll()).thenReturn(mockPagamentos);

        List<Pagamento> pagamentos = assertDoesNotThrow(() -> pagamentoService.listAll());
        assertEquals(1, pagamentos.size());
        verify(pagamentoDaoMock, times(1)).readAll();
    }

    @Test
    public void testListAllPagamentosFailure() throws Exception {
        when(pagamentoDaoMock.readAll()).thenThrow(new RuntimeException());

        PagamentoServiceException exception = assertThrows(PagamentoServiceException.class,
                () -> pagamentoService.listAll());

        assertEquals("Não foi possível listar os pagamentos", exception.getMessage());
    }

    @Test
    public void testUpdatePagamentoSuccess() throws Exception {
        doNothing().when(pagamentoDaoMock).update(pagamento);

        assertDoesNotThrow(() -> pagamentoService.update(pagamento));
        verify(pagamentoDaoMock, times(1)).update(pagamento);
    }

    @Test
    public void testUpdatePagamentoFailure() throws Exception {
        doThrow(new RuntimeException()).when(pagamentoDaoMock).update(any(Pagamento.class));

        PagamentoServiceException exception = assertThrows(PagamentoServiceException.class,
                () -> pagamentoService.update(pagamento));

        assertEquals("Não foi possível atualizar em T_CON_PAGAMENTO", exception.getMessage());
    }

    @Test
    public void testDeletePagamentoSuccess() throws Exception {
        doNothing().when(pagamentoDaoMock).delete(anyInt());

        assertDoesNotThrow(() -> pagamentoService.delete(1));
        verify(pagamentoDaoMock, times(1)).delete(1);
    }

    @Test
    public void testDeletePagamentoFailure() throws Exception {
        doThrow(new RuntimeException()).when(pagamentoDaoMock).delete(anyInt());

        PagamentoServiceException exception = assertThrows(PagamentoServiceException.class,
                () -> pagamentoService.delete(1));

        assertEquals("Não foi possível atualizar em T_CON_PAGAMENTO", exception.getMessage());
    }
}
