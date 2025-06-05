package controle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Calculadora de formas geométricas\n");

        System.out.println("Retângulo:");
        System.out.print("Informe a largura: ");
        double largura = scanner.nextDouble();

        System.out.print("Informe a altura: ");
        double altura = scanner.nextDouble();

        Retangulo retangulo = new Retangulo(largura, altura);

        System.out.println("\nCírculo:");
        System.out.print("Informe o raio: ");
        double raio = scanner.nextDouble();

        Circulo circulo = new Circulo(raio);

        System.out.println("\n--- Resultados ---");

        System.out.println("Retângulo:");
        System.out.printf("Área: %.2f%n", retangulo.calcularArea());
        System.out.printf("Perímetro: %.2f%n", retangulo.calcularPerimetro());

        System.out.println("\nCírculo:");
        System.out.printf("Área: %.2f%n", circulo.calcularArea());
        System.out.printf("Perímetro: %.2f%n", circulo.calcularPerimetro());

        scanner.close();
    }
}
