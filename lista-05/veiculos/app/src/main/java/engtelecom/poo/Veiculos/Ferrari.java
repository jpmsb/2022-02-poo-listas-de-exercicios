package engtelecom.poo.Veiculos;

public class Ferrari extends Veiculo implements Conversivel {
    private boolean capotaAberta;
    private boolean farolNeblinaLigado;
    
    public Ferrari(String nome) {
        super(nome);
        this.capotaAberta = false;
        this.farolNeblinaLigado = false;
    }

    public boolean ligarFarolNeblina(){
        if (! farolNeblinaLigado){
            this.farolNeblinaLigado = true;
            return true;
        }
        return false;
    }

    public boolean desligarFarolNeblina(){
        if (farolNeblinaLigado){
            this.farolNeblinaLigado = false;
            return true;
        }
        return false;
    }

    @Override
    public void frear(int i) {
        if (velocidadeAtual - i <= 0) this.velocidadeAtual = 0;
        else if (i > 0) this.velocidadeAtual -= i;
    }

    @Override
    public void acelerar(int i) {
        if (velocidadeAtual + i > VELOCIDADE_MAXIMA) velocidadeAtual = VELOCIDADE_MAXIMA;
        else if (i > 0) velocidadeAtual += i;
    }

    @Override
    public boolean abrirCapota() {
        if ((! capotaAberta) && (velocidadeAtual < 20)){
            this.capotaAberta = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean fecharCapota() {
        if ((capotaAberta) && (velocidadeAtual < 20)){
            this.capotaAberta = false;
            return true;
        }
        return false;
    }
}