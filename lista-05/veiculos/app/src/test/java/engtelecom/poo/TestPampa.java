package engtelecom.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import engtelecom.poo.Veiculos.Pampa;

public class TestPampa {
    @Test
    // Testando aceleração do Pamapa
    public void acelerarPampa(){
        Pampa p = new Pampa("Pampa");

        // Acelerando nas condições ideais
        p.acelerar(100);
        assertEquals(100, p.getVelocidadeAtual());

        // Validando se a velocidade for negativa
        p.acelerar(-1);
        assertEquals(100, p.getVelocidadeAtual());

        // Validando se a velocidade máxima é respeitada
        p.acelerar(500);
        assertEquals(140, p.getVelocidadeAtual());
    }

    @Test
    // Testando freio do Pampa
    public void frearPampa(){
        Pampa p = new Pampa("Pampa");

        p.acelerar(120);

        // Freando nas condições ideais
        p.frear(30);
        assertEquals(90, p.getVelocidadeAtual());

        // Validando se a intensidade for negativa
        p.frear(-1);
        assertEquals(90, p.getVelocidadeAtual());

        // Validando intensidade máxima
        p.frear(300);
        assertEquals(0, p.getVelocidadeAtual());
    }

    @Test
    // Validando abertura da caçamba
    public void aberturaDaCacamba(){
        // Abrindo nas condições ideais
        Pampa p = new Pampa("Pampa");
        assertTrue(p.abrirCacamba());

        // Validando com velocidade acima do permitido
        Pampa p2 = new Pampa("Pampa");
        p2.acelerar(20);
        assertFalse(p2.abrirCacamba());

        // Validando abrir uma caçamba já aberta
        Pampa p3 = new Pampa("Pampa");
        p3.abrirCacamba();
        assertFalse(p3.abrirCacamba());
    }

    @Test
    // Validando fechamento da caçamba
    public void fechamentoDaCacamba(){
        // Fechando nas condições ideais
        Pampa p = new Pampa("Pampa");
        p.abrirCacamba();
        assertTrue(p.fecharCacamba());

        // Validando com velocidade acima do permitido
        Pampa p2 = new Pampa("Pampa");
        p2.abrirCacamba();
        p2.acelerar(5);
        assertFalse(p2.fecharCacamba());

        // Validando abrir uma capota já aberta
        Pampa p3 = new Pampa("Pampa");
        assertFalse(p3.fecharCacamba());
    }

    @Test
    // Testando ativação ou desativação da tração integral
    public void tracaoIntegral(){
        Pampa p = new Pampa("Pampa");

        // Validando em condições ideais
        assertTrue(p.ativarDesativarTracao());

        // Validando caso a velocidade seja acima da permitida
        p.acelerar(1);
        assertFalse(p.ativarDesativarTracao());
    }
}
