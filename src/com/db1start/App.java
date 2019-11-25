package com.db1start;

import static com.db1start.ContaCorrente.getData;

public class App {
    public static void transferir(ContaCorrente conta1, ContaCorrente conta2, Double valor){
        conta1.realizarTransferencia(conta1, conta2,100.00);
    }

    private static void extrato(ContaCorrente conta) {

        separar();
        System.out.println(conta.extratoParte1());
        conta.getTransacoes().forEach(n -> System.out.println(n));
        System.out.println(" ");
        System.out.println(getData() + "    Saldo até esta data "
                +"                                                " +" R$:"+ conta.verSaldo());
        separar();
    }

    private static void separar() {
        System.out.println(" ");
        System.out.println("-------------------------------------------------------------------------------------------------");
    }
    
    public static void main(String[] args) {

        ContaCorrente c1 = new ContaCorrente(101, "Bruno");
        ContaCorrente c2 = new ContaCorrente(202, "Amanda");
        ContaCorrente c3 = new ContaCorrente(303, "Pedro");
        ContaCorrente c4 = new ContaCorrente(404, "Roberto");
        ContaCorrente c5 = new ContaCorrente(505, "Sandra");
        ContaCorrente c6 = new ContaCorrente(606, "João");
        ContaCorrente c7 = new ContaCorrente(707, "Maria");
        ContaCorrente c8 = new ContaCorrente(808, "Izabela");
        ContaCorrente c9 = new ContaCorrente(909, "Ana");

//        System.out.println(c1.verSaldo());
//        System.out.println(c1.extratoBasico());

        c1.abrirConta();
        c2.abrirConta();

        c1.depositar(100.00);
        c1.depositar(200.00);
        c1.depositar(1010.00);
        c1.sacar(200.00);
        c2.depositar(10.00);
        c2.depositar(3050.00);
        c2.depositar(30.00);
        c1.sacar(10.00);

        transferir(c1, c2,100.00);
//        System.out.println(c1.verSaldo());
//        System.out.println(c2.verSaldo());

        extrato(c1);
        extrato(c2);

    }
}
