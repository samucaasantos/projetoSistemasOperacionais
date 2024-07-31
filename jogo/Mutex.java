package jogo;

//Solução mutex
public class Mutex {
    private boolean locked = false;

    public synchronized void lock(String nome) {
        while (locked) {
            try {
                System.out.println(nome + " tentando acessar o tabuleiro.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        locked = true;
        System.out.println(nome + " conseguiu acessar o tabuleiro.");
    }

    public synchronized void unlock(String nome) {
        locked = false;
        System.out.println(nome + " liberou o tabuleiro.");
        notify();
    }
}