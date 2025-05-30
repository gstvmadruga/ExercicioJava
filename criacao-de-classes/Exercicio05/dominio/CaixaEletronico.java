package dominio;

public class CaixaEletronico {
    private double saldo;

    public CaixaEletronico(double saldoInicial) {
        if (saldoInicial >= 0) {
            this.saldo = saldoInicial;
        } else {
            this.saldo = 0; // Garante saldo não negativo
            System.out.println("Saldo inicial inválido. Definido como 0.");
        }
    }

    public boolean sacar(double valor) {
        // Verifica se o valor é positivo
        if (valor <= 0) {
            System.out.println("Valor de saque inválido. Deve ser positivo.");
            return false;
        }
        if (valor % 10 != 0) {
            System.out.println("Valor de saque inválido. Deve ser múltiplo de R$ 10.");
            return false;
        }
        if (valor > this.saldo) {
            System.out.println("Saldo insuficiente para realizar o saque de R$ " + valor);
            return false;
        }

        this.saldo -= valor;
        System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
        exibirSaldo(); 
        return true;
    }

    public void exibirSaldo() {
        System.out.println("Saldo atual: R$ " + String.format("%.2f", this.saldo));
    }

    public double getSaldo() {
        return saldo;
    }
}
