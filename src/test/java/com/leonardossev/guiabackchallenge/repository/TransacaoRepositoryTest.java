package com.leonardossev.guiabackchallenge.repository;

import com.leonardossev.guiabackchallenge.model.TransacaoFiltro;
import com.leonardossev.guiabackchallenge.repository.impl.TransacaoRepositoryImpl;
import com.leonardossev.guiabackchallenge.type.TransacaoAlcance;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
public class TransacaoRepositoryTest {

    @InjectMocks
    private TransacaoRepositoryImpl transacaoRepository;

    private final int INDICE = 5;

    @Test
    void deveRetornarUmaTransacaoComValorMaximo() {
        var filtro = new TransacaoFiltro(100000, 12, 9999999);

        var transacao = this.transacaoRepository.obterTransacao(filtro, this.INDICE);

        assertEquals(TransacaoAlcance.ALCANCE_MAXIMO_VALOR.getValor(), transacao.getValor());
    }

    @Test
    void deveRetornarUmaTransacaoComValorMinimo() {
        var filtro = new TransacaoFiltro(-100000, 12, -9999999);

        var transacao = this.transacaoRepository.obterTransacao(filtro, this.INDICE);

        assertEquals(TransacaoAlcance.ALCANCE_MINIMO_VALOR.getValor(), transacao.getValor());
    }

    @Test
    void deveRetornarUmaTransacaoComTamanhoMaximoDaDescricao() {
        var filtro = new TransacaoFiltro(1000, 12, 2020);

        var transacao = this.transacaoRepository.obterTransacao(filtro, 60);

        assertEquals(TransacaoAlcance.ALCANCE_MAXIMO_DESCRICAO.getValor(), transacao.getDescricao().length());
    }

    @Test
    void deveRetornarUmaTransacaoComTamanhoMinimoDaDescricao() {
        var filtro = new TransacaoFiltro(1000, 1, 2020);

        var transacao = this.transacaoRepository.obterTransacao(filtro, 0);

        assertEquals(TransacaoAlcance.ALCANCE_MINIMO_DESCRICAO.getValor(), transacao.getDescricao().length());
    }

    @Test
    void deveRetornarUmaTransacaoComDiaValido() {
        var filtro = new TransacaoFiltro(1000, 1, 2020);

        var transacao = this.transacaoRepository.obterTransacao(filtro, this.INDICE);

        var calendario = Calendar.getInstance();
        calendario.setTimeInMillis(transacao.getData());

        var dia = calendario.get(Calendar.DAY_OF_MONTH);

        assertTrue(dia <= TransacaoAlcance.ALCANCE_MAXIMO_DIA_MES_GERAL.getValor());
    }

    @Test
    void deveRetornarUmaTransacaoComDiaValidoQuandoMesForFevereiro() {
        var filtro = new TransacaoFiltro(1000, 2, 2020);

        var transacao = this.transacaoRepository.obterTransacao(filtro, this.INDICE);

        var calendario = Calendar.getInstance();
        calendario.setTimeInMillis(transacao.getData());

        var dia = calendario.get(Calendar.DAY_OF_MONTH);

        assertTrue(dia <= TransacaoAlcance.ALCANCE_MAXIMO_DIA_MES_FEVEREIRO.getValor());
    }

}
