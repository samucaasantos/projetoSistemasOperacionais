package jogo;

//solução semáforo
public class Semaforo {
    private int valor;

    public Semaforo(int valor) {
        this.valor = valor;
    }

    public synchronized void p(String nome) {
        while (valor <= 0) {
            try {
                System.out.println(nome + " tentando acessar o tabuleiro.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        valor--;
        System.out.println(nome + " conseguiu acessar o tabuleiro.");
    }

    public synchronized void v(String nome) {
        valor++;
        System.out.println(nome + " liberou o tabuleiro.");
        notifyAll();
    }
}
