package practica_final;

public class Tablero {

    private BarcosTablero barcos; //Objeto para gestionar los barcos en el tablero.
    private Casilla[][] tablero; //Matriz que representa el tablero del juego.
    private int dimX; //Número de filas en el tablero.
    private int dimY; //Número de columnas en el tablero.
    private final char AGUA = 'a'; //Simboliza una casilla con agua (color azul).
    private final char TOCADO = 't'; //Simboliza una casilla de barco tocado (color amarillo).
    private final char HUNDIDO = 'x'; //Simboliza una casilla de barco hundido (color rojo).

    //Constructor por defecto: inicializa un tablero de 10x10.
    public Tablero() {
        dimX = 10;
        dimY = 10;
        tablero = new Casilla[dimX][dimY]; // Crea la matriz de casillas.
        barcos = new BarcosTablero(); // Inicializa la gestión de barcos.
    }

    // Constructor que permite definir las dimensiones del tablero.
    public Tablero(int fila, int columna) {
        dimX = fila;
        dimY = columna;
        tablero = new Casilla[dimX][dimY]; // Crea la matriz con las dimensiones especificadas.
        barcos = new BarcosTablero(); // Inicializa la gestión de barcos.
    }

    // Método para inicializar todas las casillas del tablero como vacías.
    public void inicializacion() {
        for (int i = 0; i < dimX; i++) {
            for (int j = 0; j < dimY; j++) {
                tablero[i][j] = new Casilla(); // Asigna una nueva casilla vacía a cada posición.
            }
        }
    }
    
    public char acceso(int fila, int columna){
        return tablero[fila][columna].getContenido();
    }
    
    // Método para gestionar el acceso del jugador a una casilla del tablero.
    public void disparar(int fila, int columna) {
        switch (tablero[fila][columna].getContenido()) {
            case '-': // Casilla vacía (agua).
                tablero[fila][columna] = new Casilla(fila, columna, 'a'); // Marca como agua.
                tablero[fila][columna].setEstado(true); // Cambia el estado a "ya disparado".
                break;
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9': // Si se golpea un barco.
                if (barcos.estaHundido(tablero[fila][columna].getContenido())) {
                    int barcoIndex = tablero[fila][columna].getContenido() - 48; // Convierte el carácter del barco en índice.
                    Barco barco = barcos.getBarco(barcoIndex);
                    int numeroX = barco.getXx() - barco.getX();
                    int numeroY = barco.getYy() - barco.getY();
                    if (numeroX < numeroY) {
                        if (numeroX < 0) {
                            for (int i = 0; i < barco.getLongitudInicial(); i++) {
                                tablero[barco.getX() - i][barco.getY()] = new Casilla(barco.getX() - i, barco.getY(), 'x');
                                tablero[barco.getX() - i][barco.getY()].setEstado(true);
                            }
                        } else {
                            for (int i = 0; i < barco.getLongitudInicial(); i++) {
                                tablero[barco.getX()][barco.getY() + i] = new Casilla(barco.getX(), barco.getY() + i, 'x');
                                tablero[barco.getX()][barco.getY() + i].setEstado(true);
                            }
                        }
                    } else {
                        if (numeroX > 0) {
                            for (int i = 0; i < barco.getLongitudInicial(); i++) {
                                tablero[barco.getX() + i][barco.getY()] = new Casilla(barco.getX() + i, barco.getY(), 'x');
                                tablero[barco.getX() + i][barco.getY()].setEstado(true);
                            }
                        } else {
                            for (int i = 0; i < barco.getLongitudInicial(); i++) {
                                tablero[barco.getX()][barco.getY() - i] = new Casilla(barco.getX(), barco.getY() - i, 'x');
                                tablero[barco.getX()][barco.getY() - i].setEstado(true);
                            }
                        }
                    }
                } else {
                    tablero[fila][columna] = new Casilla(fila, columna, 't'); // Marca como tocado.
                    tablero[fila][columna].setEstado(true);
                }
                break;
            default: // Si ya se ha disparado en esta casilla.
                System.out.println("Ya has disparado en esta coordenada.");
                break;
        }
    }

    // Método para convertir una línea de texto en información para el tablero.
    public void LineasToTablero(Linea linea, int fila) throws Exception {
        char caracter;
        int j = 0;
        caracter = linea.obtenerCaracter(j); // Obtiene el primer carácter de la línea.
        do {
            barcos.barcos(caracter, fila, j); // Registra o actualiza el barco.
            tablero[fila][j] = new Casilla(fila, j, caracter); // Asigna una casilla con el contenido correspondiente.
            j++;
            caracter = linea.obtenerCaracter(j); // Obtiene el siguiente carácter.
        } while (j < dimY); // Repite hasta completar la fila.
    }

    // Verifica si todos los barcos han sido hundidos.
    public boolean verificarVictoria() {
        for (int i = 0; i < dimX; i++) {
            for (int j = 0; j < dimY; j++) {
                char contenido = tablero[i][j].getContenido();
                if (contenido != '-' && contenido != 'x' && contenido != 'a' && contenido != 't') {
                    return false; // Si queda algún barco sin hundir, devuelve false.
                }
            }
        }
        return true; // Todos los barcos están hundidos.
    }

    // Método para visualizar el tablero propio con coordenadas y bordes.
    public void visualizarTablero() {
        // Imprimir los números en la parte superior
        System.out.print("    ");
        for (int i = 1; i <= dimY; i++) {
            if (i < 10) {
                System.out.print(" " + i + "  ");
            } else {
                System.out.print(" " + i + " ");
            }
        }
        System.out.println();

        // Línea separadora superior
        System.out.print("    ");
        for (int i = 0; i < dimY; i++) {
            System.out.print("----");
        }
        System.out.println();

        for (int i = 0; i < dimX; i++) {
            // Imprimir las letras en el lateral izquierdo
            System.out.print((char) ('A' + i) + " |");
            for (int j = 0; j < dimY; j++) {
                char contenido = tablero[i][j].getContenido();
                int color;

                // Determinar si la casilla contiene un barco (números del '0' al '9')
                if (contenido >= '0' && contenido <= '9') {
                    color = 3; // Verde para barcos
                } else {
                    color = obtenerColor(contenido, true); // Color basado en el contenido
                }

                System.out.print(LT.colorBG(color) + " " + contenido + " " + LT.colorBG(0) + "|");
            }
            // Imprimir las letras en el lateral derecho
            System.out.print(" " + (char) ('A' + i));
            System.out.println();
        }

        // Línea separadora inferior
        System.out.print("    ");
        for (int i = 0; i < dimY; i++) {
            System.out.print("----");
        }
        System.out.println();

        // Imprimir los números en la parte inferior
        System.out.print("    ");
        for (int i = 1; i <= dimY; i++) {
            if (i < 10) {
                System.out.print(" " + i + "  ");
            } else {
                System.out.print(" " + i + " ");
            }
        }
        System.out.println();
    }

    //Visualizar el tablero rival
    public void visualizarTableroRival() {
        // Imprimir los números en la parte superior
        System.out.print("    ");
        for (int i = 1; i <= dimY; i++) {
            if (i < 10) {
                System.out.print(" " + i + "  ");
            } else {
                System.out.print(" " + i + " ");
            }
        }
        System.out.println();

        // Línea separadora superior
        System.out.print("    ");
        for (int i = 0; i < dimY; i++) {
            System.out.print("----");
        }
        System.out.println();

        for (int i = 0; i < dimX; i++) {
            // Imprimir las letras en el lateral izquierdo
            System.out.print((char) ('A' + i) + " |");
            for (int j = 0; j < dimY; j++) {
                if (tablero[i][j].getEstado()) {
                    char contenido = tablero[i][j].getContenido();
                    int color = obtenerColor(contenido, false); // Mostrar colores para el rival
                    System.out.print(LT.colorBG(color) + " " + contenido + " " + LT.colorBG(0) + "|");
                } else {
                    System.out.print(" - |"); // Espacio para casillas no reveladas
                }
            }
            // Imprimir las letras en el lateral derecho
            System.out.print(" " + (char) ('A' + i));
            System.out.println();
        }

        // Línea separadora inferior
        System.out.print("    ");
        for (int i = 0; i < dimY; i++) {
            System.out.print("----");
        }
        System.out.println();

        // Imprimir los números en la parte inferior
        System.out.print("    ");
        for (int i = 1; i <= dimY; i++) {
            if (i < 10) {
                System.out.print(" " + i + "  ");
            } else {
                System.out.print(" " + i + " ");
            }
        }
        System.out.println();
    }

    //Metodo que nos permite pintar el fondo de una casilla
    private int obtenerColor(char contenido, boolean mostrarCompleto) {
        if (!mostrarCompleto) {
            if (contenido == 'x') {
                return 2; // Rojo - Barco hundido
            }
            if (contenido == 't') {
                return 4; // Amarillo - Barco tocado
            }
            if (contenido == 'a') {
                return 7; // Azul - Agua
            }
        } else {
            if (contenido == 'v') {
                return 3; // Verde - Barco completo
            }
            if (contenido == 'x') {
                return 2; // Rojo - Barco hundido
            }
            if (contenido == 't') {
                return 4; // Amarillo - Barco tocado
            }
            if (contenido == 'a') {
                return 7; // Azul - Agua
            }
        }
        return 0; // Color por defecto
    }

    // Métodos para obtener las dimensiones del tablero.
    public int getDimX() {
        return dimX;
    }

    public int getDimY() {
        return dimY;
    }
}
