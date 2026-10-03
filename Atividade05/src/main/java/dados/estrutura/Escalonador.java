package dados.estrutura;

public class Escalonador {
    private static final int QUANTUM = 2;
    private Processo[] tarefas;
    private boolean[] isNaFila;
    private int tempo;

    private FilaCircular<Processo> fila;

    public Escalonador(Processo[] tarefas,int capacidadeFila) {
        this.fila = new FilaCircular<>(capacidadeFila);
        this.tarefas = tarefas;
        this.isNaFila = new boolean[tarefas.length];
        this.tempo = 0;
    }

    private void verificarChegada(){

    }

    private boolean isProcessosFaltando(){

        return true;
    }

    public void executarQuantum(){
        while(isProcessosFaltando()){
            verificarChegada();

            if(fila.isEmpty()){
                System.out.println("Fila vazia no tempo: " + tempo);
            }

        }
    }
}
