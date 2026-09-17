package dados.estrutura;

public class Stack<T extends Comparable<T>> {

    private Vetor<T> vetor;


    public Stack(int capacidade){
        vetor = new Vetor<>(capacidade);
    }

    public void push(T elemento){
        vetor.inserir(elemento);
    }

    public boolean isEmpty(){
        return vetor.obterTamanho() == 0;
    }

    public T pop(){
        if(isEmpty()) {
            throw new RuntimeException("Vazio");
        }

        T valor = vetor.ler(vetor.obterTamanho()-1);
        vetor.remover(vetor.obterTamanho()-1);
        return valor;
    }

    public T peek(){
        if (isEmpty()){
            throw new RuntimeException("Vazio");
        }
        return vetor.ler(vetor.obterTamanho()-1);
    }
//    public String Conteudo() {
//        if (isEmpty()){
//            throw new RuntimeException("Vazio");
//        }
//
//        String conteudo = " ";
//        for (int i = 0; i < vetor.obterTamanho()-1; i++) {
//            conteudo +=
//
//        }
//    }
}
