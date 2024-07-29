package jogo;

import java.util.LinkedList;
import java.util.Queue;

//Solução troca de mensagem
public class FilaMensagens {
    private final Queue<String> fila = new LinkedList<>();

    public synchronized void enviar(String mensagem) {
        fila.add(mensagem);
        notify();
    }

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
