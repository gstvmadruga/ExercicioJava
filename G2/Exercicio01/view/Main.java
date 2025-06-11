package view;

import java.util.Scanner;
import modell.*;
import controller.VeiculoController;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VeiculoController controller = new VeiculoController();
        int opcao = 0;

        while (opcao != 3) {
            System.out.println("1 - Cadastrar novo veículo");
            System.out.println("2 - Listar veículos");
            System.out.println("3 - Sair");
            System.out.print(">> ");
            opcao = Integer.parseInt(sc.nextLine());

            if (opcao == 1) {
                System.out.print("Tipo (1-Carro, 2-Moto, 3-Caminhão): ");
                int tipo = Integer.parseInt(sc.nextLine());

                System.out.print("Modelo: ");
                String modelo = sc.nextLine();
                System.out.print("Placa: ");
                String placa = sc.nextLine();
                System.out.print("Ano: ");
                int ano = Integer.parseInt(sc.nextLine());

                if (tipo == 1) {
                    System.out.print("Qtd de portas: ");
                    int portas = Integer.parseInt(sc.nextLine());
                    controller.adicionar(new Carro(placa, modelo, ano, portas));
                } else if (tipo == 2) {
                    System.out.print("Cilindrada: ");
                    int cil = Integer.parseInt(sc.nextLine());
                    controller.adicionar(new Moto(placa, modelo, ano, cil));
                } else if (tipo == 3) {
                    System.out.print("Capacidade de carga (ton): ");
                    double carga = Double.parseDouble(sc.nextLine());
                    controller.adicionar(new Caminhao(placa, modelo, ano, carga));
                }
            } else if (opcao == 2) {
                controller.listar();
            }
        }

        sc.close();
    }
}
