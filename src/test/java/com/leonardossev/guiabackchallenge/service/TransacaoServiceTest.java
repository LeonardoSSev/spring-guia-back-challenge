package com.leonardossev.guiabackchallenge.service;

import com.leonardossev.guiabackchallenge.model.Transacao;
import com.leonardossev.guiabackchallenge.model.TransacaoFiltro;
import com.leonardossev.guiabackchallenge.repository.impl.TransacaoRepositoryImpl;
import com.leonardossev.guiabackchallenge.service.impl.TransacaoServiceImpl;
import com.leonardossev.guiabackchallenge.type.TransacaoAlcance;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.security.InvalidParameterException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class TransacaoServiceTest {

    @Mock
    private TransacaoRepositoryImpl transacaoRepository;

    @InjectMocks
    private TransacaoServiceImpl transacaoService;

    @Test
    public void deveRetornarListaCujoTamanhoIgualAoMesMultiplicadoPeloPrimeiroDigitoDoId() {
        var transacaoFiltro = new TransacaoFiltro(1000, 1, 2020);

        this.prepararTransacao(transacaoFiltro);

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
        var id = TransacaoAlcance.ALCANCE_MAXIMO_ID.ordinal() + 1;

        var transacaoFiltro = new TransacaoFiltro(id, 12, 2020);

        assertThrows(InvalidParameterException.class, () -> this.transacaoService.listarTransacao(transacaoFiltro));
    }

    @Test
    public void deveLancarInvalidParameterExceptionQuandoMesFornecidoForMenorQueAlcancePermitido()
            throws InvalidParameterException {
        var id = TransacaoAlcance.ALCANCE_MINIMO_ID.ordinal() - 1;

        var transacaoFiltro = new TransacaoFiltro(id, 0, 2020);

        assertThrows(InvalidParameterException.class, () -> this.transacaoService.listarTransacao(transacaoFiltro));
    }

    @Test
    public void deveLancarInvalidParameterExceptionQuandoMesFornecidoForMaiorQueAlcancePermitido()
            throws InvalidParameterException {
        var transacaoFiltro = new TransacaoFiltro(999, 13, 2020);

        assertThrows(InvalidParameterException.class, () -> this.transacaoService.listarTransacao(transacaoFiltro));
    }

    private void prepararTransacao(TransacaoFiltro transacaoFiltro) {
        var descricao = "Lorem ipsu";
        var data = Timestamp.valueOf(LocalDateTime.now());
        var valor = 10;

        when(this.transacaoRepository.obterTransacao(transacaoFiltro, 1)).thenReturn(
            new Transacao(descricao, data.getTime(), valor)
        );
    }

}
