package br.gov.caixa.banco.cliente;
import br.gov.caixa.banco.cliente.conta.ContaCorrente;
import br.gov.caixa.banco.cliente.conta.ContaPoupanca;

import java.time.LocalDate;


public class Cliente {
    protected String id;
    protected String nome;
    protected LocalDate dataCadastro;
    protected boolean statusAtivo;
    protected String tipo;
    public ContaCorrente contaCorrente;
    public ContaPoupanca contaPoupanca;



    public Cliente(String id, String nome, String tipo, boolean statusAtivo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.dataCadastro = LocalDate.now();
        this.statusAtivo = statusAtivo;
        this.contaCorrente = new ContaCorrente(tipo);
        System.out.println(nome + " seja bem-vindo à Caixa! Sua conta corrente de numero " + contaCorrente.getNumeroConta() + " foi aberta nesta data!");
    }
    public void criarContaPoupanca(){
        if (tipo.equals("PF")) {
            this.contaPoupanca = new ContaPoupanca(tipo);
            System.out.println("Abertura de Conta Poupanca para o cliente "+ nome +" realizada com sucesso. Numero da conta:" + contaPoupanca.getNumeroConta());
        } else {
            System.out.println("Abertura de Conta Poupanca permitido apenas para Pessoa Fisica");
        }
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        System.out.println("Este cliente é um cliente " + tipo);
        return tipo;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", dataCadastro=" + dataCadastro +
                ", statusAtivo=" + statusAtivo +
                ", tipo='" + tipo + '\'' +
                ", contaCorrente=" + contaCorrente +
                ", contaPoupanca=" + contaPoupanca +
                '}';
    }
}
