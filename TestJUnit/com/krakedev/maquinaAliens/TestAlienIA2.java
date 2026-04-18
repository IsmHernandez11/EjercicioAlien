package com.krakedev.maquinaAliens;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

public class TestAlienIA2 {

	private static final double DELTA = 0.0001;
	
	//@BeforeEach antes de cada test
	//@AfterEach después de cada metodo.
		
	@Test
	//@Order(#)
	//@DisplayName("titulo")
	
	public void testConstructorDebeAsignarValoresNormalesCorrectamente() {
		// Arrange
		Alien alien = new Alien(10, "Verde");

		// Act
		int tamanio = alien.getTamanio();
		String color = alien.getColor();
		int ojos = alien.getNumeroOjos();
		int brazos = alien.getNumeroBrazos();
		int piernas = alien.getNumeroPiernas();
		double precioCuerpo = alien.getPrecioCuerpo();
		double precioExtremidad = alien.getPrecioExtremidad();
		double precioOjo = alien.getPrecioOjo();
		double precioTotal = alien.getPrecioTotal();

		// Assert
		// Valida que el constructor guarde correctamente los valores iniciales
		assertEquals(10, tamanio);
		assertEquals("Verde", color);
		assertEquals(0, ojos);
		assertEquals(0, brazos);
		assertEquals(0, piernas);
		assertEquals(2.0, precioCuerpo, DELTA);
		assertEquals(1.0, precioExtremidad, DELTA);
		assertEquals(0.5, precioOjo, DELTA);
		assertEquals(0.0, precioTotal, DELTA);
	}

	@Test
	public void testConstructorDebeAjustarTamanioAlMinimoCuandoEsMenorQueCinco() {
		// Arrange
		Alien alien = new Alien(2, "Azul");

		// Act
		int tamanio = alien.getTamanio();

		// Assert
		// Valida el límite inferior permitido para el tamaño
		assertEquals(5, tamanio);
		assertEquals(1.0, alien.getPrecioCuerpo(), DELTA);
		assertEquals(0.5, alien.getPrecioExtremidad(), DELTA);
		assertEquals(0.25, alien.getPrecioOjo(), DELTA);
	}

	@Test
	public void testConstructorDebeAjustarTamanioAlMaximoCuandoEsMayorQueTreinta() {
		// Arrange
		Alien alien = new Alien(40, "Rojo");

		// Act
		int tamanio = alien.getTamanio();

		// Assert
		// Valida el límite superior permitido para el tamaño
		assertEquals(30, tamanio);
		assertEquals(6.0, alien.getPrecioCuerpo(), DELTA);
		assertEquals(3.0, alien.getPrecioExtremidad(), DELTA);
		assertEquals(1.5, alien.getPrecioOjo(), DELTA);
	}

	@Test
	public void testAgregarBrazosDebeRetornarTrueYActualizarCantidadCuandoEsValido() {
		// Arrange
		Alien alien = new Alien(10, "Morado");

		// Act
		boolean resultado = alien.agregarBrazos(4);

		// Assert
		// Valida que se agreguen brazos correctamente cuando no supera el máximo permitido
		assertTrue(resultado);
		assertEquals(4, alien.getNumeroBrazos());
		assertEquals(0, alien.getNumeroPiernas());
		assertEquals(0, alien.getNumeroOjos());
		assertEquals(6.0, alien.getPrecioTotal(), DELTA); // cuerpo 2 + 4 extremidades*1
	}

	@Test
	public void testAgregarPiernasDebeRetornarTrueYActualizarCantidadCuandoEsValido() {
		// Arrange
		Alien alien = new Alien(10, "Gris");

		// Act
		boolean resultado = alien.agregarPiernas(3);

		// Assert
		// Valida que se agreguen piernas correctamente cuando no supera el máximo permitido
		assertTrue(resultado);
		assertEquals(3, alien.getNumeroPiernas());
		assertEquals(0, alien.getNumeroBrazos());
		assertEquals(5.0, alien.getPrecioTotal(), DELTA); // cuerpo 2 + 3 extremidades*1
	}

	@Test
	public void testAgregarBrazosDebeAceptarExactamenteElLimiteDeDiezExtremidades() {
		// Arrange
		Alien alien = new Alien(15, "Negro");
		alien.agregarPiernas(6);

		// Act
		boolean resultado = alien.agregarBrazos(4);

		// Assert
		// Valida el caso límite exacto de 10 extremidades
		assertTrue(resultado);
		assertEquals(6, alien.getNumeroPiernas());
		assertEquals(4, alien.getNumeroBrazos());
		
	}

	@Test
	public void testAgregarPiernasDebeRetornarFalseCuandoSuperaDiezExtremidades() {
		// Arrange
		Alien alien = new Alien(15, "Blanco");
		alien.agregarBrazos(8);

		// Act
		boolean resultado = alien.agregarPiernas(3);

		// Assert
		// Valida que no se agreguen piernas si se supera el máximo de extremidades
		assertFalse(resultado);
		assertEquals(8, alien.getNumeroBrazos());
		assertEquals(0, alien.getNumeroPiernas());
		assertEquals(15.0, alien.getPrecioTotal(), DELTA); // cuerpo 3 + 8 extremidades*1.5
	}

	@Test
	public void testAgregarBrazosDebeRetornarFalseYNoModificarEstadoCuandoSuperaLimite() {
		// Arrange
		Alien alien = new Alien(20, "Celeste");
		alien.agregarPiernas(9);
		double precioAntes = alien.getPrecioTotal();

		// Act
		boolean resultado = alien.agregarBrazos(2);

		// Assert
		// Valida que no haya cambios cuando la acción no puede realizarse
		assertFalse(resultado);
		assertEquals(0, alien.getNumeroBrazos());
		assertEquals(9, alien.getNumeroPiernas());
		assertEquals(precioAntes, alien.getPrecioTotal(), DELTA);
	}

	@Test
	public void testAgregarOjosDebeRetornarTrueEnAlienPequenioDentroDelLimite() {
		// Arrange
		Alien alien = new Alien(8, "Verde");

		// Act
		boolean resultado = alien.agregarOjos(3);

		// Assert
		// Valida que un alien pequeño pueda tener hasta 3 ojos
		assertTrue(resultado);
		assertEquals(3, alien.getNumeroOjos());
		
	}
	
	@Test
	public void testAgregarOjosAlienPequenio() {

	    Alien alien = new Alien(8, "verde");

	    boolean resultado = alien.agregarOjos(3);

	    assertTrue(resultado);
	    assertEquals(3, alien.getNumeroOjos());
	}
	
	@Test
	public void testAgregarOjosAlienMediano() {

	    Alien alien = new Alien(15, "rojo");

	    boolean resultado = alien.agregarOjos(5);

	    assertTrue(resultado);
	    assertEquals(5, alien.getNumeroOjos());
	}
	
	@Test
	public void testAgregarOjosAlienGrande() {

	    Alien alien = new Alien(25, "azul");

	    boolean resultado = alien.agregarOjos(7);

	    assertTrue(resultado);
	    assertEquals(7, alien.getNumeroOjos());
	}
	
	@Test
	public void testAgregarOjosSuperaLimite() {

	    Alien alien = new Alien(10, "verde");

	    boolean resultado = alien.agregarOjos(4);

	    assertFalse(resultado);
	}
	
	@Test
	public void testMetodoImprimir() {
		Alien alien9 = new Alien(10,"blanco");
		alien9.imprimir();
	}
	
	@Test
    public void testImprimirAlienInicial() {

        // Instancia para prueba
        Alien alien = new Alien(10, "Verde");
        
        //Redirigir a capturador para futura comparación
        ByteArrayOutputStream salidaCapturada = new ByteArrayOutputStream();
        PrintStream salidaOriginal = System.out;
        System.setOut(new PrintStream(salidaCapturada));

        // Acto de imprimir
        alien.imprimir();

        // Assert, cambio salida a string
        String salida = salidaCapturada.toString();
        
        //compruebo si el contenido esta en la salida
        assertTrue(salida.contains("Tamaño: 10"));
        assertTrue(salida.contains("Color: Verde"));
        assertTrue(salida.contains("Número de ojos: 0"));
        assertTrue(salida.contains("Número de brazos: 0"));
        assertTrue(salida.contains("Número de piernas: 0"));
        
        //se devuelve para que imrpima los demás mensajes en consola
        System.setOut(salidaOriginal);
    }
	
	@Test
	public void testImprimirAlienConPartes() {

	    // Arrange
	    Alien alien = new Alien(10, "Azul");
	    alien.agregarBrazos(2);
	    alien.agregarPiernas(2);
	    alien.agregarOjos(2);

	    ByteArrayOutputStream salidaCapturada = new ByteArrayOutputStream();
	    PrintStream salidaOriginal = System.out;
	    System.setOut(new PrintStream(salidaCapturada));

	    // Act
	    alien.imprimir();

	    // Assert
	    String salida = salidaCapturada.toString();

	    assertTrue(salida.contains("Número de ojos: 2"));
	    assertTrue(salida.contains("Número de brazos: 2"));
	    assertTrue(salida.contains("Número de piernas: 2"));
	    assertTrue(salida.contains("Precio Total"));

	    System.setOut(salidaOriginal);
	}
	
	
	
}