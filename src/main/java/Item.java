public class Item {

    private String nombre;
    private String descripcion;
    private int cantidad;

    // Constructor para inicializar un Item
    public Item(String nombre, String descripcion, int cantidad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    // Usar el item (Ejemplo: Pociones, Revivir, etc.)
    public void usar(Pokemon pokemon) {
        if (cantidad > 0) {
            System.out.println("Usando " + nombre + " en " + pokemon.getNombre());
            aplicarEfecto(pokemon);
            cantidad--; // Decrece la cantidad del item
        } else {
            System.out.println("No tienes más " + nombre + " disponibles.");
        }
    }

    // Método para aplicar el efecto del item (se puede extender)
    private void aplicarEfecto(Pokemon pokemon) {
        // Por ejemplo: Si el item es una poción, curar al Pokémon
        if (nombre.equals("Potion")) {
            pokemon.curar(50); // Cura 50 puntos de vida
            System.out.println(pokemon.getNombre() + " ha recuperado 50 puntos de vida.");
        }
        else if (nombre.equals("Revive")) {
            if (pokemon.estaDebilitado()) {
                pokemon.curar(pokemon.getVidaMaxima() / 2); // Revive al Pokémon con la mitad de vida
                System.out.println(pokemon.getNombre() + " ha sido revivido con la mitad de su vida.");
            } else {
                System.out.println(pokemon.getNombre() + " no está debilitado, no es necesario usar Revive.");
            }
        }
        // Se pueden agregar más items con efectos específicos.
    }

    // Método para mostrar información del item
    public void mostrarInfo() {
        System.out.println("Item: " + nombre);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Cantidad: " + cantidad);
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}