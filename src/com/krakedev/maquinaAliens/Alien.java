package com.krakedev.maquinaAliens;

public class Alien {
	private int tamanio;
	private String color;
	private int numeroOjos;
	private int numeroBrazos;
	private int numeroPiernas;
	private double precioExtremidad;
	private double precioOjo;
	private double precioCuerpo;
	private double precioTotal = 0;

	public Alien(int tamanio, String color) {
		super();
		if (tamanio < 5) {
			this.tamanio = 5;
		} else if (tamanio > 30) {
			this.tamanio = 30;
		} else {
			this.tamanio = tamanio;
		}

		this.color = color;
		this.precioCuerpo = this.tamanio * 0.20;
		this.precioExtremidad = this.tamanio * 0.10;
		this.precioOjo = this.tamanio * 0.05;
	}

	public int getTamanio() {
		return tamanio;
	}

	public String getColor() {
		return color;
	}

	public int getNumeroOjos() {
		return numeroOjos;
	}

	public int getNumeroBrazos() {
		return numeroBrazos;
	}

	public int getNumeroPiernas() {
		return numeroPiernas;
	}

	public double getPrecioExtremidad() {
		return precioExtremidad;
	}

	public double getPrecioOjo() {
		return precioOjo;
	}

	public double getPrecioCuerpo() {
		return precioCuerpo;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void imprimir() {
		System.out.println("Tamaño: " + this.tamanio);
		System.out.println("Color: " + this.color);
		System.out.println("Número de ojos: " + this.numeroOjos);
		System.out.println("Número de brazos: " + this.numeroBrazos);
		System.out.println("Número de piernas: " + this.numeroPiernas);

		System.out.printf("Precio cuerpo: %.2f\n", this.precioCuerpo);
		System.out.printf("Precio extremidad: %.2f\n", this.precioExtremidad);
		System.out.printf("Precio ojo: %.2f\n", this.precioOjo);
		System.out.printf("Precio Total: %.2f\n", this.precioTotal);
	}

	public boolean agregarBrazos(int cantidadBrazos) {
		int cantidadExtremidades = this.numeroBrazos + this.numeroPiernas + cantidadBrazos;
		if (cantidadExtremidades <= 10) {
			this.numeroBrazos = this.numeroBrazos + cantidadBrazos;
			calcularPrecioTotal();
			return true;

		} else {
			return false;
		}
	}

	public boolean agregarPiernas(int cantidadPiernas) {
		int cantidadExtremidades = this.numeroBrazos + this.numeroPiernas + cantidadPiernas;
		if (cantidadExtremidades <= 10) {
			this.numeroPiernas = this.numeroPiernas + cantidadPiernas;
			calcularPrecioTotal();
			return true;

		} else {
			return false;
		}
	}

	public boolean agregarOjos(int cantidadOjos) {
		int maximoOjos = 0;

		if (this.tamanio >= 5 && this.tamanio <= 10) {
			maximoOjos = 3;
		} else if (this.tamanio > 10 && this.tamanio <= 20) {
			maximoOjos = 5;
		} else if (this.tamanio > 20 && this.tamanio <= 30) {
			maximoOjos = 7;
		}

		if (this.numeroOjos + cantidadOjos <= maximoOjos) {
			this.numeroOjos = this.numeroOjos + cantidadOjos;
			calcularPrecioTotal();
			return true;
		} else {
			return false;
		}
	}
	
	public void calcularPrecioTotal() {
		int cantidadExtre = this.numeroBrazos + this.numeroPiernas;
		this.precioTotal = this.precioCuerpo+ (this.precioExtremidad * cantidadExtre) + (this.precioOjo*this.numeroOjos);
		
	}
	

}
