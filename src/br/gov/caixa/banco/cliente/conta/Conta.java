package br.gov.caixa.banco.cliente.conta;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

abstract public class Conta implements Movimentavel {
    protected String numeroConta;
    protected double saldo;
    protected LocalDate dataCriacao;
    protected String tipoPessoa;
    protected static int contadorInstancias = 0;
    protected static List<Conta> contas = new ArrayList<>();


    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        System.out.println("O saldo atual da conta: " + numeroConta + " é de R$" + saldo);
        return saldo;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }
    public double depositar(double valor) {
        if (this != null){
            this.saldo += valor;
            System.out.println("O valor de R$" + valor + " foi depositado na conta: " + getNumeroConta());
            return valor;
        } else {
            System.out.println("A conta que você está tentando depositar não existe.");
            return 0;
        }
    }

    public double sacar(double valor) {
        if (valor <= saldo){
            this.saldo -= valor;
            System.out.println("Saque de R$" + valor + " na conta " + numeroConta + " realizado com sucesso!");
            return valor;
        } else {
            System.out.println("Saque de R$" + valor + " não realizado, saldo da conta " + numeroConta +" insuficiente");
            return 0;
        }
    }

    public double transferir(double valor, String contaDestino) {

        for (Conta conta : contas){
            if (conta.getNumeroConta().equals(contaDestino)){
                if(this.sacar(valor)!=0){
                    conta.depositar(valor);
                    return valor;
                } else {
                    System.out.println("Saldo insuficiente para realização da transferência.");
                    return 0;
                }
            }
        }
        System.out.println("A Conta destino não foi localizada em nosso banco.");
        return 0;
    }
}
