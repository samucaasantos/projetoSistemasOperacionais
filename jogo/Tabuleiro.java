package jogo;

import java.util.Random;
import java.util.Scanner;

//Método usado para criar tabuleiro e também mostrar ele pela primeira vez ao usuário

public class Tabuleiro {
    public static char[][] tabuleiro() {
        Scanner input = new Scanner(System.in);
        Random gerador = new Random();

        int linha = 0, coluna = 0;

        //while serve para que o usuário somente conseguir criar um tabuleiro em que os 6 navios consigam entrar
        while (linha * coluna < 6) {
            System.out.println("Digite o número de linhas do tabuleiro:");
            linha = input.nextInt();
            System.out.println("Digite o número de colunas do tabuleiro:");
            coluna = input.nextInt();
            if (linha * coluna < 6) {
                System.out.println("O tabuleiro precisa ter no mínimo 6 espaços");
                pulaLinha();
            }
        }
        char tab[][] = new char[linha][coluna];
        int linha1 = 0;
        int coluna1 = 0;

        /* O 'for' é usado para gerar os navios em posições aleatórias, se a posição gerada já estiver um navio,
        * ele diminui uma vez o contador e faz uma nova tentativa até ter 5 navios no tabuleiro.'n'
        * significa navios*/
        for (int cont = 0 ; cont < 6; cont++) {
            linha1 = gerador.nextInt(linha);
            coluna1 = gerador.nextInt(coluna);
            if (tab[linha1][coluna1] == 'n') {
                cont--;
            }
            else {
                tab[linha1][coluna1] = 'n';
            }
        }

        //"for" para colocar 'a' que significa água nos espaços vazios
        for (int contl = 0; contl < linha; contl++) {
            for (int contc = 0; contc < coluna; contc++){
                if (tab[contl][contc] != 'n') {
                    tab[contl][contc] = 'a';
                }
            }
        }

        //usado para escrever o tabuleiro pela primeira vez
        for (int contl = 0; contl < linha; contl++) {
            for (int contc = 0; contc < coluna; contc++) {
                System.out.print("~  ");
            }
            pulaLinha();
        }
        return tab;
    }

    /* o método pulalinha() foi criado só para ser uma forma mais rápida de pular as linhas
    * quando essas aparecerem na tela do programa */
    public static void pulaLinha() {
        System.out.println();
    }
}
