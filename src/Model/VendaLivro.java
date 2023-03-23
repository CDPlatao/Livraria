package Model;

import java.time.LocalDate;

import java.util.ArrayList;

public class VendaLivro {
    private int idVendaLivro;
    private Cliente idCliente;
    private ArrayList<Livro> idLivro;
    private int quant;
    private float subTotal;
    private LocalDate dataVenda;
    private int idVenda;

    public VendaLivro() {
    }

    public VendaLivro(int idVendaLivro, Cliente idCliente, ArrayList<Livro> idLivro, int quant, float subTotal,
            LocalDate dataVenda, int idVenda) {
        this.idVendaLivro = idVendaLivro;
        this.idCliente = idCliente;
        this.idLivro = idLivro;
        this.quant = quant;
        this.subTotal = subTotal;
        this.dataVenda = dataVenda;
        this.idVenda = idVenda;
    }

    public int getIdVendaLivro() {
        return idVendaLivro;
    }

    public void setIdVendaLivro(int idVendaLivro) {
        this.idVendaLivro = idVendaLivro;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public ArrayList<Livro> getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(ArrayList<Livro> idLivro) {
        this.idLivro = idLivro;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    @Override
    public String toString() {
        return "VendaLivro | ID: " + idVendaLivro + " | Cliente: " + idCliente + " | Livro: " + idLivro
                + " | Quantidade: " + quant + " | SubTOTAL: " + subTotal + " | Data da venda: " + dataVenda
                + " | Venda: " + idVenda
                + "|";
    }

}
