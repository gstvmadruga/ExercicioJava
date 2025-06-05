package controle;

import pagamento.Pagamento;
import pagamento.CartaoCredito;
import pagamento.BoletoBancario;

public class PagamentoTeste {
    public static void main(String[] args) {
        Pagamento pagamento1 = new CartaoCredito();
        Pagamento pagamento2 = new BoletoBancario();

        pagamento1.realizarPagamento(100.00);
        pagamento2.realizarPagamento(200.00);
    }
}
