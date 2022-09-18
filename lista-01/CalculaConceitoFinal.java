import java.lang.Math;

public class CalculaConceitoFinal {
    public static void main(String[] args){
        int projeto1 = Integer.parseInt(args[0]);
        int projeto2 = Integer.parseInt(args[1]);
        int lista1 = Integer.parseInt(args[2]);
        int lista2 = Integer.parseInt(args[3]);
        int lista3 = Integer.parseInt(args[4]);
        int lista4 = Integer.parseInt(args[5]);
        int lista5 = Integer.parseInt(args[6]);

        int[] listas = {lista1,lista2,lista3,lista4,lista5};
        double pesoProjetos = (((projeto1 * 2) + (projeto2 * 4))/6) * 0.9;

        int produtorioListas = 1;

        for (int nota : listas){
            produtorioListas *= nota;
        }

        double pesoListas = Math.pow(produtorioListas, ((double) 1/5)) * 0.1;

        double conceitoFinal = Math.floor(pesoProjetos) + Math.ceil(pesoListas - 0.0000001);

        if (conceitoFinal >= 6) {
            System.out.println(conceitoFinal + ", APROVADO");

        } else System.out.println(conceitoFinal + ", REPROVADO");

    }
}