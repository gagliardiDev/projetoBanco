package br.gov.caixa.banco;
import br.gov.caixa.banco.cliente.Cliente;
import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Cliente> clientes;
    ;
    public Banco(){

        clientes = new ArrayList<>();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }



    public void adicionarPoupanca(Cliente cliente){

        cliente.criarContaPoupanca();
    }

    public void adicionarCliente(String id, String nome, String tipo, boolean status){
        Cliente cliente = new Cliente(id,nome,tipo,status);
        clientes.add(cliente);
    }



    public Cliente getCliente(String id){
        for (Cliente cliente: clientes){
            if(cliente.getId().equals(id)){
                return cliente;
            }
        }
        return null;
    }


}
