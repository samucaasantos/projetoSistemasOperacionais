package jogo;

import java.util.LinkedList;
import java.util.Queue;

//Solução troca de mensagem
public class FilaMensagens {
    private final Queue<String> fila = new LinkedList<>(); //Fila de mensagens usada para sincronização entre threads.

    // Método que adiciona uma mensagem na fila e notifica uma thread bloqueada
    public synchronized void enviar(String mensagem) {
        fila.add(mensagem);
        notify();
    }

    // Método que retira e retorna uma mensagem da fila, aguardando se a fila estiver vazia
    public synchronized String receber() {
        while (fila.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return fila.poll();
    }
}
