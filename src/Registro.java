package practica_final;

import java.util.Date;

public class Registro {
    //Atributo para almacenar la fecha de la partida como un objeto Linea.
    private Linea fecha = new Linea();
    //Atributo para almacenar el nombre del jugador como un objeto Linea.
    private Linea nombreJugador = new Linea();
    //Atributo para almacenar el modo de juego como un objeto Linea.
    private Linea modoJuego = new Linea();
    //Atributo para almacenar el tamaño del tablero como un objeto Linea.
    private Linea tamañoTablero = new Linea();
    //Atributo para almacenar la distribución de barcos como un objeto Linea.
    private Linea distribucionBarcos = new Linea();
    //Atributo para contar los disparos que hundieron barcos.
    private int disparosHundidos;
    //Atributo para contar los disparos que tocaron barcos pero no los hundieron.
    private int disparosTocados;
    //Atributo para contar los disparos que cayeron al agua.
    private int disparosAgua;
    //Atributo para contar los disparos que impactaron en los barcos del jugador.
    private int disparosRecibidos;
    //Atributo para almacenar si el jugador ganó la partida como un objeto Linea.
    private Linea haGanado = new Linea();
    //Atributo estático que define el carácter separador para el formato del registro.
    static private final char SEPARADOR = '#';

    //Constructor por defecto que inicializa las estadísticas de la partida a 0.
    public Registro() {
        disparosHundidos = 0; //Inicializa los disparos hundidos en 0.
        disparosTocados = 0; //Inicializa los disparos tocados en 0.
        disparosAgua = 0; //Inicializa los disparos al agua en 0.
        disparosRecibidos = 0; //Inicializa los disparos recibidos en 0.
    }

    //Constructor que inicializa los atributos del registro con los valores proporcionados.
    public Registro(Linea nombreJugador, Linea modoJuego, Linea tamañoTablero, Linea distribucionBarcos,
            int disparosHundidos, int disparosTocados, int disparosAgua, int disparosRecibidos, boolean haGanado) {
        //Establece la fecha actual utilizando el método obtenerFechaActual.
        this.fecha = obtenerFechaActual();
        //Asigna el nombre del jugador al atributo correspondiente.
        this.nombreJugador = nombreJugador;
        //Asigna el modo de juego al atributo correspondiente.
        this.modoJuego = modoJuego;
        //Asigna el tamaño del tablero al atributo correspondiente.
        this.tamañoTablero = tamañoTablero;
        //Asigna la distribución de barcos al atributo correspondiente.
        this.distribucionBarcos = distribucionBarcos;
        //Asigna el número de disparos hundidos al atributo correspondiente.
        this.disparosHundidos = disparosHundidos;
        //Asigna el número de disparos tocados al atributo correspondiente.
        this.disparosTocados = disparosTocados;
        //Asigna el número de disparos al agua al atributo correspondiente.
        this.disparosAgua = disparosAgua;
        //Asigna el número de disparos recibidos al atributo correspondiente.
        this.disparosRecibidos = disparosRecibidos;
        //Determina si el jugador ganó y asigna "true" o "false" al atributo haGanado.
        if (haGanado) {
            this.haGanado = new Linea("true");
        } else {
            this.haGanado = new Linea("false");
        }
    }

    //Método privado que obtiene la fecha actual y la devuelve como un objeto Linea.
    private Linea obtenerFechaActual() {
        //Crea un objeto Date para obtener la fecha y hora actual.
        Date date = new Date();
        //Convierte la fecha a un objeto Linea y la devuelve.
        return new Linea(date.toString());
    }

    
    @Override
    public String toString() {
        String conversion = "Partida " + fecha + "\n";
        conversion += "Modo \"" + modoJuego + "\", ";
        conversion += tamañoTablero + " " + distribucionBarcos + "\n";
        if (haGanado.obtenerCaracter(0) == 't') {  //primer caracter de la palabra "true"
            conversion += "- Jugador \"" + nombreJugador + "\"(ganador/a)\n";
        } else {
            conversion += "- Jugador \"" + nombreJugador + "\"(perdedor/a)\n";
        }
        conversion += "  - " + disparosHundidos + " disparos a barcos hundidos\n";
        conversion += "  - " + disparosTocados + " disparos a barcos tocados no hundidos\n";
        conversion += "  - " + disparosAgua + " disparos al agua\n";
        conversion += "  - " + disparosRecibidos + " disparos recibidos a barcos\n";
        return conversion;
    }

    //Método que convierte un objeto Registro en un objeto Linea para almacenamiento en archivo.
    public Linea RegistroToLinea() {

        //Crea un nuevo objeto Linea que contendrá la información del registro.
        Linea linea = new Linea();

        //Añade la fecha al objeto Linea.
        linea.adicionLinea(fecha);
        //Añade un separador después de la fecha.
        linea.adicionCaracter((int) SEPARADOR);

        //Añade el nombre del jugador al objeto Linea.
        linea.adicionLinea(nombreJugador);
        //Añade un separador después del nombre del jugador.
        linea.adicionCaracter((int) SEPARADOR);

        //Añade el modo de juego al objeto Linea.
        linea.adicionLinea(modoJuego);
        //Añade un separador después del modo de juego.
        linea.adicionCaracter((int) SEPARADOR);

        //Añade el tamaño del tablero al objeto Linea.
        linea.adicionLinea(tamañoTablero);
        //Añade un separador después del tamaño del tablero.
        linea.adicionCaracter((int) SEPARADOR);

        //Añade la distribución de barcos al objeto Linea.
        linea.adicionLinea(distribucionBarcos);
        //Añade un separador después de la distribución de barcos.
        linea.adicionCaracter((int) SEPARADOR);

        //Añade el número de disparos hundidos al objeto Linea.
        linea.adicionNumero(disparosHundidos);
        //Añade un separador después del número de disparos hundidos.
        linea.adicionCaracter((int) SEPARADOR);

        //Añade el número de disparos tocados al objeto Linea.
        linea.adicionNumero(disparosTocados);
        //Añade un separador después del número de disparos tocados.
        linea.adicionCaracter((int) SEPARADOR);

        //Añade el número de disparos al agua al objeto Linea.
        linea.adicionNumero(disparosAgua);
        //Añade un separador después del número de disparos al agua.
        linea.adicionCaracter((int) SEPARADOR);

        //Añade el número de disparos recibidos al objeto Linea.
        linea.adicionNumero(disparosRecibidos);
        //Añade un separador después del número de disparos recibidos.
        linea.adicionCaracter((int) SEPARADOR);

        //Añade el estado de victoria/derrota al objeto Linea.
        linea.adicionLinea(haGanado);

        //Devuelve el objeto Linea construido.
        return linea;
    }


    //Método que convierte un objeto Linea en un objeto Registro, descomponiendo los datos almacenados en la Linea.
    public void LineaToRegistro(Linea linea) throws Exception {
        //Declaración de variables auxiliares para el procesamiento.
        int suma;
        char caracter;
        int indice = 0;

        //Obtiene el primer carácter de la línea.
        caracter = linea.obtenerCaracter(indice);

        //Extrae y asigna la fecha del registro.
        while (caracter != SEPARADOR) {
            fecha.adicionCaracter((int) caracter);
            indice++;
            caracter = linea.obtenerCaracter(indice);
        }
        indice++; //Avanza el índice para saltar el separador.

        //Extrae y asigna el nombre del jugador.
        caracter = linea.obtenerCaracter(indice);
        while (caracter != SEPARADOR) {
            nombreJugador.adicionCaracter((int) caracter);
            indice++;
            caracter = linea.obtenerCaracter(indice);
        }
        indice++;

        //Extrae y asigna el modo de juego.
        caracter = linea.obtenerCaracter(indice);
        while (caracter != SEPARADOR) {
            modoJuego.adicionCaracter((int) caracter);
            indice++;
            caracter = linea.obtenerCaracter(indice);
        }
        indice++;

        //Extrae y asigna el tamaño del tablero.
        caracter = linea.obtenerCaracter(indice);
        while (caracter != SEPARADOR) {
            tamañoTablero.adicionCaracter((int) caracter);
            indice++;
            caracter = linea.obtenerCaracter(indice);
        }
        indice++;

        //Extrae y asigna la distribución de los barcos.
        caracter = linea.obtenerCaracter(indice);
        while (caracter != SEPARADOR) {
            distribucionBarcos.adicionCaracter((int) caracter);
            indice++;
            caracter = linea.obtenerCaracter(indice);
        }
        indice++;

        //Extrae y asigna el número de disparos hundidos.
        caracter = linea.obtenerCaracter(indice);
        suma = 0;
        while (caracter != SEPARADOR) {
            suma += (int) caracter;
            disparosHundidos = suma - 48;
            indice++;
            caracter = linea.obtenerCaracter(indice);
        }
        indice++;

        //Extrae y asigna el número de disparos tocados.
        caracter = linea.obtenerCaracter(indice);
        suma = 0;
        while (caracter != SEPARADOR) {
            suma += (int) caracter;
            disparosTocados = suma - 48;
            indice++;
            caracter = linea.obtenerCaracter(indice);
        }
        indice++;

        //Extrae y asigna el número de disparos al agua.
        caracter = linea.obtenerCaracter(indice);
        suma = 0;
        while (caracter != SEPARADOR) {
            suma += (int) caracter;
            disparosAgua = suma - 48;
            indice++;
            caracter = linea.obtenerCaracter(indice);
        }
        indice++;

        //Extrae y asigna el número de disparos recibidos.
        caracter = linea.obtenerCaracter(indice);
        suma = 0;
        while (caracter != SEPARADOR) {
            suma += (int) caracter;
            disparosRecibidos = suma - 48;
            indice++;
            caracter = linea.obtenerCaracter(indice);
        }
        indice++;

        //Extrae y asigna el estado de victoria o derrota.
        caracter = linea.obtenerCaracter(indice);
        while (indice < linea.numeroCaracteres()) {
            haGanado.adicionCaracter((int) caracter);
            indice++;
            caracter = linea.obtenerCaracter(indice);
        }
    }

    
    //Método para obtener el nombre del jugador almacenado en el registro.
    public Linea getNombre(){
        return nombreJugador;
    }

    //Método para obtener el modo de juego registrado.
    public Linea getModoJuego() {
        return modoJuego;
    }

    //Método para obtener el número de disparos hundidos registrados.
    public int getDisparosHundidos() {
        return disparosHundidos;
    }

    //Método para obtener el número de disparos tocados registrados.
    public int getDisparosTocados() {
        return disparosTocados;
    }

    //Método para obtener el número de disparos al agua registrados.
    public int getDisparosAgua() {
        return disparosAgua;
    }

    //Método para obtener el número de disparos recibidos registrados.
    public int getDisparosRecibidos() {
        return disparosRecibidos;
    }

    //Método para obtener el estado de victoria o derrota registrado.
    public Linea getHaGanado() {
        return haGanado;
    }

}
