package Livaria;

import java.util.InputMismatchException;
import java.util.Scanner;

import Controle.CCliente;
import Controle.CEditora;
import Controle.CLivro;
import Controle.CVendaLivro;
import Model.Cliente;
import util.Validadores;

public class Livraria { // Incio CLASS
    public static CCliente CadCliente = new CCliente();
    public static CEditora CadEditora = new CEditora();
    public static CLivro CadLivro = new CLivro();
    public static CVendaLivro CadVendaLivro = new CVendaLivro();
    public static Scanner ler = new Scanner(System.in);

    public static int LeiaNumINT() {// Inicio LEIA
        int num = 99;
        boolean leu = false;
        Scanner lerNum = new Scanner(System.in);
        while(!leu){
            try{
                num = lerNum.nextInt();
                leu = true;
            } catch (InputMismatchException e){
                System.out.println("Entrada inválida, tente novamente!");
                ler.nextLine():
            }
        } return num;
    }// Fim LEIA

    public static void MenuP() {// Inicio MENU
        System.out.println();
        System.out.println();
        System.out.println("|-------------------|");
        System.out.println("|--    LIVRARIA   --|");
        System.out.println("|-------------------|");
        System.out.println("| 1 - Ger. Cliente  |");
        System.out.println("| 2 - Ger. Editora  |");
        System.out.println("| 3 - Ger. Livro    |");
        System.out.println("| 4 - Venda Livro   |");
        System.out.println("| 0 - Sair          |");
        System.out.println("|-------------------|");
        System.out.print(" Escolha uma opção: ");

    }// Fim MENU

    public static void SubMenu(int op) {// Inicio SUBMENU
        String tpCad = null;
        switch (op) {
            case 1:
                tpCad = "Cliente";
                break;
            case 2:
                tpCad = "Editora";
                break;
            case 3:
                tpCad = "Livro";
                break;
        }
        System.out.println();
        System.out.println();
        System.out.println("|------------------------------|");
        System.out.println("|--       Gerenciamento      --|");
        System.out.println("|------------------------------|");
        System.out.println("| 1 - Cadastrar " + tpCad + "        |");
        System.out.println("| 2 - Editar " + tpCad + "        |");
        System.out.println("| 3 - Listar " + tpCad + "        |");
        System.out.println("| 4 - Deletar " + tpCad + "        |");
        System.out.println("| 0 - Voltar                   |");
        System.out.println("|------------------------------|");
        System.out.print(" Escolha uma opção: ");
    }// Fim SUBMENU

    public static void cadastrarCliente() {// Inicio CADCLIENTE
        int idCliente;
        String nomeCliente;
        String cpf;
        String cnpj = null;
        String endereco;
        String telefone;

        System.out.println("|Cadastro de Cliente|");
        System.out.print("Informe o CPF:");
        boolean cpfis;
        int opCPF;
        do {// Inicio DO
            cpf = ler.nextLine();
            cpfis = Validadores.isCPF(cpf);
            if (!cpfis) {
                System.out.println("CPF inválido" + "\nDeseja tentar novamente ? 1 - Sim | 2 - Não");
                opCPF = LeiaNumINT();

                if (opCPF == 1) {
                    System.out.println("Informe o CPF:");
                } else if (opCPF == 2) {
                    System.out.println("Cadastro cancelado pelo usuário");
                    break;
                }
            }
        } while (!Validadores.isCPF(cpf));
        if (CadCliente.getClienteCPF(cpf) != null) {
            System.out.println("Cliente já cadastrado");
        } else {
            System.out.println("Informe o nome: ");
            nomeCliente = ler.nextLine();
            System.out.println("Informe o telefone: ");
            telefone = ler.nextLine();
            System.out.println("Informe o endereço: ");
            endereco = ler.nextLine();
            idCliente = CadCliente.geraID();
            Cliente cli = new Cliente(idCliente, nomeCliente, cpf, cnpj, endereco, telefone);
            CadCliente.addCliente(cli);
            System.out.println("Cliente cadastro com sucesso!");

        } // Fim DO
    }// Fim CADCLIENTE

    public static void deletarCliente() {// Inicio DELETAR
        System.out.println("|Deletar Cliente|");
        System.out.print("Informe o CPF: ");
        String cpf = ler.next();
        if (Validadores.isCPF(cpf)) {
            Cliente cli = CadCliente.getClienteCPF(cpf);
            if (cli != null) {
                System.out.println("Cliente deletado com sucesso!.");
            } else {
                System.out.println("Cliente não consta na base de dados.");
            }
        } else
            System.out.println("CPF Inválido!.");
    }// Fim DELETAR

    public static void listarCliente() {// Inicio LISTAR
        for (Cliente cli : CadCliente.GetClientes()) {
            System.out.println("\nCPF: " + cli.getCpf());
            System.out.println("Nome: " + cli.getNomeCliente());
            System.out.println("Telefone: " + cli.getTelefone());
        }
    }// Fim LISTAR

    public static void main(String[] args) {// Inicio VOID
        int opM;
        do {
            MenuP();
            opM = LeiaNumINT();
            switch (opM) {
                case 1:
                case 2:
                case 3:

                    int opSM;
                    do {
                        SubMenu(opM);
                        opSM = LeiaNumINT();

                        switch (opSM) {
                            case 1:
                                System.out.println("-- Cadastrar --");
                                break;
                            case 2:
                                System.out.println("-- Editar --");
                                break;
                            case 3:
                                System.out.println("-- Listar --");
                                break;
                            case 4:
                                System.out.println("-- Deletar --");
                                break;
                            case 0:
                                System.out.println("-- Menu Principal --");
                                opM = 99;
                                break;
                            default:
                                System.out.println("Opção inválida, tente novamente!!");
                                break;
                        }

                    } while (opSM != 0); // SubMenu
                    break;
                case 4:
                    System.out.println("-- Venda Livros--");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente!!");
                    break;
            }
        } while (opM != 0);// Sistema
    }// Fim VOID
}// Fim CLASS
