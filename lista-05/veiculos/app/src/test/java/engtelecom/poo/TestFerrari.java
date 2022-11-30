package engtelecom.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import engtelecom.poo.Veiculos.Ferrari;

public class TestFerrari {
    @Test
    // Testando aceleração da Ferrari
    public void acelerarFerrari(){
        Ferrari f = new Ferrari("Ferrari");

        // Acelerando nas condições ideais
        f.acelerar(100);
        assertEquals(100, f.getVelocidadeAtual());

        // Validando se a velocidade for negativa
        f.acelerar(-1);
        assertEquals(100, f.getVelocidadeAtual());

        // Validando se a velocidade máxima é respeitada
        f.acelerar(500);
        assertEquals(200, f.getVelocidadeAtual());
    }

    @Test
    // Testando freio da Ferrari
    public void frearFerrari(){
        Ferrari f = new Ferrari("Ferrari");

        f.acelerar(150);

        // Freando nas condições ideais
        f.frear(50);
        assertEquals(100, f.getVelocidadeAtual());

        // Validando se a intensidade for negativa
        f.frear(-1);
        assertEquals(100, f.getVelocidadeAtual());

        // Validando intensidade máxima
        f.frear(500);
        assertEquals(0, f.getVelocidadeAtual());
    }

    @Test
    // Validando abertura da capota
    public void aberturaDaCapota(){
        // Abrindo nas condições ideais
        Ferrari f = new Ferrari("Ferrari");
        assertTrue(f.abrirCapota());

        Ferrari f2 = new Ferrari("Ferrari");
        f2.acelerar(19);
        assertTrue(f2.abrirCapota());

        // Validando com velocidade acima do permitido
        Ferrari f3 = new Ferrari("Ferrari");
        f3.acelerar(20);
        assertFalse(f3.abrirCapota());

        // Validando abrir uma capota já aberta
        Ferrari f4 = new Ferrari("Ferrari");
        f4.abrirCapota();
        assertFalse(f4.abrirCapota());
    }

    @Test
    // Validando fechamento da capota
    public void fechamentoDaCapota(){
        // Fechando nas condições ideais
        Ferrari f = new Ferrari("Ferrari");
        f.abrirCapota();
        assertTrue(f.fecharCapota());

        Ferrari f2 = new Ferrari("Ferrari");
        f2.acelerar(19);
        f2.abrirCapota();
        assertTrue(f2.fecharCapota());

        // Validando com velocidade acima do permitido
        Ferrari f3 = new Ferrari("Ferrari");
        f3.abrirCapota();
        f3.acelerar(20);
        assertFalse(f3.fecharCapota());

        // Validando fechar uma capota já fechada
        Ferrari f4 = new Ferrari("Ferrari");
        assertFalse(f4.fecharCapota());
    }

    @Test
    // Validando ligar o farol de neblina
    public void ligarFarol(){
        Ferrari f = new Ferrari("Ferrari");

        // Testando nas condições ideais
        assertTrue(f.ligarFarolNeblina());

        // Validando um farol que já está ligado
        assertFalse(f.ligarFarolNeblina());
    }

    @Test
    // Validando desligar o farol de neblina
    public void desligarFarol(){
        Ferrari f = new Ferrari("Ferrari");

        // Testando nas condições ideais
        f.ligarFarolNeblina();
        assertTrue(f.desligarFarolNeblina());

        // Validando um farol que já está desligado
        assertFalse(f.desligarFarolNeblina());
    }
}