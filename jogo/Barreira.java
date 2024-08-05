package jogo;

import java.util.concurrent.atomic.AtomicInteger;

//Solução Barreira
public class Barreira {
    private final int numThreads; // Número de threads que devem alcançar a barreira antes que elas possam prosseguir
    private final AtomicInteger count = new AtomicInteger(0); // Contador para rastrear quantas threads alcançaram a barreira
    private final AtomicInteger release = new AtomicInteger(0); // Contador para rastrear quantas threads foram liberadas da barreira

    //Construtor
    public Barreira(int numThreads) {
        this.numThreads = numThreads;
    }

    // Método que cada thread deve chamar para aguardar na barreira
    public synchronized void await(String nome) {
        // Incrementa o contador de threads que chegaram à barreira
        count.incrementAndGet();
        // Enquanto o número de threads que chegaram à barreira for menor que o número necessário, a thread espera
        while (count.get() < numThreads) {
            try {
                wait(); // A thread aguarda até ser notificada
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Incrementa o contador de threads liberadas
        release.incrementAndGet();
        // Notifica todas as threads esperando na barreira para prosseguir
        notifyAll();
        // Imprime uma mensagem indicando que a thread foi liberada da barreira
        System.out.println(nome + " liberou a barreira.");
    }
}
