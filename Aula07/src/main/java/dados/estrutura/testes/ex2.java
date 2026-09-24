package dados.estrutura.testes;

import dados.estrutura.Fila;
import dados.estrutura.Pacote;
import dados.estrutura.Produtor;

public class ex2 {
    static void main() {

        Fila<Pacote> fila = new Fila<Pacote>(10);

        Produtor pr1 = new Produtor("Produtor 1", "PC-A");
        Produtor pr2 = new Produtor("Produtor 2", "PC-B");

        pr1.produzirPacote(fila,1,"Login", "Servidor 1", "AAAA");
        pr1.produzirPacote(fila,2,"Imagem", "Servidor 2", "AAAA");

        pr2.produzirPacote(fila,3,"Imagem","Servidor 3", "AAAA");

        System.out.println("FILA DE PACOTES");
        fila.imprimir();

        System.out.println("FILA DEPOIS DE DESENFILEIRAR");
        fila.desenfileirar();
        fila.imprimir();
    }
}
