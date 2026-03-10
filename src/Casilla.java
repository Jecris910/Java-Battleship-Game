
package practica_final;

public class Casilla {
    //Dimensión X (fila) de la casilla.
    private int fila;
    //Dimensión Y (columna) de la casilla.
    private int columna;
    //Contenido de la casilla. Puede ser:
    // 'a' = agua, 'c' = alga, 'm' = moneda, '-' = vacío.
    private char contenido;
    //Estado de la casilla. False significa que no se ha interactuado con ella.
    private boolean estado;
    
    //Constructor por defecto que inicializa la casilla como vacía y no interactuada.
    public Casilla() {
        contenido = '-';
        estado = false;
    }

    //Constructor que inicializa la casilla con fila, columna, y contenido.
    public Casilla(int fila, int columna, char cont) {
        estado = false;
        this.fila = fila;
        this.columna = columna;
        contenido = cont;
    }

    //Constructor que inicializa la casilla con fila, columna, contenido y estado.
    public Casilla(int fila, int columna, char cont, boolean estado) {
        this.fila = fila;
        this.columna = columna;
        contenido = cont;
        this.estado = estado;
    }

    //Devuelve la fila (dimensión X) de la casilla.
    public int getFila() {
        return fila;
    }

    //Devuelve la columna (dimensión Y) de la casilla.
    public int getColumna() {
        return columna;
    }

    //Devuelve el contenido de la casilla.
    public char getContenido() {
        return contenido;
    }

    //Devuelve el estado de la casilla (true si ya fue interactuada).
    public boolean getEstado() {
        return estado;
    }

    //Establece la fila (dimensión X) de la casilla.
    public void setFila(int fila) {
        this.fila = fila;
    }

    //Establece la columna (dimensión Y) de la casilla.
    public void setColumna(int columna) {
        this.columna = columna;
    }

    //Establece el contenido de la casilla.
    public void setContenido(char contenido) {
        this.contenido = contenido;
    }

    //Establece el estado de la casilla.
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    //Devuelve true si la casilla ya ha sido interactuada.
    public boolean hayCasilla() {
        return estado == true;
    }

    //Marca la casilla como interactuada.
    public void seleccion() {
        estado = true;
    }
}
