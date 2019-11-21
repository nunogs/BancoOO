package com.db1start;

import java.util.*;

public class ContaCorrente {
    private Integer nConta;
    private String dono;
    private Boolean aberta;
    private Double saldo;
    private ArrayList<String> transacoes = new ArrayList<>();


    // Construtor
    public ContaCorrente(Integer nConta, String dono) {
        this.setnConta(nConta);
        this.setDono(dono);

        testadorDeNulo(nConta, "Numero da conta");
        testadorDeNulo(dono, "Dono da conta");

        this.setSaldo(0.0);
        this.setAberta(false);
    }


    //Metodos especiais
    public void abrirConta(){
        setAberta(true);
    }

    public String depositar(Double deposito){
        setSaldo(getSaldo()+ deposito);
        String depositoOk = "Deposito de: "+ deposito + " feito com sucesso.";
        transacoes.add(depositoOk);
        return depositoOk;
    }


    public String sacar(Double saque){
        if(getSaldo() >= saque){
            setSaldo(getSaldo() - saque);
            String saqueOk = "Saque de " + saque.toString() + "realizado.";
            transacoes.add(saqueOk);
            return saqueOk;
        }else{
            return "Não foi possivel sacar, verSaldo insuficiente";
        }
    }
    public String trasferir(Double transferencia){
        if(getSaldo() >= transferencia){
            setSaldo(getSaldo() - transferencia);
            String transferenciaOk = "Transferencia de " + transferencia + "realizada.";
            transacoes.add(transferenciaOk);
            return transferenciaOk;
        }else{
            return "Não foi possivel transferir, verSaldo insuficiente";
        }
    }
    public String verSaldo(){
        if (this.getAberta()) {
            return getSaldo().toString();
        }else {
            return "Impossivel ver verSaldo de uma conta FECHADA";
        }
    }

    public ArrayList<String> extrato (){
        if (this.getAberta()) {
            String contAberta;
                if (getAberta()){
                    contAberta = "Conta aberta";
                }else{
                    contAberta = "Conta fechada";
                }
            ArrayList<String> extratoLista = new ArrayList<>();
            String conta =("Conta nº: " + this.getnConta());
            String dono = ("Titular: " + this.getDono());
            String contaAberta =("Stado da conta: " + contAberta);
            String saldo = ("Saldo final: " + this.getSaldo());
            extratoLista.addAll(Arrays.asList(conta,dono,contaAberta, saldo));
            return (extratoLista);
        }else{
            ArrayList<String> extrato = new ArrayList<>(1);
            extrato.add("Impossivel ver extrato de uma conta FECHADA");
            return extrato;
        }
    }

    //Getters e Setters

    private ArrayList<String> getTransacoes() {
        return transacoes;
    }

    private void setTransacoes(ArrayList<String> transacoes) {
        this.transacoes = transacoes;
    }

    private Integer getnConta() {
        return nConta;
    }

    private void setnConta(Integer nConta) {
        this.nConta = nConta;
    }

    private String getDono() {
        return dono;
    }

    private void setDono(String dono) {
        this.dono = dono;
    }

    private Boolean getAberta() {
        return aberta;
    }

    private void setAberta(Boolean aberta) {
        this.aberta = aberta;
    }

    private Double getSaldo() {
        return saldo;
    }

    private void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    //Outros Metodos
    private void testadorDeNulo(Object variavel, String campo) {
        if (variavel == null) {
            throw new CampoNaoPodeSerNulo( campo +" não pode ser nulo");
        }
    }

}
