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
    private List<String> movimientos;

    public Pokemon(String nombre, String tipo, int nivel, int vidaMaxima, int ataque, int defensa) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        this.vidaMaxima = vidaMaxima;
        this.vidaActual = vidaMaxima;
        this.ataque = ataque;
        this.defensa = defensa;
        this.movimientos = new ArrayList<>();
    }

    // Métodos principales

    public void atacar(Pokemon objetivo) {
        Random rand = new Random();
        int variacion = rand.nextInt(6); // daño aleatorio 0-5
        int danio = Math.max(0, (this.ataque + variacion) - objetivo.defensa);

        objetivo.recibirDanio(danio);

        System.out.println(this.nombre + " atacó a " + objetivo.nombre + " causando " + danio + " de daño.");
    }

    public void recibirDanio(int danio) {
        this.vidaActual -= danio;
        if (this.vidaActual < 0) {
            this.vidaActual = 0;
        }
    }

    public boolean estaDebilitado() {
        return this.vidaActual <= 0;
    }

    public void curar(int cantidad) {
        this.vidaActual += cantidad;
        if (this.vidaActual > vidaMaxima) {
            this.vidaActual = vidaMaxima;
        }
    }

    public void agregarMovimiento(String movimiento) {
        movimientos.add(movimiento);
    }

    public void mostrarEstado() {
        System.out.println("=== " + nombre + " ===");
        System.out.println("Tipo: " + tipo);
        System.out.println("Nivel: " + nivel);
        System.out.println("Vida: " + vidaActual + "/" + vidaMaxima);
        System.out.println("Ataque: " + ataque);
        System.out.println("Defensa: " + defensa);
        System.out.println("Movimientos: " + movimientos);
    }

    // Getters y setters

    public String getNombre() {
        return nombre;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }
}
