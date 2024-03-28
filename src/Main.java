import br.gov.caixa.banco.Banco;
import br.gov.caixa.banco.menu.Menu;
import br.gov.caixa.banco.cliente.Cliente;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Banco banco = menu.getBanco();
        banco.adicionarCliente("012345678910", "Marcus", "PF", true);
        banco.adicionarCliente("122222222222", "Rodrigo", "PF", true);
        banco.adicionarCliente("111111111111", "Caixa", "PJ", true);
        banco.adicionarCliente("333333333333", "ADA Tech", "PJ", true);
        Cliente c1 = banco.getCliente("012345678910");
        Cliente c2 = banco.getCliente("111111111111");
        Cliente c3 = banco.getCliente("122222222222");
        Cliente c4 = banco.getCliente("333333333333");

        //Verificar que os novos clientes possuem conta.Conta corrente vinculada:
        System.out.println("#Segue a relação de clientes cadastrados em nosso banco:");
        for (Cliente cliente : banco.getClientes()) {
            System.out.println(cliente);
        }
        System.out.println("                                                    ");
        System.out.println("                                                    ");
        System.out.println("                                                    ");

        //Verificar as funcionalidades da  Conta Corrente PF:
        System.out.println("#Depositando R$300,00 na Conta Corrente do cliente Marcus:");
        c1.contaCorrente.depositar(300);
        System.out.println("#Sacando R$100,00 na Conta Corrente do cliente Marcus:");
        c1.contaCorrente.sacar(100);
        System.out.println("#Transferindo R$100,00 na Conta Corrente do cliente Marcus para a Conta Corrente do cliente ADA nº: " + c4.contaCorrente.getNumeroConta());
        c1.contaCorrente.transferir(100, c4.contaCorrente.getNumeroConta());
        System.out.println("#Consultado saldo da Conta Corrente do cliente Marcus");
        c1.contaCorrente.getSaldo();
        System.out.println("#TESTE DE FUNCIONALIDADES CONTA CORRENTE PF CONCLUIDO");

        System.out.println("                                                    ");
        System.out.println("                                                    ");
        System.out.println("                                                    ");


        //Verificar as funcionalidades da Conta Corrente PJ:
        System.out.println("#Verificando o tipo do Cliente ADA");
        c2.getTipo();
        System.out.println("#Realizando Depósito na conta");
        c2.contaCorrente.depositar(500);
        c2.contaCorrente.getSaldo();
        System.out.println("#Realizando Saque da Conta Corrente PJ");
        c2.contaCorrente.sacar(50);
        c2.contaCorrente.getSaldo();
        System.out.println("#Realizando Transferencia da Conta Corrente PJ");
        c2.contaCorrente.transferir(10, c1.contaCorrente.getNumeroConta());
        System.out.println("#Realizando Deposito na Conta Corrente PJ");
        c2.contaCorrente.depositar(1500);
        System.out.println("#TESTE DE FUNCIONALIDADES CONTA CORRENTE PJ CONCLUIDO");


        System.out.println("                                                    ");
        System.out.println("                                                    ");
        System.out.println("                                                    ");


        //Verificar as funcionalidades da Conta Investimento PF:
        System.out.println("#Verificando Saldo atual da conta corrent PF:");
        c1.contaCorrente.getSaldo();
        System.out.println("#Realizando Investimento de R$50,00:");
        c1.contaCorrente.investir(50);
        System.out.println("#Realizando novo Investimento de R$10,00, agora com a conta investimento já aberta:");
        c1.contaCorrente.investir(10);
        System.out.println("#Consultando o saldo da conta corrente:");
        c1.contaCorrente.getSaldo();
        System.out.println("#Realizando o resgate da conta investimento:");
        c1.contaCorrente.resgatar(50.6);
        c1.contaCorrente.getSaldo();
        System.out.println("#Verificando o saldo da conta investimento:");
        c1.contaCorrente.getSaldoAplicado();
        System.out.println("#Tentativa de resgate de R$100,00 da conta investimento sem saldo suficiente:");
        c1.contaCorrente.resgatar(100);
        System.out.println("#TESTE DE FUNCIONALIDADES CONTA INVESTIMENTO PF CONCLUIDO");

        System.out.println("                                                    ");
        System.out.println("                                                    ");
        System.out.println("                                                    ");


        //Verificar as funcionalidades da Conta Investimento PJ:
        System.out.println("#Verificando Saldo atual da conta PJ:");
        c4.contaCorrente.getSaldo();
        System.out.println("#Realizando Investimento de R$50,00:");
        c4.contaCorrente.investir(50);
        System.out.println("#Realizando novo Investimento de R$10,00, agora com a conta investimento já aberta:");
        c4.contaCorrente.investir(10);
        System.out.println("#Consultando o saldo da conta corrente:");
        c4.contaCorrente.getSaldo();
        System.out.println("#Realizando o resgate da conta investimento:");
        c4.contaCorrente.resgatar(50.6);
        c4.contaCorrente.getSaldo();
        System.out.println("#Verificando o saldo da conta investimento:");
        c4.contaCorrente.getSaldoAplicado();
        System.out.println("#Tentativa de resgate de R$100,00 da conta investimento sem saldo suficiente:");
        c4.contaCorrente.resgatar(100);
        System.out.println("#TESTE DE FUNCIONALIDADES CONTA INVESTIMENTO PJ CONCLUIDO");

        System.out.println("                                                    ");
        System.out.println("                                                    ");
        System.out.println("                                                    ");

        //Verificar as funcionalidades da Conta Poupanca PF:
        System.out.println("#Realizando abertura de conta poupança para cliente PF");
        banco.adicionarPoupanca(c3);
        System.out.println("#Realizando deposito de R$500,00 na conta poupanca:");
        c3.contaPoupanca.depositar(500);
        System.out.println("#Realizando saque de R$100,00 na conta poupanca:");
        c3.contaPoupanca.sacar(100);
        System.out.println("#Realizando transferencia de R$100,00 na conta poupanca para uma conta inexistente:");
        c3.contaPoupanca.transferir(100, "001.5555-88");
        System.out.println("#Realizando transferencia de R$100,00 na conta poupanca para a conta " + c1.contaCorrente.getNumeroConta());
        c3.contaPoupanca.transferir(100, c1.contaCorrente.getNumeroConta());
        System.out.println("#Consultando saldo da Conta");
        c3.contaPoupanca.getSaldo();
        System.out.println("#TESTE DE FUNCIONALIDADES CONTA POUPANCA PF CONCLUIDO");

        System.out.println("                                                    ");
        System.out.println("                                                    ");
        System.out.println("                                                    ");

        System.out.println("#Tentativa de abertura de Conta Poupanca para cliente PJ:");
        System.out.println("#Verificando o tipo do Cliente 'Caixa'");
        c4.getTipo();
        banco.adicionarPoupanca(c4);
        System.out.println("#TESTE DE FUNCIONALIDADES CONTA POUPANCA PJ CONCLUIDO");

        System.out.println("                                                    ");
        System.out.println("                                                    ");
        System.out.println("                                                    ");
        System.out.println("Testes concluidos, segue relação de clientes e contas abertas nesse procedimento.");
        for (Cliente cliente : banco.getClientes()) {
            System.out.println(cliente);
        }
        System.out.println("                                                    ");
        System.out.println("Iniciando aplicação, sinta-se a vontade para realizar novas aberturas de conta, ou movimentar as contas já existentes.");
        System.out.println("                                                    ");


        //INICIALIZAÇÃO DO SISTEMA PARA UTILIZAÇÃO PELO USUÁRIO

        menu.exibirBoasVindas();
        while (!menu.isSair()) {
            menu.exibirMenu();
        }


    }

}



