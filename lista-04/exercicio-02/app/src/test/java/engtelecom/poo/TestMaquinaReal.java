package engtelecom.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestMaquinaReal {
    @Test
    // Testa a criação de uma máquina virtual
    public void criarMaquinaVirtual(){
        MaquinaReal m = new MaquinaReal("MR1", 20000, 400);

        // Testa a criação no caso bem sucedido
        assertTrue(m.criaMV("MV1", 8000, 200));

        // Testa a criação de uma máquina virtual com o mesmo nome de uma já criada
        assertFalse(m.criaMV("MV1", 2000, 100));

        // Testa a criação que exceda a capacidade de armazenamento
        assertFalse(m.criaMV("MV2", 8000, 300));

        // Testa a criação que exceda a capacidade de memória RAM
        assertFalse(m.criaMV("MV3", 15000, 100));

        // Testa a criação que deixa o uso de memória RAM no limite
        assertTrue(m.criaMV("MV4", 12000, 100));

        // Testa a criação que deixa o uso de armazenamento no limite
        MaquinaReal m2 = new MaquinaReal("MR2", 16000, 400);
        assertTrue(m2.criaMV("MV5", 4000, 200));
        assertTrue(m2.criaMV("MV6", 8000, 200));

        // Testa a criação de máquinas virtuais até atingir a quantidade limite
        MaquinaReal m3 = new MaquinaReal("MR3", 16000, 400);
    
        assertTrue(m3.criaMV("MV1", 1000, 10));
        assertTrue(m3.criaMV("MV2", 1000, 10));
        assertTrue(m3.criaMV("MV3", 1000, 10));
        assertTrue(m3.criaMV("MV4", 1000, 10));
        assertTrue(m3.criaMV("MV5", 1000, 10));
        assertFalse(m3.criaMV("MV6", 1000, 10));

        // Testa se uma máquina virtual realmente foi criada
        assertInstanceOf(MaquinaVirtual.class, m3.obtem("MV1"));
    }

    @Test
    // Testa a exclusão de máquinas virtuais
    public void excluirMaquinasVirtuais(){
        MaquinaReal m = new MaquinaReal("MR1", 20000, 400);

        m.criaMV("MV1", 8000, 200);
        m.criaMV("MV2", 8000, 100);

        // Testa uma exclusão válida
        assertTrue(m.excluiMV("MV1"));

        // Testa a exclusão de uma máquina virtual inexistente
        // Nesse caso, testando com a mesma máquina que foi excluída
        // anteriormente, também já valida se a máquina virtual
        // anterior realmente foi removida
        assertFalse(m.excluiMV("MV1"));
    }

    @Test
    // Testa a operação que liga uma máquina virtual
    public void ligaMV(){
        MaquinaReal m = new MaquinaReal("MR1", 20000, 400);

        m.criaMV("MV1", 8000, 200);

        // Testa uma ação válida
        assertEquals("MV1 está ligada!", m.liga("MV1"));

        // Testa ligar uma máquina virtual inexistente
        assertEquals("MV2 não existe!", m.liga("MV2"));

        // Testa ligar uma máquina virtual já ligada
        assertEquals("MV1 está ligada!", m.liga("MV1"));


    }

    @Test
    // Testa a operação que desliga uma máquina virtual
    public void desligaMV(){
        MaquinaReal m = new MaquinaReal("MR1", 20000, 400);

        m.criaMV("MV1", 8000, 200);

        // Testa uma ação válida
        assertEquals("MV1 está desligada!", m.desliga("MV1"));

        // Testa desligar uma máquina virtual inexistente
        assertEquals("MV2 não existe!", m.desliga("MV2"));

        // Testa desligar uma máquina virtual já desligada
        assertEquals("MV1 está desligada!", m.desliga("MV1"));


    }
}
