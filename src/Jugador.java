
package practica_final;

public class Jugador {
    //Nombre del jugador.
    private String nombre;
    //Apellido del jugador.
    private String apellido;
    
    //Constructor por defecto que inicializa un jugador vacío.
    public Jugador() {
    }

    //Constructor que inicializa un jugador con un nombre y un apellido.
    public Jugador(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    //Devuelve el nombre del jugador.
    public String getNombre() {
        return nombre;
    }

    //Devuelve el apellido del jugador.
    public String getApellido() {
        return apellido;
    }

    //Establece el nombre del jugador.
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Establece el apellido del jugador.
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    //Devuelve una representación en texto del jugador.
    @Override
    public String toString() {
        return "Jugador --> " + nombre + " " + apellido;
    }
}
