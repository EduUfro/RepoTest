public class Main {
    public static void main(String[] args) {
        Pokemon pikachu = new Pokemon("Pikachu", "Eléctrico", 5, 100, 20, 10);
        Pokemon charmander = new Pokemon("Charmander", "Fuego", 5, 100, 18, 8);

        pikachu.agregarMovimiento("Impactrueno");
        pikachu.agregarMovimiento("Ataque Rápido");

        charmander.agregarMovimiento("Ascuas");
        charmander.agregarMovimiento("Arañazo");

        System.out.println("--- PRESENTACIÓN DE LOS LUCHADORES ---");
        pikachu.mostrarEstado();
        System.out.println();
        charmander.mostrarEstado();

        System.out.println("\n--- ¡COMIENZA EL COMBATE! ---\n");

        int ronda = 1;
        while (!pikachu.estaDebilitado() && !charmander.estaDebilitado()) {
            System.out.println(">> Ronda " + ronda);

            pikachu.atacar(charmander);
            
            if (charmander.estaDebilitado()) {
                System.out.println(charmander.getNombre() + " se ha debilitado.");
                break; 
            }
            charmander.atacar(pikachu);
            
            if (pikachu.estaDebilitado()) {
                System.out.println(pikachu.getNombre() + " se ha debilitado.");
                break;
            }
            System.out.println("Salud actual -> " + pikachu.getNombre() + ": " + pikachu.getVidaActual() + 
                               " | " + charmander.getNombre() + ": " + charmander.getVidaActual());
            System.out.println("--------------------------------\n");
            
            ronda++;
        }
        System.out.println("\n--- RESULTADO DEL COMBATE ---");
        if (pikachu.estaDebilitado()) {
            System.out.println("¡" + charmander.getNombre() + " es el ganador!");
        } else if (charmander.estaDebilitado()) {
            System.out.println("¡" + pikachu.getNombre() + " es el ganador!");
        }
    }
}