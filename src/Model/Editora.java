package Model;

public class Editora {
    private int idEditora;
    private String nomeEditora;
    private String cnpj;
    private String endereco;
    private String telefone;
    private String gerente;

    public Editora() {
    }

    public Editora(int idEditora, String nomeEditora, String cnpj, String endereco, String telefone,
            String gerente) {
        this.idEditora = idEditora;
        this.nomeEditora = nomeEditora;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
        this.gerente = gerente;
    }

    public int getIdEditora() {
        return idEditora;
    }

    public void setIdEditora(int idEditora) {
        this.idEditora = idEditora;
    }

    public String getnomeEditora() {
        return nomeEditora;
    }

    public void setNomeEditora(String nomeEditora) {
        this.nomeEditora = nomeEditora;
    }

    public String getcnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String Getendereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String Gettelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getgerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    @Override
    public String toString() {
        return "Editora | idEditora: " + idEditora + "| nomeEditora: " + nomeEditora +
                "| cnpj: " + cnpj + "| endereco: " + endereco + "| telefone: "
                + telefone + ", gerente: " + gerente + "|";
    }

}
