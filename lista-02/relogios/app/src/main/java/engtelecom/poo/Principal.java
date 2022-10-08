package engtelecom.poo;

import java.awt.Color;

import edu.princeton.cs.algs4.Draw;

public class Principal {
    private static Draw desenho;
    private static Relogio[] relogios = new Relogio[3];

    public Principal(){
        this.desenho = new Draw();
        // definindo a área de desenho -- https://introcs.cs.princeton.edu/java/stdlib/javadoc/Draw.html
        this.desenho.setCanvasSize(600,600);

        // definindo a escala da área de desenho -- leia mais na documentação da classe
        this.desenho.setXscale(0, 600);

        this.desenho.setYscale(0, 600);
    }


    public static boolean adicionarRelogio(Relogio relogio){
        for (int j = 0; j < relogios.length; j++){
            if (relogios[j] == null) {
                relogios[j] = relogio;
                return true;
            }
        }

        return false;
    }

    public static void desenharRelogios(){
        for (Relogio relogio : relogios) {
            relogio.desenhar(desenho, 7, 45, 15);
        }

    }

    public static void main(String[] args) {
        Principal p = new Principal();

        Relogio r = new Relogio(150, 450, -1, "Brasília");
        adicionarRelogio(r);

        Relogio r2 = new Relogio(450, 450, 9, "Japão");
        adicionarRelogio(r2);

        Relogio r3 = new Relogio(150, 150, 1, "Inglaterra");
        adicionarRelogio(r3);

        desenharRelogios();
    }
}
