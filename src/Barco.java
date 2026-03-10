package practica_final;

public class Barco {
    //Atributo que identifica de forma única al barco dentro del tablero.
    private int index;
    //Longitud inicial del barco, es decir, su tamaño total al ser colocado.
    private int longitudInicial;
    //Longitud actual del barco, que puede cambiar si es impactado.
    private int longitud;
    //Coordenada inicial X del barco.
    private int x;
    //Coordenada inicial Y del barco.
    private int y;
    //Coordenada final X del barco.
    private int xx;
    //Coordenada final Y del barco.
    private int yy;
    
    //Constructor vacío para inicializar un objeto Barco sin valores específicos.
    public Barco() {
    }

    //Constructor que inicializa un barco con longitud, coordenadas iniciales y finales, y un índice único.
    public Barco(int longitud, int x, int y, int xx, int yy, int index) {
        this.index = index;
        this.longitud = longitud;
        longitudInicial = longitud;
        this.x = x;
        this.y = y;
        this.xx = xx;
        this.yy = yy;
    }

    //Devuelve el índice único del barco.
    public int getIndex() {
        return index;
    }

    //Devuelve la longitud actual del barco.
    public int getLongitud() {
        return longitud;
    }

    //Devuelve la longitud inicial del barco.
    public int getLongitudInicial() {
        return longitudInicial;
    }

    //Devuelve la coordenada inicial X del barco.
    public int getX() {
        return x;
    }

    //Devuelve la coordenada inicial Y del barco.
    public int getY() {
        return y;
    }

    //Devuelve la coordenada final X del barco.
    public int getXx() {
        return xx;
    }

    //Devuelve la coordenada final Y del barco.
    public int getYy() {
        return yy;
    }

    //Establece el índice único del barco.
    public void setIndex(int index) {
        this.index = index;
    }

    //Establece la longitud actual del barco.
    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    //Establece la coordenada inicial X del barco.
    public void setX(int x) {
        this.x = x;
    }

    //Establece la coordenada inicial Y del barco.
    public void setY(int y) {
        this.y = y;
    }

    //Establece la coordenada final X del barco.
    public void setXx(int xx) {
        this.xx = xx;
    }
    
    //Establece la coordenada final Y del barco.
    public void setYy(int yy) {
        this.yy = yy;
    }
}
