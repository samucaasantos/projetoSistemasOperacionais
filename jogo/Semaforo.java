package jogo;

//solução semáforo
public class Semaforo {
    private int contador;

    public Semaforo(int contadorInicial) {
        this.contador = contadorInicial;
    }

    public synchronized void p() {
        System.out.println(Thread.currentThread().getName() + " tentando acessar (P).");
        while (contador == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        contador--;
        System.out.println(Thread.currentThread().getName() + " conseguiu acessar (P).");
    }

    public synchronized void v() {
        contador++;
        System.out.println(Thread.currentThread().getName() + " liberou o acesso (V).");
        notify();
    }
}
