public class ContasPoupanca extends Contas {

    private static final String TP_CONTA = "Poupança";

    public ContasPoupanca(Clientes cliente) {
        super(cliente);
    }

    @Override
    public void extrato() {
        imprimirExtrato(this.TP_CONTA);
    }

    @Override
    public void saldo() {
        imprimirSaldo(this.TP_CONTA);
    }
}
