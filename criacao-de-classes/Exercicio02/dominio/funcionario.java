package dominio;

public class Funcionario {
    private String nome;
    private double salarioBase;
    private String categoria; // "A", "B" ou "C"

    public Funcionario(String nome, double salarioBase, String categoria) {
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.categoria = categoria.toUpperCase(); 
    }

    public double calcularSalarioFinal() {
        double salarioFinal = this.salarioBase;
        
        switch (this.categoria) {
            case "A":
                salarioFinal *= 1.20; // Bônus de 20%
                break;
            case "B":
                salarioFinal *= 1.10; // Bônus de 10%
                break;
            case "C":
                break;
            default:
                System.out.println("Categoria inválida ('" + this.categoria + "'). Salário base considerado.");
                break;
        }
        return salarioFinal;
    }

    public String getNome() {
        return nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public String getCategoria() {
        return categoria;
    }
}
