package dados.estrutura;

public enum Status {

    PRONTO("pronto"),
    EXECUTANDO("executando"),
    TERMINADO("terminado");

    private final String situacao;


    Status(String situacao) {
        this.situacao = situacao;
    }

    @Override
    public String toString() {
        return "Status:  " + situacao;

    }
}
