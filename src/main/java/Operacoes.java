import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Operacoes {

    private String operacao;
    private double valor;
    private String dataOperacao;

    @Override
    public String toString() {
        return "Operacoes{" +
                "operacao='" + operacao + '\'' +
                ", valor=" + valor +
                ", dataOperacao='" + dataOperacao + '\'' +
                '}';
    }

    public Operacoes() {}

    public Operacoes(String operacao, double valor) {
        this.operacao = operacao;
        this.valor = valor;
        this.dataOperacao = this.dataAtual();
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDataOperacao() {
        return dataOperacao;
    }

    private String dataAtual(){
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
    }
}
