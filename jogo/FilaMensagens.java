package jogo;

import java.util.LinkedList;
import java.util.Queue;

//Solução troca de mensagem
public class FilaMensagens {
    private final Queue<String> fila = new LinkedList<>();

    public synchronized void enviarMensagem(String mensagem, String nome) {
        fila.add(mensagem);
        System.out.println(nome + " enviou mensagem: " + mensagem);
        notifyAll();
    }

    public synchronized String receberMensagem(String nome) {
        while (fila.isEmpty()) {
            try {
                System.out.println(nome + " esperando para receber mensagem.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String mensagem = fila.poll();
        System.out.println(nome + " recebeu mensagem: " + mensagem);
        return mensagem;
    }
}