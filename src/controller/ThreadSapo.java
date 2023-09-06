package controller;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSapo extends Thread {
    private static AtomicInteger colocacao = new AtomicInteger(1);
    private final int distanciaMaximaPulo;
    private final int id = (int) threadId();

    public ThreadSapo(int distanciaMaximaPulo) {
        this.distanciaMaximaPulo = distanciaMaximaPulo;
    }

    @Override
    public void run() {
        int distanciaPulada; //distanciaPulada |==> de 0 a distanciaMaximaPulo
        int distanciaPercorrida = 0;

        int TAMANHO_PERCURSO = 10;
        while (distanciaPercorrida < TAMANHO_PERCURSO) {
            distanciaPulada = (int) (Math.random() * (distanciaMaximaPulo + 1));
            distanciaPercorrida += distanciaPulada;
            mostrarProgresso(distanciaPulada, distanciaPercorrida);
        }

        mostarResultado();
    }

    public void mostrarProgresso(int distanciaPulada, int distanciaPercorrida) {
        System.out.println("#" + id + " >>> pulou: " + distanciaPulada + "m; Percorreu " + distanciaPercorrida + "m");
    }

    public void mostarResultado() {
        int colocacaoAtual = colocacao.getAndIncrement(); //colocacao++;
        System.out.println("#" + id + " >>> terminou na posição " + colocacaoAtual);
    }
}
