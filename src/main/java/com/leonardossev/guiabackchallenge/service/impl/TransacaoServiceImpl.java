package com.leonardossev.guiabackchallenge.service.impl;

import com.leonardossev.guiabackchallenge.model.Transacao;
import com.leonardossev.guiabackchallenge.model.TransacaoFiltro;
import com.leonardossev.guiabackchallenge.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class TransacaoServiceImpl implements TransacaoService {

    @Autowired
    private GeradorTransacaoServiceImpl geradorTransacaoService;

    private final int ID_ALCANCE_MAXIMO = 100000;

    private final int ID_ALCANCE_MINIMO = 1000;

    private final int MES_ALCANCE_MAXIMO = 12;

    private final int MES_ALCANCE_MINIMO = 1;

    @Override
    public List<Transacao> listarTransacao(TransacaoFiltro transacaoFiltro) {
        this.validarId(transacaoFiltro.getId());
        this.validarMes(transacaoFiltro.getMes());

        var primeiroDigitoId = Integer.parseInt(Integer.toString(transacaoFiltro.getId()).substring(0, 1));

        var quantidadeTransacoes = primeiroDigitoId * transacaoFiltro.getMes();

        var transacaoLista = new ArrayList<Transacao>();

        for (int i = 0; i < quantidadeTransacoes; i++) {
            var transacao = this.geradorTransacaoService.gerarTransacao(transacaoFiltro, i);

            transacaoLista.add(transacao);
        }

        return transacaoLista;
    }

    private void validarId(int id) {
        if (id < this.ID_ALCANCE_MINIMO || id > this.ID_ALCANCE_MAXIMO) {
            throw new InvalidParameterException();
        }
    }

    private void validarMes(int mes) {
        if (mes < this.MES_ALCANCE_MINIMO || mes > this.MES_ALCANCE_MAXIMO) {
            throw new InvalidParameterException();
        }
    }
}
