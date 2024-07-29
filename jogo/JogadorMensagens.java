package jogo;

import java.util.Random;

public class JogadorMensagens implements Runnable {
    private final String nome;
    private final char[][] tabuleiro;
    private final FilaMensagens filaMensagens;
    private final ContadorGlobalMensagens contadorGlobal;
    private int acertos = 0;

    public JogadorMensagens(String nome, char[][] tabuleiro, FilaMensagens filaMensagens, ContadorGlobalMensagens contadorGlobal) {
        this.nome = nome;
        this.tabuleiro = tabuleiro;
        this.filaMensagens = filaMensagens;
        this.contadorGlobal = contadorGlobal;
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

        while (contadorGlobal.getNaviosRestantes() > 0) {
            boolean acaoRealizada = false;
            String mensagem = nome + " está jogando";
            filaMensagens.enviar(mensagem);
            filaMensagens.receber(); // Aguarda sua vez de jogar

            if (contadorGlobal.getNaviosRestantes() <= 0) {
                break;
            }

            int linha = rand.nextInt(tabuleiro.length);
            int coluna = rand.nextInt(tabuleiro[0].length);

            synchronized (tabuleiro) {
                if (tabuleiro[linha][coluna] == 'n') {
                    tabuleiro[linha][coluna] = 'x';
                    acertos++;
                    contadorGlobal.decrementar();
                    System.out.println(nome + " acertou um navio em (" + (linha + 1) + ", " + (coluna + 1) + ")");
                    acaoRealizada = true;
                } else if (tabuleiro[linha][coluna] == 'a') {
                    tabuleiro[linha][coluna] = 'o';
                    System.out.println(nome + " errou um tiro em (" + (linha + 1) + ", " + (coluna + 1) + ")");
                    acaoRealizada = true;
                }
            }

            if (acaoRealizada) {
                imprimirTabuleiro();
            }

            try {
                Thread.sleep(100); // Aguarda um tempo antes da próxima tentativa
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            filaMensagens.enviar(mensagem); // Permite que o próximo jogador jogue
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
