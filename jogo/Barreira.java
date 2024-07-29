package jogo;

public class Barreira {
    private final int totalThreads;
    private int waitingThreads = 0;

    public Barreira(int totalThreads) {
        this.totalThreads = totalThreads;
    }

    public synchronized void await() {
        waitingThreads++;
        if (waitingThreads < totalThreads) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            waitingThreads = 0;
            notifyAll();
        }
    }
}
