package com.krakedev.maquinaAliens;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AlienExtremidadesTest {

    @Test
    void testAgregarBrazosValido() {
        Alien alien = new Alien(10, "verde");

        boolean resultado = alien.agregarBrazos(4);

        assertTrue(resultado);
        assertEquals(4, alien.getNumeroBrazos());
        assertEquals(0, alien.getNumeroPies());
    }

    @Test
    void testAgregarPiernasValido() {
        Alien alien = new Alien(10, "azul");

        boolean resultado = alien.agregarPiernas(3);

        assertTrue(resultado);
        assertEquals(0, alien.getNumeroBrazos());
        assertEquals(3, alien.getNumeroPies());
    }

    @Test
    void testLimiteExactoExtremidades() {
        Alien alien = new Alien(10, "rojo");

        boolean resultado = alien.agregarBrazos(10);

        assertTrue(resultado);
        assertEquals(10, alien.getNumeroBrazos());
        assertEquals(0, alien.getNumeroPies());
    }

    @Test
    void testExcesoExtremidadesBrazos() {
        Alien alien = new Alien(10, "gris");

        boolean resultado = alien.agregarBrazos(11);

        assertFalse(resultado);
        assertEquals(0, alien.getNumeroBrazos());
        assertEquals(0, alien.getNumeroPies());
    }

    @Test
    void testExcesoExtremidadesPiernas() {
        Alien alien = new Alien(10, "negro");

        boolean resultado = alien.agregarPiernas(12);

        assertFalse(resultado);
        assertEquals(0, alien.getNumeroBrazos());
        assertEquals(0, alien.getNumeroPies());
    }

    @Test
    void testCasoCombinadoValido() {
        Alien alien = new Alien(10, "morado");

        boolean resultado1 = alien.agregarBrazos(4);
        boolean resultado2 = alien.agregarPiernas(6);

        assertTrue(resultado1);
        assertTrue(resultado2);
        assertEquals(4, alien.getNumeroBrazos());
        assertEquals(6, alien.getNumeroPies());
    }

    @Test
    void testCasoCombinadoExcedeLimite() {
        Alien alien = new Alien(10, "amarillo");

        boolean resultado1 = alien.agregarBrazos(6);
        boolean resultado2 = alien.agregarPiernas(5);

        assertTrue(resultado1);
        assertFalse(resultado2);
        assertEquals(6, alien.getNumeroBrazos());
        assertEquals(0, alien.getNumeroPies());
    }
}