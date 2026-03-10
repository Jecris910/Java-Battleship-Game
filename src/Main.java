
package practica_final;

import java.util.Random;

public class ProgramaPrincipal {

    public static void main(String[] args) throws Exception {
        //Llama al método principal del programa.
        new ProgramaPrincipal().metodoPrincipal();
    }

    // Método principal del programa.
    public void metodoPrincipal() throws Exception {
        char menu; // Variable para almacenar la elección del menú.
        boolean seguir = true; // Controla si el programa sigue ejecutándose.

        // Bucle del menú principal.
        while (seguir) {
            visualizarMenu(); // Muestra el menú principal.
            menu = LT.readChar(); // Lee la opción seleccionada por el usuario.

            // Controla las opciones seleccionadas.
            switch (menu) {
                case '1' -> { // Opción para jugar.
                    LT.skipLine(); // Limpia el buffer de entrada.
                    limpiarConsola(); // Limpia la pantalla.
                    jugar(); // Llama al método para gestionar el juego.
                }
                case '2' -> { // Opción para el registro.
                    LT.skipLine();
                    limpiarConsola();
                    registroo(); // Llama al método de registro.
                }
                case 'S' -> { // Opción para salir del programa.
                    limpiarConsola();
                    System.out.println("Fin del programa.");
                    seguir = false; // Termina el bucle.
                }
                default -> { // Opción inválida.
                    limpiarConsola();
                    System.out.println("Caracter no vàlid.");
                }
            }
        }
    }

    // Muestra el menú principal.
    public void visualizarMenu() {
        System.out.println("***********************************************************");
        System.out.println("MENU PRINCIPAL");
        System.out.println("***********************************************************");
        System.out.println("      1 Jugar");
        System.out.println("      2 Registro");
        System.out.println("      S Salir");
        System.out.println("***********************************************************");
        System.out.print("Opcion [1,2,S] : ");
    }

    // Muestra el submenú de opciones de juego.
    public void visualizarMenuJugar() {
        System.out.println("***********************************************************");
        System.out.println("JUGAR");
        System.out.println("***********************************************************");
        System.out.println("      1 Jugar solo");
        System.out.println("      2 Jugar contra otro jugador");
        System.out.println("      3 Jugar contra el ordenador");
        System.out.println("      S Volver al menu principal");
        System.out.println("***********************************************************");
        System.out.print("Opcion [1,2,3,S] : ");
    }

    // Muestra el submenú de opciones de juego.
    public void visualizarMenuRegistro() {
        System.out.println("***********************************************************");
        System.out.println("REGISTRO");
        System.out.println("***********************************************************");
        System.out.println("      1 Mostrar detalles de las partidas");
        System.out.println("      2 Mostrar estadísticas de un jugador");
        System.out.println("      S Volver al menu principal");
        System.out.println("***********************************************************");
        System.out.print("Opcion [1,2,S] : ");
    }

    // Limpia la pantalla para mejorar la visualización.
    public void limpiarConsola() {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    // Método que gestiona las opciones del menú de juego.
    public void jugar() throws Exception {
        char menu; // Almacena la elección del menú.
        boolean seguir = true; // Controla si el submenú sigue activo.

        // Bucle del submenú de juego.
        while (seguir) {
            visualizarMenuJugar(); // Muestra las opciones de juego.
            menu = LT.readChar(); // Lee la opción seleccionada.

            // Controla las opciones del submenú.
            switch (menu) {
                case '1' -> { // Opción para jugar solo.
                    LT.skipLine();
                    limpiarConsola();
                    solo(); // Llama al método para jugar solo.
                }
                case '2' -> { // Opción para jugar contra otro jugador.
                    LT.skipLine();
                    limpiarConsola();
                    vsJugador(); // Llama al método para jugar contra otro jugador.
                }
                case '3' -> { // Opción para jugar contra el ordenador.
                    LT.skipLine();
                    limpiarConsola();
                    vsPC(); // Llama al método para jugar contra el ordenador.
                }
                case 'S' -> { // Opción para volver al menú principal.
                    limpiarConsola();
                    System.out.println("Fin del programa.");
                    seguir = false; // Termina el bucle.
                }
                default -> { // Opción inválida.
                    limpiarConsola();
                    System.out.println("Caracter no vàlid0.");
                }
            }
        }
    }

    // Método para gestionar el juego en modo individual.
    public void solo() throws Exception {
        // Solicitar el nombre del jugador
        System.out.print("Introduce tu nombre: ");
        Linea nombreJugador = new Linea();
        if (Linea.hayLinea()) {
            nombreJugador.lectura();
        }

        // Variables para gestionar el juego
        char coordX;
        int coordY;
        int turno = 1;
        int disparosAgua = 0;
        int disparosTocados = 0;
        int disparosHundidos = 0;

        // Generar un tablero aleatorio para la partida
        Random rand = new Random();
        int numero = rand.nextInt(0, 100);
        int indice = 0;

        Tablero tableroPC = new Tablero();
        tableroPC.inicializacion();

        // Configuración del tablero desde un archivo
        LineaFicherosLectura fichero = new LineaFicherosLectura("10-10-5-4-3-3-2/" + numero + ".txt");
        Linea fila;

        // Leer las líneas del archivo y configurarlas en el tablero
        while (fichero.quedanLineas()) {
            fila = fichero.lectura();
            tableroPC.LineasToTablero(fila, indice++);
        }
        // Cerrar el archivo después de la configuración
        fichero.cierre();

        // Iniciar el bucle del juego hasta que el jugador gane
        while (!tableroPC.verificarVictoria()) {
            System.out.println("TURNO " + turno);
            System.out.println("Escribe la coordenada X donde desee disparar: (A-" + conversionX(tableroPC.getDimX()) + ")");
            coordX = LT.readChar();
            System.out.println("Escribe la coordenada Y donde desee disparar: (1-" + tableroPC.getDimY() + ")");
            coordY = LT.readInt();
            tableroPC.disparar(conversionX(coordX) - 1, coordY - 1);
            tableroPC.visualizarTableroRival();
            turno++;
        }

        // Contar las estadísticas de disparos al finalizar la partida
        for (int i = 0; i < tableroPC.getDimX(); i++) {
            for (int j = 0; j < tableroPC.getDimY(); j++) {
                switch (tableroPC.acceso(i, j)) {
                    case 'a':
                        disparosAgua++;
                        break;
                    case 't':
                        disparosTocados++;
                        break;
                    case 'x':
                        disparosHundidos++;
                        break;
                    default:
                        break;
                }
            }
        }
        // Mostrar mensaje de victoria
        System.out.println("¡Felicidades, " + nombreJugador.toString() + "! Ganaste.");

        // Crear un registro de la partida
        Registro registro = new Registro(
                nombreJugador,
                new Linea("Solo"),
                new Linea("10x10"),
                new Linea("5-4-3-3-2"),
                disparosHundidos,
                disparosTocados,
                disparosAgua,
                0, // disparosRecibidos no aplica aquí
                true
        );

        // Guardar el registro en un archivo
        RegistroFicherosEscritura guardarRegistro = new RegistroFicherosEscritura("resultados.txt", true);
        guardarRegistro.escritura(registro);
        guardarRegistro.escrituraSaltoDeContacto();
        guardarRegistro.cierre();
    }


    // Método para gestionar el juego en modo multijugador.
    public void vsJugador() throws Exception {
        // Solicitar el nombre del Jugador 1.
        System.out.print("Introduce el nombre del Jugador 1: ");
        Linea nombreJugador1 = new Linea();
        if (Linea.hayLinea()) {
            nombreJugador1.lectura();
        }

        // Solicitar el nombre del Jugador 2.
        System.out.print("Introduce el nombre del Jugador 2: ");
        Linea nombreJugador2 = new Linea();
        if (Linea.hayLinea()) {
            nombreJugador2.lectura();
        }

        limpiarConsola();

        // Inicializar los tableros para ambos jugadores.
        Tablero tableroJugador1 = new Tablero();
        Tablero tableroJugador2 = new Tablero();
        tableroJugador1.inicializacion();
        tableroJugador2.inicializacion();

        // Generar configuraciones de tableros desde archivos aleatorios.
        Random rand = new Random();
        int numero = rand.nextInt(0, 100);

        // Leer y configurar el tablero del Jugador 1.
        LineaFicherosLectura fichero1 = new LineaFicherosLectura("10-10-5-4-3-3-2/" + numero + ".txt");
        int indice = 0;
        Linea fila;
        while (fichero1.quedanLineas()) {
            fila = fichero1.lectura();
            tableroJugador1.LineasToTablero(fila, indice);
            indice++;
        }
        fichero1.cierre();

        // Leer y configurar el tablero del Jugador 2.
        numero = rand.nextInt(0, 100);
        LineaFicherosLectura fichero2 = new LineaFicherosLectura("10-10-5-4-3-3-2/" + numero + ".txt");
        indice = 0;
        while (fichero2.quedanLineas()) {
            fila = fichero2.lectura();
            tableroJugador2.LineasToTablero(fila, indice);
            indice++;
        }
        fichero2.cierre();

        // Variable para alternar turnos entre los jugadores.
        boolean turnoJugador1 = true;

        // Variables de estadísticas para el registro.
        int disparosAgua1 = 0, disparosTocados1 = 0, disparosHundidos1 = 0;
        int disparosAgua2 = 0, disparosTocados2 = 0, disparosHundidos2 = 0;

        // Bucle principal del juego hasta que haya un ganador.
        while (!tableroJugador1.verificarVictoria() && !tableroJugador2.verificarVictoria()) {
            if (turnoJugador1) {
                // Turno del Jugador 1.
                System.out.println("Turno de " + nombreJugador1.toString());
                System.out.println("Tu tablero " + nombreJugador1.toString());
                tableroJugador1.visualizarTablero();
                System.out.println("\nTablero Rival");
                tableroJugador2.visualizarTableroRival();

                // Solicitar las coordenadas de disparo.
                System.out.println("Escribe la coordenada X donde desee disparar: (A-" + conversionX(tableroJugador2.getDimX()) + ")");
                char coordX = LT.readChar();
                System.out.println("Escribe la coordenada Y donde desee disparar: (1-" + tableroJugador2.getDimY() + ")");
                int coordY = LT.readInt();

                limpiarConsola();

                // Disparar en el tablero del oponente.
                tableroJugador2.disparar(conversionX(coordX) - 1, coordY - 1);

                turnoJugador1 = false; // Cambiar el turno.
            } else {
                // Turno del Jugador 2.
                System.out.println("Turno de " + nombreJugador2.toString());
                System.out.println("Tu tablero " + nombreJugador2.toString());
                tableroJugador2.visualizarTablero();
                System.out.println("\nTablero Rival");
                tableroJugador1.visualizarTableroRival();

                // Solicitar las coordenadas de disparo.
                System.out.println("Escribe la coordenada X donde desee disparar: (A-" + conversionX(tableroJugador1.getDimX()) + ")");
                char coordX = LT.readChar();
                System.out.println("Escribe la coordenada Y donde desee disparar: (1-" + tableroJugador1.getDimY() + ")");
                int coordY = LT.readInt();

                limpiarConsola();

                // Disparar en el tablero del oponente.
                tableroJugador1.disparar(conversionX(coordX) - 1, coordY - 1);

                turnoJugador1 = true; // Cambiar el turno.
            }
        }

        // Determinar el ganador.
        boolean jugador1Gana = tableroJugador2.verificarVictoria();
        if (jugador1Gana) {
            System.out.println("¡" + nombreJugador1.toString() + " gana!");
        } else {
            System.out.println("¡" + nombreJugador2.toString() + " gana!");
        }

        // Contar estadísticas de disparos para cada jugador.
        for (int i = 0; i < tableroJugador1.getDimX(); i++) {
            for (int j = 0; j < tableroJugador1.getDimY(); j++) {
                switch (tableroJugador1.acceso(i, j)) {
                    case 'a':
                        disparosAgua2++;
                        break;
                    case 't':
                        disparosTocados2++;
                        break;
                    case 'x':
                        disparosHundidos2++;
                        break;
                }
            }
        }
        for (int i = 0; i < tableroJugador2.getDimX(); i++) {
            for (int j = 0; j < tableroJugador2.getDimY(); j++) {
                switch (tableroJugador2.acceso(i, j)) {
                    case 'a':
                        disparosAgua1++;
                        break;
                    case 't':
                        disparosTocados1++;
                        break;
                    case 'x':
                        disparosHundidos1++;
                        break;
                }
            }
        }

        // Crear registros para ambos jugadores.
        Registro registro1 = new Registro(
                nombreJugador1,
                new Linea("Multijugador"),
                new Linea(tableroJugador1.getDimX() + "x" + tableroJugador1.getDimY()),
                new Linea("5-4-3-3-2"),
                disparosHundidos1,
                disparosTocados1,
                disparosAgua1,
                disparosHundidos2 + disparosTocados2,
                jugador1Gana
        );
        Registro registro2 = new Registro(
                nombreJugador2,
                new Linea("Multijugador"),
                new Linea(tableroJugador2.getDimX() + "x" + tableroJugador2.getDimY()),
                new Linea("5-4-3-3-2"),
                disparosHundidos2,
                disparosTocados2,
                disparosAgua2,
                disparosHundidos1 + disparosTocados1,
                !jugador1Gana
        );

        // Guardar registros en el archivo.
        RegistroFicherosEscritura guardarRegistro = new RegistroFicherosEscritura("resultados.txt", true);
        guardarRegistro.escritura(registro1);
        guardarRegistro.escrituraSaltoDeContacto();
        guardarRegistro.escritura(registro2);
        guardarRegistro.escrituraSaltoDeContacto();
        guardarRegistro.cierre();
    }

    // Método para gestionar el juego contra la CPU.
    public void vsPC() throws Exception {
        // Inicialización de tableros y nombres.
        Tablero tableroJugador = new Tablero();
        Tablero tableroCPU = new Tablero();
        tableroJugador.inicializacion();
        tableroCPU.inicializacion();

        // Solicitar el nombre del jugador.
        System.out.print("Introduce tu nombre: ");
        Linea nombreJugador = new Linea();
        if (Linea.hayLinea()) {
            nombreJugador.lectura();
        }
        // Nombre predeterminado para la CPU.
        Linea nombreCPU = new Linea("CPU");

        limpiarConsola();

        // Variables para estadísticas de registro.
        int disparosAguaJugador = 0, disparosTocadosJugador = 0, disparosHundidosJugador = 0;
        int disparosAguaCPU = 0, disparosTocadosCPU = 0, disparosHundidosCPU = 0;

        // Configuración de los tableros desde archivos.
        Random rand = new Random();
        int numero = rand.nextInt(0, 100);

        // Configuración del tablero del jugador.
        LineaFicherosLectura ficheroJugador = new LineaFicherosLectura("10-10-5-4-3-3-2/" + numero + ".txt");
        int indice = 0;
        Linea fila;
        while (ficheroJugador.quedanLineas()) {
            fila = ficheroJugador.lectura();
            tableroJugador.LineasToTablero(fila, indice);
            indice++;
        }
        ficheroJugador.cierre();

        // Configuración del tablero de la CPU.
        numero = rand.nextInt(0, 100);
        LineaFicherosLectura ficheroCPU = new LineaFicherosLectura("10-10-5-4-3-3-2/" + numero + ".txt");
        indice = 0;
        while (ficheroCPU.quedanLineas()) {
            fila = ficheroCPU.lectura();
            tableroCPU.LineasToTablero(fila, indice);
            indice++;
        }
        ficheroCPU.cierre();

        // Bucle de turnos entre el jugador y la CPU.
        boolean turnoJugador = true; // Indica de quién es el turno.
        boolean[][] disparosCPU = new boolean[10][10]; // Registro de disparos realizados por la CPU.

        while (!tableroJugador.verificarVictoria() && !tableroCPU.verificarVictoria()) {
            if (turnoJugador) {
                // Turno del jugador.
                System.out.println("Turno de " + nombreJugador.toString());
                System.out.println("Tu tablero " + nombreJugador.toString());
                tableroJugador.visualizarTablero();
                System.out.println("\nTablero Rival");
                tableroCPU.visualizarTableroRival();

                // Solicitar coordenadas para disparar.
                System.out.println("Escribe la coordenada X donde desee disparar: (A-" + conversionX(tableroCPU.getDimX()) + ")");
                char coordX = LT.readChar();
                System.out.println("Escribe la coordenada Y donde desee disparar: (1-" + tableroCPU.getDimY() + ")");
                int coordY = LT.readInt();

                limpiarConsola();

                // Realizar disparo en el tablero de la CPU.
                tableroCPU.disparar(conversionX(coordX) - 1, coordY - 1);

                turnoJugador = false; // Cambiar el turno a la CPU.
            } else {
                // Turno de la CPU.
                System.out.println("Turno de " + nombreCPU.toString());

                int filaDisparo;
                int columnaDisparo;

                // Generar disparos aleatorios únicos.
                do {
                    filaDisparo = rand.nextInt(10);
                    columnaDisparo = rand.nextInt(10);
                } while (disparosCPU[filaDisparo][columnaDisparo]);

                disparosCPU[filaDisparo][columnaDisparo] = true; // Marcar como disparado.

                System.out.println(nombreCPU.toString() + " dispara en: " + conversionX(filaDisparo + 1) + (columnaDisparo + 1));

                // Realizar disparo en el tablero del jugador.
                tableroJugador.disparar(filaDisparo, columnaDisparo);

                turnoJugador = true; // Cambiar el turno al jugador.
            }
        }

        // Determinar el ganador.
        boolean jugadorGana = tableroCPU.verificarVictoria();

        if (jugadorGana) {
            System.out.println("¡" + nombreJugador.toString() + " gana!");
        } else {
            System.out.println("¡La CPU gana!");
        }

        // Contar estadísticas de disparos para el jugador.
        for (int i = 0; i < tableroJugador.getDimX(); i++) {
            for (int j = 0; j < tableroJugador.getDimY(); j++) {
                switch (tableroJugador.acceso(i, j)) {
                    case 'a':
                        disparosAguaCPU++;
                        break;
                    case 't':
                        disparosTocadosCPU++;
                        break;
                    case 'x':
                        disparosHundidosCPU++;
                        break;
                }
            }
        }

        // Contar estadísticas de disparos para la CPU.
        for (int i = 0; i < tableroCPU.getDimX(); i++) {
            for (int j = 0; j < tableroCPU.getDimY(); j++) {
                switch (tableroCPU.acceso(i, j)) {
                    case 'a':
                        disparosAguaJugador++;
                        break;
                    case 't':
                        disparosTocadosJugador++;
                        break;
                    case 'x':
                        disparosHundidosJugador++;
                        break;
                }
            }
        }

        // Crear registro para el jugador.
        Registro registroJugador = new Registro(
                nombreJugador,
                new Linea("vsCPU"),
                new Linea(tableroJugador.getDimX() + "x" + tableroJugador.getDimY()),
                new Linea("10-10-5-4-3-3-2"),
                disparosHundidosJugador,
                disparosTocadosJugador,
                disparosAguaJugador,
                disparosTocadosCPU + disparosHundidosCPU,
                jugadorGana
        );

        // Crear registro para la CPU.
        Registro registroCPU = new Registro(
                nombreCPU,
                new Linea("vsCPU"),
                new Linea(tableroCPU.getDimX() + "x" + tableroCPU.getDimY()),
                new Linea("10-10-5-4-3-3-2"),
                disparosHundidosCPU,
                disparosTocadosCPU,
                disparosAguaCPU,
                disparosTocadosJugador + disparosHundidosJugador,
                !jugadorGana
        );

        // Guardar registros en archivo.
        RegistroFicherosEscritura guardarRegistro = new RegistroFicherosEscritura("resultados.txt", true);
        guardarRegistro.escritura(registroJugador);
        guardarRegistro.escrituraSaltoDeContacto();
        guardarRegistro.escritura(registroCPU);
        guardarRegistro.escrituraSaltoDeContacto();
        guardarRegistro.cierre();
    }


    public void registroo() throws Exception {
        char menu; // Variable para almacenar la elección del menú.
        boolean seguir = true; // Controla si el programa sigue ejecutándose.

        // Bucle del menú principal.
        while (seguir) {
            visualizarMenuRegistro(); // Muestra el menú principal.
            menu = LT.readChar(); // Lee la opción seleccionada por el usuario.

            // Controla las opciones seleccionadas.
            switch (menu) {
                case '1' -> { // Opción para ver el registro.
                    LT.skipLine(); // Limpia el buffer de entrada.
                    limpiarConsola(); // Limpia la pantalla.
                    registro(); // Llama al método para gestionar el juego.
                }
                case '2' -> { // Opción para el registro de estadisticas del jugador.
                    LT.skipLine();
                    limpiarConsola();
                    estadisticasJugador(); // Llama al método de registro.
                }
                case 'S' -> { // Opción para salir del programa.
                    limpiarConsola();
                    System.out.println("Salir al menu principal");
                    seguir = false; // Termina el bucle.
                }
                default -> { // Opción inválida.
                    limpiarConsola();
                    System.out.println("Caracter no vàlid.");
                }
            }
        }
    }

    // Método para mostrar y guardar el registro de las partidas.
    public void registro() throws Exception {
        Registro registro;
        RegistroFicherosLectura fichero = new RegistroFicherosLectura("resultados.txt");

        System.out.println("Registro de partidas:");
        System.out.println("");
        while (fichero.hayRegistros()) {
            registro = fichero.lectura();
            System.out.println(registro.toString());
        }
        fichero.cierre();
    }

    // Método para calcular y mostrar las estadísticas de un jugador.
    public void estadisticasJugador() throws Exception {
        // Variables para recopilar estadísticas.
        int partidas = 0; // Número total de partidas jugadas.
        int ganadas = 0; // Número total de partidas ganadas.
        double hundido = 0; // Número total de disparos a barcos hundidos.
        double tocado = 0; // Número total de disparos a barcos tocados pero no hundidos.
        double agua = 0; // Número total de disparos al agua.
        int recibidos = 0; // Número total de disparos recibidos.

        // Solicitar el nombre del jugador.
        Linea nombre = new Linea();
        Registro registro;
        RegistroFicherosLectura fichero = new RegistroFicherosLectura("resultados.txt");
        System.out.println("Introduzca el nombre del jugador: ");
        if (Linea.hayLinea()) {
            nombre.lectura();
        }

        // Leer registros del fichero y calcular estadísticas.
        while (fichero.hayRegistros()) {
            registro = fichero.lectura();
            if (registro.getNombre().igual(nombre)) {
                partidas++; // Incrementar el contador de partidas.
                hundido += registro.getDisparosHundidos(); // Sumar disparos a barcos hundidos.
                tocado += registro.getDisparosTocados(); // Sumar disparos a barcos tocados.
                agua += registro.getDisparosAgua(); // Sumar disparos al agua.
                recibidos += registro.getDisparosRecibidos(); // Sumar disparos recibidos.
                if (registro.getHaGanado().obtenerCaracter(0) == 't') { // Verificar si ganó la partida.
                    ganadas++;
                }
            }
        }

        // Cerrar el fichero tras procesar todos los registros.
        fichero.cierre();

        // Mostrar las estadísticas calculadas.
        System.out.println("Estadísticas del jugador: " + nombre.toString() + "\n");
        System.out.println("Partidas jugadas: " + partidas);
        System.out.println("Partidas ganadas: " + ganadas);
        System.out.println("% de partidas ganadas: " + (ganadas / (double) partidas) * 100 + "%");
        System.out.println("Disparos totales efectuados: " + (tocado + hundido + agua));
        System.out.println("Promedio de disparos al agua: " + agua / partidas);
        System.out.println("Promedio de disparos a barcos no hundidos: " + tocado / partidas);
        System.out.println("Promedio de disparos a barcos hundidos: " + hundido / partidas);
        System.out.println("Promedio de disparos recibidos: " + recibidos / partidas);
    }
    
    // Convierte una letra (A-P) a un número (1-16).
    public int conversionX(char caracter) {
        int conversion = 0;
        switch (caracter) {
            case 'A':
                conversion = 1;
                break;
            case 'B':
                conversion = 2;
                break;
            case 'C':
                conversion = 3;
                break;
            case 'D':
                conversion = 4;
                break;
            case 'E':
                conversion = 5;
                break;
            case 'F':
                conversion = 6;
                break;
            case 'G':
                conversion = 7;
                break;
            case 'H':
                conversion = 8;
                break;
            case 'I':
                conversion = 9;
                break;
            case 'J':
                conversion = 10;
                break;
            case 'K':
                conversion = 11;
                break;
            case 'L':
                conversion = 12;
                break;
            case 'M':
                conversion = 13;
                break;
            case 'N':
                conversion = 14;
                break;
            case 'O':
                conversion = 15;
                break;
            case 'P':
                conversion = 16;
                break;
        }
        return conversion;
    }

    // Convierte un número (1-16) a una letra (A-P).
    public char conversionX(int numero) {
        char conversion = ' ';
        switch (numero) {
            case 1:
                conversion = 'A';
                break;
            case 2:
                conversion = 'B';
                break;
            case 3:
                conversion = 'C';
                break;
            case 4:
                conversion = 'D';
                break;
            case 5:
                conversion = 'E';
                break;
            case 6:
                conversion = 'F';
                break;
            case 7:
                conversion = 'G';
                break;
            case 8:
                conversion = 'H';
                break;
            case 9:
                conversion = 'I';
                break;
            case 10:
                conversion = 'J';
                break;
            case 11:
                conversion = 'K';
                break;
            case 12:
                conversion = 'L';
                break;
            case 13:
                conversion = 'M';
                break;
            case 14:
                conversion = 'N';
                break;
            case 15:
                conversion = 'O';
                break;
            case 16:
                conversion = 'P';
                break;
        }
        return conversion;
    }
}
