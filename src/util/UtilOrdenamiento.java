package util;

import model.Pokemon;

public class UtilOrdenamiento {

    // Ordenamiento por selección - ataque
    public static void seleccionPorAtaque(Pokemon[] arreglo, int len) {
        for (int i = 0; i < len - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < len; j++) {
                if (arreglo[j].getAtaque() < arreglo[minIdx].getAtaque()) {
                    minIdx = j;
                }
            }
            Pokemon tmp = arreglo[i];
            arreglo[i] = arreglo[minIdx];
            arreglo[minIdx] = tmp;
        }
    }

    // Ordenamiento por inserción - defensa
    public static void insercionPorDefensa(Pokemon[] arreglo, int len) {
        for (int i = 1; i < len; i++) {
            Pokemon temp = arreglo[i];
            int j = i - 1;
            while (j >= 0 && arreglo[j].getDefensa() > temp.getDefensa()) {
                arreglo[j + 1] = arreglo[j];
                j--;
            }
            arreglo[j + 1] = temp;
        }
    }

    // Ordenamiento por inserción - id
    public static void insercionPorId(Pokemon[] arreglo, int len) {
        for (int i = 1; i < len; i++) {
            Pokemon temp = arreglo[i];
            int j = i - 1;
            while (j >= 0 && arreglo[j].getId() > temp.getId()) {
                arreglo[j + 1] = arreglo[j];
                j--;
            }
            arreglo[j + 1] = temp;
        }
    }
}
