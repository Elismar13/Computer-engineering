package br.ifpb.edu;

import br.ifpb.edu.exception.EntradaInvalidaException;
import br.ifpb.edu.exception.QuantiaNaoNegativaException;
import br.ifpb.edu.exception.SaldoInuficienteException;
import org.junit.Assert;
import org.junit.function.ThrowingRunnable;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ContaCorrenteTest {
    @Test
    void TestaImpostoCPMF() {
        try {
            ContaCorrente c1 = new ContaCorrente(555L, "Elismar", new BigDecimal(400.00));
            BigDecimal valor = c1.sacar(new BigDecimal(100.00));
            Assert.assertEquals(valor.doubleValue(), 100.00, 0);
            Assert.assertEquals(c1.saldo(), 296.00, 0);
        } catch (Exception e) { }

        try {
            ContaCorrente c1 = new ContaCorrente(555L, "Isabela");
            BigDecimal valor = c1.sacar(new BigDecimal(1.00));
            Assert.assertEquals(valor.doubleValue(), 1.00, 0);
            Assert.assertEquals(c1.saldo(), 8.90, 0);
        } catch (Exception e) { }
    }

    @Test
    void DepositaEVerificaSaldoValido() {
        try {
            ContaCorrente c1 = new ContaCorrente(555L, "Elismar");
            c1.deposito(new BigDecimal(25.00));
            Assert.assertEquals( 35.00, c1.saldo(), 0 );
        } catch (Exception e) {}

        try {
            ContaCorrente c2 = new ContaCorrente(13L, "Julia");
            c2.deposito(new BigDecimal(10.00));
            Assert.assertEquals( 20.00, c2.saldo(), 0 );
        } catch (Exception e) {}

        try {
            ContaCorrente c3  = new ContaCorrente(89L, "Joao");
            c3.deposito(new BigDecimal(100.00));
            Assert.assertEquals( 110.00, c3.saldo(), 0 );
        } catch (Exception e) {}

        try {
            ContaCorrente c4  = new ContaCorrente(8787L, "Carlos", new BigDecimal(1000.00));
            c4.deposito(new BigDecimal(100.00));
            Assert.assertEquals( 1100.00, c4.saldo(), 0 );
        } catch (Exception e) {}
    }

    @Test
    void VerificaDepositosNegativos() {
        // confirmando que tipo da exceção gerada é QuantiaNaoNegativaException
        Assert.assertThrows(QuantiaNaoNegativaException.class, () ->  {
                ContaCorrente c1 = new ContaCorrente(555L, "Elismar");
                c1.deposito(new BigDecimal(-100));
            }
        );
        Assert.assertThrows(QuantiaNaoNegativaException.class, () ->  {
                ContaCorrente c1 = new ContaCorrente(555L, "Elismar");
                c1.deposito(new BigDecimal(-10));
            }
        );
        Assert.assertThrows(QuantiaNaoNegativaException.class, () ->  {
             ContaCorrente c1 = new ContaCorrente(555L, "Elismar");
             c1.deposito(new BigDecimal(-1));
            }
        );
        Assert.assertThrows(QuantiaNaoNegativaException.class, () ->  {
                ContaCorrente c1 = new ContaCorrente(555L, "Elismar");
                c1.deposito(new BigDecimal(-0.01));
            }
        );
    }
}