package dados.estrutura;

public class App {
    static void main() {
        App agenda = new App();


        agenda.menu(0);

    }

    void menu(int opcao) {

        Agenda agenda = new Agenda();

        while (opcao != 5) {
            String hub = String.format("""
                    ..:: Agenda ::..
                    1 - Adicionar contato (ordenado)
                    2 - Remover contato
                    3 - Buscar contato
                    4 - Atualizar contato
                    5 - Sair""");

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
                    String nome = IO.readln("Insira o nome do contato que deseja remover: ");

                    agenda.removerContato(nome);
                }
                case 3 -> {
                    String nome = IO.readln("Insira o nome do contato que deseja encontrar: ");

                    Contato contatoAnalise = new Contato(nome, "");

                    Contato contatoBuscado = agenda.buscarContato(contatoAnalise);

                    if (contatoBuscado == null) {
                        System.out.println("Contato não encontrado");
                    } else {
                        System.out.println(contatoBuscado);
                    }

                }
                case 4 -> {
                    String nome = IO.readln("Insira o nome do contato que deseja atualizar: ");

                    String nomeNovo = IO.readln("Insira o novo nome: ");
                    String telNovo = IO.readln("Insira o novo telefone: ");

                    Contato contatoAtualizado = new Contato(nomeNovo, telNovo);

                    agenda.atualizarContato(nome, contatoAtualizado);
                }

                case 5 -> {
                    System.out.println("Fechando agenda...");
                }

            }

        }
    }

}