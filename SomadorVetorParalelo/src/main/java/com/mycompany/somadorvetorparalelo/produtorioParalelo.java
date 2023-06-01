/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.somadorvetorparalelo;

import java.math.BigInteger;
import java.util.concurrent.Callable;

/**
 *
 * @author William
 */
public class produtorioParalelo implements Callable<BigInteger> {

    private int[] vetor;
    private int inicioVetor;
    private int fimVetor;

    public produtorioParalelo(int[] vetor, int inicioVetor, int fimVetor) {
        this.vetor = vetor;
        this.inicioVetor = inicioVetor;
        this.fimVetor = fimVetor;
    }

    @Override
    public BigInteger call() throws Exception {
        BigInteger produtorioParcial = BigInteger.ONE;
        for (int i = inicioVetor; i < fimVetor; i++) {
            if (vetor[i] != 0) {
                produtorioParcial = produtorioParcial.multiply(BigInteger.valueOf(vetor[i]));
            }
        }
        return produtorioParcial;
    }

}
