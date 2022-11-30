package engtelecom.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import engtelecom.poo.Veiculos.Panther;

public class TestPanther {
    @Test
    // Testando aceleração do Panther
    public void acelerarPanther(){
        Panther p = new Panther("Panther");

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
    // Testando freio da Panther
    public void frearPanther(){
        Panther p = new Panther("Panther");

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
    // Validando abertura da capota
    public void aberturaDaCapota(){
        // Abrindo nas condições ideais
        Panther p = new Panther("Panther");
        assertTrue(p.abrirCapota());

        // Validando com velocidade acima do permitido
        Panther p2 = new Panther("Panther");
        p2.acelerar(20);
        assertFalse(p2.abrirCapota());

        // Validando abrir uma capota já aberta
        Panther p3 = new Panther("Panther");
        p3.abrirCapota();
        assertFalse(p3.abrirCapota());
    }

    @Test
    // Validando fechamento da capota
    public void fechamentoDaCapota(){
        // Fechando nas condições ideais
        Panther p = new Panther("Panther");
        p.abrirCapota();
        assertTrue(p.fecharCapota());

        // Validando com velocidade acima do permitido
        Panther p2 = new Panther("Panther");
        p2.abrirCapota();
        p2.acelerar(20);
        assertFalse(p2.fecharCapota());

        // Validando fechar uma capota já fechada
        Panther p3 = new Panther("Panther");
        assertFalse(p3.fecharCapota());
    }

    @Test
    // Testando recolhimento das rodas
    public void recolhimentoDasRodas(){
        // Testando em codições ideiais
        Panther p = new Panther("Panther");
        assertTrue(p.recolherRodas());
        assertTrue(p.isLastroVazio());

        // Testando com o veículo em movimento
        Panther p2 = new Panther("Panther");
        p2.acelerar(1);
        assertFalse(p2.recolherRodas());
        assertFalse(p2.isLastroVazio());

        // Validando recolher rodas já recolhidas
        assertFalse(p2.recolherRodas());
    }

    @Test
    // Testando abertura das rodas
    public void aberturaDasRodas(){
        // Testando em codições ideiais
        Panther p = new Panther("Panther");
        p.recolherRodas();
        assertTrue(p.abrirRodas());

        // Testando com o veículo em movimento
        Panther p2 = new Panther("Panther");
        p.recolherRodas();
        p2.acelerar(1);
        assertFalse(p2.abrirRodas());

        // Validando abrir rodas já abertas
        Panther p3 = new Panther("Panther");
        assertFalse(p3.abrirRodas());
    }

    @Test
    // Validando ativação ou desativação da tração integral
    public void ativarDesativarTracao(){
        Panther p = new Panther("Panther");

        // Testando em condições ideais
        assertTrue(p.ativarDesativarTracao());

        // Testando com as rodas recolhidas
        p.recolherRodas();
        assertFalse(p.ativarDesativarTracao());

        // Testando com velocidade acima do permitido
        Panther p2 = new Panther("Panther");
        p2.acelerar(1);
        assertFalse(p2.ativarDesativarTracao());
    }

    @Test
    // Testando definir a temperatura
    public void definirTemperatura(){
        Panther p = new Panther("Panther");
        
        // Testando em condições ideais
        assertTrue(p.setTempRefri(10));

        // Testando acima do limite
        assertFalse(p.setTempRefri(20));

        // Testando abaixo do limite
        assertFalse(p.setTempRefri(-20));
    }
}