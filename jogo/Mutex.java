package jogo;

//Solução mutex
public class Mutex {
    private boolean locked = false;  // Indica se o mutex está atualmente bloqueado

    public synchronized void lock(String nome) {
        // Enquanto o mutex estiver bloqueado, a thread espera
        while (locked) {
            try {
                // Imprime uma mensagem indicando que a thread está tentando acessar o recurso protegido
                System.out.println(nome + " tentando acessar o tabuleiro.");
                wait(); // A thread aguarda até ser notificada
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Bloqueia o mutex
        locked = true;
        // Imprime uma mensagem indicando que a thread conseguiu acessar o recurso protegido
        System.out.println(nome + " conseguiu acessar o tabuleiro.");
    }

    // Método para liberar o bloqueio do mutex
    public synchronized void unlock(String nome) {
        // Desbloqueia o mutex
        locked = false;
        // Imprime uma mensagem indicando que a thread liberou o recurso protegido
        System.out.println(nome + " liberou o tabuleiro.");
        // Notifica uma das threads esperando para que ela possa prosseguir
        notify();
    }
}