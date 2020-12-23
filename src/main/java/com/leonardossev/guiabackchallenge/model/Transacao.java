package com.leonardossev.guiabackchallenge.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Transacao implements Serializable {

    private String descricao;

    private Timestamp data;

    private int valor;

    public Transacao(String descricao, Timestamp data, int valor) {
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public Timestamp getData() {
        return data;
    }

    public int getValor() {
        return valor;
    }
}
