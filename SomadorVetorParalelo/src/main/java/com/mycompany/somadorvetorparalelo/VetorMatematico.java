/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.somadorvetorparalelo;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author William
 */
public class VetorMatematico {

    private int[] vetor;
    private int tamanhoBloco;
    private int numThreads;

    private long soma;
    private BigInteger produto;
    private long media;

    public VetorMatematico(int tam, int numThreads) {
        this.vetor = new int[tam];
        this.soma = 0;
        this.produto = BigInteger.ONE;
        this.inicializarVetor();
        this.tamanhoBloco = (tam / numThreads);
        this.numThreads = numThreads;
    }

    private void inicializarVetor() {
        for (int i = 0; i < this.vetor.length; i++) {
            this.vetor[i] = i;
        }
    }

    public long somatorioVetor() {
        this.soma = 0;
        for (int i = 0; i < this.vetor.length; i++) {
            this.soma += vetor[i];
        }
        return this.soma;
    }

    public long somatorioVetorParalelo() {
        this.soma = 0;
        ExecutorService executor = Executors.newCachedThreadPool();

        /*
        Future<Integer> Future1 = executor.submit(tarefa1);
        Future<Integer> Future2 = executor.submit(tarefa2);
        Future<Integer> Future3 = executor.submit(tarefa3);
        Future<Integer> Future4 = executor.submit(tarefa4);
         */
        LinkedList<Future<Integer>> future = new LinkedList<>();

        for (int i = 0; i < this.numThreads; i++) {
            int inicioVetor = (this.tamanhoBloco * i);
            int fimVetor = (this.tamanhoBloco * (i + 1));

            if(i == (numThreads - 1)){
                fimVetor = vetor.length;
            }
            future.add(executor.submit(new somatorioParalelo(vetor, inicioVetor, fimVetor)));
        }

        executor.shutdown();

        try {
            for (int i = 0; i < future.size(); i++) {
                this.soma += future.get(i).get();
            }

        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }
        return this.soma;
    }

    public BigInteger produtorio() {
        this.produto = BigInteger.ONE;
        for (int i = 0; i < this.vetor.length; i++) {
            if (vetor[i] != 0) {
                this.produto = produto.multiply(BigInteger.valueOf(vetor[i]));
            }

        }
        return this.produto;
    }

    public BigInteger produtorioParalelo() {
        this.produto = BigInteger.ONE;
        
        ExecutorService executor = Executors.newCachedThreadPool();
        
        LinkedList<Future<BigInteger>> future = new LinkedList<>();
        
        for(int i = 0; i < numThreads; i++){
            int inicioVetor = (this.tamanhoBloco * i);
            int fimVetor = (this.tamanhoBloco * (i + 1));
            
            if(i == numThreads - 1){
                fimVetor = vetor.length;
            }
            
            future.add(executor.submit(new produtorioParalelo(vetor, inicioVetor, fimVetor)));
        }
        
        executor.shutdown();


        for(int i = 0; i < future.size(); i++){
            try {
                this.produto = this.produto.multiply(future.get(i).get());
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(VetorMatematico.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return this.produto;
    }

    Callable<Integer> tarefa1 = () -> {
        int somaParcial = 0;
        for (int i = 0; i < 25; i++) {
            somaParcial += vetor[i];
        }
        return somaParcial;
    };

    Callable<Integer> tarefa2 = () -> {
        int somaParcial = 0;
        for (int i = 25; i < 50; i++) {
            somaParcial += vetor[i];
        }
        return somaParcial;
    };

    Callable<Integer> tarefa3 = () -> {
        int somaParcial = 0;
        for (int i = 50; i < 75; i++) {
            somaParcial += vetor[i];
        }
        return somaParcial;
    };

    Callable<Integer> tarefa4 = () -> {
        int somaParcial = 0;
        for (int i = 75; i < 100; i++) {
            somaParcial += vetor[i];
        }
        return somaParcial;
    };

    public long getSoma() {
        return soma;
    }

    public BigInteger getProduto() {
        return produto;
    }
    
    

}
