public class ContasCorrente extends Contas {

    private static final String TP_CONTA = "Corrente";

    public ContasCorrente(Clientes cliente) {
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
