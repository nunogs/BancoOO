package com.db1start;

public class App {

    // Para acessar os dados do cliente precisa passar por dentro da conta, um metodo de manter os dados vinculados
    // porem o cliente pode ter mais de duas contas para que
    // futuramente o codigo pode ter acrescentado tipos de contas (como conta pj ou conta poupança)
    // sem que hajam tantos problemas de implementação.


    public static void main(String[] args) {
        ContaCorrente c1 = new ContaCorrente(101,"Bruno", "0511115684841", true);
        ContaCorrente c2 = new ContaCorrente(202, "Amanda", "041616566616", true);
        ContaCorrente c3 = new ContaCorrente(303, "Pedro", "0619875684841", false);

//        c1.depositar(00.00);
//        c3.depositar(100.00);


        c1.depositar(100.00);
        c1.depositar(200.00);
        c1.depositar(1010.00);
        c1.sacar(200.00);
        c2.depositar(10.00);
        c2.depositar(3050.00);
        c2.depositar(30.00);
        c1.sacar(10.00);

        Controle.transferir(c1, c2,100.00);
//        System.out.println(c1.verSaldo());
//        System.out.println(c2.verSaldo());

        Controle.extrato(c1);
        Controle.extrato(c2);


        // Para acessar os dados do cliente precisa passar por dentro da conta, um metodo de manter os dados vinculados
        // porem o cliente pode ter mais de duas contas para que
        // futuramente o codigo pode ter acrescentado tipos de contas (como conta pj ou conta poupança)
        // sem que hajam tantos problemas de implementação.


        System.out.println(c1.getCliente().getNome());

    }
}
