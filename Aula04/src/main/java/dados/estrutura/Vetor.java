package dados.estrutura;

public class Vetor<T> {

    private T[] elementos;
    private int tamanho;

    @SuppressWarnings("unchecked")
    public Vetor(int quantidade){
        elementos = (T[]) new Object[quantidade];
        tamanho = 0;
    }


    public void inserir(T elemento) {
        if (tamanho == elementos.length){
            expandir();
        }
        elementos[tamanho] = elemento;
        tamanho++;
    }

    public void inserir(int indice, T elemento){
        if (tamanho >= elementos.length){
            System.out.println("Vetor cheio");
            return;
        }
        if (indice < 0 || indice > elementos.length){
            System.out.println("Posição inválida");
            return;
        }

        for (int i = tamanho; i > indice ; i--) {
            elementos[i] = elementos[i-1];
        }
        elementos[indice] = elemento;
        tamanho++;
    }


    @SuppressWarnings("unchecked")
    private void expandir(){
        T[] novo = (T[]) new Object[this.elementos.length * 2];
        for (int i = 0; i < this.elementos.length; i++){
            novo[i] = this.elementos[i];
        }
        this.elementos = novo;
    }


    @SuppressWarnings("unchecked")
    private void reduzir(){

        // Quando diminuir?
        if (tamanho <= elementos.length/4){
            // Quanto diminuir?
            T[] novo =(T[])  new Object[elementos.length/2];
            for (int i = 0; i < tamanho; i++) {
                novo[i] = elementos[i];
            }
            elementos = novo;
        }
    }

    public void remover(int indice){
        if (indice < 0 || indice >= tamanho){
            System.out.println("Índice inválido");
            return;
        }
        for (int i = indice; i < tamanho; i++) {
            elementos[i] = elementos [i + 1];
        }
        elementos[tamanho - 1] = null;
        tamanho--;
        reduzir();
    }

    public void remover(T elemento) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i].equals(elemento)){
                remover(i);
                return;
            }
        }
    }

    public void imprimir(){
        System.out.print("[");

        for (int i = 0; i < elementos.length; i++) {
            System.out.print(elementos[i]);
            if (i < elementos.length -1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public Object ler(int indice) {
        if (indice >= 0 && indice < tamanho) {
            return elementos[indice];
        } else {
            throw new IndexOutOfBoundsException("Índice inválido");
        }
    }
    // Vetor desenvolvido anteriormente acima

    public int obterTamanho(){
        return tamanho;
    }


    public void geradorAleatorio(Vetor<Integer> vetor,int quantidade, int range){


        int intervalo1 = 0;
        int intervalo2 = 100;
        int[] numeros = new int[quantidade];

        for (int i = 0; i < quantidade; i++) {
           int numRandom = (int) (Math.random() * ((intervalo2 - intervalo1) + 1)) + intervalo1;

           numeros[i] = numRandom;

            // Verificar repetição
            for (int j = 0; j < numeros.length; j++) {
                if (numRandom == numeros[j] && numeros[0] != 0){
                    return;
                }
            }

            // Ordenar Crescentemente


            for (int j = 0; j < tamanho; j++) {
                if ((int)elementos[j] < numeros[i] ) {
                    inserir(j,numeros[i]);
                }

            }


        }

    }

    public void inserirOrdenado(T valor){

        if (localizar)

        if (tamanho == 0){
            inserir(tamanho,valor);
            return;
        }

        for (int i = 0; i < tamanho; i++) {
            if ((Integer) valor < (Integer) elementos[i]){
                inserir(i,valor);
                break;
            }

        }
    }

    public void inserirOrdenadoLivro(T valor){

    }

}