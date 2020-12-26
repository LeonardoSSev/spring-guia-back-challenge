package com.leonardossev.guiabackchallenge.type;

/**
 * Representa um enum com os valores utilizados para realizar as validações das transações e seu filtro.
 *
 * @author leonardossev
 * @author https://github.com/leonardossev
 * @version 25/12/2020
 */
public enum TransacaoAlcance {
    ALCANCE_MINIMO_ID(1000),
    ALCANCE_MAXIMO_ID(100000),
    ALCANCE_MINIMO_DESCRICAO(10),
    ALCANCE_MAXIMO_DESCRICAO(60),
    ALCANCE_MINIMO_MES(1),
    ALCANCE_MAXIMO_MES(12),
    ALCANCE_MINIMO_VALOR(-9999999),
    ALCANCE_MAXIMO_VALOR(9999999);

    private final int alcance;

    TransacaoAlcance(final int alcance) {
        this.alcance = alcance;
    }

    public int getAlcance() {
        return this.alcance;
    }
}
