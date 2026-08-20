package dados.estrutura;

public class App {
    static void main() {

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
