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
        }
    }
}
