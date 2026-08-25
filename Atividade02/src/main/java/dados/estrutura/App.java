package dados.estrutura;

import java.util.Arrays;
import java.util.Random;

public class App {
    static void main() {

        Vetor<Integer> vetorPequeno =  new Vetor<>(1000);
        Vetor<Integer> vetorMedio =  new Vetor<>(10000);
        Vetor<Integer> vetorGrande =  new Vetor<>(100000);

        geradorAleatorio(vetorPequeno, 500, 1000);
        geradorAleatorio(vetorMedio, 5000, 10000);
        geradorAleatorio(vetorGrande, 50000, 100000);

        // Vetor pequeno

        System.out.println("Vetor pequeno e linear: ");
        System.out.println("");

        int resultadoLinearPequenoInicio = buscaLinearOrdenada(vetorPequeno,vetorPequeno.ler(0));
        int resultadoLinearPequenoMeio = buscaLinearOrdenada(vetorPequeno,vetorPequeno.ler((vetorPequeno.obterTamanho() - 1) / 2));
        int resultadoLinearPequenoFinal = buscaLinearOrdenada(vetorPequeno,vetorPequeno.ler(vetorPequeno.obterTamanho() - 1));

        System.out.println("Vetor pequeno e binário: ");
        System.out.println("");

        int resultadoBinarioPequenoInicio = buscaBinaria(vetorPequeno,vetorPequeno.ler(0));
        int resultadoBinarioPequenoMeio = buscaBinaria(vetorPequeno,vetorPequeno.ler((vetorPequeno.obterTamanho() - 1) / 2));
        int resultadoBinarioPequenoFinal = buscaBinaria(vetorPequeno,vetorPequeno.ler(vetorPequeno.obterTamanho() - 1));

        // Vetor médio

        System.out.println("Vetor médio e linear: ");
        System.out.println("");

        int resultadoLinearMedioInicio = buscaLinearOrdenada(vetorMedio,vetorMedio.ler(0));
        int resultadoLinearMedioMeio = buscaLinearOrdenada(vetorMedio,vetorMedio.ler((vetorMedio.obterTamanho() - 1) / 2));
        int resultadoLinearMedioFinal = buscaLinearOrdenada(vetorMedio,vetorMedio.ler(vetorMedio.obterTamanho() - 1 ));

        System.out.println("Vetor médio e binário: ");
        System.out.println("");

        int resultadoBinarioMedioInicio = buscaBinaria(vetorMedio,vetorMedio.ler(0));
        int resultadoBinarioMedioMeio = buscaBinaria(vetorMedio,vetorMedio.ler((vetorMedio.obterTamanho() - 1) / 2));
        int resultadoBinarioMedioFinal = buscaBinaria(vetorMedio,vetorMedio.ler(vetorMedio.obterTamanho() - 1));


        // Vetor grande

        System.out.println("Vetor grande e linear: ");
        System.out.println("");

        int resultadoLinearGrandeInicio = buscaLinearOrdenada(vetorGrande,vetorGrande.ler(0));
        int resultadoLinearGrandeMeio = buscaLinearOrdenada(vetorGrande,vetorGrande.ler((vetorGrande.obterTamanho() - 1) / 2));
        int resultadoLinearGrandeFinal = buscaLinearOrdenada(vetorGrande,vetorGrande.ler(vetorGrande.obterTamanho() - 1 ));

        System.out.println("Vetor grande e binário: ");
        System.out.println("");

        int resultadoBinarioGrandeInicio = buscaBinaria(vetorGrande,vetorGrande.ler(0));
        int resultadoBinarioGrandeMeio = buscaBinaria(vetorGrande,vetorGrande.ler((vetorGrande.obterTamanho() - 1) / 2));
        int resultadoBinarioGrandeFinal = buscaBinaria(vetorGrande,vetorGrande.ler(vetorGrande.obterTamanho() - 1));


        // Se tratando do algoritmo de buscaLinearOrdenada, o melhor dos casos seria buscar a primeira opção, o caso médio estaria no meio do vetor
        // e no pior dos casos o último elemento do vetor, logo que será o último percorrido, ou o elemento não existir.
        // Se tratando da buscaBinária, no melhor dos casos o elemento precisa estar no meio, no caso médio o elemento precisaria
        // estar "perto" do inicio,fim ou meio mas não em uma posição central, exigindo algumas comparações,
        // mas não tantas quanto o elemento que exija o número máximo de comparações,
        // precisando que muitas comparações sejam feitas, ou o elemento não estar no vetor.
        // Como conclusão, se o vetor for pequeno e na maioria das vezes os primeiro números forem selecionados, é mais vantajoso
        // utilizar a busca linear, mas para sistemas grandes e com resultados diversos, é mais eficiente utilizar a busca binária,
        // desta forma conclui-se que, dependendo da situação, um mecanismo de busca pode ser mais eficiente que o outro.

        // Análise final

        int[] calc = {1,2,3,4,5,6,7,8,9,10,11,13,56,78,98,150,175,180};
        int valor =  150;


        long inicio = System.nanoTime();
        int pos = Arrays.binarySearch(calc,valor);
        long fim = System.nanoTime();
        long duracaoMs = (fim - inicio) / 1000000;
        System.out.println("Tempo Arrays.binarySearch: " + duracaoMs + " ms");

        // Para esse teste a diferença de tempo não mudou tanto, logo que os vetores são pequenos,
        // mas nesse teste o vetor da classe Vetor feito localmente foi mais rápido que o Arrays.binarySearch.
        // Contudo, no geral o Array.searchBinary é mais rápido, logo que está bem otimizado, e minha classe Vetor não
        // possui verificações complexas, na qual a biblioteca possui, interferindo no resultado.

        // Questão dicionário

        // Se tratando da busca linear/sequencial, a pior hipótese seria a resposta ser a última palavra ou a palavra não existir,
        // o que levaria 240.000 tentativas, enquanto no pior caso da busca binária não chegaria nem a 100 comparações, sendo muito mais
        // eficiente nesse contexto.

        // É possível chegar em uma generalização, logo que:
        // 1 busca -> n/2
        // 2 buscas -> n/4
        // 3 buscas -> n/8
        // 4 buscas -> n/16 -> 2 elevado a 4 é 16

        // Pesquisando eu encontrei que é possivel fazer: resultado = log2(n)
        // Se tratando de inteiros, se o log anterior não for suficiente, o resultado é o próximo, caindo em um intervalo.


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
        long inicio = System.nanoTime();
        int contador = 0;

        for (int i = 0; i < vetor.obterTamanho(); i++) {
            contador++;

            if (vetor.ler(i) == alvo) {
                System.out.println("Foram feitas: " + contador + " comparações!");
                long fim = System.nanoTime();
                long duracaoMs = (fim - inicio) / 1000000;
                System.out.println("Tempo: " + duracaoMs + " ms");
                return i;
            } else if(vetor.ler(i) > alvo) {
                System.out.println("Foram feitas: " + contador + " comparações!");
                long fim = System.nanoTime();
                long duracaoMs = (fim - inicio) / 1000000;
                System.out.println("Tempo: " + duracaoMs + " ms");
                return -1;
            }
        }
        System.out.println("Foram feitas: " + contador + " comparações!");
        long fim = System.nanoTime();
        long duracaoMs = (fim - inicio) / 1000000;
        System.out.println("Tempo: " + duracaoMs + " ms");
        return -1;
    }

    public static int buscaBinaria(Vetor<Integer> vetor, int alvo) {
        long inicioNano = System.nanoTime();

        int contador = 0;
        int inicio = 0;
        int fim = vetor.obterTamanho() - 1;

        while(inicio <= fim) {
            int meio = (inicio + fim) / 2;
            contador++;

            if(vetor.ler(meio) == alvo){
                System.out.println("Foram feitas: " + contador + " comparações!");
                long fimNano = System.nanoTime();
                long duracaoMs = (fimNano - inicioNano) / 1000000;
                System.out.println("Tempo: " + duracaoMs + " ms");
                return meio;
            } else if (vetor.ler(meio) > alvo) {
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }
        System.out.println("Foram feitas: " + contador + " comparações!");
        long fimNano = System.nanoTime();
        long duracaoMs = (fimNano - inicioNano) / 1000000;
        System.out.println("Tempo: " + duracaoMs + " ms");
        return -1;
    }
}

