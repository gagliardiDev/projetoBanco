package br.gov.caixa.banco.cliente.conta;

public interface Movimentavel {
    double sacar(double valor);
    double depositar(double valor);
    double transferir(double valor, String contaDestino);
    double getSaldo();
}
