import br.ifpb.edu.Banco;
import br.ifpb.edu.ContaCorrente;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class TesteBanco {
    private final BigDecimal SALDOINICIAL = new BigDecimal("10.00");
    private Banco banco;
    private ContaCorrente conta;

    @Before
    public void start() {
        banco = new Banco();
        conta = null;
    }

    @Test
    public void testaCriacaoDeContasAPartirDoBanco() {
        try {
            conta = banco.cadrastro("Elismar");
            Assert.assertNotNull(conta);
            Assert.assertEquals(conta.getTitular(), "Elismar");
            Assert.assertEquals(conta.saldo(), SALDOINICIAL);

            conta = banco.cadrastro("Zé Rocha", new BigDecimal(100.00));
            Assert.assertNotNull(conta);
            Assert.assertEquals(conta.getTitular(), "Zé Rocha");
            Assert.assertEquals(conta.saldo(), new BigDecimal("100.00"));
        } catch (Exception e) {
            throw new AssertionError("Erro no cadrastro!");
        }
    }

    @Test
    public void testaCriacaoEAtualizacaoDeContas() {
        try {
            ContaCorrente contaAtualizada;

            conta = banco.cadrastro("Elismar");
            contaAtualizada = conta;
            contaAtualizada.deposito(new BigDecimal("10.00"));
            contaAtualizada = banco.atualizaConta(conta.getNumero(), contaAtualizada);
            Assert.assertNotEquals(conta, contaAtualizada);

            banco.cadrastro("Joao", new BigDecimal("90.00"));
            conta.deposito(new BigDecimal("10.00"));
            contaAtualizada = banco.atualizaConta(conta.getNumero(), conta);
            Assert.assertNotEquals(conta, contaAtualizada);

        } catch (Exception e) {
            throw new AssertionError("Erro no teste!");
        }
    }
}

