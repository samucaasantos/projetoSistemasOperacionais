package jogo;

public class BatalhaNaval {
    public static void main(String[] args) {
        //chamada do método jogada
        Jogada play = new Jogada();

        System.out.println("Batalha Naval!");
        System.out.println();
        System.out.println("Esse é o BATALHA NAVAL, o jogo onde você deve acertar os navios inimigos que estão escondidos no tabuleiro");
        System.out.println("O tabuleiro contém 5 navios de tamanho 1x1");
        System.out.println("Primeiro você deve definir o tamnho do tabuleiro (mínimo 2x3 ou 3x2)");

        /* o tabuleiro.tabuleiro() vai ser usado para gerar o tabuleiro do tamanho que o usuário quiser
        com os navios sendo gerados de forma aleatória */
        char tab[][] = Tabuleiro.tabuleiro();
        int nlinha = tab.length;
        int ncoluna = tab[0].length;

        /* o método "jogada" é usado aqui, passando o número de linhas e colunas para o método
        * "jogada" e também executando o mesmo com o "jogar()" , assim repetindo jogadas até
        * terminar a partida */
        play.linha = nlinha;
        play.coluna = ncoluna;
        play.jogar(tab);

    }
}
