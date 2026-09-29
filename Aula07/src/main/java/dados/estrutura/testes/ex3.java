package dados.estrutura.testes;

import dados.estrutura.Servidor;

import java.util.Random;

public class ex3 {

    static void main() {
        int ciclos = 100_000;
        int[] capacidades = {5, 10, 50};
        int[] processadores = {1, 2, 4};
        int[] maxChegadas = {2, 4, 6};


        System.out.printf("%-10s %-14s %-12s %s%n",
                "Fila", "Processadores", "MaxChegadas", "P(perda)");

        for (int capacidade : capacidades) {
            for (int processador : processadores) {
                for (int maxChegada : maxChegadas) {
                    Random rnd = new Random(13);
                    Servidor sv = new Servidor(capacidade,processador,maxChegada,rnd);

                    for (int ciclo = 0; ciclo < ciclos; ciclo++) {
                        sv.executar(ciclo);
                    }

                    System.out.printf("%-10d %-14d %-12d %.4f%%%n",
                            capacidade, processador, maxChegada, sv.getProbPerda() * 100);
                }
            }
        }
    }
}
