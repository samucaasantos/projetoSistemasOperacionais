package jogo;

import java.util.LinkedList;
import java.util.Queue;

//Solução troca de mensagem
public class FilaMensagens {
    private final Queue<String> fila = new LinkedList<>(); //Fila de mensagens usada para sincronização entre threads.

    // Envia uma mensagem para a fila
    public synchronized void enviar(String mensagem) {
        fila.add(mensagem);
        notify();
    }

    // Recebe uma mensagem da fila
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
