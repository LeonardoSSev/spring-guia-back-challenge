package com.leonardossev.guiabackchallenge.model;

import java.io.Serializable;

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
