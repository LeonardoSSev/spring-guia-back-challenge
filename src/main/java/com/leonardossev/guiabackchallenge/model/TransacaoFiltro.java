package com.leonardossev.guiabackchallenge.model;

import java.io.Serializable;

public class TransacaoFiltro implements Serializable {

    private static final long serialVersionUID = 4616419055955159119L;

    private int id;

    private int mes;

    private int ano;

    public TransacaoFiltro(int id, int mes, int ano) {
        this.id = id;
        this.mes = mes;
        this.ano = ano;
    }

    public int getId() {
        return id;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

}
