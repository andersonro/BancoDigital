public interface ContaInterface {

    void sacar(double valor);

    void depositar(double valor);

    void transferir(double valor, Contas contaDestino);

    void extrato();

    void saldo();
}
