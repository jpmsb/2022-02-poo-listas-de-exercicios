package engtelecom.poo.Veiculos;

public abstract class Veiculo {
    protected final int VELOCIDADE_MAXIMA = 200;
    protected String nome;
    protected int velocidadeAtual;


    public Veiculo(String nome) {
        this.nome = nome;
        this.velocidadeAtual = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getVelocidadeAtual() {
        return velocidadeAtual;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setVelocidadeAtual(int velocidadeAtual) {
        this.velocidadeAtual = velocidadeAtual;
    }

}