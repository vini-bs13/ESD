package dados.estrutura;

import java.util.Random;

public class Servidor {

    private final Fila<Requisicao> fila;
    private final int processadores;
    private final int maxChegadas;
    private final Random rnd;

    private int totalChegadas;
    private int perdidas;

    public Servidor(int capacidadeFila, int processadores, int maxChegadas, Random rnd) {
        this.fila = new Fila<>(capacidadeFila);
        this.processadores = processadores;
        this.maxChegadas = maxChegadas;
        this.rnd = rnd;
        this.totalChegadas = 0;
        this.perdidas = 0;
    }

    public void executar(int numeroCiclo){

        for(int pedidos = 0; pedidos < processadores && !fila.isEmpty(); pedidos++){
            fila.desenfileirar();
        }

        int novasChegadas = rnd.nextInt(maxChegadas + 1);
        for (int i = 0; i < novasChegadas; i++) {
            totalChegadas++;
            if(fila.isFull()){
                perdidas++;
            } else {
                fila.enfileirar(new Requisicao("cliente" + rnd.nextInt(100), "bala", numeroCiclo ));
            }
            
        }
    }

    public double getProbPerda(){
        return totalChegadas == 0 ? 0 : (double) perdidas / totalChegadas;
    }
}
