package service;

import model.Entrenador;
import model.Pokemon;

public class Campeonato {

    public static void rondaRoundRobin(Entrenador[] entrenadores, int numEntrenadores, Pokemon[] pokemones, int numPokemones) {
        for (int i = 0; i < numEntrenadores; i++) {
            for (int j = i+1; j < numEntrenadores; j++) {
                Entrenador e1 = entrenadores[i];
                Entrenador e2 = entrenadores[j];
                // Selección automática del primer Pokémon de cada entrenador
                int idPoke1 = e1.getEquipo()[0];
                int idPoke2 = e2.getEquipo()[0];
                Pokemon p1 = buscarPorId(pokemones, numPokemones, idPoke1);
                Pokemon p2 = buscarPorId(pokemones, numPokemones, idPoke2);

                System.out.printf("Combate: %s vs %s\n", e1.getNombre(), e2.getNombre());
                boolean ganoE1 = Batalla.simular(p1, p2);
                e1.actualizarEstadisticas(ganoE1);
                e2.actualizarEstadisticas(!ganoE1);
            }
        }
    }

    public static void mostrarTabla(Entrenador[] entrenadores, int numEntrenadores) {
        System.out.println("Tabla de Posiciones:");
        System.out.println("Entrenador | PJ | PG | PP | %Victorias");
        for (int i = 0; i < numEntrenadores; i++) {
            Entrenador e = entrenadores[i];
            System.out.printf("%-10s | %2d | %2d | %2d | %.2f%%\n",
                    e.getNombre(), e.getPJ(), e.getPG(), e.getPP(), e.getPorcVictorias());
        }
    }

    private static Pokemon buscarPorId(Pokemon[] pokemones, int n, int id) {
        for (int i = 0; i < n; i++) {
            if (pokemones[i].getId() == id) return pokemones[i];
        }
        return null;
    }
}
