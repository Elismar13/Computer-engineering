package br.ifpb.edu;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Banco {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        HashMap<Long, ContaCorrente> contas = new HashMap<Long, ContaCorrente>;

        Menu.exibirMenu();
        int opcao = s1.nextInt();

        switch (opcao) {
            case 1:
                Long id;
                String nome;
                ContaCorrente novaConta = new ContaCorrente();
        }
    }
}
