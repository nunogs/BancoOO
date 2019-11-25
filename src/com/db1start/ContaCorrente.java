package com.db1start;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class ContaCorrente {
    private Integer nConta;
    private String dono;
    private Boolean aberta;
    private Double saldo;
    private ArrayList<String> transacoes = new ArrayList<>();
    private ArrayList<String> transferenciasFeitas = new ArrayList<>();

    public static String getData() {
        DateFormat dataPtBr = new SimpleDateFormat("dd/MM/yyyy" + " " + "hh:mm");
        Calendar calendar = Calendar.getInstance();
        return dataPtBr.format(calendar.getTime());
    }

    // Construtor

    public ContaCorrente() {
    }

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
        this.setSaldo(getSaldo()+ deposito);
        String depositoOk = this.getData() + "    Deposito comum "  + "                                                     " + "+R$:" + deposito ;
        this.transacoes.add(depositoOk);
        return depositoOk;
    }
    public String depositar(Double deposito, ContaCorrente conta2){
        this.setSaldo(getSaldo()+ deposito);
        String depositoOk = this.getData() + "    Deposito recebido por transferencia da conta nº: " + conta2.getnConta() + "                " + "+R$:" + deposito ;
        this.transacoes.add(depositoOk);
        return depositoOk;
    }

    public String sacar(Double saque){
        if(getSaldo() >= saque){
            setSaldo(getSaldo() - saque);
            String saqueOk = this.getData() + "    Saque de realizado "  + "                                                 " + "-RS:"+ saque;
            transacoes.add(saqueOk);
            return saqueOk;
        }else{
            return "Não foi possivel sacar, saldo insuficiente ";
        }
    }

    public String realizarTransferencia(ContaCorrente conta1, ContaCorrente conta2 , Double transferencia){
        if(this.getSaldo() >= transferencia){
            this.setSaldo(getSaldo() - transferencia);
            conta2.depositar(transferencia, conta1);

            String transferenciaOk =  this.getData() + "    Transferencia comum para a conta nº: " + conta2.getnConta()
                    +"                            " +  "-R$:" + transferencia  +"\n";
            transacoes.add(transferenciaOk);
            return transferenciaOk;
        }else{
            return "Não foi possivel transferir, saldo insuficiente";
        }
    }

    public String verSaldo(){
        if (this.getAberta()) {
            return getSaldo().toString();
        }else {
            return "Impossivel ver saldo de uma conta FECHADA";
        }
    }

    public String extratoParte1(){
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

    public Integer getnConta() {
        return nConta;
    }

    public void setnConta(Integer nConta) {
        this.nConta = nConta;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public Boolean getAberta() {
        return aberta;
    }

    public void setAberta(Boolean aberta) {
        this.aberta = aberta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    //Outros Metodos
    private void testadorDeNulo(Object variavel, String campo) {
        if (variavel == null) {
            throw new CampoNaoPodeSerNulo( campo +" não pode ser nulo");
        }
    }

}
