package dados.estrutura;

public class Requisicoes implements Comparable<Requisicoes> {
    private int id;
    private String origem;
    private String situacao;

    public Requisicoes(int id, String origem, String situacao) {
        this.id = id;
        this.origem = origem;
        this.situacao = situacao;
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
    public int compareTo(Requisicoes o) {
        return 0;
    }
}
