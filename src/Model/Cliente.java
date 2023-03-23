package Model;

public class Cliente {

    private int idCliente;
    private String nomeCliente;
    private String cpf;
    private String cnpj;
    private String endereco;
    private String telefone;

    public Cliente() {
    }

    public Cliente(int idCliente, String nomeCliente, String cpf, String cnpj, String endereco,
            String telefone) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Cliente | Nome do CLiente: " + nomeCliente + " | CPF: " + cpf + " | CNPJ: " + cnpj
                + " | Endereço: " + endereco + " | Telefone: " + telefone + "|";
    }

}