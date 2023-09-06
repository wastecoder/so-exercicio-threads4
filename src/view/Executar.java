package view;

import controller.ThreadSapo;

public class Executar {
    public static void main(String[] args) {
        Thread[] sapos = new Thread[5];
        int DISTANCIA_MAXIMA_DO_PULO = 4;

        for (int i = 0; i < sapos.length; i++) {
            sapos[i] = new ThreadSapo(DISTANCIA_MAXIMA_DO_PULO);
        }

        for (Thread sapo : sapos) {
            sapo.start();
        }
    }
}
