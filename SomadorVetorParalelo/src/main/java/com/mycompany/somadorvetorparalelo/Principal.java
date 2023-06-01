/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.somadorvetorparalelo;

import java.text.DecimalFormat;

/**
 *
 * @author William
 */
public class Principal {

    public static void main(String[] args) {
  

        VetorMatematico vetor = new VetorMatematico(200000, Processador.getNucleos());
        DecimalFormat numeroFormatado = new DecimalFormat("#.##");


        Long mediaParalela = BenchMark.mediaTempo(10, vetor::produtorioParalelo);
        System.out.println("Media de tempo Paralelo: " + mediaParalela);


    }
}
