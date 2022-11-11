package engtelecom.poo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestRack {
    @Test
    // Teste que afere se o método adiciona está operando corretamente
    public void adicionarMaquinasReais(){
        Rack r = new Rack();

        assertTrue(r.adiciona("M1", 32768, 1024));

        // Testa adicionar uma máquina real que já existe 
        assertFalse(r.adiciona("M1", 32768, 1024));

        assertTrue(r.adiciona("M2", 32768, 1024));
        assertTrue(r.adiciona("M3", 32768, 1024));
        assertTrue(r.adiciona("M4", 32768, 1024));
        assertTrue(r.adiciona("M5", 32768, 1024));

        // Testa se o limite de máquinas reais permitidas no rack é respeitado
        assertFalse(r.adiciona("M6", 32768, 1024));

        // Testa se uma máquina realmente foi adicionada
        assertInstanceOf(MaquinaReal.class, r.obtem("M1"));
    }

    @Test
    // Teste que afere se o método de remoção está operando corretamente
    public void removerMaquinasReais(){
        Rack r = new Rack();

        r.adiciona("M1", 32768, 1024);
       
        // Testa uma situação válida
        assertTrue(r.remove("M1"));

        // Testa a remoção de um máquina inexistente
        assertFalse(r.remove("M4"));

    }
}
