package jogo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BatalhaNavalTrocaDeMensagem {
    public static void main(String[] args) {
        System.out.println("Batalha Naval!");
        System.out.println();
        System.out.println("Esse é o BATALHA NAVAL, o jogo onde você deve acertar os navios inimigos que estão escondidos no tabuleiro...");
        System.out.println("O tabuleiro contém 8 navios de tamanho 1x1");
        System.out.println("Primeiro você deve definir o tamanho do tabuleiro (mínimo 2x4 ou 4x2)");

        // Gera o tabuleiro do tamanho que o usuário quiser
        char tab[][] = Tabuleiro.tabuleiro();
        int nlinha = tab.length;
        int ncoluna = tab[0].length;

        FilaMensagens filaMensagens = new FilaMensagens();

        // Contador global de navios
        ContadorGlobalMensagens contadorGlobal = new ContadorGlobalMensagens(8);

        // Cria duas threads representando os jogadores
        JogadorMensagens jogador1 = new JogadorMensagens("Jogador 1", tab, filaMensagens, contadorGlobal);
        JogadorMensagens jogador2 = new JogadorMensagens("Jogador 2", tab, filaMensagens, contadorGlobal);

        // Usando ExecutorService para executar as threads de forma assíncrona
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(jogador1);
        executor.execute(jogador2);

        executor.shutdown();
        while (!executor.isTerminated()) {
            // Aguarda até que todas as threads terminem
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