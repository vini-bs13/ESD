package dados.estrutura;

public class Vetor<T> {

    // Classe copiada da Aula04

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

        for (int i = 0; i < tamanho; i++) {
            System.out.print(elementos[i]);
            if (i < tamanho -1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public T ler(int indice) {
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


    public void inserirOrdenado(T valor){

        if (localizar(valor) != -1){
            System.out.println("Valor " + valor + " já existente");
            return;
        }

        if (tamanho == elementos.length){
            expandir();
        }
        int i;
        for (i = tamanho - 1; i >= 0; i--) {
            Integer atual = (Integer) elementos[i];
            if (atual > (Integer) valor){
                elementos[i + 1] = elementos[i]; // desloca para a direita
            } else {
                break;
            }
        }
        elementos[i + 1] = valor;
        tamanho++;
    }

    public void inserirOrdenadoLivro(T valor){
        if (localizar(valor) != -1) {
            System.out.println("Valor " + valor + " já existe na lista.");
            return;
        }
        if (tamanho == 0) {
            inserir(tamanho,valor);
            return;
        }
        for (int i = 0; i < tamanho; i++) {
            if ((Integer)valor < (Integer) elementos[i]) {
                inserir(i,valor);
                break;
            }
        }

    }

    public int localizar(T elemento) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i] != null && elementos[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

}