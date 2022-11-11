package engtelecom.poo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestMaquinaVirtual {
    @Test
    // Testa ligar uma máquina virtual
    public void ligarMaquinaVirtual(){
        MaquinaVirtual m = new MaquinaVirtual("MV1", 1000, 10);

        m.liga();
        assertTrue(m.isEstado());
    }

    @Test
    // Testa ligar uma máquina virtual
    public void desligarMaquinaVirtual(){
        MaquinaVirtual m = new MaquinaVirtual("MV1", 1000, 10);

        m.desliga();
        assertFalse(m.isEstado());
    }
}
