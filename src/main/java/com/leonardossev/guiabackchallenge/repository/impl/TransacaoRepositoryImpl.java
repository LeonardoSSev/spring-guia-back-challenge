package com.leonardossev.guiabackchallenge.repository.impl;

import com.leonardossev.guiabackchallenge.model.Transacao;
import com.leonardossev.guiabackchallenge.model.TransacaoFiltro;
import com.leonardossev.guiabackchallenge.repository.ITransacaoRepository;
import com.leonardossev.guiabackchallenge.type.TransacaoAlcance;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.Month;

/**
 * Representa o repositório que, em uma aplicação real, iria apenas fazer uma busca na base de dados. Porém, para o
 * desafio, esse repositório irá gerar os dados com base nos valores do filtro e índice.
 *
 * @author leonardossev
 * @author https://github.com/leonardossev
 * @version 26/12/2020
 */
@Repository
public class TransacaoRepositoryImpl implements ITransacaoRepository {

    /**
     * Esse método é responsável por retornar uma nova transação com base no filtro e índice fornecido.
     *
     * @param transacaoFiltro representa o filtro da listagem de transações.
     * @param indice representa o índice da listagem de transações.
     * @return transação.
     */
    @Override
    public Transacao obterTransacao(final TransacaoFiltro transacaoFiltro, final int indice) {
        var descricao = this.obterDescricaoTransacao(indice);
        var valor = this.obterValorTransacao(transacaoFiltro, indice);
        var data = this.obterDataTransacao(transacaoFiltro, indice);

        return new Transacao(descricao, data, valor);
    }

    /**
     * Esse método retorna a descrição da transação.
     * Com base no tamanho mínimo para os caracteres da transação e no mês, é definido um valor entre 10 e 60 (tamanho
     * mínimo e máximo da descrição da transação).
     *
     * @param indice representa o índice da listagem de transações.
     * @return descricao da transação.
     */
    private String obterDescricaoTransacao(final int indice) {
        var quantidadeCaracteres = indice % (TransacaoAlcance.ALCANCE_MAXIMO_DESCRICAO.getValor() + 1);

        if (quantidadeCaracteres < TransacaoAlcance.ALCANCE_MINIMO_DESCRICAO.getValor()) {
            quantidadeCaracteres = quantidadeCaracteres + TransacaoAlcance.ALCANCE_MINIMO_DESCRICAO.getValor();
        }

        var descricaoBase = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Earum deleniti nostrum.";

        return descricaoBase.substring(0, quantidadeCaracteres);
    }


    /**
     * Esse método retorna o valor da transação.
     * Com base no tamanho mínimo para os caracteres da transação e no mês, é definido um valor entre 10 e 60 (tamanho
     * mínimo e máximo da descrição da transação).
     *
     * @param transacaoFiltro representa o filtro da listagem de transações.
     * @param indice representa o índice da listagem de transações.
     * @return valor da transação.
     */
    private int obterValorTransacao(final TransacaoFiltro transacaoFiltro, final int indice) {
        var valor = transacaoFiltro.getId() + transacaoFiltro.getAno() + indice;

        if (valor > TransacaoAlcance.ALCANCE_MAXIMO_VALOR.getValor()) {
            valor = TransacaoAlcance.ALCANCE_MAXIMO_VALOR.getValor();
        }

        if (valor < TransacaoAlcance.ALCANCE_MINIMO_VALOR.getValor()) {
            valor = TransacaoAlcance.ALCANCE_MINIMO_VALOR.getValor();
        }

        return valor;
    }

    /**
     * Esse método retorna a data cuja transação foi realizada.
     * É retornado um dia aleatório primeiro momento do dia do mês do ano que foram fornecidos no filtro.
     *
     * @param transacaoFiltro representa o filtro da listagem de transações.
     * @param indice representa o índice da listagem de transações.
     * @return data, no formato long, da transação.
     */
    private long obterDataTransacao(final TransacaoFiltro transacaoFiltro, final int indice) {
        var dia = this.obterDia(transacaoFiltro.getMes(), indice);

        var dataHora = LocalDateTime.of(
            transacaoFiltro.getAno(), transacaoFiltro.getMes(), dia, 0, 0, 0
        );

        return Timestamp.valueOf(dataHora).getTime();
    }

    private int obterDia(final int mes, final int indice) {
        var diaMaximo = TransacaoAlcance.ALCANCE_MAXIMO_DIA_MES_GERAL.getValor();

        if (mes == Month.FEBRUARY.getValue()) {
            diaMaximo = TransacaoAlcance.ALCANCE_MAXIMO_DIA_MES_FEVEREIRO.getValor();
        }

        var dia = indice % diaMaximo;

        if (dia == 0) {
            return ++dia;
        }

        return dia;
    }

}
