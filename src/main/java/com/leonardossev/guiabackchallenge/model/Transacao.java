package com.leonardossev.guiabackchallenge.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Transacao implements Serializable {

    private static final long serialVersionUID = 369718317290262550L;

    private final String descricao;

    private final Timestamp data;

    private final int valor;

    public Transacao(final String descricao, final Timestamp data, final int valor) {
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
    }
}
