package com.leonardossev.guiabackchallenge.repository.impl;

import com.leonardossev.guiabackchallenge.model.Transacao;
import com.leonardossev.guiabackchallenge.model.TransacaoFiltro;
import com.leonardossev.guiabackchallenge.repository.TransacaoRepository;
import com.leonardossev.guiabackchallenge.type.TransacaoAlcance;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Repository
public class TransacaoRepositoryImpl implements TransacaoRepository {

    @Override
    public Transacao obterTransacao(final TransacaoFiltro transacaoFiltro, final int indice) {
        var descricao = this.obterDescricaoTransacao(transacaoFiltro.getMes());
        var valor = this.obterValorTransacao(transacaoFiltro, indice);
        var data = this.obterDataTransacao(transacaoFiltro, indice);

        return new Transacao(descricao, data, valor);
    }

    private String obterDescricaoTransacao(final int mes) {
        var quantidadeCaracteres = TransacaoAlcance.ALCANCE_MINIMO_DESCRICAO.getAlcance();

        if (mes > TransacaoAlcance.ALCANCE_MINIMO_MES.getAlcance()) {
            quantidadeCaracteres = mes * 5;
        }

        if (quantidadeCaracteres == TransacaoAlcance.ALCANCE_MAXIMO_MES.getAlcance()) {
            quantidadeCaracteres--;
        }

        var descricaoBase = "Lorem ipsum dolor sit amet consectetur adipisicing elit, earu.";

        return descricaoBase.substring(0, quantidadeCaracteres);
    }

    private int obterValorTransacao(final TransacaoFiltro transacaoFiltro, final int indice) {
        return transacaoFiltro.getId() + transacaoFiltro.getAno() + indice;
    }

    private Timestamp obterDataTransacao(final TransacaoFiltro transacaoFiltro, final int indice) {
        var dataHora = LocalDateTime.of(
            transacaoFiltro.getAno(), transacaoFiltro.getMes(), 1, 0, 0, 0
        );

        return Timestamp.valueOf(dataHora);
    }

}
