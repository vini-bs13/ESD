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
            vetor.inserir(sorteado);
        }
//            // Verificar repetição
//            for (int j = 0; j < numeros.length; j++) {
//                if (numRandom == numeros[j] && numeros[0] != 0){
//                    return;
//                }
//            }
//
//            // Ordenar Crescentemente
//
//
//            for (int j = 0; j < tamanho; j++) {
//                if ((int)elementos[j] < numeros[i] ) {
//                    inserir(j,numeros[i]);
//                }
//
//            }
//
//
//        }

    }
}
