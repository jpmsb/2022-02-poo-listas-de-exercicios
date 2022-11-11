package engtelecom.poo;

import java.util.HashMap;

public class Rack {
    private final int MAX_SERVIDORES = 5;
    private HashMap<String, MaquinaReal> maquinasReais;

    /**
     * Construtor da classe
     * 
     * Cria um rack
     */
    public Rack() {
        maquinasReais = new HashMap<>();
    }

    /**
     * Adiciona uma máquina real ao rack
     * 
     * @param nome apelido da máquina real
     * @param processador quantidade de processadores
     * @param ram quantidade de memória RAM em megabytes
     * @param armazenamento quantidade de armazenamento em gigabytes
     * @return verdadeiro se fooi possível adicionar e falso, caso contrário.
     */
    public boolean adiciona(String nome, double ram, double armazenamento){
        if ((! estaCheio()) && (maquinasReais.get(nome) == null)){
            maquinasReais.put(nome, new MaquinaReal(nome, ram, armazenamento));
            return true;
        }
        return false;
    }

    /**
     * Remove uma máquina real do rack
     * @param nome apelido da máquina a ser removida
     * @return verdadeiro se fooi possível remover e falso, caso contrário.
     */
    public boolean remove(String nome){
        if (maquinasReais.get(nome) != null){
            maquinasReais.remove(nome);
            return true;
        }
        return false;
    }

    /**
     * Dá acesso a uma máquina real especificada pelo nome
     * @param nome apelido da máquina real a ser recebida
     * @return objeto MaquinaReal
     */
    public MaquinaReal obtem(String nome){
        return maquinasReais.get(nome);
    }

    /**
     * Obtém a quantidade de máquinas armazenadas no rack
     * @return inteiro que representa a quantidade de máquinas armazenadas
     */
    public int compartimentosEmUso(){
        return maquinasReais.size();
    }

    /**
     * Verifica se o rack está cheio
     * @return verdadeiro caso o rack está na lotação máxima e falso, caso contrário.
     */
    public boolean estaCheio(){
        if (compartimentosEmUso() == MAX_SERVIDORES) return true;
        else return false;
    }
}
