package dados.estrutura;


public class App {
    static void main() {

        FilaCircular<Processo> tarefas = new FilaCircular<>(10);
        Processo p1 = new Processo(7,0);
        Processo p2 = new Processo(4,0);
        Processo p3 = new Processo(5,1);
        Processo p4 = new Processo(6,2);
        Processo p5 = new Processo(3,4);



        tarefas.enfileirar(p1);
        tarefas.enfileirar(p2);

        p1.executarQuantum();





    }


}
