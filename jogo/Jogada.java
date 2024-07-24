package jogo;

import java.util.Scanner;

public class Jogada {
    Scanner input = new Scanner(System.in);

    /* Os inteiros "linha" e "coluna" vão servir para pegarem o total de linhas e colunas do tabuleiro,
    * eles vão pegar essas informações da classe "BatalhaNaval" */

    int linha;
    int coluna;

    // o método "jogar()" vai ser usado para cada jogada do usuário
    public void jogar(char tabuleiro[][]) {
        int navio = 5, contador = 0 ;

        //o while mantém o usuário jogando enquanto ainda tem navios escondidos
        while (navio > 0) {
            contador++;
            int jogadalinha = linha + 1, jogadacoluna = coluna + 1;

            /* os dois "while" abaixo vão servir para o usuário digitar em qual linha e coluna ele quer
            * atacar, o while é necessário para não deixar o usuário selecionar um lugar que não está no
            * tabuleiro */
            while (jogadalinha >= linha || jogadalinha < 0) {
                System.out.println("Faça sua jogada \nEscolha a posição da linha: ");
                jogadalinha = input.nextInt() - 1;
                if (jogadalinha >= linha) {
                    System.out.println("Posição inválida");
                    System.out.println();
                }
            }

            while (jogadacoluna >= coluna || jogadacoluna < 0) {
                System.out.println("Escolha a posição da coluna: ");
                jogadacoluna = input.nextInt() - 1;
                if (jogadacoluna >= coluna) {
                    System.out.println("Posição inválida");
                    System.out.println();
                }
            }

            /* A partir daqui são só os comandos necessários para escrever o tabuleiro de novo,
            * então as posições não foram jogadas ficam com "~", as posições que o usuaário atacou e
            * errou ficam com "O" e as posições que ele acertou com "X" */
            if (tabuleiro[jogadalinha][jogadacoluna] == 'n') {
                tabuleiro[jogadalinha][jogadacoluna] = 'x';
                for (int contl = 0; contl < linha; contl++) {
                    for (int contc = 0; contc < coluna; contc++) {
                        if (tabuleiro[contl][contc] == 'x') {
                            System.out.print("X  ");
                        }
                        else if (tabuleiro[contl][contc] == 'o') {
                            System.out.print("O  ");
                        }
                        else {
                            System.out.print("~  ");
                        }
                    }
                    System.out.println();
                }
                System.out.println();
                System.out.println("Você acertou!");
                System.out.println();
                System.out.println();
                navio--;
            }
            else if (tabuleiro[jogadalinha][jogadacoluna] == 'a') {
                tabuleiro[jogadalinha][jogadacoluna] = 'o';
                for (int contl = 0; contl < linha; contl++) {
                    for (int contc = 0; contc < coluna; contc++) {
                        if (tabuleiro[contl][contc] == 'o') {
                            System.out.print("O  ");
                        }
                        else if (tabuleiro[contl][contc] == 'x') {
                            System.out.print("X  ");
                        }
                        else {
                            System.out.print("~ ");
                        }
                    }
                    System.out.println();
                }
                System.out.println();
                System.out.println("Você errou!");
                System.out.println();
                System.out.println();
            }
            else {
                System.out.println();
                System.out.println("Essa posição já foi atacada");
                System.out.println();
            }
        }
        //O contador é usado para informar em quantas tentativas o jogador terminou o jogo
        System.out.println("Parabéns");
        System.out.println("Você venceu com " + contador + " tentativas!");
    }
}
