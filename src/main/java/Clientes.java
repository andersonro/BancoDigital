public class Clientes {

    private String nome;
    private String cpf;

    public Clientes(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Clientes() {}

    @Override
    public String toString() {
        return "Clientes{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
