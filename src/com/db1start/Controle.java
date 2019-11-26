package com.db1start;

import static com.db1start.ContaCorrente.getData;

public class Controle {


    public static void transferir(ContaCorrente conta1, ContaCorrente conta2, Double valor){
        if (valor == 0.0 || valor == null){
            throw new RuntimeException("Valor não pode ser nullo, favor digitar valor valido");
        }
        conta1.realizarTransferencia(conta1, conta2,valor);
    }

    static void extrato(ContaCorrente conta) {

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
}
