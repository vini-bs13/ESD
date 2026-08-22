package dados.estrutura;

public class Agenda {

    private Contato[] contatos;
    private int tamanho;

    public Agenda(int quantidade){
        contatos = new Contato[quantidade];
        this.tamanho = 0;
    }

    public void addContato(Contato contato){

        String nome = contato.getNome();
        String telefone = contato.getTelefone();

        for (int i = 0; i < tamanho; i++) {
            if (nome.equals(contatos[i].getNome())){
                System.out.println("Nome já cadastrado!" + '\n');
                nome = "";
                return;
            } else if (telefone.equals(contatos[i].getTelefone())){
                System.out.println("Telefone já cadastrado!" + '\n');
                telefone = "";
                return;
            }

        }
        if (tamanho == contatos.length){
            expandirAgenda();
        }

        contatos[tamanho] = contato;
        tamanho++;
         System.out.println("Contato adicionado com sucesso!" + '\n');
    }

    public void removerContatoIndice(int indice){
        if (indice < 0 || indice >= tamanho) {
            System.out.println("Erro na agenda!");
            return;
        }
        for (int i = indice; i < tamanho; i++) {
            contatos[i] = contatos [i+1];
        }
        contatos[tamanho-1] = null;
        tamanho--;
        reduzirAgenda();
    }

    public void removerContato(String nomeTel){
        for (int i = 0; i < tamanho; i++) {
            if (contatos[i].getNome().equals(nomeTel)){
                removerContatoIndice(i);
                System.out.println("Contato removido com sucesso!" + '\n');
                return;
            } else if (contatos[i].getTelefone().equals(nomeTel)){
                removerContatoIndice(i);
                System.out.println("Contato removido com sucesso!" + '\n');
                return;
            }
        }
            System.out.println("Nome ou telefone inválidos!" + '\n');

    }

    public void listarContatos(){
        for (int i = 0; i < tamanho; i++) {
            System.out.printf(contatos[i].toString());
        }
    }

    public void buscarContato(String nomeTel){
        for (int i = 0; i < tamanho; i++) {
            if (contatos[i].getNome().equals(nomeTel)){
                System.out.println(contatos[i].toString());
                return;
            } else if (contatos[i].getTelefone().equals(nomeTel)) {
                System.out.println(contatos[i].toString());
                return;
            }
        }
        System.out.println("Contato não encontrado!" + '\n');
    }



    // Evitar entrar com todas essas Strings, entrar com um Contato

    public void atualizarContato(String nomeTel, String nome, String tel){
        for (int i = 0; i < tamanho; i++) {
            if (contatos[i].getNome().equals(nomeTel) || contatos[i].getTelefone().equals(nomeTel)){
                for (int j = 0; j < tamanho; j++) {
                    if (nome.equals(contatos[j].getNome())){
                        System.out.println("Nome já cadastrado!" + '\n');
                        nome = "";
                        return;
                    } else if (tel.equals(contatos[j].getTelefone())) {
                        System.out.println("Telefone já cadastrado!" + '\n');
                        tel = "";
                        return;
                    }
                }

                contatos[i].setNome(nome);
                contatos[i].setTelefone(tel);
                System.out.println("Contato atualizado com sucesso!");
                return;
            }
        }

        System.out.println("Atualização não concluída!");
    }

    public void adicionarVariosContatos(Contato[] arrayContatos){
        for (Contato contato : arrayContatos) {
            addContato(contato);
        }

    }

    // Evitar retornar Strings, trocar "void" por "Contato[]" e retornar o próprio contato

    public void buscarPrefixo(String prefixo){
        for (int i = 0; i < tamanho; i++) {
            if (contatos[i].getNome().startsWith(prefixo)){
                System.out.println(contatos[i].toString());
            } else if (contatos[i].getTelefone().startsWith(prefixo)) {
                System.out.println(contatos[i].toString());
            }
        }

    }

    // Depois da aula sobre vetor dinâmico

    private void expandirAgenda(){
        Contato[] novo = new Contato[this.contatos.length * 2];
        for (int i = 0; i < this.contatos.length; i++){
            novo[i] = this.contatos[i];
        }
        this.contatos = novo;
    }

    private void reduzirAgenda(){

        if (tamanho <= contatos.length/4){
            Contato[] novo =  new Contato[contatos.length/2];
            for (int i = 0; i < tamanho; i++) {
                novo[i] = contatos[i];
            }
            contatos = novo;
        }
    }



}
