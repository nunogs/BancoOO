package com.db1start;

public class Cliente {
    private String nome;
    private String cpf;
    private Integer numeroDaConta;
    private String estadoDaConta;
    private Object conta;

    public Cliente(Object conta, Integer numeroDaConta, String nome, String cpf, Boolean estadoDaConta) {
        this.conta = conta;
        this.nome = nome;
        this.cpf = cpf;
        this.numeroDaConta = numeroDaConta;
        if (estadoDaConta) {
            this.estadoDaConta = "Conta Aberta";
        }

    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Integer getNumeroDaConta() {
        return numeroDaConta;
    }

    public String getEstadoDaConta() {
        return estadoDaConta;
    }
}
