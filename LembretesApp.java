/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Registro;

/**
 *
 * @author laiane
 */
import java.util.Scanner;
import java.util.List;

public class LembretesApp {
    public static void main(String[] args) {
        BlocoDeLembretes blocoDeLembretes = new BlocoDeLembretes();
        Scanner scanner = new Scanner(System.in);

        int opcao = 0;
while (opcao != 9) {
    opcao = menu();
    if (opcao == 1) {
        menuInserirLembrete(blocoDeLembretes, scanner);
    } else if (opcao == 2) {
        menuRemoverLembrete(blocoDeLembretes, scanner);
    } else if (opcao == 3) {
        menuBuscarSubstring(blocoDeLembretes, scanner);
    } else if (opcao == 4) {
        menuBuscarMes(blocoDeLembretes, scanner);
    } else if (opcao == 5) {
        menuBuscarPorDia(blocoDeLembretes, scanner);
    } else if (opcao == 6) {
        System.out.println("#### Todos os Lembretes ####");
        System.out.println(blocoDeLembretes);
    } else if (opcao == 7) {
        menuImprimirLembretesPorMes(blocoDeLembretes, scanner);
    } else if (opcao == 8) {
        menuImprimirLembretesPorDia(blocoDeLembretes, scanner);
    } else if (opcao == 9) {
        System.out.println("Saindo do programa.");
    } else {
        System.out.println("Opcao invalida. Tente novamente.");
    }
}

    }

    private static int menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("#### MENU ####");
        System.out.print("Escolha uma opcao: \n");
        System.out.println("1- Inserir Lembrete");
        System.out.println("2- Remover Lembrete");
        System.out.println("3- Buscar Lembrete");
        System.out.println("4- Buscar Mes");
        System.out.println("5- Buscar Dia");
        System.out.println("6- Imprimir Todos os Lembretes");
        System.out.println("7- Imprimir Lembretes por Mes");
        System.out.println("8- Imprimir Lembretes por Dia");
        System.out.println("9- Sair");
        
        return scanner.nextInt();
    }

    private static void menuInserirLembrete(BlocoDeLembretes blocoDeLembretes, Scanner scanner) {
    System.out.println("Digite a data (dd/mm/aaaa): ");
    String data = scanner.next(); 
    System.out.println("Digite o lembrete: ");
    String lembrete = scanner.next();
    blocoDeLembretes.adicionarLembrete(new Lembrete(data, lembrete));
    System.out.println("O lembrete foi inserido");
}


    private static void menuRemoverLembrete(BlocoDeLembretes blocoDeLembretes, Scanner scanner) {
        System.out.println("Digite o numero do lembrete que deseja remover: ");
        int indice = scanner.nextInt();
        blocoDeLembretes.removerLembrete(indice);
        System.out.println("O lembrete foi removido");
    }

    private static void menuBuscarSubstring(BlocoDeLembretes blocoDeLembretes, Scanner scanner) {
        scanner.nextLine();
        System.out.println("Digite uma substring: ");
        String substring = scanner.nextLine();
        List<Lembrete> retornos = blocoDeLembretes.buscarSubstring(substring);
        System.out.println("Lembretes encontrados:");
        for (Lembrete lembrete : retornos) {
            System.out.println(lembrete);
        }
    }

    private static void menuBuscarMes(BlocoDeLembretes blocoDeLembretes, Scanner scanner) {
        System.out.println("Digite o mes: ");
        int mes = scanner.nextInt();
        List<Lembrete> retornos = blocoDeLembretes.buscarMes(mes);
        System.out.println("Lembretes do mes " + mes + ":");
        for (Lembrete lembrete : retornos) {
            System.out.println(lembrete);
        }
    }

    private static void menuBuscarPorDia(BlocoDeLembretes blocoDeLembretes, Scanner scanner) {
        System.out.println("Digite o dia: ");
        int dia = scanner.nextInt();
        List<Lembrete> retornos = blocoDeLembretes.buscarPorDia(dia);
        System.out.println("Lembretes do dia " + dia + ":");
        for (Lembrete lembrete : retornos) {
            System.out.println(lembrete);
        }
    }

    private static void menuImprimirLembretesPorMes(BlocoDeLembretes blocoDeLembretes, Scanner scanner) {
        System.out.println("Digite o número do mês: ");
        int mes = scanner.nextInt();
        blocoDeLembretes.ordenarPorData();
        List<Lembrete> retornos = blocoDeLembretes.buscarMes(mes);
        System.out.println("Lembretes do mes " + mes + " (ordem de data):");
        for (Lembrete lembrete : retornos) {
            System.out.println(lembrete);
        }
    }

    private static void menuImprimirLembretesPorDia(BlocoDeLembretes blocoDeLembretes, Scanner scanner) {
        System.out.println("Digite dia: ");
        int dia = scanner.nextInt();
        blocoDeLembretes.ordenarPorData();
        List<Lembrete> retornos = blocoDeLembretes.buscarPorDia(dia);
        System.out.println("Lembretes do dia " + dia + " (ordem de data):");
        for (Lembrete lembrete : retornos) {
            System.out.println(lembrete);
        }
    }
}

