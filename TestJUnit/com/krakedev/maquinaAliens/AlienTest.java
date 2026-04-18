package com.krakedev.maquinaAliens;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AlienTest {

	@Test
	void testCrearAlienNormal() {
		Alien alien = new Alien(10, "verde");
		assertEquals(10, alien.getTamanio());
		assertEquals("verde", alien.getColor());
		assertEquals(2.0, alien.getPrecioCuerpo(), 0.001);
		assertEquals(1.0, alien.getPrecioExtremidad(), 0.001);
		assertEquals(0.5, alien.getPrecioOjo(), 0.001);
	}

	@Test
	void testTamanioMenorAlMinimo() {
		Alien alien = new Alien(3, "rojo");
		assertEquals(5, alien.getTamanio());
		assertEquals(1.0, alien.getPrecioCuerpo(), 0.001);
		assertEquals(0.5, alien.getPrecioExtremidad(), 0.001);
		assertEquals(0.25, alien.getPrecioOjo(), 0.001);
	}

	@Test
	void testTamanioMayorAlMaximo() {
		Alien alien = new Alien(40, "azul");
		assertEquals(30, alien.getTamanio());
		assertEquals(6.0, alien.getPrecioCuerpo(), 0.001);
		assertEquals(3.0, alien.getPrecioExtremidad(), 0.001);
		assertEquals(1.5, alien.getPrecioOjo(), 0.001);
	}
}