package br.gov.caixa.banco.menu;

import br.gov.caixa.banco.Banco;
import br.gov.caixa.banco.cliente.Cliente;
import br.gov.caixa.banco.cliente.conta.Conta;
import br.gov.caixa.banco.cliente.conta.ContaCorrente;
import br.gov.caixa.banco.cliente.conta.ContaPoupanca;
import java.util.Scanner;

public class Menu {
    private Scanner selecaoMenu = new Scanner(System.in);
    private int opcaoSelecionada;
    private double valorInformado;
    private String text;
    private Banco banco = new Banco();
    private boolean sair = false;

    public boolean isSair() {
        return sair;
    }

    public Banco getBanco() {
        return banco;
    }

    public void exibirBoasVindas(){
        System.out.println("####################################################");
        System.out.println("#######SEJA BEM VINDO A CAIXA ECONOMICA FEDERAL#####");
        System.out.println("####################################################");
    }

    public void exibirMenu(){
        System.out.println("Escolha a opção desejada:");
        System.out.println("1 - Criar Cliente");
        System.out.println("2 - Acessar Conta Corrente");
        System.out.println("3 - Acessar Conta Poupança");
        System.out.println("4 - Acessar Conta Investimento");
        System.out.println("5 - Encerrar Sistema Bancário!");
        chamarOpcao(capturaSelecao());
    }

    public void chamarOpcao(int opcao){
        switch (opcao){
            case 1:
                menuCriarCliente();
                break;
            case 2:
                menuContaCorrente();
                break;
            case 3:
                menuContaPoupanca();
                break;
            case 4:
                menuContaInvestimento();
                break;
            case 5:
                menuSair();
                break;
        }

    }

    private void menuCriarCliente(){
        String tipoPessoa;
        String id;

        System.out.println("Informe se o cliente é Pessoa Fisica ou Juridica:");
        System.out.println("1 - Pessoa Fisica");
        System.out.println("2 - Pessoa Juridica");


        if (capturaSelecao() == 1){
            tipoPessoa = "PF";
            System.out.println("Informe o CPF do cliente:");
            id =  capturaString();
        } else {
            tipoPessoa = "PJ";
            System.out.println("Informe o CNPJ do cliente:");
            id =  capturaString();
        }
        System.out.println("Informe o Nome do cliente:");
        var nome = capturaString();

        banco.adicionarCliente(id, nome, tipoPessoa,true);

    }

    private void menuSair(){
        System.out.println("A Caixa agradece seu contato! Volte Sempre!");
        sair = true;
    }

    private void menuContaInvestimento(){
        System.out.println("Sua Conta Investimento está vinculada a sua Conta Corrente, e as movimentações se dão através das opções INVESTIR e RESGATAR");
        System.out.println("Deseja acessar o menu da sua Conta Corrente? (S/N)");
        if (selecaoMenu.next().toLowerCase().equals("s")){
            menuContaCorrente();
        }


    }

    private void menuContaCorrente(){
        System.out.println("Qual o CPF/CNPJ do cliente que irá movimentar a conta?");
        Cliente cliente = banco.getCliente(capturaString());

        if (cliente != null){
            System.out.println("O que você deseja fazer?");
            System.out.println("0 - Consultar Saldo da Conta Corrente");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Transferir");
            System.out.println("4 - Aplicar");
            System.out.println("5 - Resgatar");
            System.out.println("6 - Consultar Saldo de Investimento");
            switch (capturaSelecao()){
                case 0:
                    cliente.contaCorrente.getSaldo();
                    break;
                case 1:
                    System.out.println("Qual o valor do depósito?");
                    cliente.contaCorrente.depositar(capturaValor());
                    cliente.contaCorrente.getSaldo();
                    break;
                case 2:
                    System.out.println("Qual o valor de saque?");
                    cliente.contaCorrente.sacar(capturaValor());
                    cliente.contaCorrente.getSaldo();
                    break;
                case 3:
                    exibirContas();
                    System.out.println("Qual o valor a ser transferido?");
                    var valor = capturaValor();
                    System.out.println("Qual o numero da conta que irá receber a transferencia?");
                    cliente.contaCorrente.transferir(valor, capturaString());
                    cliente.contaCorrente.getSaldo();
                    break;
                case 4:
                    System.out.println("Qual o valor a ser aplicado?");
                    cliente.contaCorrente.investir(capturaValor());
                    break;
                case 5:
                    cliente.contaCorrente.getSaldoAplicado();
                    System.out.println("Qual o valor a ser resgatado?");
                    cliente.contaCorrente.resgatar(capturaValor());
                    break;
                case 6:
                    cliente.contaCorrente.getSaldoAplicado();
                    break;
            }
        } else {
            System.out.println("Cliente inexistente!");
        }

    }

    private void menuContaPoupanca(){
        System.out.println("Qual o CPF/CNPJ do cliente que irá movimentar a conta?");
        Cliente cliente = banco.getCliente(capturaString());


        if (cliente != null){
            if (cliente.contaPoupanca == null){
                System.out.println("Este cliente ainda não possui uma conta poupança.");
                System.out.println("Confirma abertura de nova Conta Poupança para o cliente "+cliente.getNome()+"? (S/N)");
                if (selecaoMenu.next().toLowerCase().equals("s")){
                    cliente.criarContaPoupanca();
                } else{
                    System.out.println("Abertura de conta abortada.");
                }

            } else {
                System.out.println("O que você deseja fazer?");
                System.out.println("0 - Consultar saldo da Conta Poupança");
                System.out.println("1 - Depositar");
                System.out.println("2 - Sacar");
                System.out.println("3 - Transferir");
                switch (capturaSelecao()) {
                    case 0:
                        cliente.contaPoupanca.getSaldo();
                        break;
                    case 1:
                        System.out.println("Qual o valor do depósito?");
                        cliente.contaPoupanca.depositar(capturaValor());
                        cliente.contaPoupanca.getSaldo();
                        break;
                    case 2:
                        System.out.println("Qual o valor de saque?");
                        cliente.contaPoupanca.sacar(capturaValor());
                        cliente.contaPoupanca.getSaldo();
                        break;
                    case 3:
                        exibirContas();
                        System.out.println("Qual o valor a ser transferido?");
                        var valor = capturaValor();
                        System.out.println("Qual o numero da conta que irá receber a transferencia?");
                        cliente.contaPoupanca.transferir(valor, capturaString());
                        cliente.contaPoupanca.getSaldo();
                        break;
                }

            }
        } else {
            System.out.println("Cliente inexistente!");
        }

    }

    private int capturaSelecao(){
        return selecaoMenu.nextInt();
    }

    private double capturaValor(){
        return  selecaoMenu.nextDouble();
    }

    private String capturaString(){
        return selecaoMenu.next();
    }

    private void exibirContas(){
        System.out.println("Contas diponíveis para recebimento de transferência de valores:");
        for(Conta conta:Conta.getContas()){
            if (conta instanceof ContaCorrente || conta instanceof ContaPoupanca){
                System.out.println(conta.getNumeroConta());
            }

        }
    }


}
