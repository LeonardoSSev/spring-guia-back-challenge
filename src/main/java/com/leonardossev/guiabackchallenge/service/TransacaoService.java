package com.leonardossev.guiabackchallenge.service;

import com.leonardossev.guiabackchallenge.model.Transacao;
import com.leonardossev.guiabackchallenge.model.TransacaoFiltro;

import java.util.List;

public interface TransacaoService {

    List<Transacao> listarTransacao(TransacaoFiltro transacaoFiltro);
}
