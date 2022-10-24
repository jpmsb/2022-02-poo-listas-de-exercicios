package engtelecom.poo;

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
    private int posicaoPlanoExploracao;

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
        this.coordenadaAtualX = coordenadaAtualX;
        this.coordenadaAtualY = coordenadaAtualY;
        this.coordenadaAnteriorX = this.coordenadaAtualX;
        this.coordenadaAnteriorY = this.coordenadaAtualY;
        this.direcao = direcao;
        this.movimentosMaximos = movimentosMaximos;
        this.unidadesPorMovimento = unidadesPorMovimento;
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
     * Define a coordenada X atual do robô
     * @param coordenadas inteiro com a coordenada X do robô
     */
    public void setCoordenadaAtualX(int coordenada) {
        this.coordenadaAtualX = coordenada;
    }

    /**
     * Define a coordenada Y atual do robô
     * @param coordenadas inteiro com a coordenada Y do robô
     */
    public void setCoordenadaAtualY(int coordenada) {
        this.coordenadaAtualY = coordenada;
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
        this.direcao = direcao;
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
        return unidadesPorMovimento;
    }

    /**
     * Define a quantidade de unidades que um robô pode realizar a cada movimento
     * @param unidadesPorMovimento quantidade de unidades que serão realizadas por movimento
     */
    public void setUnidadesPorMovimento(int unidadesPorMovimento) {
        this.unidadesPorMovimento = unidadesPorMovimento;
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
        return false;
    }
    
    /**
     * Gira o robô em torno do seu próprio eixo para o próximo sentido à esquerda
     * @return string contendo o nome da nova direção
     */
    public String girarParaEsquerda(){
        return this.direcao;
    }

    /**
     * Gira o robô em torno do seu próprio eixo para o próximo sentido à direita
     * @return string contendo o nome da nova direção
     */
    public String girarParaDireita(){
        return this.direcao;
    }

    /**
     * Carrega um plano de exploração
     * @return verdadeiro caso o carregamento seja bem sucedido e falso, caso contrário.
     */
    public boolean carregarPlano(String plano){
        return false;
    }

    /**
     * Executa o próximo comando do plano de exploração
     * @return verdadeiro caso a execução seja possível e falso, caso contrário.
     */
    public boolean executarPlano(){
        return false;
    }


}
