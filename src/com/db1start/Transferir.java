package com.db1start;

public class Transferir {
    

    protected static void tranferir(ContaCorrente conta1, ContaCorrente conta2, double valor) {
        conta1.trasferir(valor);
        conta2.depositar(valor);
    }
}
