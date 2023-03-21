package Livaria;

import java.util.InputMismatchException;
import java.util.Scanner;

import Controle.CCliente;
import Controle.CEditora;
import Controle.CLivro;
import Controle.CVendaLivro;
import Model.Cliente;
import Model.Editora;
import util.Validadores;

public class Livraria { // Incio CLASS
    public static CCliente CadCliente = new CCliente();
    public static CEditora CadEditora = new CEditora();
    public static CLivro CadLivro = new CLivro();
    public static CVendaLivro CadVendaLivro = new CVendaLivro();
    public static Scanner ler = new Scanner(System.in);
    public static String tpCad = null;

    public static int LeiaNumINT() {// Inicio LEIA
        int num = 99;
        boolean leu = false;
        Scanner lerNum = new Scanner(System.in);
        while (!leu) {
            try {
                num = lerNum.nextInt();
                leu = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida, tente novamente!");
                ler.nextLine();
            }
        }
        return num;
    }// Fim LEIA

    // Inicio MENU
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
        tpCad = null;
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
     // Fim MENU

    // Inicio CLIENTE
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
            System.out.print("Informe o nome: ");
            nomeCliente = ler.nextLine();
            System.out.print("Informe o telefone: ");
            telefone = ler.nextLine();
            System.out.print("Informe o endereço: ");
            endereco = ler.nextLine();
            idCliente = CadCliente.geraID();
            Cliente cli = new Cliente(idCliente, nomeCliente, cpf, cnpj, endereco, telefone);
            CadCliente.addCliente(cli);
            System.out.println("Cliente cadastro com sucesso!");

        } // Fim DO
    }// Fim CADCLIENTE

    private static void editarCliente() {// Inicio EDICLIENTE
        System.out.println("|Editar Cliente|");
        System.out.print("Informe o CPF: ");
        String cpf = ler.nextLine();
        if (Validadores.isCPF(cpf)) {
            Cliente cli = CadCliente.getClienteCPF(cpf);
            if (cli != null) {
                System.out.println("1- Nome:\t" + cli.getNomeCliente());
                System.out.println("2- Endereco:\t" + cli.getEndereco());
                System.out.println("3- Telefone:\t" + cli.getTelefone());
                System.out.println("4- Todos os campos acima.");
                System.out.print("Qual campo gostaria de alterar ? +\nDigite aqui:");
                int opEditor = LeiaNumINT();
                if (opEditor == 1 || opEditor == 4) {
                    System.out.println("Informe o |Nome:");
                    cli.setNomeCliente(ler.nextLine());
                }
                if (opEditor == 2 || opEditor == 4) {
                    System.out.println("Informe o Endereço:");
                    cli.setEndereco(ler.nextLine());
                }
                if (opEditor == 3 || opEditor == 4) {
                    System.out.println("Informe o Telefone:");
                    cli.setTelefone(ler.nextLine());
                }
                System.out.println("Cliente \n" + cli.toString());
            } else {
                System.out.println("Cliente não consta na base de dados!.");
            }
        }

    }// Fim EDICLIENTE

    public static void deletarCliente() {// Inicio DELCLIENTE
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
    }// Fim DELCLIENTE

    public static void listarCliente() {// Inicio LISTACLIENTE
        for (Cliente cli : CadCliente.GetClientes()) {
            System.out.println("CPF: " + cli.getCpf());
            System.out.println("Nome:" + cli.getNomeCliente());
            System.out.println("Telefone: " + cli.getTelefone());
        }
    }// Fim LISTACLIENTE
     // Fim CLIENTE

    // Inicio EDITORA
    public static void cadastrarEditora() {// Inicio CADEDITORA
        int idEditora;
        String nomeEditora;
        String cnpj;
        String endereco;
        String telefone;
        String nomeGerente;

        System.out.println("|Cadastro de Editora|");
        System.out.print("Informe o CNPJ:");
        boolean cnpjis;
        int opCNPJ;
        do {// Inicio DO
            cnpj = ler.nextLine();
            cnpjis = Validadores.isCNPJ(cnpj);
            if (!cnpjis) {
                System.out.println("CNPJ inválido" + "\nDeseja tentar novamente ? 1 - Sim | 2 - Não");
                opCNPJ = LeiaNumINT();

                if (opCNPJ == 1) {
                    System.out.println("Informe o CNPJ:");
                } else if (opCNPJ == 2) {
                    System.out.println("Cadastro cancelado pelo usuário");
                    break;
                }
            }
        } while (!Validadores.isCNPJ(cnpj));
        if (CadEditora.getEditoraCNPJ(cnpj) != null) {
            System.out.println("Editora já cadastrada");
        } else {
            System.out.print("Informe o nome da Editora: ");
            nomeEditora = ler.nextLine();
            System.out.print("Informe o Telefone: ");
            telefone = ler.nextLine();
            System.out.print("Informe o Endereço: ");
            endereco = ler.nextLine();
            System.out.println("Informe o nome do Gerente: ");
            nomeGerente = ler.nextLine();
            idEditora = CadEditora.geraID();
            Editora edi = new Editora(idEditora, nomeEditora, cnpj, endereco, telefone, nomeGerente);
            CadEditora.addEditora(edi);
            System.out.println("Editora cadastrada com sucesso!");
        } // Fim DO
    }// Fim CADEDITORA

    private static void editarEditora() {// Inicio EDIEDITORA
        System.out.println("|Editar Editora|");
        System.out.print("Informe o CNPJ: ");
        String cnpj = ler.nextLine();
        if (Validadores.isCNPJ(cnpj)) {
            Editora edi = CadEditora.getEditoraCNPJ(cnpj);
            if (edi != null) {
                System.out.println("1- Nome Editora:\t" + edi.getnomeEditora());
                System.out.println("2- Endereço:\t" + edi.Getendereco());
                System.out.println("3- Telefone:\t" + edi.Gettelefone());
                System.out.println("4- Nome Gerente:\t" + edi.getgerente());
                System.out.println("5- Todos os campos acima.");
                System.out.print("Qual campo gostaria de alterar ? +\nDigite aqui:");
                int opEditor = LeiaNumINT();
                if (opEditor == 1 || opEditor == 5) {
                    System.out.println("Informe o Nome:");
                    edi.setNomeEditora(cnpj);
                }
                if (opEditor == 2 || opEditor == 5) {
                    System.out.println("Informe o Endereço:");
                    edi.setEndereco(cnpj);
                }
                if (opEditor == 3 || opEditor == 5) {
                    System.out.println("Informe o Telefone:");
                    edi.setTelefone(cnpj);
                }
                if (opEditor == 4 || opEditor == 5) {
                    System.out.println("Informe o Telefone:");
                    edi.setGerente(cnpj);
                }
                System.out.println("Editora \n" + edi.toString());
            } else {
                System.out.println("Editora não consta na base de dados!.");
            }
        }

    }// Fim EDIEDITORA

    public static void deletarEditora() {// Inicio DELEDITORA
        System.out.println("|Deletar Editora|");
        System.out.print("Informe o CNPJ: ");
        String cnpj = ler.next();
        if (Validadores.isCNPJ(cnpj)) {
            Editora edi = CadEditora.getEditoraCNPJ(cnpj);
            if (edi != null) {
                System.out.println("Editora deletada com sucesso!.");
            } else {
                System.out.println("Editora não consta na base de dados.");
            }
        } else
            System.out.println("CNPJ Inválido!.");
    }// Fim DELEDITORA

    public static void listarEditora() {// Inicio LISTAEDITORA
        for (Editora edi : CadEditora.getEditoras()) {
            System.out.println("CNPJ: " + edi.getcnpj());
            System.out.println("Nome Editora: " + edi.getnomeEditora());
            System.out.println("Telefone: " + edi.Gettelefone());
        }
    }// Fim LISTAEDITORA
     // Fim EDITORA

    /*
     * // Inicio LIVRO
     * public static void cadastrarLivro() {// Inicio CADLIVRO
     * int idEditora;
     * String nomeEditora;
     * String cnpj;
     * String endereco;
     * String telefone;
     * String nomeGerente;
     * 
     * System.out.println("|Cadastro de Editora|");
     * System.out.print("Informe o CNPJ:");
     * boolean cnpjis;
     * int opCNPJ;
     * do {// Inicio DO
     * cnpj = ler.nextLine();
     * cnpjis = Validadores.isCNPJ(cnpj);
     * if (!cnpjis) {
     * System.out.println("CNPJ inválido" +
     * "\nDeseja tentar novamente ? 1 - Sim | 2 - Não");
     * opCNPJ = LeiaNumINT();
     * 
     * if (opCNPJ == 1) {
     * System.out.println("Informe o CNPJ:");
     * } else if (opCNPJ == 2) {
     * System.out.println("Cadastro cancelado pelo usuário");
     * break;
     * }
     * }
     * } while (!Validadores.isCNPJ(cnpj));
     * if (CadEditora.getEditoraCNPJ(cnpj) != null) {
     * System.out.println("Editora já cadastrada");
     * } else {
     * System.out.print("Informe o nome da editora: ");
     * nomeEditora = ler.nextLine();
     * System.out.print("Informe o telefone: ");
     * telefone = ler.nextLine();
     * System.out.print("Informe o endereço: ");
     * endereco = ler.nextLine();
     * idEditora = CadEditora.geraID();
     * Editora edi = new Editora(idEditora, nomeEditora, cnpj, endereco, telefone,
     * nomeGerente)
     * CadEditora.addEditora(edi);
     * System.out.println("Editora cadastrada com sucesso!");
     * } // Fim DO
     * }// Fim CADLIVRO
     * 
     * private static void editarLivro() {// Inicio EDILIVRO
     * System.out.println("|Editar Editora|");
     * System.out.print("Informe o CNPJ: ");
     * String cnpj = ler.nextLine();
     * if (Validadores.isCNPJ(cnpj)) {
     * Editora edi = CadEditora.getEditoraCNPJ(cnpj);
     * if (edi != null) {
     * System.out.println("1- Nome Editora:\t" + edi.getnomeEditora());
     * System.out.println("2- Endereço:\t" + edi.Getendereco());
     * System.out.println("3- Telefone:\t" + edi.Gettelefone());
     * System.out.println("4- Nome Gerente:\t" + edi.getgerente());
     * System.out.println("5- Todos os campos acima.");
     * System.out.print("Qual campo gostaria de alterar ? +\nDigite aqui:");
     * int opEditor = LeiaNumINT();
     * if (opEditor == 1 || opEditor == 5) {
     * System.out.println("Informe o Nome:");
     * edi.setNomeEditora(cnpj);
     * }
     * if (opEditor == 2 || opEditor == 5) {
     * System.out.println("Informe o Endereço:");
     * edi.setEndereco(cnpj);
     * }
     * if (opEditor == 3 || opEditor == 5) {
     * System.out.println("Informe o Telefone:");
     * edi.setTelefone(cnpj);
     * }
     * if (opEditor == 4 || opEditor == 5) {
     * System.out.println("Informe o Telefone:");
     * edi.setGerente(cnpj);
     * }
     * System.out.println("Editora \n" + edi.toString());
     * } else {
     * System.out.println("Editora não consta na base de dados!.");
     * }
     * }
     * 
     * }// Fim EDILIVRO
     * 
     * public static void deletarLivro() {// Inicio DELLIVRO
     * System.out.println("|Deletar Editora|");
     * System.out.print("Informe o CNPJ: ");
     * String cnpj = ler.next();
     * if (Validadores.isCNPJ(cnpj)) {
     * Editora edi = CadEditora.getEditoraCNPJ(cnpj);
     * if (edi != null) {
     * System.out.println("Editora deletada com sucesso!.");
     * } else {
     * System.out.println("Editora não consta na base de dados.");
     * }
     * } else
     * System.out.println("CNPJ Inválido!.");
     * }// Fim DELLIVRO
     * 
     * public static void listarLivro() {// Inicio LISTALIVRO
     * for (Editora edi : CadEditora.getEditoras()) {
     * System.out.println("CNPJ: " + edi.getcnpj());
     * System.out.println("Nome Editora: " + edi.getnomeEditora());
     * System.out.println("Telefone: " + edi.Gettelefone());
     * }
     * }// Fim LISTALIVRO
     * // Fim LIVRO
     */
    public static void main(String[] args) {// Inicio VOID
        CadCliente.mockClientes();
        CadEditora.mockEditora();
        CadLivro.mockLivros();
        CadVendaLivro.mockVendaLivros();
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
                                System.out.println("-- Cadastrar --\n");
                                if (tpCad.equals("Cliente")) {
                                    cadastrarCliente();
                                }
                                if (tpCad.equals("Editora")) {
                                    cadastrarEditora();
                                }
                                if (tpCad.equals("Livro")) {
                                    cadastrarLivro();
                                }
                                break;
                            case 2:
                                System.out.println("-- Editar --\n");
                                if (tpCad.equals("Cliente")) {
                                    editarCliente();
                                }
                                if (tpCad.equals("Editora")) {
                                    editarEditora();
                                }
                                if (tpCad.equals("Livro")) {
                                    editarLivro();
                                }
                                break;
                            case 3:
                                System.out.println("-- Listar --\n");
                                if (tpCad.equals("Cliente")) {
                                    listarCliente();
                                }
                                if (tpCad.equals("Editora")) {
                                    listarEditora();
                                }
                                if (tpCad.equals("Livro")) {
                                    listarLivro();
                                }
                                break;
                            case 4:
                                System.out.println("-- Deletar --\n");
                                if (tpCad.equals("Cliente")) {
                                    deletarCliente();
                                }
                                if (tpCad.equals("Editora")) {
                                    deletarEditora();
                                }
                                if (tpCad.equals("Livro")) {
                                    deletarLivro();
                                }
                                break;
                            case 0:
                                System.out.println("-- Menu Principal --\n");
                                opM = 99;
                                MenuP();
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
