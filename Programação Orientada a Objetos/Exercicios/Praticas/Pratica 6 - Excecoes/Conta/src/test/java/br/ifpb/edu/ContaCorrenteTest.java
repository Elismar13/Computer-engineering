package br.ifpb.edu;

import br.ifpb.edu.exception.EntradaInvalidaException;
import br.ifpb.edu.exception.QuantiaNaoNegativaException;
import org.junit.Assert;
import org.junit.function.ThrowingRunnable;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ContaCorrenteTest {
    @Test
    void DepositaEVerificaSaldo() {
        ContaCorrente c1 = new ContaCorrente(555L, "Elismar");
        try {
            c1.deposito(new BigDecimal(25.00));
        } catch (Exception e) {}
        Assert.assertEquals( 35.00, c1.saldo(), 0 );

        ContaCorrente c2 = new ContaCorrente(13L, "Julia");
        try {
            c2.deposito(new BigDecimal(10.00));
        } catch (Exception e) {}
        Assert.assertEquals( 20.00, c2.saldo(), 0 );

        ContaCorrente c3  = new ContaCorrente(89L, "Joao");
        try {
            c3.deposito(new BigDecimal(100.00));
        } catch (Exception e) {}
        Assert.assertEquals( 110.00, c3.saldo(), 0 );

        ContaCorrente c4  = new ContaCorrente(8787L, "Carlos", new BigDecimal(1000.00));
        try {
            c4.deposito(new BigDecimal(100.00));
        } catch (Exception e) {}
        Assert.assertEquals( 1100.00, c4.saldo(), 0 );
    }

    @Test
    void VerificaDepositosNegativos() {
        ContaCorrente c1 = new ContaCorrente(555L, "Elismar");

        // confirmando que tipo da exceção gerada é QuantiaNaoNegativaException
        Assert.assertThrows(QuantiaNaoNegativaException.class, () ->  {
                c1.deposito(new BigDecimal(-100));
            }
        );
        Assert.assertThrows(QuantiaNaoNegativaException.class, () ->  {
                c1.deposito(new BigDecimal(-10));
            }
        );
        Assert.assertThrows(QuantiaNaoNegativaException.class, () ->  {
                c1.deposito(new BigDecimal(-1));
            }
        );
        Assert.assertThrows(QuantiaNaoNegativaException.class, () ->  {
                c1.deposito(new BigDecimal(-0.01));
            }
        );
    }

    void SacaEVerificaSaquesRealizadosNaConta() {
        ContaCorrente c1 = new ContaCorrente( 555, "Elismar");
        Assert.assertTrue( c1.sacar(200) );
        Assert.assertFalse( c1.sacar(10000) );
        Assert.assertFalse( c1.sacar(-100) );
        Assert.assertTrue( c1.sacar(0) );
    }

    void SaldoEVerificaSaldo() {
//        ContaCorrente c1 = new ContaCorrente( 555, "Elismar" );
//        Assert.assertEquals( 200, c1.saldo() );
//        c1.deposito(300);
//        Assert.assertEquals( 500, c1.saldo() );     //Verificar a questão dos 1% que o professor especifica na prática
    }
}