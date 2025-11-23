import model.Pokemon;
import model.Entrenador;
import util.UtilBusqueda;
import util.UtilOrdenamiento;
import service.Batalla;
import service.Campeonato;

import java.util.Scanner;

public class Main {
    // Reglas del sistema
    public static final int MAX_POKEMONES = 40;
    public static final int MAX_ENTRENADORES = 4;
    public static final int MAX_EQUIPO = 6;

    public static void main(String[] args) {
        Pokemon[] pokemones = new Pokemon[MAX_POKEMONES];
        Entrenador[] entrenadores = new Entrenador[MAX_ENTRENADORES];
        int numPokemones = 0, numEntrenadores = 0;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("--- MENU PRINCIPAL ---");
            System.out.println("1. Registrar Pokemon");
            System.out.println("2. Registrar Entrenador");
            System.out.println("3. Buscar Pokemon");
            System.out.println("4. Ordenar Pokemon");
            System.out.println("5. Simular Batalla 1v1");
            System.out.println("6. Campeonato Round Robin");
            System.out.println("7. Mostrar Tabla");
            System.out.println("0. Salir");
            System.out.print("Selecciona opcion: ");

            int opcion = leerEntero(sc, "Selecciona opcion: ");
            if (opcion == 0) break;

            switch (opcion) {
                case 1: // Registrar Pokemon
                    if (numPokemones < MAX_POKEMONES) {
                        int id = leerEntero(sc, "ID: ");

                        String nombre = leerStringLetras(sc, "Nombre: ");

                        String tipo = leerTipoPokemon(sc, "Tipo (Agua/Fuego/Planta/Electrico): ");

                        String entrenador = leerStringLetras(sc, "Entrenador: ");

                        pokemones[numPokemones++] = new Pokemon(id, nombre, tipo, entrenador);
                        System.out.println("Pokemon registrado!\n");
                    } else {
                        System.out.println("Limite de Pokemon alcanzado.");
                    }
                    break;

                case 2: // Registrar Entrenador
                    if (numEntrenadores < MAX_ENTRENADORES) {
                        int id = leerEntero(sc, "ID: ");
                        String nombre = leerStringLetras(sc, "Nombre: ");
                        entrenadores[numEntrenadores] = new Entrenador(id, nombre, MAX_EQUIPO);

                        int n = leerEnteroRango(sc, "Cuantos Pokemon en el equipo? (1-6): ", 1, MAX_EQUIPO);

                        for (int j = 0; j < n; j++) {
                            int idPoke = leerEntero(sc, "ID de Pokemon #" + (j + 1) + ": ");
                            entrenadores[numEntrenadores].agregarPokemon(idPoke);
                        }
                        numEntrenadores++;
                        System.out.println("Entrenador registrado!\n");
                    } else {
                        System.out.println("Limite de entrenadores alcanzado.");
                    }
                    break;

                case 3: // Buscar Pokemon por nombre
                    System.out.print("Buscar por nombre: ");
                    String nombreBuscar = sc.nextLine();
                    int pos = UtilBusqueda.busquedaLinealPorNombre(pokemones, numPokemones, nombreBuscar);
                    if (pos != -1)
                        System.out.println("Encontrado: " + pokemones[pos]);
                    else
                        System.out.println("No encontrado.\n");
                    break;

                case 4: // Ordenar Pokemon
                    System.out.println("1. Ordenar por ataque (seleccion)");
                    System.out.println("2. Ordenar por defensa (insercion)");
                    System.out.println("3. Ordenar por id (insercion)");
                    int tipoOrd = leerEnteroRango(sc, "Tipo de ordenamiento (1-3): ", 1, 3);

                    System.out.println("-- Estado ANTES de ordenar --");
                    for (int i = 0; i < numPokemones; i++) System.out.println(pokemones[i]);

                    if (tipoOrd == 1) UtilOrdenamiento.seleccionPorAtaque(pokemones, numPokemones);
                    if (tipoOrd == 2) UtilOrdenamiento.insercionPorDefensa(pokemones, numPokemones);
                    if (tipoOrd == 3) UtilOrdenamiento.insercionPorId(pokemones, numPokemones);

                    System.out.println("-- Estado DESPUES de ordenar --");
                    for (int i = 0; i < numPokemones; i++) System.out.println(pokemones[i]);
                    break;

                case 5: // Simular Batalla 1v1
                    int id1 = leerEntero(sc, "ID pokemon 1: ");
                    int id2 = leerEntero(sc, "ID pokemon 2: ");
                    Pokemon p1 = null, p2 = null;
                    for (int i = 0; i < numPokemones; i++) {
                        if (pokemones[i].getId() == id1) p1 = pokemones[i];
                        if (pokemones[i].getId() == id2) p2 = pokemones[i];
                    }
                    if (p1 != null && p2 != null) {
                        Batalla.simular(p1, p2);
                    } else {
                        System.out.println("Pokemon no encontrado.\n");
                    }
                    break;

                case 6: // Campeonato
                    Campeonato.rondaRoundRobin(entrenadores, numEntrenadores, pokemones, numPokemones);
                    break;

                case 7: // Mostrar tabla
                    Campeonato.mostrarTabla(entrenadores, numEntrenadores);
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }
        }
        sc.close();
    }

    // Lee un entero y valida que sea correcto
    public static int leerEntero(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextInt()) {
            System.out.println("Invalido, aqui van solo numeros.");
            sc.next();
            System.out.print(mensaje);
        }
        int val = sc.nextInt();
        sc.nextLine();
        return val;
    }

    // Lee un entero en un rango valido
    public static int leerEnteroRango(Scanner sc, String mensaje, int min, int max) {
        int x = leerEntero(sc, mensaje);
        while (x < min || x > max) {
            System.out.println("Invalido. Debe ser entre " + min + " y " + max + ".");
            x = leerEntero(sc, mensaje);
        }
        return x;
    }

    // Lee una cadena que solo contenga letras y espacios
    public static String leerStringLetras(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        String valor = sc.nextLine();
        while (!valor.matches("[a-zA-Z\\s]+")) {
            System.out.println("Invalido, aqui van solo letras.");
            System.out.print(mensaje);
            valor = sc.nextLine();
        }
        return valor;
    }

    // Lee y valida el tipo de Pokemon segun las opciones permitidas
    public static String leerTipoPokemon(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        String tipo = sc.nextLine();
        while (!tipo.equalsIgnoreCase("Agua") &&
                !tipo.equalsIgnoreCase("Fuego") &&
                !tipo.equalsIgnoreCase("Planta") &&
                !tipo.equalsIgnoreCase("Electrico")) {
            System.out.println("Tipo invalido. Opciones: Agua, Fuego, Planta, Electrico.");
            System.out.print(mensaje);
            tipo = sc.nextLine();
        }
        return tipo;
    }
}
