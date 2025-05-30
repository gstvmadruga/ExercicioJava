package classificaidade;

import java.util.Scanner;

public class ClassificaIdade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite a idade: ");
        int idade = scanner.nextInt();
        
        if (idade < 18) {
            System.out.println("Menor de idade");
        } else if (idade <= 60) {
            System.out.println("Adulto");
        } else {
            System.out.println("Idoso");
        }
        
        scanner.close();
    }
}
