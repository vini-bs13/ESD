package dados.estrutura;

public class EditorTexto {
    
    private Stack<String> undo;
    private Stack<String> redo;
    private String conteudo;
    
    public EditorTexto() {
        this.undo = new Stack<>(20);
        this.redo = new Stack<>(20);
        this.conteudo = "";
    }
    
    public void escrever(String texto){
        undo.push(texto);
        conteudo += texto;
        
        // Limpando a pilha de refazer
        redo = new Stack<>(20);
    }

    public String getConteudo(){
        return this.conteudo;
    }

    public void desfazer() {
        if (!undo.isEmpty()) {
            redo.push(conteudo);
            undo.pop();

            while(!undo.isEmpty()){
                conteudo += undo.pop();
            }
        } else {
            System.out.println("Nada para DESFAZER");
        }
    }

    public void refazer() {
        if (!redo.isEmpty()) {
            undo.push(conteudo);
            conteudo = redo.pop();
        } else {
            System.out.println("Nada para REFAZER");
        }
    }
    
}
