package Controle;

import java.util.ArrayList;
import Model.Cliente;

public class CCliente {
    ArrayList<Cliente> clientes = new ArrayList<>();
    int idCliente = 1;

    public int geraID() {
        return this.idCliente++;
    }

    public void addCliente(Cliente c) {
        this.clientes.add(c);
    }

    public ArrayList<Cliente> GetClientes() {
        return this.clientes;
    }

    public void removeCliente(Cliente c) {
        this.clientes.remove(c);
    }

    public void mockClientes() {
        Cliente c1 = new Cliente();
        c1.setIdCliente(this.geraID());
        c1.setNomeCliente("Juvenal das Candongas");
        c1.setCpf("123456789");
        c1.setEndereco("Rua das Oliveiras");
        c1.setTelefone("5188899988899");
        this.addCliente(c1);
        Cliente c2 = new Cliente();
        c2.setIdCliente(this.geraID());
        c2.setNomeCliente("Barbara Paz");
        c2.setCpf("987654321");
        c2.setEndereco("Rua das Flores");
        c2.setTelefone("5199988899988");
        this.addCliente(c2);
    }

    public Cliente getClienteCPF(String cpf) {
        Cliente c = null;
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                c = cliente;
                break;
            }
        }
        return c;
    }
}
