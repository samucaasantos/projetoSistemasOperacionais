package jogo;

public class ContadorGlobal {
    private int naviosRestantes;

    public ContadorGlobal(int naviosRestantes) {
        this.naviosRestantes = naviosRestantes;
    }

    public synchronized int getNaviosRestantes() {
        return naviosRestantes;
    }

    public synchronized void decrementar() {
        if (naviosRestantes > 0) {
            naviosRestantes--;
        }
    }
}

