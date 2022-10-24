package engtelecom.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class RoboTest {
    @Test
    void criarRobo(){
        Robo r = new Robo("Robô 1", 100, 5, 5, "Norte", 70, 1);

        assertEquals(5, r.getCoordenadaAtualX());
        assertEquals(5, r.getCoordenadaAtualY());
        assertEquals(5, r.getCoordenadaAnteriorX());
        assertEquals(5, r.getCoordenadaAnteriorY());

        Robo r2 = new Robo("Robô 1", 100, 200, 200, "Norte", 70, 1);

        assertNotEquals(200, r2.getCoordenadaAtualX());
        assertNotEquals(200, r2.getCoordenadaAtualY());
        assertNotEquals(200, r2.getCoordenadaAnteriorX());
        assertNotEquals(200, r2.getCoordenadaAnteriorY());
    }

    @Test
    void obterCoordenadasAtuais(){
        Robo r = new Robo("Robô 1", 100, 5, 5, "Norte", 70, 1);

        // Verifica se retorna a coordenada correta dentro da
        // área de exploração
        assertEquals(5, r.getCoordenadaAtualX());
        assertEquals(5, r.getCoordenadaAtualY());

        // Verificando o retorno de um valor inválido. No caso o valor, deve ser
        // aleatório dentro de uma área válida
        Robo r2 = new Robo("Robô 2", 100, 300, 300, "Norte", 70, 1);
        assertNotEquals(300, r2.getCoordenadaAtualX());
        assertNotEquals(300, r2.getCoordenadaAtualY());

    }

    @Test
    void obterCoordenadasAnteriores(){
        Robo r = new Robo("Robô 1", 100, 5, 5, "Norte", 70, 1);

        assertEquals(5, r.getCoordenadaAnteriorX());
        assertEquals(5, r.getCoordenadaAnteriorY());

        // Deslocar na direção Y duas vezes
        r.deslocar();
        r.deslocar();
        assertEquals(5, r.getCoordenadaAnteriorX());
        assertEquals(6, r.getCoordenadaAnteriorY());

        r.girarParaDireita();
        r.deslocar();
        r.deslocar();
        assertEquals(6, r.getCoordenadaAnteriorX());
        assertEquals(6, r.getCoordenadaAnteriorY());
    }

    @Test
    void girarRobo(){
        Robo r = new Robo("Robô 1", 100, 5, 5, "Norte", 70, 1);

        assertEquals("Leste", r.girarParaDireita());
        assertEquals("Sul", r.girarParaDireita());
        assertEquals("Oeste", r.girarParaDireita());
        assertEquals("Norte", r.girarParaDireita());

        assertEquals("Oeste", r.girarParaEsquerda());
        assertEquals("Sul", r.girarParaEsquerda());
        assertEquals("Leste", r.girarParaEsquerda());
        assertEquals("Norte", r.girarParaEsquerda());
    }

    @Test
    void validarDeslocamento(){
        Robo r = new Robo("Robô 1", 100, 5, 5, "Norte", 70, 1);

        assertTrue(r.deslocar());
        assertEquals(6, r.getCoordenadaAtualY());

        r.girarParaDireita();
        assertTrue(r.deslocar());
        assertEquals(6, r.getCoordenadaAtualX());

        r.girarParaDireita();
        assertTrue(r.deslocar());
        assertEquals(5, r.getCoordenadaAtualY());

        r.girarParaEsquerda();
        assertTrue(r.deslocar());
        assertEquals(5, r.getCoordenadaAtualX());
    }

    @Test
    void carregamentoDoPlano(){
        Robo r = new Robo("Robô 1", 100, 5, 5, "Norte", 70, 1);

        assertTrue(r.carregarPlano("MEDMEEMDM"));
        assertFalse(r.carregarPlano("MEDMEEMDMJ"));
    }

    @Test
    void executarProximoComandoPlano(){
        Robo r = new Robo("Robô 1", 100, 5, 5, "Norte", 70, 1);

        r.carregarPlano("MEDME");
        assertTrue(r.executarPlano());
        assertTrue(r.executarPlano());
        assertTrue(r.executarPlano());
        assertTrue(r.executarPlano());
        assertTrue(r.executarPlano());
        assertFalse(r.executarPlano());
    }
}
