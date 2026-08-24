package dados.estrutura;

public class Agenda {

    private Contato[] contatos;
    private int tamanho;

    public Agenda(int quantidade) {
        contatos = new Contato[quantidade];
        this.tamanho = 0;
    }

    public void addContato(Contato contato) {

        String nome = contato.getNome();
        String telefone = contato.getTelefone();

        for (int i = 0; i < tamanho; i++) {
            if (nome.equals(contatos[i].getNome())) {
                System.out.println("Nome já cadastrado!" + '\n');
                nome = "";
                return;
            } else if (telefone.equals(contatos[i].getTelefone())) {
                System.out.println("Telefone já cadastrado!" + '\n');
                telefone = "";
                return;
            }

        }
        if (tamanho == contatos.length) {
            expandirAgenda();
        }

        contatos[tamanho] = contato;
        tamanho++;
        System.out.println("Contato adicionado com sucesso!" + '\n');
    }

    public void removerContatoIndice(int indice) {
        if (indice < 0 || indice >= tamanho) {
            System.out.println("Erro na agenda!");
            return;
        }
        for (int i = indice; i < tamanho - 1; i++) {
            contatos[i] = contatos[i + 1];
        }
        contatos[tamanho - 1] = null;
        tamanho--;
        reduzirAgenda();
    }

    public void removerContato(String nomeTel) {
        for (int i = 0; i < tamanho; i++) {
            if (contatos[i].getNome().equals(nomeTel)) {
                removerContatoIndice(i);
                System.out.println("Contato removido com sucesso!" + '\n');
                return;
            } else if (contatos[i].getTelefone().equals(nomeTel)) {
                removerContatoIndice(i);
                System.out.println("Contato removido com sucesso!" + '\n');
                return;
            }
        }
        System.out.println("Nome ou telefone inválidos!" + '\n');

    }

    public Contato[] listarContatos() {
        Contato[] contatosLista = new Contato[tamanho];
        for (int i = 0; i < tamanho; i++) {
            contatosLista[i] = contatos[i];
        }
        return contatosLista;
    }

    public Contato buscarContato(Contato contato) {
        for (int i = 0; i < tamanho; i++) {
            if (contatos[i].getNome().equals(contato.getNome()) || contatos[i].getTelefone().equals(contato.getTelefone())) {
                return contatos[i];
            }
        }
        return null;
    }


    // Evitar entrar com todas essas Strings, entrar com um Contato


    public void atualizarContato(String nomeTel, Contato contatoAtualizado) {
        for (int i = 0; i < tamanho; i++) {
            if (contatos[i].getNome().equals(nomeTel) || contatos[i].getTelefone().equals(nomeTel)) {
                for (int j = 0; j < tamanho; j++) {
                    if (i != j) {
                        if (contatoAtualizado.getNome().equals(contatos[j].getNome())) {
                            System.out.println("Nome já cadastrado!" + '\n');
                            return;
                        }
                        if (contatoAtualizado.getTelefone().equals(contatos[j].getTelefone())) {
                            System.out.println("Telefone já cadastrado!" + '\n');
                            return;
                        }
                    }
                }
                contatos[i] = contatoAtualizado;
                System.out.println("Contato atualizado com sucesso!");
                return;

            }

            System.out.println("Atualização não concluída!");
        }
    }

    public void adicionarVariosContatos(Contato[] arrayContatos) {
        for (Contato contato : arrayContatos) {
            addContato(contato);
        }

    }

    // Evitar retornar Strings, trocar "void" por "Contato[]" e retornar o próprio contato


    public Contato[] buscarPrefixo(String prefixo) {
        int encontrados = 0;

        for (int i = 0; i < tamanho; i++) {
            if (contatos[i].getNome().startsWith(prefixo) || contatos[i].getTelefone().startsWith(prefixo)) {
                encontrados++;
            }
        }
        Contato[] contatosEncontrados = new Contato[encontrados];

        for (int j = 0; j < tamanho; j++) {
            if (contatos[j].getNome().startsWith(prefixo) || contatos[j].getTelefone().startsWith(prefixo)) {
                contatosEncontrados[j] = contatos[j];
            }
        }

        return contatosEncontrados;

    }

    // Depois da aula sobre vetor dinâmico

    private void expandirAgenda() {
        Contato[] novo = new Contato[this.contatos.length * 2];
        for (int i = 0; i < this.contatos.length; i++) {
            novo[i] = this.contatos[i];
        }
        this.contatos = novo;
    }

    private void reduzirAgenda() {

        if (tamanho <= contatos.length / 4) {
            Contato[] novo = new Contato[contatos.length / 2];
            for (int i = 0; i < tamanho; i++) {
                novo[i] = contatos[i];
            }
            contatos = novo;
        }
    }

}
