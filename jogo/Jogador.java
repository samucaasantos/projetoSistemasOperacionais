package jogo;

import java.util.Random;

public class Jogador implements Runnable {
    private final String nome;
    private final char[][] tabuleiro;
    private int acertos = 0;

    public Jogador(String nome, char[][] tabuleiro) {
        this.nome = nome;
        this.tabuleiro = tabuleiro;
    }

    public String getNome() {
        return nome;
    }

    public int getAcertos() {
        return acertos;
    }

    @Override
    public void run() {
        Random rand = new Random();
        int naviosRestantes = 5;

        while (naviosRestantes > 0) {
            int linha = rand.nextInt(tabuleiro.length);
            int coluna = rand.nextInt(tabuleiro[0].length);

            if (tabuleiro[linha][coluna] == 'n') {
                tabuleiro[linha][coluna] = 'x';
                acertos++;
                naviosRestantes--;
                System.out.println(nome + " acertou um navio em (" + (linha + 1) + ", " + (coluna + 1) + ")");
            } else if (tabuleiro[linha][coluna] == 'a') {
                tabuleiro[linha][coluna] = 'o';
                System.out.println(nome + " errou um tiro em (" + (linha + 1) + ", " + (coluna + 1) + ")");
            } else {
                System.out.println(nome + " tentou uma posição já atacada em (" + (linha + 1) + ", " + (coluna + 1) + ")");
            }

            imprimirTabuleiro();

            try {
                Thread.sleep(100); // Aguarda um tempo antes da próxima tentativa
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

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
