public class Main {
    public static void main(String[] args) {
        // Crear pokemones
        Pokemon pikachu = new Pokemon("Pikachu", "Eléctrico", 5, 100, 20, 10);
        Pokemon charmander = new Pokemon("Charmander", "Fuego", 5, 100, 18, 8);

        // Agregar movimientos
        pikachu.agregarMovimiento("Impactrueno");
        pikachu.agregarMovimiento("Ataque Rápido");

        charmander.agregarMovimiento("Ascuas");
        charmander.agregarMovimiento("Arañazo");

        // Mostrar estado inicial
        pikachu.mostrarEstado();
        charmander.mostrarEstado();

        System.out.println("\n--- COMBATE ---\n");

        // Simular ataque
        pikachu.atacar(charmander);
        charmander.atacar(pikachu);

        // Mostrar estado después del ataque
        pikachu.mostrarEstado();
        charmander.mostrarEstado();

        // Verificar si alguno está debilitado
        if (pikachu.estaDebilitado()) {
            System.out.println("Pikachu está debilitado.");
        }

        if (charmander.estaDebilitado()) {
            System.out.println("Charmander está debilitado.");
        }
    }
}
