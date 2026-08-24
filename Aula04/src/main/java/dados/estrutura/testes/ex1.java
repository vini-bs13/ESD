package dados.estrutura.testes;

import dados.estrutura.Vetor;

import java.util.Random;

public class ex1 {

    static void main(){

        Vetor<Integer> vetor =  new Vetor<>(10);
        geradorAleatorio(vetor, 100, 200);

        vetor.imprimir();

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


    public int buscaLinear(Vetor<Integer> vetor, int alvo) {

        for (int i = 0; i < vetor.obterTamanho(); i++) {
            if (vetor.ler(i) == alvo) {
                return i;
            }
        }
        return -1;
    }

    public int buscaLinearOrdenada(Vetor<Integer> vetor, int alvo) {

        for (int i = 0; i < vetor.obterTamanho(); i++) {
            if (vetor.ler(i) == alvo) {
                return i;
            } else if(vetor.ler(i) > alvo) {
                return -1;
            }
        }
        return -1;
    }

    public int buscaBinaria(Vetor<Integer> vetor, int alvo) {

        int inicio = 0;
        int fim = vetor.obterTamanho();

        while(inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if(vetor.ler(meio) == alvo){
                return meio;
            } else if (vetor.ler(meio) > alvo) {
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }
        return inicio;
    }
}
