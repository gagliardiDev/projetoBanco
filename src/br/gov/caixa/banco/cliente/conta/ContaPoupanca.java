package br.gov.caixa.banco.cliente.conta;

import java.time.LocalDate;
import java.util.Random;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(String tipoPessoa){
        Random random = new Random();
        int dv = random.nextInt(10);
        contadorInstancias++;
        super.tipoPessoa = tipoPessoa;
        super.numeroConta = String.format("013.%05d-" + dv, contadorInstancias);
        super.saldo = 0;
        super.dataCriacao = LocalDate.now();
        contas.add(this);
    }

    @Override
    public String toString() {
        return "ContaPoupanca{" +
                "numeroConta='" + numeroConta + '\'' +
                ", saldo=" + saldo +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}
