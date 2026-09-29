package dados.estrutura;

import java.util.Random;

public class Servidor {

    private final Fila<Requisicao> fila;
    private final int processadores;
    private final int maxGeradas;
    private int reqsAtendidas;
    private final Random rnd;

    private int totalChegadas;
    private int perdidas;

    public Servidor(int capacidadeFila, int processadores, int maxGeradas, Random rnd) {
        this.fila = new Fila<>(capacidadeFila);
        this.processadores = processadores;
        this.maxGeradas = maxGeradas;
        this.rnd = rnd;
        this.totalChegadas = 0;
        this.perdidas = 0;
    }

    public void executar(int numeroCiclo){
        for (int ciclo = 0; ciclo <= numeroCiclo; ciclo++) {



        for(int requisicoes = 0; requisicoes < processadores && !fila.isEmpty(); requisicoes++){
            fila.desenfileirar();
            reqsAtendidas++;
        }

        int novasChegadas = rnd.nextInt(1,maxGeradas);
        for (int i = 0; i < novasChegadas; i++) {
            totalChegadas++;
            if(fila.isFull()){
                perdidas++;
            } else {
                fila.enfileirar(new Requisicao("cliente", "bala"));
                }
            }
        }
    }

    public double getProbPerda(){

        if(totalChegadas == 0){
            return 0;
        } else {
            return (double) perdidas / totalChegadas;
        }
    }

    @Override
    public String toString() {
        return "Servidor{" +
                " processadores=" + processadores +
                ", maxGeradas=" + maxGeradas +
                ", reqsAtendidas=" + reqsAtendidas +
                ", totalChegadas=" + totalChegadas +
                ", perdidas=" + perdidas +
                '}';
    }
}
