package com.db1start;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class ContaCorrente {
    private Integer numeroDaConta;
    private Cliente cliente;
    private String nomeTitular;
    private Boolean contaAbertaOuFechada;
    private Double saldo;
    private ArrayList<String> transacoes = new ArrayList<>();
    private ArrayList<String> transferenciasFeitas = new ArrayList<>();



    // Construtor

    public ContaCorrente(Integer numeroDaConta, String cliente, String cpf, Boolean abrirConta) {

        if(testadorDeNulo(numeroDaConta)){
            throw new CampoNaoPodeSerNulo( "Numero da conta não pode ser nulo");
        }
        if(testadorDeNulo(cliente)){
            throw new CampoNaoPodeSerNulo( "Nome do cliente não pode ser nulo");
        }
        if(testadorDeNulo(cpf)){
            throw new CampoNaoPodeSerNulo( "Cpf não pode ser nulo");
        }
        if(testadorDeNulo(abrirConta)){
            throw new CampoNaoPodeSerNulo( "Campo 'abrir conta' não pode ser nulo");
        }

        this.contaAbertaOuFechada = abrirConta;

        this.nomeTitular = cliente;
        this.numeroDaConta = numeroDaConta;
        this.cliente = new Cliente(this , numeroDaConta, cliente, cpf, abrirConta);



        this.saldo = 0.0;
    }


    //Metodos especiais

    public String depositar(Double deposito){
        if(testadorDeNulo(deposito)){
            throw new CampoNaoPodeSerNulo( "Deposito não pode ser nulo");
        }
        if(!contaAbertaOuFechada){
            throw new CampoNaoPodeSerNulo( "Impossivel depositar em uma conta fechada");
        }
        this.saldo += deposito;
        String depositoOk = this.getData() + "    Deposito comum "  + "                                                     " + "+R$:" + deposito ;
        this.transacoes.add(depositoOk);
        return depositoOk;
    }
    public String depositarPorTransferencia(Double deposito, ContaCorrente conta2){
        if(testadorDeNulo(deposito)){
            throw new CampoNaoPodeSerNulo( "Deposito não pode ser nulo");
        }
        if(!contaAbertaOuFechada){
            throw new CampoNaoPodeSerNulo( "Impossivel depositar em uma conta fechada");
        }
        this.saldo += deposito;
        String depositoOk = this.getData() + "    Deposito recebido por transferencia da conta nº: " + conta2.getNumeroDaConta() + "                " + "+R$:" + deposito ;
        this.transacoes.add(depositoOk);
        return depositoOk;
    }

    public String sacar(Double saque){
        if(testadorDeNulo(saque)){
            throw new CampoNaoPodeSerNulo( "Valor do saque não pode ser nulo");
        }
        if(this.saldo >= saque){
            this.saldo -= saque;
            String saqueOk = this.getData() + "    Saque de realizado "  + "                                                 " + "-RS:"+ saque;
            transacoes.add(saqueOk);
            return saqueOk;
        }else{
            return "Não foi possivel sacar, saldo insuficiente";
        }
    }

    public String realizarTransferencia(ContaCorrente conta1, ContaCorrente conta2 , Double transferencia){
        if(testadorDeNulo(transferencia)){
            throw new CampoNaoPodeSerNulo( "Valor da transferencia não pode ser nulo");
        }
        if(!conta2.getContaAbertaOuFechada()){
            throw new CampoNaoPodeSerNulo( "Impossivel depositar em uma conta fechada");
        }
        if(this.saldo >= transferencia){
            this.saldo -= - transferencia;
            conta2.depositarPorTransferencia(transferencia, conta1);
            String transferenciaOk =  this.getData() + "    Transferencia comum para a conta nº: " + conta2.getNumeroDaConta()
                    +"                            " +  "-R$:" + transferencia  +"\n";
            transacoes.add(transferenciaOk);
            return transferenciaOk;
        }else{
            return "Não foi possivel transferir, saldo insuficiente";
        }
    }

    public String verSaldo(){

        if (this.contaAbertaOuFechada) {
            return this.saldo.toString();
        }else {
            return "Impossivel ver saldo de uma conta FECHADA";
        }
    }

    public String extratoParte1(){
        String contAberta;
        if (this.contaAbertaOuFechada){
            contAberta = "Conta aberta";
        }else{
            contAberta = "Conta fechada";
        }

        String extrato = ("Titular: " + this.cliente.getNome() + "\n" + "Conta corrente: " + this.numeroDaConta + "\n"
                + "Status da conta: " + contAberta + "\n");
        return extrato;
    }

    public String fecharConta(){
        if (this.saldo < 0.0 ){
            throw new RuntimeException("Impossivel fechar conta com credito aberto." +
                    " Favor quitar déficit antes de fechar a conta. ");
        }else if(this.saldo > 0.0){
            throw new RuntimeException("Impossivel fechar conta com saldo positivo." +
                    " Favor sacar todo capital antes de fechar a conta. ");
        }
        this.contaAbertaOuFechada = false;
        String movimentoOk = "Conta fechada com sucesso no dia " + getData();
        return movimentoOk;
    }

    // METOTDOS ACESSORES


    public Cliente getCliente() {
        return cliente;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public ArrayList<String> getTransferenciasFeitas() {
        return transferenciasFeitas;
    }

    public static String getData() {
        DateFormat dataPtBr = new SimpleDateFormat("dd/MM/yyyy" + " " + "hh:mm");
        Calendar calendar = Calendar.getInstance();
        return dataPtBr.format(calendar.getTime());
    }

    public ArrayList<String> getTransacoes() {
        return transacoes;
    }

    public Integer getNumeroDaConta() {
        return numeroDaConta;
    }

    public Boolean getContaAbertaOuFechada() {
        return contaAbertaOuFechada;
    }

    public Double getSaldo() {
        return saldo;
    }



    //Outros Metodos
    private Boolean testadorDeNulo(Object variavel) {
        if (variavel == null || variavel.equals(" ") || variavel.equals(0.0))  {
            return true;
        }else{
            return false;
        }
    }

}
