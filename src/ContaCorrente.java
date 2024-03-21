import java.time.LocalDate;
import java.util.Random;


public class ContaCorrente extends Conta{
    protected ContaInvestimento contaInvestimento;
    private static int contadorInstancias = 0;
    public ContaCorrente() {
        Random random = new Random();
        int dv = random.nextInt(10);
        contadorInstancias++;
        super.numeroConta = String.format("001.%05d-"+dv, contadorInstancias);
        super.saldo = 0;
        super.dataCriacao = LocalDate.now();

    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "numeroConta='" + numeroConta + '\'' +
                ", saldo=" + saldo +
                ", dataCriacao=" + dataCriacao +
                '}';
    }

    public void investir(double valor){
        if (contaInvestimento == null){
            contaInvestimento.
        }
    }
    public void depositar(double valor) {
        this.saldo += valor;
    }


    public void transferir(double valor, Conta contaDestino) {

    }
}
