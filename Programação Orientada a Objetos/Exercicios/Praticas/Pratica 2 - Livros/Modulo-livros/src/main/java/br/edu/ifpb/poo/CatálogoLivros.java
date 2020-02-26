package br.edu.ifpb.poo;

import java.util.ArrayList;

public class CatálogoLivros {
    private ArrayList<Livro> lista;
    private int quantidade;

    CatálogoLivros() {
        this.lista = new ArrayList();
        this.quantidade = 0;
    }

    public int getQuantidadeLivros() {
        return quantidade;
    }

    public boolean adicionaLivro( int id, String livro ) {
        if(!livro.isEmpty()) {
            Livro NovoLivro = new Livro(id, livro);
            if(!lista.contains(NovoLivro)) {
                this.lista.add(NovoLivro);
                quantidade += 1;

                return true;
            }
        }
        return false;
    }

    public boolean removeLivro( int id ) {
        if( id >= 0 && quantidade > 0 ) {
            for( int i = 0; i < quantidade; i++ ) {
                Livro book = lista.get(i);
                if( book.getId() == id ) {
                    lista.remove( book );
                    quantidade -= 1;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "CatálogoLivros{" +
                "lista=" + lista +
                ", quantidade=" + quantidade +
                '}';
    }
}