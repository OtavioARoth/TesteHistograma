/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.somadorvetorparalelo;

import java.util.function.Supplier;

/**
 *
 * @author William
 */
public class BenchMark {

    public static long mediaTempo(int iteracoes, Supplier<Object> metodo) {
        long tempoTotal = 0;

        for (int i = 0; i < iteracoes; i++) {
            long inicio = System.currentTimeMillis();
            metodo.get();
            long fim = System.currentTimeMillis();

            tempoTotal += (fim - inicio);
        }
        return tempoTotal;
    }

    public static double speedUP(long tempoSequencial, long tempoParalelo) {
        return ((double) tempoSequencial / tempoParalelo);
    }
    
    public static double eficiencia(double speedUP, int numeroThreads){
        return (speedUP / numeroThreads) * 100;
    }

}
