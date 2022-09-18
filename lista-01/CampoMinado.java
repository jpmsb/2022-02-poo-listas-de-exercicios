import java.util.Random;

public class CampoMinado {
    public static void main(String[] args) {
        int tamanho = 9;
        int quantidadeDeMinas = 10;
        String minas = ",";

        Random numeroAleatorio = new Random();
        for (int i = 0; i < quantidadeDeMinas; i++) {
            minas += numeroAleatorio.nextInt(80) + ",";
        }

        int contador = 0;

        // Criando a matriz
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                if (minas.matches(".*," + contador + ",.*")){
                    System.out.print("* " );
                } else System.out.print(". ");
                contador++;
                
            }
            System.out.print("\n");
        }
    }
}
