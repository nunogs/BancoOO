
package com.db1start;


import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContaCorrenteTest {
    @Test
    public void deveCriarAlunoPorMeioDoConstrutor(){
        ContaCorrente cont = new ContaCorrente( 1,"Bruno");
        String nome = "Bruno";
        Integer conta = 1;
        Assert.assertEquals(nome, cont.getDono());
        Assert.assertEquals(conta, cont.getnConta());
    }

    @Test
    public void deveAbrirConta(){
        ContaCorrente cont = new ContaCorrente();
        cont.abrirConta();
        Assert.assertEquals(true, cont.getAberta());
    }
    @Test
    public void deveFecharConta(){
        ContaCorrente cont = new ContaCorrente();
        cont.abrirConta();
        cont.setAberta(false);
        Assert.assertEquals(false, cont.getAberta());
    }

    @Test
    public void deveDepositar11ReaisE11Centavos(){
        ContaCorrente cont = new ContaCorrente();
        cont.setSaldo(11.11);
        Double dep = 11.11;
        Assert.assertEquals(dep, cont.getSaldo());
    }
    @Test
    public void deveSacar11ReaisE11CentavosERetornar88e89(){
        ContaCorrente cont = new ContaCorrente();
        cont.setSaldo(100.00);
        cont.sacar(11.11);
        Double sac = 88.89;
        Assert.assertEquals(sac, cont.getSaldo());
    }
}