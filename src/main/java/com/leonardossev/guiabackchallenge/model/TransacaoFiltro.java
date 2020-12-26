package com.leonardossev.guiabackchallenge.model;

import java.io.Serializable;

/**
 * Representa o filtro que será utilizado para listar as transações. Este filtro contém os atributos que serão recebidos
 * na requisição.
 *
 * @author leonardossev
 * @author https://github.com/leonardossev
 * @version 25/12/2020
 */
public class TransacaoFiltro implements Serializable {

    private static final long serialVersionUID = 4616419055955159119L;

    private final int id;

    private final int mes;

    private final int ano;

    public TransacaoFiltro(final int id, final int mes, final int ano) {
        this.id = id;
        this.mes = mes;
        this.ano = ano;
    }

    public int getId() {
        return this.id;
    }

    public int getMes() {
        return this.mes;
    }

    public int getAno() {
        return this.ano;
    }

}
