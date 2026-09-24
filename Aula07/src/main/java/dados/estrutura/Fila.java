package dados.estrutura;

public class Fila<T extends Comparable> {
    private T[] elementos;
    private int tamanho;


    @SuppressWarnings("unchecked")
    public Fila(int capacidade) {
        this.elementos = (T[]) new Comparable[capacidade];
        this.tamanho = 0;
    }

    // Igual adicionar na ordem linear, bem simples
    public void enfileirar(T elemento){
        if(tamanho == elementos.length){
            throw new RuntimeException("Fila cheia");
        }
        elementos[tamanho] = elemento;
        tamanho++;
    }

    private boolean isEmpty(){
        return tamanho == 0;
    }


    // Desse jeito o big O (complexidade) fica O(elevado a n - "Ó de n")
    public T desenfileirar() {
        if (isEmpty()){
            throw new RuntimeException("Fila vazia!");
        }
        T elemento = elementos[0];

        for (int i = 0; i < tamanho - 1; i++) {
            elementos[i] = elementos[i+1];
        }
        elementos[tamanho - 1] = null;
        tamanho--;
        return elemento;

    }

    // Igual o peek que pega o topo, porém se tratando de filas, topo equivale a frente
    public T frente(){
        if(isEmpty()){
            throw new RuntimeException("Fila vazia");
        }
        return elementos[0];
    }

    public void imprimir(){
        if(isEmpty()){
            System.out.println("Fila vazia");
        } else {
            System.out.println("Fila: ");
            for (int i = 0; i < tamanho; i++) {
                System.out.print(elementos[i] + " ");
            }
            System.out.println();
        }
    }
}
