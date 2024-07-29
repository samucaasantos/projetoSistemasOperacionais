package jogo;

//contador de navios restantes para o Batalha Naval com troca de mensagens
public class ContadorGlobalMensagens {
    private int naviosRestantes;

    //construtor que inicializa o contador
    public ContadorGlobalMensagens(int naviosRestantes) {
        this.naviosRestantes = naviosRestantes;
    }

    //retorna os navios restantes de forma sincronizada
    public synchronized int getNaviosRestantes() {
        return naviosRestantes;
    }

    //decrementa o contador de navios restantes de forma sincronizada
    public synchronized void decrementar() {
        naviosRestantes--;
    }
}
