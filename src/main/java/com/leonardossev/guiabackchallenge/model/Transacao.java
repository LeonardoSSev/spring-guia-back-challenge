package com.leonardossev.guiabackchallenge.model;

import java.io.Serializable;

/**
 * Representa uma transação de acordo com o contrato estabelecido no desafio.
 *
 * @author leonardossev
 * @author https://github.com/leonardossev
 * @version 25/12/2020
 */
public class Transacao implements Serializable {

    private static final long serialVersionUID = 369718317290262550L;

    private final String descricao;

    private final long data;

    private final int valor;

    /**
     * @param descricao representa a descrição, no formato String, da transação
     * @param data representa a data e hora, no formato Timestamp, da transação
     * @param valor representa o valor, em formato inteiro, da transação
     */
    public Transacao(final String descricao, final long data, final int valor) {
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public long getData() {
        return this.data;
    }

    public int getValor() {
        return this.valor;
    }
}
