package br.gov.caixa.banco.cliente.conta;

import java.time.LocalDate;
import java.util.Random;


public class ContaCorrente extends Conta{
    private ContaInvestimento contaInvestimento;
    private final double taxaSaque = 0.005;

    public ContaCorrente(String tipoPessoa) {
        Random random = new Random();
        int dv = random.nextInt(10);
        contadorInstancias++;
        super.tipoPessoa = tipoPessoa;
        if (tipoPessoa.equals("PF")) {
            super.numeroConta = String.format("001.%05d-" + dv, contadorInstancias);
        } else{
            super.numeroConta = String.format("003.%05d-" + dv, contadorInstancias);
        }
        super.saldo = 0;
        super.dataCriacao = LocalDate.now();
        contas.add(this);
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "numeroConta='" + numeroConta + '\'' +
                ", saldo=" + saldo +
                ", dataCriacao=" + dataCriacao +
                ", tipoPessoa='" + tipoPessoa + '\'' +
                ", Conta Investimento: " + contaInvestimento +
                '}';
    }

    private void abrirInvestimento(){
        System.out.println("Conta Investimento inexistente, aguarde enquanto realizamos a abertura da conta...");
        this.contaInvestimento = new ContaInvestimento(numeroConta);
        contas.add(contaInvestimento);
    }

    public void investir(double valor){
        if (this.contaInvestimento == null){
            abrirInvestimento();
        }
        if (saldo >= valor) {
            double taxaRendimento = 0.01;
            if (tipoPessoa.equals("PJ")){
                taxaRendimento = 0.02;
            }
            double rendimento = valor * taxaRendimento;
            saldo -= valor;
            this.contaInvestimento.depositar(valor+rendimento);
            System.out.println("O valor de R$" + valor + " foi aplicado em sua Conta Investimento de nº:" + this.contaInvestimento.getNumeroConta());
            System.out.println("Esta conta teve um rendimento de R$" + rendimento + " e o Saldo Atual é de: R$" + contaInvestimento.getSaldo());
        } else{
            System.out.println("Saldo em conta insuficiente para realizar esta aplicação");
        }
    }

    public void resgatar(double valor){
        if (this.contaInvestimento.sacar(valor)>0){
            saldo += valor;
        }
    }

    public double getSaldoAplicado(){
        if (contaInvestimento == null){
            System.out.println("Você ainda não possui uma conta investimento, realize sua primeira aplicação para abertura da conta.");
            return 0;
        }
        return this.contaInvestimento.getSaldo();
    }

    public double sacar(double valor){
        double taxaSaqueReais = 0;
        if (tipoPessoa.equals("PJ")){
            taxaSaqueReais = valor*this.taxaSaque;
        }
        if (valor+taxaSaqueReais <= saldo){
            this.saldo -= valor+taxaSaqueReais;
            System.out.println("Saque de R$" + valor + " na conta " + numeroConta + " realizado com sucesso! Sendo cobrado R$" + taxaSaqueReais + " de tarifa pelo serviço");
            return valor;
        } else {
            System.out.println("Saque de R$" + valor + " não realizado, saldo da conta " + numeroConta +" insuficiente");
            return 0;
        }

    }
}
