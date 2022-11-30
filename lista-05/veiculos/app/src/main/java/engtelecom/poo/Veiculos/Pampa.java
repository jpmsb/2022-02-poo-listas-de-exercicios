package engtelecom.poo.Veiculos;

public class Pampa extends Veiculo implements TracaoIntegral {
    private final int VELOCIDADE_MAXIMA = 140;
    private boolean cacambaAberta;
    private boolean tracaoIntegralAtivada;

    public Pampa(String nome) {
        super(nome);
        this.cacambaAberta = false;
        this.tracaoIntegralAtivada = false;
    }

    public boolean abrirCacamba(){
        if ((! cacambaAberta) && (velocidadeAtual == 0)){
            this.cacambaAberta = true;
            return true;
        }
        return false;
    }

    public boolean fecharCacamba(){
        if ((cacambaAberta) && (velocidadeAtual == 0)){
            this.cacambaAberta = false;
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
    public boolean ativarDesativarTracao() {
        if (velocidadeAtual == 0){
            this.tracaoIntegralAtivada = ! this.tracaoIntegralAtivada;
            return true;
        }
        return false;
    }
}