import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pokemon {
    private String nombre;
    private String tipo;
    private int nivel;
    private int vidaMaxima;
    private int vidaActual;
    private int ataque;
    private int defensa;
    private int velocidad; // Nueva estadística
    private List<Movimiento> movimientos; // Ahora guarda objetos Movimiento

    public Pokemon(String nombre, String tipo, int nivel, int vidaMaxima, int ataque, int defensa, int velocidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        this.vidaMaxima = vidaMaxima;
        this.vidaActual = vidaMaxima;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.movimientos = new ArrayList<>();
    }

    // El ataque ahora recibe qué movimiento se está usando
    public void atacar(Pokemon objetivo, Movimiento movimiento) {
        System.out.println("¡" + this.nombre + " usó " + movimiento.getNombre() + "!");

        // Fórmula básica de daño
        Random rand = new Random();
        int variacion = rand.nextInt(6); 
        
        // Calcular multiplicador de tipo
        double multiplicador = obtenerMultiplicadorDeTipo(movimiento.getTipo(), objetivo.getTipo());
        
        if (multiplicador > 1.0) System.out.println("¡Es muy eficaz!");
        if (multiplicador < 1.0) System.out.println("No es muy eficaz...");

        // Daño basado en el Poder del Movimiento + Ataque del Pokemon
        int danioBase = ((this.ataque + movimiento.getPoder()) / 2) - objetivo.getDefensa() + variacion;
        int danioFinal = Math.max(1, (int)(danioBase * multiplicador)); // Mínimo siempre hace 1 de daño

        objetivo.recibirDanio(danioFinal);
        System.out.println(objetivo.getNombre() + " recibió " + danioFinal + " de daño.\n");
    }

    // Lógica básica de piedra-papel-tijeras de Pokémon
    private double obtenerMultiplicadorDeTipo(String tipoAtaque, String tipoDefensor) {
        if (tipoAtaque.equals("Agua") && tipoDefensor.equals("Fuego")) return 2.0;
        if (tipoAtaque.equals("Fuego") && tipoDefensor.equals("Planta")) return 2.0;
        if (tipoAtaque.equals("Eléctrico") && tipoDefensor.equals("Agua")) return 2.0;
        
        if (tipoAtaque.equals("Fuego") && tipoDefensor.equals("Agua")) return 0.5;
        if (tipoAtaque.equals("Eléctrico") && tipoDefensor.equals("Planta")) return 0.5;
        if (tipoAtaque.equals("Normal")) return 1.0;
        
        return 1.0; // Neutro por defecto
    }

    public void recibirDanio(int danio) {
        this.vidaActual -= danio;
        if (this.vidaActual < 0) this.vidaActual = 0;
    }

    public boolean estaDebilitado() {
        return this.vidaActual <= 0;
    }

    public void curar(int cantidad) {
        this.vidaActual += cantidad;
        if (this.vidaActual > vidaMaxima) this.vidaActual = vidaMaxima;
    }

    public void agregarMovimiento(Movimiento movimiento) {
        movimientos.add(movimiento);
    }

    // Método para elegir un movimiento al azar (simula la IA)
    public Movimiento elegirMovimientoAleatorio() {
        Random rand = new Random();
        return movimientos.get(rand.nextInt(movimientos.size()));
    }

    public void mostrarEstado() {
        System.out.println("=== " + nombre + " (Nv." + nivel + ") ===");
        System.out.println("Tipo: " + tipo + " | Vel: " + velocidad);
        System.out.println("Vida: " + vidaActual + "/" + vidaMaxima);
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public int getVidaActual() { return vidaActual; }
    public int getVidaMaxima() { return vidaMaxima; }
    public int getDefensa() { return defensa; }
    public int getVelocidad() { return velocidad; }
}