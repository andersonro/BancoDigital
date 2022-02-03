
public class Main {

    public static void main(String[] args) {

        Clientes cli1 = new Clientes();
        cli1.setNome("Anderson");
        cli1.setCpf("12345678901");
        Contas cc = new ContasCorrente(cli1);
        cc.setEspecial(true);

        Clientes cli2 = new Clientes();
        cli2.setNome("Paula");
        cli2.setCpf("98765432109");
        Contas cp = new ContasPoupanca(cli2);
        cp.setEspecial(false);

        cc.depositar(100);
        cc.transferir(10, cp);
        cc.sacar(5);
        cc.depositar(115);

        try {
            cp.sacar(8);
        } catch (Exception e) {
            System.out.println("Transf: " + e.getMessage());
        }

        cc.extrato();
        cc.saldo();
        cp.extrato();
        cp.saldo();

    }

}
