package Livaria;

import java.util.Scanner;

import Controle.CCliente;
import Controle.CEditora;
import Controle.CLivro;
import Controle.CVendaLivro;

public class Livraria {
    public static CCliente CadCliente = new CCliente();
    public static CEditora CadEditora = new CEditora();
    public static CLivro CadLivro = new CLivro();
    public static CVendaLivro CadVendaLivro = new CVendaLivro();

    public static int LeiaNumINT() {
        try {
            Scanner leia = new Scanner(System.in);
            return leia.nextInt();
        } catch (Exception e) {
            System.out.println("Tente novamente!");
            LeiaNumINT();
        }
        return 0;
    }

    public static void MenuP() {
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

    }

    public static void SubMenu(int op) {
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
    }

    public static void main(String[] args) {
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
    }
}
