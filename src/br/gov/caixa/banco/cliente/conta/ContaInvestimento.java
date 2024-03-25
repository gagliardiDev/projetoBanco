package br.gov.caixa.banco.cliente.conta;

public class ContaInvestimento extends Conta{
    public ContaInvestimento(String numeroConta) {
        super.numeroConta = numeroConta.replace("001.","022.").replace("003.","023.");
    }

    public double depositar(double valor){
        saldo += valor;
        return valor;
    }
    public boolean resgatar(double valor){
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("R$" + valor +" resgatados em sua Conta Corrente");
            return true;
        }
        System.out.println("Saldo insuficiente na aplicação");
        System.out.println("Saldo atual de R$" + saldo);
        return false;
    }


    @Override
    public String toString() {
        return "ContaInvestimento{" +
                "numeroConta='" + numeroConta + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
