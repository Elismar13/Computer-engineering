package br.ifpb.edu;

import br.ifpb.edu.exception.EntradaInvalidaException;
import br.ifpb.edu.exception.QuantiaNaoNegativaException;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        Banco banco = new Banco();
        Menu.exibirMenu();

        while(true) {
            System.out.print("O que deseja fazer? ");
            int opcao = s1.nextInt();
            Long id;
            ContaCorrente conta;

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do usuário: ");
                    String nome = s2.nextLine();
                    System.out.print("O usuário deseja sacar? S/N ");
                    String primeiroSaque = s2.nextLine();
                    ContaCorrente novaConta;

                    try {
                        if (primeiroSaque.equals("S")) {
                            System.out.print("Digite a quantia: ");
                            BigDecimal quantia = s2.nextBigDecimal();
                            novaConta = banco.criaConta(nome, quantia);
                        } else if (primeiroSaque.equals("N")) {
                            novaConta = banco.criaConta(nome);
                        } else {
                            System.out.println("Opcao invalida. Tente novamente");
                            break;
                        }
                    } catch (EntradaInvalidaException e) {
                        System.out.println("ERRO DE ENTRADA: " + e.getMessage() + "\nCancelando operação.");
                        break;
                    }
                    catch (QuantiaNaoNegativaException e) {
                        System.out.println("ERRO DE QUANTIA NEGATIVA: " + e.getMessage() + "\nCancelando operação.");
                        break;
                    }

                    System.out.println("Conta criada com sucesso.\nANOTE SEU ID: " + novaConta.getNumero());
                    break;

                case 2:
                    System.out.print("Digite o numero da sua conta: ");
                    id = digitarID();
                    conta = banco.procurarContaPorId(id);
                    if(conta == null) {
                        System.out.println("Este id não existe! Tente novamente.");
                        break;
                    }

                    try {
                        System.out.print("Quanto voce deseja depositar? ");
                        BigDecimal valor = s2.nextBigDecimal();
                        conta.deposito(valor);
                        banco.atualizaConta(id, conta);
                        System.out.println("Conta atualizada com sucesso!");
                        break;
                    } catch ( QuantiaNaoNegativaException e ) {
                        System.out.println("ERRO: " + e.getMessage() + "\nCancelando operação.");
                        break;
                    }
                    catch(EntradaInvalidaException e) {
                        System.out.println("ERRO!" + e.getMessage() + "\nCancelando operação.");
                        break;
                    }
                    catch(Exception e) {
                        System.out.println("ERRO do Scanner!");
                    }

                case 3:
                    System.out.print("Digite o ID da conta: ");
                    id = digitarID();
                    conta = banco.procurarContaPorId(id);
                    if(conta == null) {
                        System.out.println("Este id não existe! Tente novamente.");
                        break;
                    }

                    try {
                        System.out.print("Quanto vocẽ deseja sacar? ");
                        s2.nextBigDecimal();


                    }
                case 6:
                    System.out.println("Saindo...");
                    System.exit(0);
            }
        }
    }

    private static Long digitarID() {
        try(Scanner s3 = new Scanner(System.in);)
        {
            Long id = s3.nextLong();
            return id;
        } catch (Exception e) {
            System.out.println("Erro ao realziar operação de entrada. Causa: " + e.getMessage());
        }
        return 0L;
    }
}
