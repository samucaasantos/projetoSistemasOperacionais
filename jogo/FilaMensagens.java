package jogo;

import java.util.LinkedList;
import java.util.Queue;

//Solução troca de mensagem
public class FilaMensagens {
    private Queue<String> fila = new LinkedList<>();

    public synchronized void enviar(String mensagem) {
        System.out.println(Thread.currentThread().getName() + " tentando acessar (enviar).");
        fila.add(mensagem);
        System.out.println(Thread.currentThread().getName() + " conseguiu acessar (enviar). Mensagem enviada: " + mensagem);
        notify();
    }

    public synchronized String receber() {
        System.out.println(Thread.currentThread().getName() + " tentando acessar (receber).");
        while (fila.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String mensagem = fila.poll();
        System.out.println(Thread.currentThread().getName() + " conseguiu acessar (receber). Mensagem recebida: " + mensagem);
        return mensagem;
    }
}
