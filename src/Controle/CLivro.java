package Controle;

import java.util.ArrayList;

import Livaria.Livraria;
import Model.Livro;

public class CLivro {
    ArrayList<Livro> livros = new ArrayList<>();
    int idLivro = 1;

    public int geraID() {
        return this.idLivro++;
    }

    public void addLivro(Livro l) {
        this.livros.add(l);
    }

    public ArrayList<Livro> getLivros() {
        return this.livros;
    }

    public void removeLivro(Livro l) {
        this.livros.remove(1);
    }

    public void mockLivros() {
        Livro l1 = new Livro();
        l1.setIdLivro(this.geraID());
        l1.setIdEditora(Livraria.CadEditora.getEditoraCNPJ("567890451"));
        l1.setNomeLivro("A bela e a Fera");
        l1.setAutor("Jorél");
        l1.setIsbn("172204932");
        l1.setAssunto("Um livro que conta a história sobre a bela e a fera");
        l1.setEstoque(42);
        l1.setPreco((float) 19.90);
        this.addLivro(l1);

        Livro l2 = new Livro();
        l2.setIdLivro(this.geraID());
        l2.setIdEditora(Livraria.CadEditora.getEditoraCNPJ("745087100"));
        l2.setNomeLivro("Conhecimentos e utilizações do ChatGPT");
        l2.setAutor("Sérgio");
        l2.setIsbn("608604936");
        l2.setAssunto("um livro que detalha,ensina e analisa detalhes sobre o ChatGPT");
        l2.setEstoque(18);
        l2.setPreco((float) 68.18);
        this.addLivro(l2);
    }

    public Livro getLivroISBN(String isbn) {
        Livro l = null;
        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn)) {
                l = livro;
                break;
            }
        }
        return l;
    }

    public boolean AtualizaEstoqueLivro(String isbn) {
        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn)) {
                if (livro.getEstoque() > 0) {
                    livro.setEstoque(livro.getEstoque() - 1);
                    return true;
                }
            }

        }
        return false;
    }
}