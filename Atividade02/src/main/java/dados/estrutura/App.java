package dados.estrutura;

import java.util.Random;

public class App {
    static void main() {

        Vetor<Integer> vetorPequeno =  new Vetor<>(1000);
        Vetor<Integer> vetorMedio =  new Vetor<>(10000);
        Vetor<Integer> vetorGrande =  new Vetor<>(100000);

        geradorAleatorio(vetorPequeno, 500, 1000);
        geradorAleatorio(vetorMedio, 5000, 10000);
        geradorAleatorio(vetorPequeno, 50000, 100000);

        // Vetor pequeno

        int resultadoLinearPequenoInicio = buscaLinearOrdenada(vetorPequeno, 0);
        int resultadoLinearPequenoMeio = buscaLinearOrdenada(vetorPequeno, vetorPequeno.obterTamanho() / 2);
        int resultadoLinearPequenoFinal = buscaLinearOrdenada(vetorPequeno, vetorPequeno.obterTamanho());

        int resultadoBinarioPequenoInicio = buscaBinaria(vetorPequeno, 0);
        int resultadoBinarioPequenoMeio = buscaBinaria(vetorPequeno, vetorPequeno.obterTamanho() / 2);
        int resultadoBinarioPequenoFinal = buscaBinaria(vetorPequeno, vetorPequeno.obterTamanho());

        // Vetor médio


        // Vetor grande


    }

    public static void geradorAleatorio(Vetor<Integer> vetor, int quantidade, int range){

        Random aleatorio = new Random();
        while (vetor.obterTamanho() < quantidade) {

            int sorteado =  aleatorio.nextInt(range);

            if(vetor.localizar(sorteado) == -1){
                vetor.inserirOrdenado(sorteado);
            }
        }
    }

    public static int buscaLinearOrdenada(Vetor<Integer> vetor, int alvo) {
        int contador = 0;

        for (int i = 0; i < vetor.obterTamanho(); i++) {
            contador++;

            if (vetor.ler(i) == alvo) {
                System.out.println(contador);
                return i;
            } else if(vetor.ler(i) > alvo) {
                System.out.println(contador);
                return -1;
            }
        }
        System.out.println(contador);
        return -1;
    }

    public static int buscaBinaria(Vetor<Integer> vetor, int alvo) {

        int contador = 0;
        int inicio = 0;
        int fim = vetor.obterTamanho() - 1;

        while(inicio <= fim) {
            int meio = (inicio + fim) / 2;
            contador++;

            if(vetor.ler(meio) == alvo){
                System.out.println(contador);
                return meio;
            } else if (vetor.ler(meio) > alvo) {
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }
        System.out.println(contador);
        return inicio;
    }
}

