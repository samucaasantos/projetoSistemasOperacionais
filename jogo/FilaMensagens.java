package jogo;

import java.util.LinkedList;
import java.util.Queue;

//Solução troca de mensagem
public class FilaMensagens {
    // Fila para armazenar as mensagens
    private final Queue<String> fila = new LinkedList<>();

    // Método para enviar uma mensagem para a fila
    public synchronized void enviarMensagem(String mensagem, String nome) {
        // Adiciona a mensagem à fila
        fila.add(mensagem);
        // Imprime uma mensagem indicando que a mensagem foi enviada
        System.out.println(nome + " enviou mensagem: " + mensagem);
        // Notifica todas as threads esperando para que elas possam tentar receber a mensagem
        notifyAll();
    }

    // Método para receber uma mensagem da fila
    public synchronized String receberMensagem(String nome) {
        // Enquanto a fila estiver vazia, a thread espera
        while (fila.isEmpty()) {
            try {
                // Imprime uma mensagem indicando que a thread está esperando para receber uma mensagem
                System.out.println(nome + " esperando para receber mensagem.");
                // A thread aguarda até ser notificada
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Remove e retorna a mensagem do início da fila
        String mensagem = fila.poll();
        // Imprime uma mensagem indicando que a thread recebeu a mensagem
        System.out.println(nome + " recebeu mensagem: " + mensagem);
        return mensagem;
    }
}