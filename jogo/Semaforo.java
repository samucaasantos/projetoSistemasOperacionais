package jogo;

//solução semáforo
public class Semaforo {
    private int valor;

    public Semaforo(int valorInicial) {
        this.valor = valorInicial;
    }

    public synchronized void p() {
        while (valor <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        valor--;
    }

    public synchronized void v() {
        valor++;
        notify();
    }
}

