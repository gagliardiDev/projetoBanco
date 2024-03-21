import java.time.LocalDate;


public class Cliente {
    protected String id;
    protected String nome;
    protected LocalDate dataCadastro;
    protected boolean status;
    protected String tipo;
    protected ContaCorrente contaCorrente;
    protected ContaPoupanca contaPoupanca;


    public Cliente(String id, String nome, String tipo, boolean status) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.dataCadastro = LocalDate.now();
        this.status = status;
        this.contaCorrente = new ContaCorrente();
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public boolean isStatus() {
        return status;
    }

    public String getTipo() {
        return tipo;
    }

    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    }

    public ContaPoupanca getContaPoupanca() {
        return contaPoupanca;
    }


}
