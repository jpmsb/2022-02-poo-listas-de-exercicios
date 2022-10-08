package engtelecom.poo;

import java.awt.Color;

import edu.princeton.cs.algs4.Draw;

public class Principal {
    private static Draw desenho;

    public Principal(){
        this.desenho = new Draw();
        // definindo a área de desenho -- https://introcs.cs.princeton.edu/java/stdlib/javadoc/Draw.html
        this.desenho.setCanvasSize(600,600);

        // definindo a escala da área de desenho -- leia mais na documentação da classe
        this.desenho.setXscale(0, 600);

        this.desenho.setYscale(0, 600);
    }

    public static void main(String[] args) {
        Principal p = new Principal();

        Relogio r = new Relogio(800, 900, 14, "Brasília");
        r.desenhar(Principal.desenho, 7, 30, 15);
    }
}
