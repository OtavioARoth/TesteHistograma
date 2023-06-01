/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.somadorvetorparalelo;

import java.util.concurrent.Callable;

/**
 *
 * @author William
 */
public class somatorioParalelo implements Callable<Integer>{
    int vetor[];
    int inicioVetor;
    int fimVetor;

    public somatorioParalelo(int[] vetor, int inicioVetor, int fimVetor) {
        this.vetor = vetor;
        this.inicioVetor = inicioVetor;
        this.fimVetor = fimVetor;
    }
    
    
    
    @Override
    public Integer call() throws Exception {
        int soma = 0;
        
        for(int i = inicioVetor; i < fimVetor; i++){
            soma += this.vetor[i];
        }
        
        return soma;
    }
    
}
