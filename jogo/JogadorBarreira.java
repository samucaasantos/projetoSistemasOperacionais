package jogo;

import java.util.Random;

public class JogadorBarreira implements Runnable {
    //atributos:
    private final String nome;
    private final char[][] tabuleiro;
    private final Barreira barreira;
    private final ContadorGlobalMensagens contadorGlobal; //reaproveitei o contador de troca de mensagens
    private int acertos = 0;

    //construtor:
    public JogadorBarreira(String nome, char[][] tabuleiro, Barreira barreira, ContadorGlobalMensagens contadorGlobal) {
        this.nome = nome;
        this.tabuleiro = tabuleiro;
        this.barreira = barreira;
        this.contadorGlobal = contadorGlobal;
    }

    //retorna o nome
    public String getNome() {
        return nome;
    }

    //retorna os acertos
    public int getAcertos() {
        return acertos;
    }

    //Método principal da thread do jogador, onde ele joga até que todos os navios sejam afundados
    @Override
    public void run() {
        Random rand = new Random();

        while (contadorGlobal.getNaviosRestantes() > 0) {
            int linha = rand.nextInt(tabuleiro.length);
            int coluna = rand.nextInt(tabuleiro[0].length);

            synchronized (tabuleiro) {
                if (tabuleiro[linha][coluna] == 'n') {
                    tabuleiro[linha][coluna] = 'x';
                    acertos++;
                    contadorGlobal.decrementar();
                    System.out.println(nome + " acertou um navio em (" + (linha + 1) + ", " + (coluna + 1) + ")");
                } else if (tabuleiro[linha][coluna] == 'a') {
                    tabuleiro[linha][coluna] = 'o';
                    System.out.println(nome + " errou um tiro em (" + (linha + 1) + ", " + (coluna + 1) + ")");
                }
            }

            imprimirTabuleiro();

            // Sincroniza com a barreira
            barreira.await();

            try {
                Thread.sleep(100); // Aguarda um tempo antes da próxima tentativa
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //Imprime o estado atual do tabuleiro
    private void imprimirTabuleiro() {
        synchronized (tabuleiro) {
            for (int i = 0; i < tabuleiro.length; i++) {
                for (int j = 0; j < tabuleiro[i].length; j++) {
                    System.out.print(tabuleiro[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
