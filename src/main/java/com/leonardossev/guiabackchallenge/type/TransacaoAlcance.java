package com.leonardossev.guiabackchallenge.type;

public enum TransacaoAlcance {
    ALCANCE_MINIMO_ID(1000),
    ALCANCE_MAXIMO_ID(100000),
    ALCANCE_MINIMO_DESCRICAO(10),
    ALCANCE_MAXIMO_DESCRICAO(60),
    ALCANCE_MINIMO_MES(1),
    ALCANCE_MAXIMO_MES(12);

    private final int alcance;

    TransacaoAlcance(final int alcance) {
        this.alcance = alcance;
    }

    public int getAlcance() {
        return this.alcance;
    }
}
