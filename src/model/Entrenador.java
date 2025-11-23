package model;

public class Entrenador {
    private int id;
    private String nombre;
    private int[] equipo; // IDs de Pokémon
    private int tamEquipo;
    private int pj, pg, pp;
    private float porcVictorias;

    public Entrenador(int id, String nombre, int maxEquipo) {
        this.id = id;
        this.nombre = nombre;
        this.equipo = new int[maxEquipo];
        this.tamEquipo = 0;
        this.pj = this.pg = this.pp = 0;
        this.porcVictorias = 0;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int[] getEquipo() { return equipo; }
    public int getTamEquipo() { return tamEquipo; }
    public int getPJ() { return pj; }
    public int getPG() { return pg; }
    public int getPP() { return pp; }
    public float getPorcVictorias() { return porcVictorias; }

    public void agregarPokemon(int idPokemon) {
        if (tamEquipo < equipo.length) {
            equipo[tamEquipo++] = idPokemon;
        }
    }

    public void actualizarEstadisticas(boolean gano) {
        pj++;
        if (gano) pg++;
        else pp++;
        porcVictorias = pj > 0 ? ((float) pg / pj) * 100 : 0;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre;
    }
}
