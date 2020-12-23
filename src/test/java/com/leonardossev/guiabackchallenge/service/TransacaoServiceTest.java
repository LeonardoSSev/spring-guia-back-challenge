package com.leonardossev.guiabackchallenge.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class TransacaoServiceTest {

    @InjectMocks
    private TransacaoServiceImpl transacaoService;

    private final int ID_ALCANCE_MAXIMO = 100000;

    private final int ID_ALCANCE_MINIMO = 1000;

    @Test
    public void deveRetornarListaCujoTamanhoIgualAoMesMultiplicadoPeloPrimeiroDigitoDoId() {
        var transacaoFiltro = new TransacaoFiltro(1, 12, 2020);

        var transacaoLista = this.transacaoService.listarTransacao(transacaoFiltro);

        assertEquals(1, transacaoLista.size());
    }

    @Test
    public void deveLancarInvalidParameterExceptionQuandoIdFornecidoForMenorQueAlcancePermitido()
            throws InvalidParameterException {
        var transacaoFiltro = new TransacaoFiltro(999, 12, 2020);

        assertThrows(InvalidParameterException.class, () -> this.transacaoService.listarTransacao(transacaoFiltro));
    }

    @Test
    public void deveLancarInvalidParameterExceptionQuandoIdFornecidoForMaiorQueAlcancePermitido()
            throws InvalidParameterException {
        var id = this.ID_ALCANCE_MAXIMO + 1;

        var transacaoFiltro = new TransacaoFiltro(id, 12, 2020);

        assertThrows(InvalidParameterException.class, () -> this.transacaoService.listarTransacao(transacaoFiltro));
    }

    @Test
    public void deveLancarInvalidParameterExceptionQuandoMesFornecidoForMenorQueAlcancePermitido()
            throws InvalidParameterException {
        var id = this.ID_ALCANCE_MINIMO - 1;

        var transacaoFiltro = new TransacaoFiltro(id, 0, 2020);

        assertThrows(InvalidParameterException.class, () -> this.transacaoService.listarTransacao(transacaoFiltro));
    }

    @Test
    public void deveLancarInvalidParameterExceptionQuandoMesFornecidoForMaiorQueAlcancePermitido()
            throws InvalidParameterException {
        var transacaoFiltro = new TransacaoFiltro(999, 13, 2020);

        assertThrows(InvalidParameterException.class, () -> this.transacaoService.listarTransacao(transacaoFiltro));
    }

}
