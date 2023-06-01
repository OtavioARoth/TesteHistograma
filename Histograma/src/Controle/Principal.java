package Controle;
import java.awt.image.BufferedImage;

import Fronteira.Janela;
import Fronteira.Leitura;


public class Principal {
    public static void main(String[] args) throws Exception {
       
        BufferedImage bf = Leitura.leitor("C:\\Users\\willi\\OneDrive\\Área de Trabalho\\aviao.jpg");
       bf = Filtro.escalaCinza(bf);
       Janela janela = new Janela(bf);
       janela.exibir();
    }
}
