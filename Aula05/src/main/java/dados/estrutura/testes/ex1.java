package dados.estrutura.testes;

import dados.estrutura.Produto;
import dados.estrutura.Vetor;

public class ex1 {
    static void main() {

        Vetor<Produto> estoque = new Vetor<>(10);
        estoque.inserirOrdenado(new Produto(1,"Notebook",3500));
        estoque.inserirOrdenado(new Produto(2,"Teclado",200));
        estoque.inserirOrdenado(new Produto(3,"Mouse",50));

        estoque.imprimir();
    }
}
