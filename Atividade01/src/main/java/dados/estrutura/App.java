package dados.estrutura;

public class App {
    static void main() {
        App agenda = new App();


        agenda.menu(0);

    }

    void menu(int opcao) {

        Agenda agenda = new Agenda(2);

        while (opcao != 8) {
            String hub = String.format("""
                    ..:: Agenda ::..
                    1 - Adicionar contato
                    2 - Remover contato
                    3 - Buscar contato
                    4 - Atualizar contato
                    5 - Listar contatos
                    6 - Manipulação em lote
                    7 - Buscar por prefixo
                    8 - Sair""");

            System.out.println(hub);

            opcao = Integer.parseInt(IO.readln("Entre com uma opção: "));


            switch (opcao) {
                case 1 -> {
                    String nome = IO.readln("Insira o nome do contato: ");
                    String telefone = IO.readln("Insira o telefone: ");
                    Contato contatog = new Contato(nome, telefone);

                    agenda.addContato(contatog);
                }
                case 2 -> {
                    String nomeTel = IO.readln("Insira o nome ou telefone do contato que deseja remover: ");

                    agenda.removerContato(nomeTel);
                }
                case 3 -> {
                    String nomeTel = IO.readln("Insira o nome ou telefone do contato que deseja encontrar: ");

                    Contato contatoAnalise = new Contato(nomeTel, nomeTel);

                    Contato contatoBuscado = agenda.buscarContato(contatoAnalise);

                    if (contatoBuscado == null) {
                        System.out.println("Contato não encontrado");
                    } else {
                        System.out.println(contatoBuscado);
                    }

                }
                case 4 -> {
                    String nomeTel = IO.readln("Insira o nome ou telefone do contato que deseja atualizar: ");

                    String nome = IO.readln("Insira o novo nome: ");
                    String tel = IO.readln("Insira o novo telefone: ");

                    Contato contatoAtualizado = new Contato(nome, tel);

                    agenda.atualizarContato(nomeTel, contatoAtualizado);
                }
                case 5 -> {
                    Contato[] contatos = agenda.listarContatos();
                    for (Contato elemento : contatos) {
                        System.out.println(elemento);
                    }
                }
                case 6 -> {

                    int quantidade = Integer.parseInt(IO.readln("Insira a quantidade de contatos que deseja adicionar: "));
                    Contato[] variosContatos = new Contato[quantidade];

                    for (int i = 0; i < quantidade; i++) {
                        String nome = IO.readln("Insira o nome do contato: ");
                        String telefone = IO.readln("Insira o telefone: ");

                        variosContatos[i] = new Contato(nome, telefone);
                    }

                    agenda.adicionarVariosContatos(variosContatos);
                    Contato[] contatos = agenda.listarContatos();
                    for (Contato elemento : contatos) {
                        System.out.println(elemento);
                    }

                }
                case 7 -> {
                    String prefixo = IO.readln("Insira o prefixo que desejar buscar: ");

                    Contato[] encontrados = agenda.buscarPrefixo(prefixo);

                    if (encontrados.length == 0) {
                        System.out.println("Nenhum contato encontrado");
                    } else {
                        for (Contato contato : encontrados) {
                            System.out.println(contato);
                        }
                    }

                }
                case 8 -> {
                    System.out.println("Fechando agenda...");
                }

            }

        }
    }

}

