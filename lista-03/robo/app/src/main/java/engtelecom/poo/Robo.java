package engtelecom.poo;

import java.util.Random;

import org.checkerframework.framework.qual.Unused;

public class Robo {
    /**
     * Identificador único do robô
     */
    private String identificador;

    /**
     * Área em que o robô poderá movimentar-se
     */
    private int area;

    /**
     * Coordenada X atual do robô
     */
    private int coordenadaAtualX;

    /**
     * Coordenada X atual do robô
     */
    private int coordenadaAtualY;

    /**
     * Coordenada X anterior do robô
     */
    private int coordenadaAnteriorX;

    /**
     * Coordenada Y anterior do robô
     */
    private int coordenadaAnteriorY;

    /**
     * Valor máximo da coordenada X
     */
    private int coordenadaXMaxima;

    /**
     * Valor máximo da coordenada Y
     */
    private int coordenadaYMaxima;

    /**
     * Direção para onde o robô estará apontando
     */
    private String direcao;

    /**
     * Quantidade máxima de movimentos permitidos até acabar a bateria
     */
    private int movimentosMaximos;

    /**
     * Quantidade restante de movimentos permitidos até acabar a bateria
     */
    private int movimentosRestantes;

    /**
     * Quantidade de unidades que fará quando movimentar-se
     */
    private int unidadesPorMovimento;

    /**
     * Posição atual do plano de exploração
     */
    private int posicaoPlanoExploracao = 0;

    /**
     * Sequência de caracteres indicando o plano de exploração
     */
    private String planoDeExploracao[];

    /**
     * Quantidade máxima total que um robô poderá fazer
     */
    private static final int LIMITE_DE_MOVIMENTOS = 100;

    /**
     * Vertor com todas as direções possíveis
     */
    private String direcoes[] = {"Norte", "Leste", "Sul", "Oeste"};

    /**
     * Contém a posição que será usada no vetor de direções
     */
    private int posicaoDirecao;

    /**
     * A direção Norte
     */
    private static final String NORTE = "Norte";

    /**
     * A direção Sul
     */
    private static final String SUL = "Sul";

    /**
     * A direção Leste
     */
    private static final String LESTE = "Leste";

    /**
     * A direção Oeste
     */
    private static final String OESTE = "Oeste";



    /**
     * Construtor da classe
     * 
     * Cria um robô com um identificador único, o tamanho da área de exploração, 
     * 
     * @param identificador string com o nome do robô
     * @param area área na qual o robô poderá movimentar-se
     * @param coordenadas posições x e y iniciais do robô
     * @param direcao direção para onde o mesmo estará apontando (Norte, Sul, Lest, Oeste)
     * @param movimentosMaximos quantidade máxima de movimentos até acabar a bateria
     * @param unidadesPorMovimento quantidade de unidades percorridas a cada movimento
     */
    public Robo(String identificador, int area, int coordenadaAtualX, int coordenadaAtualY, String direcao, int movimentosMaximos, int unidadesPorMovimento) {
        this.identificador = identificador;
        this.area = area;
        this.coordenadaAtualX = setCoordenada(coordenadaAtualX);
        this.coordenadaAtualY = setCoordenada(coordenadaAtualY);
        this.coordenadaAnteriorX = this.coordenadaAtualX;
        this.coordenadaAnteriorY = this.coordenadaAtualY;
        setDirecao(direcao);
        this.movimentosMaximos = movimentosMaximos;
        this.movimentosRestantes = this.movimentosMaximos;
        setUnidadesPorMovimento(unidadesPorMovimento);
        this.coordenadaXMaxima = (int) Math.sqrt(area);
        this.coordenadaYMaxima = this.coordenadaXMaxima;
    }

    /**
     * Obtém o identificador do robô
     * @return string com nome do robô
     */
    public String getIdentificador() {
        return identificador;
    }

    /**
     * Define o identificador único do robô
     * @param identificador string contendo o nome do robô
     */
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    /**
     * Obtém o tamanho da área que o robô pode percorrer
     */
    public int getArea() {
        return area;
    }

    /**
     * Define a área que o robô pode percorrer
     * @param area
     */
    public void setArea(int area) {
        this.area = area;
    }

    /**
     * Obtém a coordenada X atual do robô
     * @return inteiro com a coodenada X atual
     */
    public int getCoordenadaAtualX() {
        return coordenadaAtualX;
    }

    /**
     * Obtém a coordenada Y atual do robô
     * @return inteiro com a coodenada Y atual
     */
    public int getCoordenadaAtualY() {
        return coordenadaAtualY;
    }

    /**
     * Define uma coordenada válida
     * @param coordenada inteiro contendo uma coordenada
     * @return inteiro com uma coordenada dentro da área de exploração
     */
    private int setCoordenada(int coordenada){
        double coordenadaXMax = Math.sqrt(this.area);
        if (coordenada <= coordenadaXMax) return coordenada;
        else {
            Random numeroAleatorio = new Random();
            return numeroAleatorio.nextInt((int)coordenadaXMax);
        }
    }

    /**
     * Obtém a direção para qual o robô está apontando podendo ser Norte, Sul, Leste ou Oeste
     * @return string contendo o nome a direção para qual o robô está apontando
     */
    public String getDirecao() {
        return direcao;
    }

    /**
     * Define a direção para qual o robô apontará
     * @param direcao 
     */
    public void setDirecao(String direcao) {
        this.direcao = NORTE;
        for (int i = 0; i < direcoes.length; i++) {
            if (direcoes[i].equals(direcao)){
                this.direcao = direcao;
                this.posicaoDirecao = i;
                break;
            }
        }
    }

    /**
     * Obtém a quantidade máxima total de movimento que o robô é capaz de fazer até acabar a bateria
     * @return inteiro com a quantidade máxima de movimentos que o robô é capaz de fazer até acabar a bateria.
     */
    public int getMovimentosMaximos() {
        return movimentosMaximos;
    }

    /**
     * Define a quantidade máxima de movimentos que um robô é capaz de fazer até acabar a sua bateria
     * @param movimentosMaximos
     */
    public void setMovimentosMaximos(int movimentosMaximos) {
        this.movimentosMaximos = movimentosMaximos;
    }

    /**
     * Obtém a quantidade de unidades que um robô pode realizar a cada movimento
     * @return inteiro com a quantidade de unidades que serão realizadas por movimento
     */
    public int getUnidadesPorMovimento() {
        return this.unidadesPorMovimento;
    }

    /**
     * Define a quantidade de unidades que um robô pode realizar a cada movimento
     * @param unidadesPorMovimento quantidade de unidades que serão realizadas por movimento
     */
    public void setUnidadesPorMovimento(int unidadesPorMovimento) {
        if (unidadesPorMovimento > LIMITE_DE_MOVIMENTOS) this.unidadesPorMovimento = LIMITE_DE_MOVIMENTOS;
        else this.unidadesPorMovimento = unidadesPorMovimento;
    }
  
    /**
     * Obtém a coordenada da posição X onde o robô estava anteriormente
     * @return inteiro com a coordenada X da posição onde o robô estava anteriormente
     */
    public int getCoordenadaAnteriorX() {
        return this.coordenadaAnteriorX;
    }

    /**
     * Obtém a coordenada da posição Y onde o robô estava anteriormente
     * @return inteiro com a coordenada Y da posição onde o robô estava anteriormente
     */
    public int getCoordenadaAnteriorY() {
        return this.coordenadaAnteriorY;
    }

    /**
     * Obtém a quantidade de movimento que o robô ainda pode fazer até acabar a bateria
     * @return inteiro com a quantidade de movimento que o robô ainda pode fazer até acabar a bateria
     */
    public int getMovimentosRestantes() {
        return movimentosRestantes;
    }

    /**
     * Faz o robô deslocar-se na quantidade de unidades definidas e na direção frontal
     * @return verdadeiro se foi possível realizar o movimento ou falso, caso contrário.
     */
    public boolean deslocar(){
        if (this.movimentosRestantes != 0){
            if (this.direcao.equals(NORTE) && (! (this.coordenadaAtualY + unidadesPorMovimento > this.coordenadaXMaxima))){
                this.coordenadaAnteriorY = this.coordenadaAtualY;
                this.coordenadaAtualY += unidadesPorMovimento;
                this.movimentosRestantes--;
                return true;
            } else if (this.direcao.equals(SUL) && (! (this.coordenadaAtualY - this.unidadesPorMovimento < 0))){
                this.coordenadaAnteriorY = this.coordenadaAtualY;
                this.coordenadaAtualY -= unidadesPorMovimento;
                this.movimentosRestantes--;
                return true;
            } else if (this.direcao.equals(LESTE) && (! (this.coordenadaAtualX + unidadesPorMovimento > this.coordenadaXMaxima))){
                this.coordenadaAnteriorX = this.coordenadaAtualX;
                this.coordenadaAtualX += unidadesPorMovimento;
                this.movimentosRestantes--;
                return true;
            } else if (this.direcao.equals(OESTE) && (! (this.coordenadaAtualX - unidadesPorMovimento < 0))){
                this.coordenadaAnteriorX = this.coordenadaAtualX;
                this.coordenadaAtualX -= unidadesPorMovimento;
                this.movimentosRestantes--;
                return true;
            }
        }
        return false;
    }
    
    /**
     * Gira o robô em torno do seu próprio eixo para o próximo sentido à esquerda
     * @return string contendo o nome da nova direção
     */
    public String girarParaEsquerda(){
        if (this.movimentosRestantes != 0){
            if (this.posicaoDirecao == 0) this.posicaoDirecao = this.direcoes.length - 1;
            else this.posicaoDirecao--;
            this.direcao = this.direcoes[this.posicaoDirecao];
            this.movimentosRestantes--;
        }
        return this.direcao;
    }

    /**
     * Gira o robô em torno do seu próprio eixo para o próximo sentido à direita
     * @return string contendo o nome da nova direção
     */
    public String girarParaDireita(){
        if (this.movimentosRestantes != 0){
            this.posicaoDirecao = (this.posicaoDirecao+1) % direcoes.length;
            this.direcao =this.direcoes[this.posicaoDirecao];
            this.movimentosRestantes--;
        }
        return this.direcao;
    }

    /**
     * Carrega um plano de exploração
     * @return verdadeiro caso o carregamento seja bem sucedido e falso, caso contrário.
     */
    public boolean carregarPlano(String plano){
        this.planoDeExploracao = new String[plano.length()];
        for (int i = 0; i < plano.length(); i++) {
            if (plano.charAt(i) == 'D' | plano.charAt(i) == 'E' | plano.charAt(i) == 'M'){
                planoDeExploracao[i] = String.valueOf(plano.charAt(i));
            } else return false;

        }
        System.out.println(planoDeExploracao.length + " " + plano.length());
        return true;
    }

    /**
     * Executa o próximo comando do plano de exploração
     * @return verdadeiro caso a execução seja possível e falso, caso contrário.
     */
    public boolean executarPlano(){
        if (this.movimentosRestantes != 0 | posicaoPlanoExploracao != planoDeExploracao.length - 1){
            if (planoDeExploracao[posicaoPlanoExploracao].equals("D")){
                posicaoPlanoExploracao++;
                this.girarParaDireita();
                return true;
            } else if (planoDeExploracao[posicaoPlanoExploracao].equals("E")){
                posicaoPlanoExploracao++;
                this.girarParaEsquerda();
                return true;
            } else if (planoDeExploracao[posicaoPlanoExploracao].equals("M")){
                posicaoPlanoExploracao++;
                return this.deslocar();
            }
        }
        return false;
    }

    /**
     * Obtém o plano de exploração que ainda resta ser executado
     * @return string contendo os comandos restantes
     */
    public String planoDeExploracaoRestante(){
        String retorno = "";
        for (int j = posicaoPlanoExploracao; j < planoDeExploracao.length; j++) {
            retorno += planoDeExploracao[j];
        }

        return retorno;
    }
}
