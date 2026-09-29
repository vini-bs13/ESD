package dados.estrutura.testes;

import dados.estrutura.Servidor;

import java.util.Random;

public class ex3 {

    static void main() {
//        int[] capacidades = {5, 10, 50};
//        int[] processadores = {1, 2, 4};
//        int[] maxGeradas = {2, 4, 6};


        int ciclos = 500;
        Servidor sv1 = new Servidor(50,30,45,new Random(13));
        Servidor sv2 = new Servidor(50,30,5,new Random(31));
        Servidor sv3 = new Servidor(50,5,30,new Random(7));


        sv1.executar(ciclos);
        sv2.executar(ciclos);
        sv3.executar(ciclos);

        System.out.println(sv1.getProbPerda() * 100);
        System.out.println(sv2.getProbPerda() * 100);
        System.out.println(sv3.getProbPerda() * 100);

        System.out.println(sv1);
        System.out.println(sv2);
        System.out.println(sv3);


//        System.out.printf("%-10s %-14s %-12s %s%n", "ReqsFila", "Processadores", "MaxChegadas", "Perdidas");
//
//        for (int capacidade : capacidades) {
//            for (int processador : processadores) {
//                for (int maxGerada : maxGeradas) {
//                    Random rnd = new Random(13);
//                    Servidor sv = new Servidor(capacidade,processador,maxGerada,rnd);
//
//                    for (int ciclo = 0; ciclo < ciclos; ciclo++) {
//                        sv.executar(ciclo);
//                    }
//
//                    System.out.printf("%-10d %-14d %-12d %.4f%%%n", capacidade, processador, maxGerada, sv.getProbPerda() * 100);
//                }
//            }
//        }
    }
}
