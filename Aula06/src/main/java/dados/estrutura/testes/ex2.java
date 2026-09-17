package dados.estrutura.testes;

import dados.estrutura.EditorTexto;

public class ex2 {

    static void main() {
        EditorTexto editor = new EditorTexto();

        editor.escrever("Olá");
        editor.escrever("Mundo");

        System.out.println("Conteúdo atual: " + editor.getConteudo());

        editor.desfazer();
        System.out.println("Conteúdo após DESFAZER: " + editor.getConteudo());

        editor.refazer();
        System.out.println("Conteúdo após REFAZER: " + editor.getConteudo());

        System.out.println("--Vão estudar!--");
        editor.escrever("");
    }
}
