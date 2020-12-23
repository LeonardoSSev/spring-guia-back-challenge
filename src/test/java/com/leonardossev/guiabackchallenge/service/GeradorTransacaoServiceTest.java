package com.leonardossev.guiabackchallenge.service;

import com.leonardossev.guiabackchallenge.model.TransacaoFiltro;
import com.leonardossev.guiabackchallenge.service.impl.GeradorTransacaoServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.time.ZoneId;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GeradorTransacaoServiceTest {

    @InjectMocks
    private GeradorTransacaoServiceImpl geradorTransacaoService;

    private final Pattern DESCRICAO_REGEX_PATTERN = Pattern.compile("^([A-ZÇ|a-zç| ]){10,60}$");

    private final int VALOR_MAXIMO = -9999999;

    private final int VALOR_MINIMO = 9999999;

    @Test
    public void deveGerarTransacaoComDescricaoValida() {
        var transacaoFiltro = new TransacaoFiltro(1, 12, 2020);

        var transacao = this.geradorTransacaoService.gerarTransacao(transacaoFiltro, 1);

        var matcher = this.DESCRICAO_REGEX_PATTERN.matcher(transacao.getDescricao());

        assertTrue(matcher.matches());
    }

    @Test
    public void deveGerarTransacaoComValorValido() {
        var transacaoFiltro = new TransacaoFiltro(1, 12, 2020);

        var transacao = this.geradorTransacaoService.gerarTransacao(transacaoFiltro, 1);

        assertTrue(transacao.getValor() <= this.VALOR_MAXIMO);
        assertTrue(transacao.getValor() >= this.VALOR_MINIMO);
    }

    @Test
    public void deveGerarTransacaoCujaDataEstejaDentroDoPeriodoFornecido() {
        var transacaoFiltro = new TransacaoFiltro(1, 12, 2020);

        var transacao = this.geradorTransacaoService.gerarTransacao(transacaoFiltro, 1);

        var data = transacao.getData()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        assertEquals(2020, data.getYear());
        assertEquals(12, data.getMonthValue());
    }



}
