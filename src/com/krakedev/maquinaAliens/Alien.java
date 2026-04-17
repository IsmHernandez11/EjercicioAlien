package com.krakedev.maquinaAliens;

public class Alien {

    private int tamanio;
    private String color;
    private int numeroOjos;
    private int numeroBrazos;
    private int numeroPies;

    private double precioExtremidad;
    private double precioOjo;
    private double precioCuerpo;
    private double precioTotal;

    public Alien(int tamanio, String color) {
        // Validación tamaño
        if (tamanio < 5) {
            this.tamanio = 5;
        } else if (tamanio > 30) {
            this.tamanio = 30;
        } else {
            this.tamanio = tamanio;
        }

        this.color = color;
        this.numeroOjos = 0;
        this.numeroBrazos = 0;
        this.numeroPies = 0;

        // Precios
        this.precioCuerpo = this.tamanio * 0.20;
        this.precioExtremidad = this.tamanio * 0.10;
        this.precioOjo = this.tamanio * 0.05;

        this.precioTotal = 0;
    }

    // GETTERS
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

    public int getNumeroPies() {
        return numeroPies;
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

    // MÉTODOS
    public boolean agregarBrazos(int cantidad) {
        if ((numeroBrazos + numeroPies + cantidad) <= 10) {
            numeroBrazos += cantidad;
            calcularPrecioTotal();
            return true;
        }
        return false;
    }

    public boolean agregarPiernas(int cantidad) {
        if ((numeroBrazos + numeroPies + cantidad) <= 10) {
            numeroPies += cantidad;
            calcularPrecioTotal();
            return true;
        }
        return false;
    }

    public boolean agregarOjos(int cantidad) {
        int maxOjos;

        if (tamanio >= 5 && tamanio <= 10) {
            maxOjos = 3;
        } else if (tamanio <= 20) {
            maxOjos = 5;
        } else {
            maxOjos = 7;
        }

        if (numeroOjos + cantidad <= maxOjos) {
            numeroOjos += cantidad;
            calcularPrecioTotal();
            return true;
        }
        return false;
    }

    public void calcularPrecioTotal() {
        precioTotal = precioCuerpo +
                (numeroBrazos + numeroPies) * precioExtremidad +
                (numeroOjos * precioOjo);
    }

    public void imprimir() {
        System.out.println("Tamaño: " + tamanio);
        System.out.println("Color: " + color);
        System.out.println("Ojos: " + numeroOjos);
        System.out.println("Brazos: " + numeroBrazos);
        System.out.println("Piernas: " + numeroPies);
        System.out.println("Precio Cuerpo: " + precioCuerpo);
        System.out.println("Precio Extremidad: " + precioExtremidad);
        System.out.println("Precio Ojo: " + precioOjo);
        System.out.println("Precio Total: " + precioTotal);
        System.out.println("------------------------");
    }
}
