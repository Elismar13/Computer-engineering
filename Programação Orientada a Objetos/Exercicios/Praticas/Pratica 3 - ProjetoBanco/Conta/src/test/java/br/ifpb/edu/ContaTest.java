package br.ifpb.edu;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContaTest {
    @Test
    void DepositaContaEVerificaDepositosNegativos() {
        Conta c1 = new Conta( 555, "Elismar", 200.00 );
        Assert.assertTrue( c1.deposito(200) );
        Assert.assertTrue( c1.deposito(100) );
        Assert.assertFalse( c1.deposito(-100) );
        Assert.assertFalse( c1.deposito(-800) );
        Assert.assertTrue( c1.deposito(100) );
    }

    void SacaEVerificaSaquesRealizadosNaConta() {
        Conta c1 = new Conta( 555, "Elismar", 200.00 );
        Assert.assertTrue( c1.sacar(200) );
        Assert.assertFalse( c1.sacar(10000) );
        Assert.assertFalse( c1.sacar(-100) );
        Assert.assertTrue( c1.sacar(0) );
    }

    void SaldoEVerificaSaldo() {
        Conta c1 = new Conta( 555, "Elismar", 200.00 );
        Assert.assertEquals( 200, c1.saldo() );
        c1.deposito(300);
        Assert.assertEquals( 500, c1.saldo() );     //Verificar a questão dos 1% que o professor especifica na prática
    }
}