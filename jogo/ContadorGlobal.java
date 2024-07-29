package jogo;

//contador de navios restantes
public class ContadorGlobal {
    private int naviosRestantes;

    //construtor que inicializa o contador
    public ContadorGlobal(int naviosRestantes) {
        this.naviosRestantes = naviosRestantes;
    }

    //retorna os navios restantes de forma sincronizada
    public synchronized int getNaviosRestantes() {
        return naviosRestantes;
    }

    //decrementa o contador de navios restantes de forma sincronizada
    public synchronized void decrementar() {
        if (naviosRestantes > 0) {
            naviosRestantes--;
        }
    }
}

