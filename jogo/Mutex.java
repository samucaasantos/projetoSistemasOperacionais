package jogo;

//Solução mutex
public class Mutex {
    private boolean locked = false;

    // Método que bloqueia o mutex, aguardando se já estiver bloqueado
    public synchronized void lock() {
        while (locked) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        locked = true;
    }

    // Método que libera o mutex e notifica uma thread bloqueada
    public synchronized void unlock() {
        locked = false;
        notify();
    }
}
