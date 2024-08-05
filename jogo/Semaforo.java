package jogo;

//solução semáforo
public class Semaforo {
    private int valor; // Contador do semáforo que controla o acesso aos recursos

    // Construtor
    public Semaforo(int valor) {
        this.valor = valor;
    }

    // Método 'p' para adquirir o semáforo
    public synchronized void p(String nome) {
        // Enquanto o valor do semáforo for menor ou igual a zero, a thread espera
        while (valor <= 0) {
            try {
                // Imprime uma mensagem indicando que a thread está tentando acessar o recurso protegido
                System.out.println(nome + " tentando acessar o tabuleiro.");
                wait(); // A thread aguarda até ser notificada
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Decrementa o valor do semáforo para sinalizar que o recurso foi adquirido
        valor--;
        // Imprime uma mensagem indicando que a thread conseguiu acessar o recurso protegido
        System.out.println(nome + " conseguiu acessar o tabuleiro.");
    }

    // Método 'v' para liberar o semáforo
    public synchronized void v(String nome) {
        // Incrementa o valor do semáforo para sinalizar que o recurso foi liberado
        valor++;
        // Imprime uma mensagem indicando que a thread liberou o recurso protegido
        System.out.println(nome + " liberou o tabuleiro.");
        // Notifica todas as threads esperando para que elas possam tentar adquirir o semáforo novamente
        notifyAll();
    }
}
