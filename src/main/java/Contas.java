import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public abstract class Contas implements ContaInterface {

    private static final int AGENCIA_PADRAO = 1;
    private static int CONTA_NUM = 1;

    protected int agencia;
    protected int numero;
    private double saldo;
    private boolean especial;
    protected Clientes cliente;

    private ArrayList<Operacoes> listOperacoes = new ArrayList<>();

    public Contas(Clientes cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = CONTA_NUM++;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void sacar(double valor) {
        if (validaOperacao() || this.saldo >= valor){
            this.saldo -= valor;
            this.listOperacoes.add(new Operacoes("saque", valor));
        }else{
            throw new IllegalArgumentException("Você não tem saldo para efetuar a operação!");
        }
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
        this.listOperacoes.add(new Operacoes("deposito", valor));
    }

    @Override
    public void transferir(double valor, Contas contaDestino) {
        if (validaOperacao() || this.saldo >= valor){
            this.sacar(valor);
            contaDestino.depositar(valor);
        }else{
            throw new IllegalArgumentException("Você não tem saldo para efetuar a operação!");
        }
    }

    private boolean validaOperacao(){
        if (this.especial){
            return true;
        }
        return false;
    }

    public void setEspecial(boolean especial) {
        this.especial = especial;
    }

    private void imprimirCabecalho(String tipoConta, String tipo){
        System.out.println("**** "+tipo+" Conta "+tipoConta+" ****");
        System.out.println(String.format("Agência %d", this.agencia));
        System.out.println(String.format("Conta %d", this.numero));
        System.out.println(String.format("Cliente %s", this.cliente.getNome()));
    }

    protected void imprimirSaldo(String tipoConta){
        this.imprimirCabecalho(tipoConta, "Saldo atual");
        System.out.println(String.format("Saldo %.2f", this.getSaldo()));
        System.out.println("-----------------------------------------");
    }

    protected void imprimirExtrato(String tipoConta) {
        this.imprimirCabecalho(tipoConta, "Extrato");

        if (this.listOperacoes.size() > 0){
            for (Operacoes op: this.listOperacoes){
                System.out.print(String.format("-- %s", op.getDataOperacao()));
                System.out.print(String.format(" - Op.: %s", op.getOperacao()));
                System.out.println(String.format(" - Valor %.2f", op.getValor()));
            }
        }else{
            System.out.println("Não existe movimentações.");
        }
        System.out.println("-----------------------------------------");
    }

}
