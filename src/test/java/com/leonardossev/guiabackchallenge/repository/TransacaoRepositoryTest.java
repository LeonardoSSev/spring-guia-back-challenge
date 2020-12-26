package com.leonardossev.guiabackchallenge.repository;

import com.leonardossev.guiabackchallenge.model.TransacaoFiltro;
import com.leonardossev.guiabackchallenge.repository.impl.TransacaoRepositoryImpl;
import com.leonardossev.guiabackchallenge.type.TransacaoAlcance;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        var transacao = this.transacaoRepository.obterTransacao(filtro, this.INDICE);

        assertEquals(TransacaoAlcance.ALCANCE_MAXIMO_DESCRICAO.getValor(), transacao.getDescricao().length());
    }

    @Test
    void deveRetornarUmaTransacaoComTamanhoMinimoDaDescricao() {
        var filtro = new TransacaoFiltro(1000, 1, 2020);

        var transacao = this.transacaoRepository.obterTransacao(filtro, this.INDICE);

        assertEquals(TransacaoAlcance.ALCANCE_MINIMO_DESCRICAO.getValor(), transacao.getDescricao().length());
    }

}
