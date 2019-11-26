
package com.db1start;


import org.junit.Assert;
import org.junit.Test;

public class ContaCorrenteTest {
    @Test
    public void deveCriarAlunoPorMeioDoConstrutor(){
        ContaCorrente cont = new ContaCorrente( 1,"Bruno", "0911115684841", true);
        String nome = "Bruno";
        Integer conta = 1;
        String cpf = "0911115684841";
        Assert.assertEquals(nome, cont.getNomeTitular());
        Assert.assertEquals(conta, cont.getNumeroDaConta());
    }

    @Test
    public void deveAbrirConta(){
        ContaCorrente cont = new ContaCorrente( 1,"Bruno", "0911115684841", true);
        Assert.assertEquals(true, cont.getContaAbertaOuFechada());
    }
    @Test
    public void deveFecharConta(){
        ContaCorrente cont = new ContaCorrente( 1,"Bruno", "0911115684841", false);
        Assert.assertEquals(false, cont.getContaAbertaOuFechada());
    }

    @Test
    public void deveDepositar11ReaisE11Centavos(){
        ContaCorrente cont = new ContaCorrente( 1,"Bruno", "0911115684841", true);
        cont.depositar(11.11);
        Double dep = 11.11;
        Assert.assertEquals(dep, cont.getSaldo());
    }
    @Test
    public void deveSacar11ReaisE11CentavosERetornar88e89(){
        ContaCorrente cont = new ContaCorrente( 1,"Bruno", "0911115684841", true);
        cont.depositar(100.00);
        cont.sacar(11.11);
        Double sac = 88.89;
        Assert.assertEquals(sac, cont.getSaldo());
    }
}