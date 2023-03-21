package Controle;

import java.util.ArrayList;
import Livaria.Livraria;
import Model.Livro;
import Model.VendaLivro;
import java.time.LocalDate;

public class CVendaLivro {
    ArrayList<VendaLivro> vendaLivros = new ArrayList<>();
    int idVendaLivro = 1;

    public int geraID() {
        return this.idVendaLivro++;
    }

    public void addVendaLivro(VendaLivro vl) {
        this.vendaLivros.add(vl);
    }

    public ArrayList<VendaLivro> getVendaLivros() {
        return this.vendaLivros;
    }

    public void removeVendaLivro(VendaLivro vl) {
        this.vendaLivros.remove(vl);
    }

    public void mockVendaLivros() {
        VendaLivro vl1 = new VendaLivro();
        vl1.setIdVendaLivro(this.geraID());
        vl1.setIdCliente(Livraria.CadCliente.getClienteCPF("987654321"));
        vl1.setDataVenda(LocalDate.parse("2023-05-25"));
        ArrayList<Livro> livro1 = new ArrayList<>();
        livro1.add(Livraria.CadLivro.getLivroISBN("172204932"));
        vl1.setSubTotal((float) 50.00);
        this.addVendaLivro(vl1);
    }

}