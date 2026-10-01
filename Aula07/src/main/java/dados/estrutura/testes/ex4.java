package dados.estrutura.testes;

import dados.estrutura.FilaCircular;

public class ex4 {
    static void main() {
        FilaCircular<String> fila = new FilaCircular<>(4);
        fila.enfileirar("A");
        fila.enfileirar("B");
        fila.enfileirar("C");
        fila.enfileirar("D");

        fila.imprimir();

        System.out.println("Removido " + fila.desenfileirar());
        System.out.println("Removido " + fila.desenfileirar());
        fila.imprimir();

        fila.enfileirar("F");
        fila.enfileirar("G");
        fila.imprimir();


    }


}
