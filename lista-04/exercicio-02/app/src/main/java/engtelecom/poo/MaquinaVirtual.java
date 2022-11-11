package engtelecom.poo;

public class MaquinaVirtual {
    private double memoriaRAMMB;
    private double armazenamentoGB;
    private boolean estado;
    private String nome;

    /**
     * Construtor da classe
     * 
     * Cria uma máquina virtual
     * 
     * @param memoriaRAMMB quantidade de memória RAM em megabytes
     * @param armazenamentoGB quantidade de armazenamento total
     * @param nome nome da máquina virtual
     */
    public MaquinaVirtual(String nome, double memoriaRAMMB, double armazenamentoGB) {
        this.memoriaRAMMB = memoriaRAMMB;
        this.armazenamentoGB = armazenamentoGB;
        this.nome = nome;
    }

    /**
     * Obtém a memória RAM total da máquina virtual
     * @return double com o valor de memória RAM total
     */
    public double getMemoriaRAMMB() {
        return memoriaRAMMB;
    }

    /**
     * Obtém a capacidade de armazenamento da máquina virtual
     * @return double com o valor da capacidade de armazenamento
     */
    public double getArmazenamentoGB() {
        return armazenamentoGB;
    }

    /**
     * Obtém o apelido da máquina virtual
     * @return string contendo o apelido da máquina virtual
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o estado para true
     */
    public void liga(){
        this.estado = true;
    }

    /**
     * Define o estado para false
     */
    public void desliga(){
        this.estado = false;
    }

    /**
     * Obtém o estado atual 
     * @return verdadeiro se a máquina virtual está ligada ou falso, caso contrário
     */
    public boolean isEstado() {
        return estado;
    }
    
}
