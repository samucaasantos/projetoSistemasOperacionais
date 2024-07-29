package jogo;


public class BatalhaNavalBarreira {
    public static void main(String[] args) {
        System.out.println("Batalha Naval!");
        System.out.println();
        System.out.println("Esse é o BATALHA NAVAL, o jogo onde você deve acertar os navios inimigos que estão escondidos no tabuleiro...");
        System.out.println("O tabuleiro contém 5 navios de tamanho 1x1");
        System.out.println("Primeiro você deve definir o tamanho do tabuleiro (mínimo 2x3 ou 3x2)");

        // Gera o tabuleiro do tamanho que o usuário quiser
        char tab[][] = Tabuleiro.tabuleiro();
        int nlinha = tab.length;
        int ncoluna = tab[0].length;

        // Cria a barreira para sincronização
        Barreira barreira = new Barreira(2);

        // Contador global de navios
        ContadorGlobalMensagens contadorGlobal = new ContadorGlobalMensagens(8);

        // Cria duas threads representando os jogadores
        JogadorBarreira jogador1 = new JogadorBarreira("Jogador 1", tab, barreira, contadorGlobal);
        JogadorBarreira jogador2 = new JogadorBarreira("Jogador 2", tab, barreira, contadorGlobal);

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
