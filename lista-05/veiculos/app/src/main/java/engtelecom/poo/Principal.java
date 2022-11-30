package engtelecom.poo;

import java.util.ArrayList;

import engtelecom.poo.Veiculos.Conversivel;
import engtelecom.poo.Veiculos.Ferrari;
import engtelecom.poo.Veiculos.Pampa;
import engtelecom.poo.Veiculos.Panther;
import engtelecom.poo.Veiculos.TracaoIntegral;
import engtelecom.poo.Veiculos.Veiculo;
import engtelecom.poo.Veiculos.VeiculoAnfibio;
import engtelecom.poo.Veiculos.VeiculoMarinho;
import engtelecom.poo.Veiculos.VeiculoTerrestre;

public class Principal {
    private static ArrayList<Veiculo> veiculos = new ArrayList<>();

    public static void main(String[] args) {
        Veiculo ferrari = new Ferrari("Ferrari");
        Veiculo pampa = new Pampa("Pampa");
        Veiculo panther = new Panther("Panther");

        veiculos.add(ferrari);
        veiculos.add(pampa);
        veiculos.add(panther);

        // Usando polimorfismo nas instruções abaixo
        if (((Conversivel)ferrari).abrirCapota()) System.out.println("Capota aberta com sucesso!");
        if (((VeiculoMarinho)panther).esvaziarLastro()) System.out.println("Lastro esvaziado com sucesso!");
        if (((VeiculoAnfibio)panther).recolherRodas()) System.out.println("Rodas recolhidas com sucesso!");
        if (((TracaoIntegral)pampa).ativarDesativarTracao()) System.out.println("Ativando/desativando tração no pampa");


        ((VeiculoTerrestre)ferrari).acelerar(20);
        ((VeiculoTerrestre)pampa).acelerar(50);
        ((VeiculoTerrestre)panther).acelerar(40);

        ((Conversivel)ferrari).frear(10);
        ((TracaoIntegral)pampa).frear(20);
        ((TracaoIntegral)panther).frear(10);
    }
}
