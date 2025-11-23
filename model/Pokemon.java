package model;

import java.util.Random;

public class Pokemon {
    private int id;
    private String nombre;
    private String tipo;
    private int ataque;
    private int defensa;
    private String entrenador;

    public Pokemon(int id, String nombre, String tipo, String entrenador) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.entrenador = entrenador;
        this.ataque = generarEstadisticaAleatoria();
        this.defensa = generarEstadisticaAleatoria();
    }

    private int generarEstadisticaAleatoria() {
        Random rand = new Random();
        return rand.nextInt(100) + 1; // 1 a 100 incluido
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public int getAtaque() { return ataque; }
    public int getDefensa() { return defensa; }
    public String getEntrenador() { return entrenador; }

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Tipo: " + tipo +
                " | Ataque: " + ataque + " | Defensa: " + defensa + " | Entrenador: " + entrenador;
    }
}
