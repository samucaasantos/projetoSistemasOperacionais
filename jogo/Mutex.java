package jogo;

//Solução mutex
public class Mutex {
    private boolean locked = false;

    public synchronized void lock() {
        System.out.println(Thread.currentThread().getName() + " tentando acessar (lock).");
        while (locked) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        locked = true;
        System.out.println(Thread.currentThread().getName() + " conseguiu acessar (lock).");
    }

    public synchronized void unlock() {
        locked = false;
        System.out.println(Thread.currentThread().getName() + " liberou o acesso (unlock).");
        notify();
    }
}
