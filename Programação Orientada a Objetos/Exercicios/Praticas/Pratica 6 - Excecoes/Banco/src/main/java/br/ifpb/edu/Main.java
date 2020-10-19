package br.ifpb.edu;

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

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do usuário: ");
                    String nome = s2.nextLine();
                    System.out.print("O usuário deseja sacar? S/N");
                    String primeiroSaque = s2.nextLine();
                    ContaCorrente novaConta;

                    if (primeiroSaque.equals("S")) {
                        System.out.print("Digite a quantia: ");
                        double quantia = s1.nextDouble();
                        banco.criaConta(nome, new BigDecimal(quantia));
                    } else if (primeiroSaque.equals("N")) {
                        banco.criaConta(nome);
                    } else {
                        System.out.println("Opcao invalida. Tente novamente");
                        break;
                    }

                    System.out.println("Conta criada com sucesso.");
                    break;

                case 6:
                    System.out.println("Saindo...");
                    System.exit(0);
            }
        }
    }
}
