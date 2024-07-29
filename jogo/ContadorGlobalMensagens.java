package jogo;

public class ContadorGlobalMensagens {
    private int naviosRestantes;

    public ContadorGlobalMensagens(int naviosRestantes) {
        this.naviosRestantes = naviosRestantes;
    }

    public synchronized int getNaviosRestantes() {
        return naviosRestantes;
    }

    public synchronized void decrementar() {
        naviosRestantes--;
    }
}
