package com.db1start;

public class App {
    public static void main(String[] args) {

        ContaCorrente c1 = new ContaCorrente(1, "Bruno");
        ContaCorrente c2 = new ContaCorrente(2, "Amanda");
        ContaCorrente c3 = new ContaCorrente(3, "Pedro");
        ContaCorrente c4 = new ContaCorrente(4, "Roberto");

//        System.out.println(c1.verSaldo());
//        System.out.println(c1.extrato());

        c1.abrirConta();
        c1.depositar(100.00);
        c1.depositar(10.00);
        c1.depositar(15.00);
        c1.sacar(15.00);


        c1.extrato().forEach(f -> System.out.println(f));


//        transfe
    }

}
