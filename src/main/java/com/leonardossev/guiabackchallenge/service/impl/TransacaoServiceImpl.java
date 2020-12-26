package com.leonardossev.guiabackchallenge.service.impl;

import com.leonardossev.guiabackchallenge.model.Transacao;
import com.leonardossev.guiabackchallenge.model.TransacaoFiltro;
import com.leonardossev.guiabackchallenge.repository.impl.TransacaoRepositoryImpl;
import com.leonardossev.guiabackchallenge.service.TransacaoService;
import com.leonardossev.guiabackchallenge.type.TransacaoAlcance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa o service reponsável por validar o filtro fornecido e, em seguida, listar as transações.
 *
 * @author leonardossev
 * @author https://github.com/leonardossev
 * @version 25/12/2020
 */
@Service
public class TransacaoServiceImpl implements TransacaoService {

    @Autowired
    private TransacaoRepositoryImpl transacaoRepository;

    @Override
    public List<Transacao> listarTransacao(final TransacaoFiltro transacaoFiltro) {
        this.validarId(transacaoFiltro.getId());
        this.validarMes(transacaoFiltro.getMes());
        this.validarAno(transacaoFiltro.getAno());

        var primeiroDigitoId = Integer.parseInt(Integer.toString(transacaoFiltro.getId()).substring(0, 1));

        var quantidadeTransacoes = primeiroDigitoId * transacaoFiltro.getMes();

        var transacaoLista = new ArrayList<Transacao>();

        for (int i = 0; i < quantidadeTransacoes; i++) {
            var transacao = this.transacaoRepository.obterTransacao(transacaoFiltro, i);

            transacaoLista.add(transacao);
        }

        return transacaoLista;
    }

    private void validarId(final int id) {
        if (id < TransacaoAlcance.ALCANCE_MINIMO_ID.getAlcance() ||
            id > TransacaoAlcance.ALCANCE_MAXIMO_ID.getAlcance()) {
            throw new InvalidParameterException("Oops! O id informado não é válido.");
        }
    }

    private void validarMes(final int mes) {
        if (mes < TransacaoAlcance.ALCANCE_MINIMO_MES.getAlcance() ||
            mes > TransacaoAlcance.ALCANCE_MAXIMO_MES.getAlcance()) {
            throw new InvalidParameterException("Oops! O mês informado não válido.");
        }
    }

    private void validarAno(final int ano) {
        if (ano == 0) {
            throw new InvalidParameterException("Oops! O ano informado não é válido.");
        }
    }
}
