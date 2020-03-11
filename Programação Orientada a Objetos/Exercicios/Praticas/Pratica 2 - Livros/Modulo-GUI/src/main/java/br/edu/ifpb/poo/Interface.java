package br.edu.ifpb.poo;

public class Interface {
    public static void main(String[] args) {
        CatálogoLivros livros = new CatálogoLivros();

        livros.adicionaLivro(555, "A menina que roubava livros");
        livros.adicionaLivro(784, "A sutil arte de ligar o foda-se");

        System.out.println(livros.getQuantidadeLivros());
        System.out.println(livros.toString());
    }
}
