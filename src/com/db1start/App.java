package com.db1start;

public class App extends Transferir {
    public static void main(String[] args) {

        ContaCorrente c1 = new ContaCorrente(1, "Bruno");
        ContaCorrente c2 = new ContaCorrente(2, "Amanda");
        ContaCorrente c3 = new ContaCorrente(3, "Pedro");
        ContaCorrente c4 = new ContaCorrente(4, "Roberto");

//        System.out.println(c1.verSaldo());
//        System.out.println(c1.extratoBasico());

        c1.abrirConta();
        c2.abrirConta();

        c1.depositar(100.00);
        c1.depositar(10.00);
        c2.depositar(10.00);
        c1.depositar(15.00);
        c1.sacar(15.00);

        c1.transferir(c2,100.00);
        System.out.println(c1.verSaldo());
        System.out.println(c2.verSaldo());

        extrato(c1);
        extrato(c2);

    }

    private static void extrato(ContaCorrente conta) {
        separar();
        System.out.println(conta.extratoBasico());
        conta.transacoes.forEach(n -> System.out.println(n));
        System.out.println("Saldo final: " + conta.verSaldo());
        separar();
    }

    private static void separar() {
        System.out.println(" ");
        System.out.println("-------------------------------------------------------------------------------------------------");
    }


}
