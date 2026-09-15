package dados.estrutura.testes;

import dados.estrutura.Pilha;

public class ex1 {

    static void main(){

        Pilha<Integer> pilha = new Pilha<>(10);

        System.out.println("A pilha está vazia: " + pilha.isEmpty());

        // inserindo dados

        pilha.push(10);
        pilha.push(11);
        pilha.push(12);
        pilha.push(13);
        pilha.push(14);
        pilha.push(15);
        pilha.push(16);

        System.out.println("A pilha está vazia: " + pilha.isEmpty());

        // removendo dados



        pilha.pop();
        int valor = pilha.pop();
        System.out.println("Segundo valor desempilhado: " + valor);

        pilha.pop();
        pilha.pop();
        pilha.pop();
        pilha.pop();
        pilha.pop();
        pilha.pop();


    }
}
