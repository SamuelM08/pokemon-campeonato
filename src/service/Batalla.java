package service;

import model.Pokemon;

public class Batalla {

    // Calcula el multiplicador de efectividad
    public static double efectividad(String tipoAtk, String tipoDef) {
        if (tipoAtk.equalsIgnoreCase("Agua") && tipoDef.equalsIgnoreCase("Fuego")) return 2.0;
        if (tipoAtk.equalsIgnoreCase("Agua") && tipoDef.equalsIgnoreCase("Planta")) return 0.5;
        if (tipoAtk.equalsIgnoreCase("Fuego") && tipoDef.equalsIgnoreCase("Planta")) return 2.0;
        if (tipoAtk.equalsIgnoreCase("Fuego") && tipoDef.equalsIgnoreCase("Agua")) return 0.5;
        if (tipoAtk.equalsIgnoreCase("Planta") && tipoDef.equalsIgnoreCase("Agua")) return 2.0;
        if (tipoAtk.equalsIgnoreCase("Planta") && tipoDef.equalsIgnoreCase("Fuego")) return 0.5;
        if (tipoAtk.equalsIgnoreCase("Electrico") && tipoDef.equalsIgnoreCase("Agua")) return 2.0;
        return 1.0;
    }

    // Simula una batalla 1vs1. Retorna true si gana el pokémon1
    public static boolean simular(Pokemon poke1, Pokemon poke2) {
        int hp1 = 100, hp2 = 100, turno = 1;
        boolean turnoPoke1 = true;
        System.out.println("Inicia batalla entre:");
        System.out.println(poke1);
        System.out.println("vs");
        System.out.println(poke2);

        while (hp1 > 0 && hp2 > 0) {
            if (turnoPoke1) {
                int daño = calcularDanio(poke1, poke2);
                hp2 -= daño;
                System.out.printf("Turno %d: %s ataca a %s. Daño: %d, HP %s: %d\n",
                        turno, poke1.getNombre(), poke2.getNombre(), daño, poke2.getNombre(), Math.max(hp2, 0));
            } else {
                int daño = calcularDanio(poke2, poke1);
                hp1 -= daño;
                System.out.printf("Turno %d: %s ataca a %s. Daño: %d, HP %s: %d\n",
                        turno, poke2.getNombre(), poke1.getNombre(), daño, poke1.getNombre(), Math.max(hp1, 0));
            }
            turno++;
            turnoPoke1 = !turnoPoke1;
        }
        boolean ganaPoke1 = hp1 > 0;
        System.out.printf("Ganador: %s\n\n", (ganaPoke1 ? poke1.getNombre() : poke2.getNombre()));
        return ganaPoke1;
    }

    private static int calcularDanio(Pokemon atacante, Pokemon defensor) {
        double e = efectividad(atacante.getTipo(), defensor.getTipo());
        double daño = 50.0 * (atacante.getAtaque() / (double)defensor.getDefensa()) * e;
        int d = (int)Math.round(daño);
        return Math.max(d, 1);
    }
}
