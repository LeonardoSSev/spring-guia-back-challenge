package com.leonardossev.guiabackchallenge.repository;

import com.leonardossev.guiabackchallenge.model.Transacao;
import com.leonardossev.guiabackchallenge.model.TransacaoFiltro;

public interface TransacaoRepository {

    Transacao obterTransacao(TransacaoFiltro transacaoFiltro, int indice);
}
