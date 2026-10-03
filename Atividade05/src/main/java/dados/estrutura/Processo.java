package dados.estrutura;

public class Processo implements Comparable<Processo> {
    private static int CONTADORDENOMEFULEIRA = 0;

    private String nome;
    private int instrucoesRestantes;
    private int tempoChegada;
    private Enum<Status> status;

    public Processo( int instrucoesRestantes, int tempoChegada) {
        this.nome = "P" + CONTADORDENOMEFULEIRA++;
        this.instrucoesRestantes = instrucoesRestantes;
        this.tempoChegada = tempoChegada;
        this.status = Status.PRONTO;
    }

    public static int getCONTADORDENOMEFULEIRA() {
        return CONTADORDENOMEFULEIRA;
    }

    public static void setCONTADORDENOMEFULEIRA(int CONTADORDENOMEFULEIRA) {
        Processo.CONTADORDENOMEFULEIRA = CONTADORDENOMEFULEIRA;
    }

    public String getNome() {
        return nome;
    }


    public int getInstrucoesRestantes() {
        return instrucoesRestantes;
    }

    public void setInstrucoesRestantes(int instrucoesRestantes) {
        this.instrucoesRestantes = instrucoesRestantes;
    }

    public int getTempoChegada() {
        return tempoChegada;
    }

    public Status getStatus() {
        return (Status) status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void executarQuantum(){
        try {
            System.out.println(nome + " executando...");
            Thread.sleep(2000); // pausa 2 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean terminou() {
        return instrucoesRestantes == 0;
    }

    @Override
    public int compareTo(Processo o) {
        return 0;
    }
}
