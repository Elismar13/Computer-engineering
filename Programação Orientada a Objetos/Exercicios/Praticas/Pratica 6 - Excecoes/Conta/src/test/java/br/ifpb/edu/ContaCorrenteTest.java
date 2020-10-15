package br.ifpb.edu;

import br.ifpb.edu.exception.EntradaInvalidaException;
import br.ifpb.edu.exception.QuantiaNaoNegativaException;
import org.junit.Assert;
import org.junit.function.ThrowingRunnable;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ContaCorrenteTest {
    @Test
    void DepositaContaEVerificaDepositosNegativos() {
        ContaCorrente c1 = new ContaCorrente(555L, "Elismar");

        try {
            c1.deposito(new BigDecimal(200.00));
        } catch (QuantiaNaoNegativaException e) {

        };
        Assert.assertEquals( 210.00, c1.saldo(), 0 );

        // deposito negativos e garantindo o tipo da exceção
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
//        ContaCorrente c1 = new ContaCorrente( 555, "Elismar");
//        Assert.assertTrue( c1.sacar(200) );
//        Assert.assertFalse( c1.sacar(10000) );
//        Assert.assertFalse( c1.sacar(-100) );
//        Assert.assertTrue( c1.sacar(0) );
    }

    void SaldoEVerificaSaldo() {
//        ContaCorrente c1 = new ContaCorrente( 555, "Elismar" );
//        Assert.assertEquals( 200, c1.saldo() );
//        c1.deposito(300);
//        Assert.assertEquals( 500, c1.saldo() );     //Verificar a questão dos 1% que o professor especifica na prática
    }
}