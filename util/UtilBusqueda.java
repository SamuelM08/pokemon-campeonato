package util;

import model.Pokemon;

public class UtilBusqueda {

    // Búsqueda lineal - nombre
    public static int busquedaLinealPorNombre(Pokemon[] pokemones, int len, String nombre) {
        for (int i = 0; i < len; i++) {
            if (pokemones[i].getNombre().equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return -1; // No encontrado
    }

    // Búsqueda binaria - requiere arreglo ordenado por id
    public static int busquedaBinariaPorId(Pokemon[] pokemones, int len, int id) {
        int izq = 0, der = len - 1;
        while (izq <= der) {
            int mid = izq + (der - izq) / 2;
            if (pokemones[mid].getId() == id) return mid;
            if (pokemones[mid].getId() < id) izq = mid + 1;
            else der = mid - 1;
        }
        return -1; // No encontrado
    }
}
