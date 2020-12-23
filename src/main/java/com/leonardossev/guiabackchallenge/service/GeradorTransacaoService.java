package com.leonardossev.guiabackchallenge.service;

import com.leonardossev.guiabackchallenge.model.Transacao;
import com.leonardossev.guiabackchallenge.model.TransacaoFiltro;

public interface GeradorTransacaoService {

    Transacao gerarTransacao(TransacaoFiltro transacaoFiltro, int indiceAtual);
}
