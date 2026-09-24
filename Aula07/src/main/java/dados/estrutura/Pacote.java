package dados.estrutura;

public class Pacote implements Comparable<Pacote> {
    private int numero;
    private String origem;
    private String destino;
    private String dados;

    public Pacote(int numero, String origem, String destino, String dados) {
        this.numero = numero;
        this.origem = origem;
        this.destino = destino;
        this.dados = dados;
    }

    @Override
    public String toString() {
        return "Pacote{" +
                "numero=" + numero +
                ", origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                ", dados='" + dados + '\'' +
                '}';
    }

    @Override
    public int compareTo(Pacote o) {
        return 0;
    }
}
