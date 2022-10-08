package engtelecom.poo;

import edu.princeton.cs.algs4.Draw;

public class Relogio {
    private int coordenadaX;
    private int coordenadaY;
    private String nome;
    private int fuso;

    public Relogio(int x, int y){
        this.coordenadaX = (x >= 0 && x <= 600) ? x : 300;
        this.coordenadaY = (y >= 0 && y <= 600) ? y : 300;
    }

    public Relogio(int x, int y, int fuso, String nome){
        this(x, y);
        this.nome = nome;
        this.fuso = (fuso >= -1 && fuso <= 14) ? fuso : 0;

    }

    public void desenhar(Draw tela, int hora, int minuto, int segundo){
        int horaAjustada = hora + this.fuso;
        if (fuso > -12 && fuso < 12){
            this.fuso = fuso;
        }
    
        int horas = hora + this.fuso; 
        int minutos = minuto; 
        int segundos = segundo;

        double h = Math.toRadians(30 * horas);
        double m = Math.toRadians(6 * minutos); 
        double s = Math.toRadians(6 * segundos);

        double r2 = 40; 
        double r3 = 35;
        double rHoras = 45;
        double r4 = 80; 
        double r5 = 100;

        // Desenha o cículo na tela
        tela.setPenRadius(0.002);
        tela.setPenColor(tela.BLACK);
        tela.circle(this.coordenadaX, this.coordenadaY, 100);

        // Desenha os tracejados que representam os números de 1 a 12
        for (int i = 0; i < 12; i++) {
            double theta = Math.toRadians(30 * i);
            tela.line(this.coordenadaX + r5*Math.sin(theta), this.coordenadaY + r5*Math.cos(theta), this.coordenadaX + r4*Math.sin(theta), this.coordenadaY + r4*Math.cos(theta));
        
        }

        // Ponteido das horas
        tela.setPenColor(tela.BLUE);
        tela.line(this.coordenadaX, this.coordenadaY, this.coordenadaX + rHoras * Math.sin(h), this.coordenadaY + rHoras * Math.cos(h));

        // Ponteiro dos minutos
        tela.setPenColor(tela.BLACK);
        tela.line(this.coordenadaX, this.coordenadaY, this.coordenadaX + r3*2 * Math.sin(m), this.coordenadaY + r3*2 * Math.cos(m));

        // Ponteiro dos segundos
        tela.setPenColor(tela.RED);
        tela.setPenRadius(0.005);
        tela.line(this.coordenadaX, this.coordenadaY, this.coordenadaX + r2*2 * Math.sin(s), this.coordenadaY + r2*2 * Math.cos(s));

        if (this.coordenadaY < 30){
            this.coordenadaY = this.coordenadaY + 25;
        } else {
            this.coordenadaY = this.coordenadaY - 25;
        }

        tela.text(this.coordenadaX, this.coordenadaY - 100, this.nome);
    }

}
