package jogo;

import java.util.concurrent.locks.ReentrantLock;

public class BatalhaNaval {
    public static void main(String[] args) {
        System.out.println("Batalha Naval!");
        System.out.println();
        System.out.println("Esse é o BATALHA NAVAL, o jogo onde você deve acertar os navios inimigos que estão escondidos no tabuleiro...");
        System.out.println("O tabuleiro contém 6 navios de tamanho 1x1");
        System.out.println("Primeiro você deve definir o tamanho do tabuleiro (mínimo 2x4 ou 4x2)");

        // Gera o tabuleiro do tamanho que o usuário quiser
        char tab[][] = Tabuleiro.tabuleiro();
        int nlinha = tab.length;
        int ncoluna = tab[0].length;

        ReentrantLock lock = new ReentrantLock();
        ContadorGlobal contadorGlobal = new ContadorGlobal(8);

        // Cria duas threads representando os jogadores
        Jogador jogador1 = new Jogador("Jogador 1", tab, lock, contadorGlobal);
        Jogador jogador2 = new Jogador("Jogador 2", tab, lock, contadorGlobal);

        // Inicia as threads
        Thread t1 = new Thread(jogador1);
        Thread t2 = new Thread(jogador2);

        t1.start();
        t2.start();

        try {
            // Aguarda as threads terminarem
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Determina o vencedor
        if (jogador1.getAcertos() > jogador2.getAcertos()) {
            System.out.println(jogador1.getNome() + " venceu com " + jogador1.getAcertos() + " acertos!");
        } else if (jogador2.getAcertos() > jogador1.getAcertos()) {
            System.out.println(jogador2.getNome() + " venceu com " + jogador2.getAcertos() + " acertos!");
        } else {
            System.out.println("O jogo terminou empatado com " + jogador1.getAcertos() + " acertos cada!");
        }
    }
}
