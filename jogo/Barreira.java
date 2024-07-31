package jogo;

import java.util.concurrent.atomic.AtomicInteger;

public class Barreira {
    private final int numThreads;
    private final AtomicInteger count = new AtomicInteger(0);
    private final AtomicInteger release = new AtomicInteger(0);

    public Barreira(int numThreads) {
        this.numThreads = numThreads;
    }

    public synchronized void await(String nome) {
        count.incrementAndGet();
        while (count.get() < numThreads) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        release.incrementAndGet();
        notifyAll();
        System.out.println(nome + " liberou a barreira.");
    }
}
