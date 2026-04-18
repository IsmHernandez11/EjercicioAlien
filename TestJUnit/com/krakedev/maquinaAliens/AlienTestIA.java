package com.krakedev.maquinaAliens;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AlienTestIA {

	@Test
	void testCreacionAlienConTamanioValido() {

		// Se crea un alien con tamaño dentro del rango permitido
		Alien alien = new Alien(15, "morado");

		// Se verifica que los atributos se asignen correctamente
		assertEquals(15, alien.getTamanio());
		assertEquals("morado", alien.getColor());

		// Valores iniciales de partes del alien
		assertEquals(0, alien.getNumeroOjos());
		assertEquals(0, alien.getNumeroBrazos());
		assertEquals(0, alien.getNumeroPiernas());
	}

	@Test
	void testRestriccionTamanioMinimo() {

		// Se crea un alien con tamaño menor al mínimo permitido
		Alien alien = new Alien(2, "verde");

		// El constructor debe ajustar automáticamente el tamaño a 5
		assertEquals(5, alien.getTamanio());

		// Verificar que los precios se calculen usando el tamaño ajustado
		assertEquals(1.0, alien.getPrecioCuerpo(), 0.001);
		assertEquals(0.5, alien.getPrecioExtremidad(), 0.001);
		assertEquals(0.25, alien.getPrecioOjo(), 0.001);
	}

	@Test
	void testRestriccionTamanioMaximo() {

		// Se crea un alien con tamaño mayor al permitido
		Alien alien = new Alien(40, "azul");

		// El tamaño debe ajustarse automáticamente al máximo permitido
		assertEquals(30, alien.getTamanio());

		// Verificación del cálculo de precios con el tamaño máximo
		assertEquals(6.0, alien.getPrecioCuerpo(), 0.001);
		assertEquals(3.0, alien.getPrecioExtremidad(), 0.001);
		assertEquals(1.5, alien.getPrecioOjo(), 0.001);
	}

	@Test
	void testCalculoPrecios() {

		// Se crea un alien con tamaño válido para comprobar los cálculos
		Alien alien = new Alien(20, "negro");

		// Precio cuerpo = 20% del tamaño
		assertEquals(4.0, alien.getPrecioCuerpo(), 0.001);

		// Precio extremidad = 10% del tamaño
		assertEquals(2.0, alien.getPrecioExtremidad(), 0.001);

		// Precio ojo = 5% del tamaño
		assertEquals(1.0, alien.getPrecioOjo(), 0.001);
	}
	
	@Test
	void testPrecioTotalInicialDebeSerCero() {
		// Se crea un alien nuevo sin agregar brazos, piernas ni ojos
		Alien alien = new Alien(10, "verde");

		// El precio total debe iniciar en 0
		assertEquals(0.0, alien.getPrecioTotal(), 0.001);
	}

	@Test
	void testAgregarBrazosDebeActualizarCantidadYPrecioTotal() {
		// Tamaño 10:
		// precio cuerpo = 2.0
		// precio extremidad = 1.0
		Alien alien = new Alien(10, "azul");

		// Se agregan 2 brazos
		boolean resultado = alien.agregarBrazos(2);

		// Debe permitir la operación y actualizar valores
		assertTrue(resultado);
		assertEquals(2, alien.getNumeroBrazos());
		assertEquals(0, alien.getNumeroPiernas());
		assertEquals(0, alien.getNumeroOjos());

		// precio total = cuerpo + (2 extremidades * 1.0) = 2.0 + 2.0 = 4.0
		assertEquals(4.0, alien.getPrecioTotal(), 0.001);
	}

	@Test
	void testAgregarPiernasDebeActualizarCantidadYPrecioTotal() {
		// Tamaño 10:
		// precio cuerpo = 2.0
		// precio extremidad = 1.0
		Alien alien = new Alien(10, "rojo");

		// Se agregan 3 piernas
		boolean resultado = alien.agregarPiernas(3);

		// Debe permitir la operación
		assertTrue(resultado);
		assertEquals(0, alien.getNumeroBrazos());
		assertEquals(3, alien.getNumeroPiernas());

		// precio total = 2.0 + (3 * 1.0) = 5.0
		assertEquals(5.0, alien.getPrecioTotal(), 0.001);
	}

	@Test
	void testAgregarOjosDebeActualizarCantidadYPrecioTotal() {
		// Tamaño 10:
		// máximo de ojos = 3
		// precio cuerpo = 2.0
		// precio ojo = 0.5
		Alien alien = new Alien(10, "morado");

		// Se agregan 3 ojos
		boolean resultado = alien.agregarOjos(3);

		// Debe permitir la operación
		assertTrue(resultado);
		assertEquals(3, alien.getNumeroOjos());

		// precio total = 2.0 + (3 * 0.5) = 3.5
		assertEquals(3.5, alien.getPrecioTotal(), 0.001);
	}

	@Test
	void testAgregarBrazosYPiernasDebeRespetarLimiteDeDiezExtremidades() {
		// Se crea un alien y se agregan extremidades de forma combinada
		Alien alien = new Alien(10, "gris");

		boolean resultado1 = alien.agregarBrazos(4);
		boolean resultado2 = alien.agregarPiernas(6);

		// 4 + 6 = 10, por lo tanto sí debe permitir
		assertTrue(resultado1);
		assertTrue(resultado2);
		assertEquals(4, alien.getNumeroBrazos());
		assertEquals(6, alien.getNumeroPiernas());

		// precio total = 2.0 + (10 * 1.0) = 12.0
		assertEquals(12.0, alien.getPrecioTotal(), 0.001);
	}

	@Test
	void testNoDebeAgregarExtremidadesSiSuperaElLimite() {
		// Se agregan brazos primero y luego se intenta exceder el máximo
		Alien alien = new Alien(10, "amarillo");

		boolean resultado1 = alien.agregarBrazos(6);
		boolean resultado2 = alien.agregarPiernas(5);

		// La primera operación sí debe funcionar
		assertTrue(resultado1);

		// La segunda no debe permitirse porque 6 + 5 = 11
		assertFalse(resultado2);

		// Solo deben mantenerse los 6 brazos
		assertEquals(6, alien.getNumeroBrazos());
		assertEquals(0, alien.getNumeroPiernas());

		// precio total = 2.0 + (6 * 1.0) = 8.0
		assertEquals(8.0, alien.getPrecioTotal(), 0.001);
	}

	@Test
	void testNoDebeAgregarOjosSiSuperaElMaximoPermitido() {
		// Para tamaño 10, el máximo de ojos es 3
		Alien alien = new Alien(10, "negro");

		// Se intenta agregar 4 ojos
		boolean resultado = alien.agregarOjos(4);

		// No debe permitir la operación
		assertFalse(resultado);
		assertEquals(0, alien.getNumeroOjos());

		// Como no se agregó nada, el precio total sigue en 0
		assertEquals(0.0, alien.getPrecioTotal(), 0.001);
	}

	@Test
	void testDebeCalcularPrecioTotalConBrazosPiernasYOjos() {
		// Tamaño 10:
		// cuerpo = 2.0
		// extremidad = 1.0
		// ojo = 0.5
		Alien alien = new Alien(10, "celeste");

		boolean resultado1 = alien.agregarBrazos(2);
		boolean resultado2 = alien.agregarPiernas(2);
		boolean resultado3 = alien.agregarOjos(3);

		// Todas las operaciones deben ser válidas
		assertTrue(resultado1);
		assertTrue(resultado2);
		assertTrue(resultado3);

		// Verificar cantidades
		assertEquals(2, alien.getNumeroBrazos());
		assertEquals(2, alien.getNumeroPiernas());
		assertEquals(3, alien.getNumeroOjos());

		// precio total = cuerpo + extremidades + ojos
		// = 2.0 + (4 * 1.0) + (3 * 0.5)
		// = 2.0 + 4.0 + 1.5 = 7.5
		assertEquals(7.5, alien.getPrecioTotal(), 0.001);
	}

	@Test
	void testDebePermitirLimiteExactoDeOjosSegunTamanio() {
		// Para tamaño 20, el máximo permitido es 5 ojos
		Alien alien = new Alien(20, "verde");

		boolean resultado = alien.agregarOjos(5);

		// Debe aceptar exactamente el límite
		assertTrue(resultado);
		assertEquals(5, alien.getNumeroOjos());

		// precio cuerpo = 4.0
		// precio ojo = 1.0
		// precio total = 4.0 + (5 * 1.0) = 9.0
		assertEquals(9.0, alien.getPrecioTotal(), 0.001);
	}

	@Test
	void testDebePermitirLimiteExactoDeExtremidades() {
		// Se prueba el valor exacto permitido de extremidades
		Alien alien = new Alien(15, "naranja");

		boolean resultado = alien.agregarPiernas(10);

		// Debe permitir exactamente 10 extremidades
		assertTrue(resultado);
		assertEquals(10, alien.getNumeroPiernas());
		assertEquals(0, alien.getNumeroBrazos());

		// precio cuerpo = 3.0
		// precio extremidad = 1.5
		// precio total = 3.0 + (10 * 1.5) = 18.0
		assertEquals(18.0, alien.getPrecioTotal(), 0.001);
	}
}