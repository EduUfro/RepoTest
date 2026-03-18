public class Main {
    public static void main(String[] args) {
        Item pocion = new Item("Potion", "cura 50", 2);
        
        // Añadimos el parámetro Velocidad al final
        Pokemon pikachu = new Pokemon("Pikachu", "Eléctrico", 5, 100, 25, 10, 90);
        Pokemon squirtle = new Pokemon("Squirtle", "Agua", 5, 100, 20, 15, 43); // Cambié a Squirtle para probar tipos

        // Creamos los objetos Movimiento (Nombre, Tipo, Poder)
        pikachu.agregarMovimiento(new Movimiento("Impactrueno", "Eléctrico", 40));
        pikachu.agregarMovimiento(new Movimiento("Ataque Rápido", "Normal", 30));

        squirtle.agregarMovimiento(new Movimiento("Pistola Agua", "Agua", 40));
        squirtle.agregarMovimiento(new Movimiento("Placaje", "Normal", 30));

        System.out.println("--- PRESENTACIÓN DE LOS LUCHADORES ---");
        pikachu.mostrarEstado();
        squirtle.mostrarEstado();

        System.out.println("\n--- ¡COMIENZA EL COMBATE! ---\n");

        int ronda = 1;
        while (!pikachu.estaDebilitado() && !squirtle.estaDebilitado()) {
            System.out.println(">> RONDA " + ronda);

            // Determinar orden por Velocidad
            Pokemon primero, segundo;
            if (pikachu.getVelocidad() >= squirtle.getVelocidad()) {
                primero = pikachu;
                segundo = squirtle;
            } else {
                primero = squirtle;
                segundo = pikachu;
            }

            // Turno del Primer Pokémon
            ejecutarTurno(primero, segundo, pocion);
            
            // Turno del Segundo Pokémon (si no ha caído)
            if (!segundo.estaDebilitado()) {
                ejecutarTurno(segundo, primero, pocion);
            }

            System.out.println("Salud -> " + pikachu.getNombre() + ": " + pikachu.getVidaActual() + 
                               " | " + squirtle.getNombre() + ": " + squirtle.getVidaActual());
            System.out.println("--------------------------------\n");
            ronda++;
        }

        System.out.println("\n--- RESULTADO DEL COMBATE ---");
        if (pikachu.estaDebilitado()) {
            System.out.println("¡" + squirtle.getNombre() + " es el ganador!");
        } else {
            System.out.println("¡" + pikachu.getNombre() + " es el ganador!");
        }
    }

    // Método auxiliar para limpiar el código del Main
    private static void ejecutarTurno(Pokemon atacante, Pokemon defensor, Item pocion) {
        // Lógica de curación simple: Si es Pikachu y tiene poca vida, intenta curarse
        if (atacante.getNombre().equals("Pikachu") && atacante.getVidaActual() < 40 && pocion.getCantidad() > 0) {
            pocion.usar(atacante);
        } else {
            // Elige un movimiento de su lista y ataca
            Movimiento mov = atacante.elegirMovimientoAleatorio();
            atacante.atacar(defensor, mov);
        }
    }
}