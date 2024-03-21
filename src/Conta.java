import java.time.LocalDate;

abstract public class Conta implements Movimentavel {
    protected String numeroConta;
    protected double saldo;
    protected LocalDate dataCriacao;

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }
    public void sacar(double valor) {
        if (valor <= saldo){
            this.saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente");
        }

    }
}
