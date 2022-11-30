package engtelecom.poo.Veiculos;

public class Panther extends Veiculo implements Conversivel, TracaoIntegral, VeiculoAnfibio {
    private final int VELOCIDADE_MAXIMA = 140;
    private final int TEMPERATURA_MINIMA = -15;
    private final int TEMPERATURA_MAXIMA = 15;
    private boolean tracaoIntegralAtivada;
    private boolean capotaAberta;
    private boolean rodasRecolhidas;
    private boolean lastroVazio;
    private int temperatura;

    public Panther(String nome) {
        super(nome);
        this.tracaoIntegralAtivada = false;
        this.capotaAberta = false;
        this.rodasRecolhidas = false;
        this.lastroVazio = false;
        this.temperatura = TEMPERATURA_MAXIMA;
    }
    
    public boolean setTempRefri(int t){
        if ((t >= TEMPERATURA_MINIMA) && (t <= TEMPERATURA_MAXIMA)) {
            this.temperatura = t;
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
    public boolean esvaziarLastro() {
        if (! lastroVazio){
            this.lastroVazio = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean recolherRodas() {
        if ((! rodasRecolhidas) && (velocidadeAtual == 0)){
            this.rodasRecolhidas = true;
            esvaziarLastro();
            return true;
        }
        return false;
    }

    @Override
    public boolean abrirRodas() {
        if (rodasRecolhidas){
            this.rodasRecolhidas = false;
            this.lastroVazio = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean ativarDesativarTracao() {
        if ((velocidadeAtual == 0) && (! rodasRecolhidas)){
            this.tracaoIntegralAtivada = ! this.tracaoIntegralAtivada;
            return true;
        }
        return false;
    }

    @Override
    public boolean abrirCapota() {
        if ((! capotaAberta) && (velocidadeAtual == 0)){
            this.capotaAberta = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean fecharCapota() {
        if ((capotaAberta) && (velocidadeAtual == 0)){
            this.capotaAberta = false;
            return true;
        }
        return false;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public boolean isLastroVazio() {
        return lastroVazio;
    }    
}