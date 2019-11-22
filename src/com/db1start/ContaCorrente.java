package com.db1start;

import java.util.*;

public class ContaCorrente {
    private Integer nConta;
    private String dono;
    private Boolean aberta;
    private Double saldo;
    public ArrayList<String> transacoes = new ArrayList<>();
    private ArrayList<String> transferenciasFeitas = new ArrayList<>();

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
        String depositoOk = "Deposito de: "+ deposito + " feito com sucesso. ";
        transacoes.add(depositoOk);
        return depositoOk;
    }


    public String sacar(Double saque){
        if(getSaldo() >= saque){
            setSaldo(getSaldo() - saque);
            String saqueOk = "Saque de " + saque.toString() + " realizado. ";
            transacoes.add(saqueOk);
            return saqueOk;
        }else{
            return "Não foi possivel sacar, verSaldo insuficiente ";
        }
    }

    public String transferir(ContaCorrente conta2 , Double transferencia){
        if(this.getSaldo() >= transferencia){
            setSaldo(getSaldo() - transferencia);
            String transferenciaOk = "Transferencia de " + transferencia + "realizada. "+ "\n";
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
            return "Impossivel ver saldo de uma conta FECHADA";
        }
    }

    public String extratoBasico(){
        String contAberta;
        if (this.getAberta()){
            contAberta = "Conta aberta";
        }else{
            contAberta = "Conta fechada";
        }

        String extrato = ("Titular: " + this.getDono() + "\n" + "Conta corrente: " + this.getnConta() + "\n"
                + "Status da conta: " + contAberta + "\n");
        return extrato;
    }


//    protected void tranferir(ContaCorrente conta1, ContaCorrente conta2, double valor) {
//        conta1.transferir(valor);
//        conta2.depositar(valor);
//
//        separarTransferencias(conta1, conta2);
//    }

    private void separarTransferencias(ContaCorrente conta1, ContaCorrente conta2) {
        transferenciasFeitas.add("Conta " + conta1 + " transferiu para " + conta2);
        transferenciasFeitas.add("Conta " + conta2 + " recebeu de " + conta1);

    }

    public ArrayList<String> getTransferenciasFeitas() {
        return transferenciasFeitas;
    }


    public ArrayList<String> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(ArrayList<String> transacoes) {
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
