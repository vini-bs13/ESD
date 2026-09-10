package dados.estrutura;

public class Agenda {

    private Vetor<Contato>[] letras;
    private int tamanho;


    @SuppressWarnings("unchecked")
    public Agenda() {
        letras = (Vetor<Contato>[]) new Vetor[26];

        for (int i = 0; i < 26; i++) {
            letras[i] = new Vetor<>();

        }
        this.tamanho = 0;
    }

    public void addContato(Contato contato) {

        int indice = obterIndiceLetra(contato.getNome());

        Vetor<Contato> vetor = letras[indice];

        for (int i = 0; i < vetor.getTamanho(); i++) {

            Contato contatoAtual = (Contato) vetor.ler(i);

            if (contato.getNome().equals(contatoAtual.getNome())) {
                System.out.println("Nome já cadastrado!" + '\n');
                return;
            }

            if (contato.getTelefone().equals(contatoAtual.getTelefone())) {
                System.out.println("Telefone já cadastrado!" + '\n');
                return;
            }

        }

        vetor.inserirOrdenado(contato);
        int posicao = vetor.localizar(contato);
        tamanho++;
        System.out.println("Contato " + contato.getNome() +
                " adicionado com sucesso na letra: '" +
                contato.getNome().charAt(0) +
                "' no indice " +
                posicao + '\n');
    }

    public void removerContatoIndice(int indice, Vetor<Contato> vetor) {
        if (indice < 0 || indice >= vetor.getTamanho()) {
            System.out.println("Erro na agenda!");
            return;
        }
        vetor.remover(indice);
        tamanho--;

    }

    public void removerContato(String nome) {

        int indice = obterIndiceLetra(nome);
        Vetor<Contato> vetor = letras[indice];


        for (int i = 0; i < vetor.getTamanho(); i++) {

            Contato contatoAtual = (Contato) vetor.ler(i);

            if (contatoAtual.getNome().equals(nome)) {
                removerContatoIndice(i, vetor);
                System.out.println("Contato '" + contatoAtual.getNome() +
                        "' removido com sucesso do vetor: '" +
                        contatoAtual.getNome().charAt(0) +
                        "'" + '\n');
                return;
            }
        }

        System.out.println("Nome ou telefone inválidos!" + '\n');

    }

    public Contato buscarContato(Contato contato) {

        int indice = obterIndiceLetra(contato.getNome());

        Vetor<Contato> vetor = letras[indice];

        for (int i = 0; i < vetor.getTamanho(); i++) {

            Contato contatoAtual = (Contato) vetor.ler(i);

            if (contatoAtual.getNome().equals(contato.getNome())) {
                 System.out.println("Contato encontado no vetor: '" + contatoAtual.getNome().charAt(0) +
                        "' |" + contatoAtual.getNome() + " , " +
                        contatoAtual.getTelefone() + '\n');
                return contatoAtual;
            }
        }
        System.out.println("Erro! O contato a seguir não foi encontrado.");
        return contato;
    }


    // Evitar entrar com todas essas Strings, entrar com um Contato


    public void atualizarContato(String nome, Contato contatoAtualizado) {

        int indice = obterIndiceLetra(nome);
        Vetor<Contato> vetor = letras[indice];

        for (int i = 0; i < vetor.getTamanho(); i++) {

            Contato contatoAtual = (Contato) vetor.ler(i);

            if (contatoAtual.getNome().equals(nome)) {
                for (int j = 0; j < vetor.getTamanho(); j++) {

                    if (i != j) {

                        Contato outroContato = (Contato) vetor.ler(j);

                        if (contatoAtualizado.getNome().equals(outroContato.getNome())) {
                            System.out.println("Nome já cadastrado!" + '\n');
                            return;
                        }
                        if (contatoAtualizado.getTelefone().equals(outroContato.getTelefone())) {
                            System.out.println("Telefone já cadastrado!" + '\n');
                            return;
                        }
                    }
                }

                vetor.remover(i);

                int indiceNovo = obterIndiceLetra(contatoAtualizado.getNome());

                Vetor<Contato> vetorNovo = letras[indiceNovo];

                vetorNovo.inserirOrdenado(contatoAtualizado);

                System.out.println("Contato '" + contatoAtualizado.getNome() + "' atualizado com sucesso!" + '\n');
                return;

            }

        }
        System.out.println("Atualização não concluída!");
    }

    // Atividade03

    private int obterIndiceLetra(String nome) {
        String nomeMinusculo = nome.toLowerCase();
        char primeiraLetra = nomeMinusculo.charAt(0);

        return primeiraLetra - 'a'; // a = 97 pela tabela ASCII
    }

}