package jogo;

//solução semáforo
public class Semaforo {
    private int valor;

    // Construtor que inicializa o valor do semáforo
    public Semaforo(int valorInicial) {
        this.valor = valorInicial;
    }

    // Método que decrementa o valor do semáforo, bloqueando se o valor for menor ou igual a zero
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

    // Método que incrementa o valor do semáforo e notifica uma thread bloqueada
    public synchronized void v() {
        valor++;
        notify();
    }
}

