package com.krakedev.maquinaAliens;

public class TestConstructores {
	public static void main(String[] args) {

        Alien a1 = new Alien(2, "Verde");  
        Alien a2 = new Alien(40, "Rojo");   

        a1.imprimir();
        a2.imprimir();

        a1.agregarBrazos(2);
        a1.agregarPiernas(2);
        a1.agregarOjos(3);

        a1.imprimir();
    }
}
