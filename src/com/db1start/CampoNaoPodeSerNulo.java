package com.db1start;

public class CampoNaoPodeSerNulo extends RuntimeException {

    public CampoNaoPodeSerNulo(String frase) {
        super(frase);
    }
}