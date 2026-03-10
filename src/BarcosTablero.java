package practica_final;

public class BarcosTablero {
    //Coordenadas iniciales de los barcos en el tablero.
    //Cada par de índices representa las coordenadas X e Y de un barco.
    private int[] coordsBarcos = new int[20];
    //Longitudes iniciales de los barcos.
    //Cada índice corresponde a un barco identificado por un número (0-9).
    private int[] longiBarcos = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    //Array de objetos Barco que almacena la información de cada barco.
    private Barco[] barcos = new Barco[7];

    //Constructor vacío.
    public BarcosTablero() {}

    //Verifica si un barco está hundido.
    //Reduce la longitud del barco en 1 y devuelve true si está completamente hundido.
    public boolean estaHundido(char cont) {
        int conversion = cont - 48; //Convierte el carácter a un índice numérico.
        Barco barco = barcos[conversion];// Obtiene el barco correspondiente.
        barco.setLongitud(barco.getLongitud() - 1); //Reduce su longitud actual.
        return barco.getLongitud() == 0; //Devuelve true si la longitud es 0.
    }

    //Registra o actualiza un barco en el tablero según su identificador y coordenadas.
    public void barcos(char caracter, int dimX, int dimY) {
        switch (caracter) {
            case '0':
                longiBarcos[0]++; //Incrementa la longitud del barco '0'.
                if (longiBarcos[0] == 1) { //Si es la primera vez que se registra el barco:
                    coordsBarcos[0] = dimX; //Guarda la coordenada X inicial.
                    coordsBarcos[1] = dimY; //Guarda la coordenada Y inicial.
                }
                //Crea o actualiza el objeto Barco correspondiente.
                barcos[0] = new Barco(longiBarcos[0], coordsBarcos[0], coordsBarcos[1], dimX, dimY, 0);
                break;
            case '1':
                longiBarcos[1]++;
                if (longiBarcos[1] == 1) {
                    coordsBarcos[2] = dimX;
                    coordsBarcos[3] = dimY;
                }
                barcos[1] = new Barco(longiBarcos[1], coordsBarcos[2], coordsBarcos[3], dimX, dimY, 1);
                break;
            case '2':
                longiBarcos[2]++;
                if (longiBarcos[2] == 1) {
                    coordsBarcos[4] = dimX;
                    coordsBarcos[5] = dimY;
                }
                barcos[2] = new Barco(longiBarcos[2], coordsBarcos[4], coordsBarcos[5], dimX, dimY, 2);
                break;
            case '3':
                longiBarcos[3]++;
                if (longiBarcos[3] == 1) {
                    coordsBarcos[6] = dimX;
                    coordsBarcos[7] = dimY;
                }
                barcos[3] = new Barco(longiBarcos[3], coordsBarcos[6], coordsBarcos[7], dimX, dimY, 3);
                break;
            case '4':
                longiBarcos[4]++;
                if (longiBarcos[4] == 1) {
                    coordsBarcos[8] = dimX;
                    coordsBarcos[9] = dimY;
                }
                barcos[4] = new Barco(longiBarcos[4], coordsBarcos[8], coordsBarcos[9], dimX, dimY, 4);
                break;
            case '5':
                longiBarcos[5]++;
                if (longiBarcos[5] == 1) {
                    coordsBarcos[10] = dimX;
                    coordsBarcos[11] = dimY;
                }
                barcos[5] = new Barco(longiBarcos[5], coordsBarcos[10], coordsBarcos[11], dimX, dimY, 5);
                break;
            case '6':
                longiBarcos[6]++;
                if (longiBarcos[6] == 1) {
                    coordsBarcos[12] = dimX;
                    coordsBarcos[13] = dimY;
                }
                barcos[6] = new Barco(longiBarcos[6], coordsBarcos[12], coordsBarcos[13], dimX, dimY, 6);
                break;
            case '7':
                longiBarcos[7]++;
                if (longiBarcos[7] == 1) {
                    coordsBarcos[14] = dimX;
                    coordsBarcos[15] = dimY;
                }
                barcos[7] = new Barco(longiBarcos[7], coordsBarcos[14], coordsBarcos[15], dimX, dimY, 7);
                break;
            case '8':
                longiBarcos[8]++;
                if (longiBarcos[8] == 1) {
                    coordsBarcos[16] = dimX;
                    coordsBarcos[17] = dimY;
                }
                barcos[8] = new Barco(longiBarcos[8], coordsBarcos[16], coordsBarcos[17], dimX, dimY, 8);
                break;
            case '9':
                longiBarcos[9]++;
                if (longiBarcos[9] == 1) {
                    coordsBarcos[18] = dimX;
                    coordsBarcos[19] = dimY;
                }
                barcos[9] = new Barco(longiBarcos[9], coordsBarcos[18], coordsBarcos[19], dimX, dimY, 9);
                break;
            default:
                break;
        }
    }

    //Devuelve el array con las coordenadas iniciales de los barcos.
    public int[] getCoordsBarcos() {
        return coordsBarcos;
    }

    //Devuelve el array con las longitudes de los barcos.
    public int[] getLongiBarcos() {
        return longiBarcos;
    }

    //Devuelve un barco específico según su índice.
    public Barco getBarco(int index) {
        return barcos[index];
    }
}
