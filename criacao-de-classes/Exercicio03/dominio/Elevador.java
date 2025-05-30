package dominio;

public class Elevador {
    private int andarAtual;
    private int totalAndares; // Ex: Se 5 andares, vai de 0 a 4

    public Elevador(int totalAndares) {
        if (totalAndares > 0) {
            this.totalAndares = totalAndares - 1; 
        } else {
            this.totalAndares = 0; // Garante pelo menos o térreo
        }
        this.andarAtual = 0; // Começa no térreo
    }

    public void subir() {
        if (this.andarAtual < this.totalAndares) {
            this.andarAtual++;
            System.out.println("Subindo para o andar " + this.andarAtual);
        } else {
            System.out.println("Você já está no último andar.");
        }
    }

    public void descer() {
        if (this.andarAtual > 0) {
            this.andarAtual--;
            System.out.println("Descendo para o andar " + this.andarAtual);
        } else {
            System.out.println("Você já está no térreo.");
        }
    }

    public void exibirAndar() {
        System.out.println("Andar atual: " + this.andarAtual);
    }

    public int getAndarAtual() {
        return andarAtual;
    }
    
    public int getTotalAndares() {
        return totalAndares;
    }
}
