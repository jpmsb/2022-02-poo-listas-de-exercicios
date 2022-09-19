import java.util.Scanner;

public class LeitorDeMatriz {
    public static boolean acima(int posicaoAtual, int tamanhoDaMatriz, String[] caracteres){
        return caracteres[posicaoAtual - tamanhoDaMatriz].equals("*");
    }

    public static boolean abaixo(int posicaoAtual, int tamanhoDaMatriz, String[] caracteres){
        return caracteres[posicaoAtual + tamanhoDaMatriz].equals("*");
    }

    public static boolean aEsquerda(int posicaoAtual, int tamanhoDaMatriz, String[] caracteres){
        return caracteres[posicaoAtual - 1].equals("*");
    }

    public static boolean aDireita(int posicaoAtual, int tamanhoDaMatriz, String[] caracteres){
        return caracteres[posicaoAtual + 1].equals("*");
    }

    public static boolean diagonalCimaEsquerda(int posicaoAtual, int tamanhoDaMatriz, String[] caracteres){
        return caracteres[posicaoAtual - (tamanhoDaMatriz + 1)].equals("*");
    }

    public static boolean diagonalCimaDireita(int posicaoAtual, int tamanhoDaMatriz, String[] caracteres){
        return caracteres[posicaoAtual - (tamanhoDaMatriz - 1)].equals("*");
    }

    public static boolean diagonalBaixoEsquerda(int posicaoAtual, int tamanhoDaMatriz, String[] caracteres){
        return caracteres[posicaoAtual + (tamanhoDaMatriz - 1)].equals("*");
    }

    public static boolean diagonalBaixoDireita(int posicaoAtual, int tamanhoDaMatriz, String[] caracteres){
        return caracteres[posicaoAtual + (tamanhoDaMatriz + 1)].equals("*");
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        entrada.useDelimiter(" ");

        int tamanhoDaMatriz = 9;
        int posicao = 0;
        String[] caracteres = new String[(tamanhoDaMatriz*tamanhoDaMatriz) + 1];

        // Lendo caractere por caractere e
        // armazenando-os em um vetor de Strings
        while (entrada.hasNextLine()){
            String caractere = entrada.next();

            // Removendo as quebras de linha
            if (caractere.contains("\n")){ 
                caractere = caractere.replace("\n", "");
                
            }
            caracteres[posicao] = caractere;
            posicao++;

        }

        // Processando e classificando os caracteres lidos
        // Legenda:
        // CSD - canto superior direito 
        // CSE - canto superior esquerdo (primeira posição)
        // CID - canto inferior direito (última posição)
        // CIE - canto inferior esquerdo
        posicao = 0;
        while (posicao < tamanhoDaMatriz*tamanhoDaMatriz){ // CSE - não pular linha
            int quantidadeDeMinas = 0;
            if (posicao == 0){
                if (caracteres[posicao].equals("*")){
                    System.out.print(caracteres[posicao] + " ");

                } else {
                    if (aDireita(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;
                    if (abaixo(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;
                    if (diagonalBaixoDireita(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;

                    if (quantidadeDeMinas == 0) System.out.print(caracteres[posicao] + " ");
                    else System.out.print(quantidadeDeMinas + " ");
                }
            } else if (posicao == (tamanhoDaMatriz - 1)) { // CSD - pular linha
                if (caracteres[posicao].equals("*")){
                    System.out.println(caracteres[posicao] + " ");

                } else {
                    if (aEsquerda(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;
                    if (abaixo(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;
                    if (diagonalBaixoEsquerda(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;

                    if (quantidadeDeMinas == 0) System.out.println(caracteres[posicao] + " ");
                    else System.out.println(quantidadeDeMinas + " ");

                }

            } else if (posicao == (tamanhoDaMatriz * (tamanhoDaMatriz - 1))){ // CIE - não pular linha
                if (caracteres[posicao].equals("*")){
                    System.out.print(caracteres[posicao] + " ");

                } else {
                    if (aDireita(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;
                    if (acima(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;
                    if (diagonalCimaDireita(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;

                    if (quantidadeDeMinas == 0) System.out.print(caracteres[posicao] + " ");
                    else System.out.print(quantidadeDeMinas + " ");
                }

            } else if (posicao == (tamanhoDaMatriz * tamanhoDaMatriz) - 1){ // CID - pular linha
                if (caracteres[posicao].equals("*")){
                    System.out.println(caracteres[posicao] + " ");

                } else {
                    if (aEsquerda(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;
                    if (acima(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;
                    if (diagonalCimaEsquerda(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;

                    if (quantidadeDeMinas == 0) System.out.println(caracteres[posicao] + " ");
                    else System.out.println(quantidadeDeMinas + " ");
                }

            } else if (posicao < tamanhoDaMatriz) { // Borda superior - não pular linha
                if (caracteres[posicao].equals("*")){
                    System.out.print(caracteres[posicao] + " ");

                } else {
                    if (aDireita(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;
                    if (aEsquerda(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;
                    if (abaixo(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;
                    if (diagonalBaixoEsquerda(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;
                    if (diagonalBaixoDireita(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;

                    if (quantidadeDeMinas == 0) System.out.print(caracteres[posicao] + " ");
                    else System.out.print(quantidadeDeMinas + " ");
                }

            } else if (posicao > (tamanhoDaMatriz * (tamanhoDaMatriz - 1))) { // Borda inferior - não pular linha
                if (caracteres[posicao].equals("*")){
                    System.out.print(caracteres[posicao] + " ");
                } else {
                    if (aDireita(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;
                    if (aEsquerda(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;
                    if (acima(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;
                    if (diagonalCimaEsquerda(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;
                    if (diagonalCimaDireita(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;

                    if (quantidadeDeMinas == 0) System.out.print(caracteres[posicao] + " ");
                    else System.out.print(quantidadeDeMinas + " ");

                }

            } else if (((posicao + 1) % tamanhoDaMatriz) == 0){ // Borda direita - pular linha
                if (caracteres[posicao].equals("*")){
                    System.out.println(caracteres[posicao] + " ");

                } else {
                    if (aEsquerda(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;
                    if (abaixo(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;
                    if (acima(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;
                    if (diagonalCimaEsquerda(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;
                    if (diagonalBaixoEsquerda(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;

                    if (quantidadeDeMinas == 0) System.out.println(caracteres[posicao] + " ");
                    else System.out.println(quantidadeDeMinas + " ");
                }

            } else if ((posicao % tamanhoDaMatriz) == 0 && (posicao != (tamanhoDaMatriz * tamanhoDaMatriz))) { // Borda esquerda - não pular linha
                if (caracteres[posicao].equals("*")){
                    System.out.print(caracteres[posicao] + " ");

                } else {
                    if (aDireita(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;
                    if (abaixo(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;
                    if (acima(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;
                    if (diagonalCimaDireita(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;
                    if (diagonalBaixoDireita(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;

                    if (quantidadeDeMinas == 0) System.out.print(caracteres[posicao] + " ");
                    else System.out.print(quantidadeDeMinas + " ");
                }

            } else { // Meio da matriz
                if (caracteres[posicao].equals("*")){
                    System.out.print(caracteres[posicao] + " ");
                    
                } else {
                    if (aDireita(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;
                    if (aEsquerda(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;
                    if (abaixo(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;
                    if (acima(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;
                    if (diagonalCimaEsquerda(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;
                    if (diagonalCimaDireita(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;
                    if (diagonalBaixoEsquerda(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;
                    if (diagonalBaixoDireita(posicao, tamanhoDaMatriz, caracteres)) quantidadeDeMinas++;

                    if (quantidadeDeMinas == 0) System.out.print(caracteres[posicao] + " ");
                    else System.out.print(quantidadeDeMinas + " ");
                }
            }
            posicao++;

        }
    }
}
