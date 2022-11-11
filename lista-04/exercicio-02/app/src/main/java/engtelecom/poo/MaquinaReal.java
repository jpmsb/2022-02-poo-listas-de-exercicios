package engtelecom.poo;

import java.util.HashMap;

public class MaquinaReal {
    private final int MAX_MV = 5;
    private double memoriaRAMMB;
    private double usoDeRAM;
    private double armazenamentoGB;
    private double usoDeArmazenamento;
    private String nome;
    private HashMap<String, MaquinaVirtual> maquinasVirtuais;

    /**
     * Construtor da classe
     * 
     * Cria uma máquina real
     * 
     * @param memoriaRAMMB quantidade de memória RAM em megabytes
     * @param armazenamentoGB quantidade de armazenamento em megabytes
     * @param processadores quantidade de processadores
     * @param nome nome da máquina real
     */
    public MaquinaReal(String nome, double memoriaRAMMB, double armazenamentoGB) {
        this.memoriaRAMMB = memoriaRAMMB;
        this.armazenamentoGB = armazenamentoGB;
        this.nome = nome;
        this.usoDeArmazenamento = 0;
        this.usoDeRAM = 0;
        maquinasVirtuais = new HashMap<>();
    }

    /**
     * Cria uma nova máquina virtual 
     * 
     * @param nome apelido da máquina virtual
     * @param ram quantidade de memória RAM total
     * @param armazenamento quantidade de armazenamento total
     * @return verdadeiro se foi possível criar uma máquina virtual e falso, caso contrário
     */
    public boolean criaMV(String nome, double ram, double armazenamento){
        if ((maquinasCriadas() != MAX_MV) && (maquinasVirtuais.get(nome) == null) && ((this.usoDeRAM + ram) <= this.memoriaRAMMB) && ((this.usoDeArmazenamento + armazenamento) <= this.armazenamentoGB)){
            this.usoDeRAM += ram;
            this.usoDeArmazenamento += armazenamento;
            maquinasVirtuais.put(nome, new MaquinaVirtual(nome, ram, armazenamento));
            return true;
        }
        return false;
    }

    /**
     * Remove uma máquina virtual e libera os recursos por ela consumidos
     * 
     * @param nome apelido da máquina virtual
     * @return verdadeiro se possível remover a máquina virtual e falso, caso contrário
     */
    public boolean excluiMV(String nome){
        if (maquinasVirtuais.get(nome) != null){
            this.usoDeRAM -= obtem(nome).getMemoriaRAMMB();
            this.usoDeArmazenamento -= obtem(nome).getArmazenamentoGB();
            maquinasVirtuais.remove(nome);
            return true;
        }
        return false;
    }

    /**
     * Liga uma máquina virtual, definindo o seu estado para "true"
     * @param nome apelido da máquina virtual que sofrerá a ação
     * @return string contendo o resultado a ação
     */
    public String liga(String nome){
        if (maquinasVirtuais.get(nome) != null){
            obtem(nome).liga();;
            return nome + " está ligada!";
        }
        return nome + " não existe!";
    }

    /**
     * Desliga uma máquina virtual, definindo o seu estado para "false"
     * @param nome apelido da máquina virtual que sofrerá a ação
     * @return string contendo o resultado a ação
     */
    public String desliga(String nome){
        if (maquinasVirtuais.get(nome) != null){
            obtem(nome).desliga();;
            return nome + " está desligada!";
        }
        return nome + " não existe!";
    }

    /**
     * Obtém o acesso a uma máquina virtual
     * @param nome apelido da máquina virtual
     * @return objeto do tipo MaquinaVirtual
     */
    public MaquinaVirtual obtem(String nome){
        return maquinasVirtuais.get(nome);
    }

    /**
     * Obtém a quantidade de máquinas armazenadas no rack
     * @return inteiro que representa a quantidade de máquinas armazenadas
     */
    public int maquinasCriadas(){
        return maquinasVirtuais.size();
    }

    /**
     * Obtém o nome da máquina real
     * @return string contendo o nome da máquina real
     */
    public String getNome() {
        return nome;
    }

    
}
