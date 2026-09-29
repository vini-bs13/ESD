package dados.estrutura;

public class Requisicao implements Comparable<Requisicao> {
    private static int GERADORDEIDFULEIRA = 0;


    private int id;
    private int numeroCiclo;
    private String origem;
    private String situacao;

    public Requisicao(String origem, String situacao, int numeroCiclo) {
        this.id = ++GERADORDEIDFULEIRA;
        this.origem = origem;
        this.situacao = situacao;
        this.numeroCiclo = numeroCiclo;
    }


    @Override
    public String toString() {
        return "Requisicoes{" +
                "id=" + id +
                ", origem='" + origem + '\'' +
                ", situacao='" + situacao + '\'' +
                '}';
    }


    @Override
    public int compareTo(Requisicao o) {
        return 0;
    }
}
