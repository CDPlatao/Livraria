package Model;

public class Livro {
    private int idLivro;
    private String nomeLivro;
    private String autor;
    private String assunto;
    private String isbn;
    private int estoque;
    private float preco;
    private Editora idEditora;

    public Livro() {
    }   

    public Livro(int idLivro, String nomeLivro, String autor, String assunto, String isbn, int estoque, float preco,
            Editora idEditora) {
        this.idLivro = idLivro;
        this.nomeLivro = nomeLivro;
        this.autor = autor;
        this.assunto = assunto;
        this.isbn = isbn;
        this.estoque = estoque;
        this.preco = preco;
        this.idEditora = idEditora;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Editora getIdEditora() {
        return idEditora;
    }

    public void setIdEditora(Editora idEditora) {
        this.idEditora = idEditora;
    }

    @Override
    public String toString() {
        return "Livro | idLivro: " + idLivro + "| nomeLivro: " + nomeLivro + "| autor: " + autor + "| assunto: " + assunto
                + "| isbn: " + isbn + "| estoque: " + estoque + "| preco: " + preco + "| idEditora: " + idEditora + "|";
    }

}
