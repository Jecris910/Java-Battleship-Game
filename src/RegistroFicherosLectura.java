package practica_final;

public class RegistroFicherosLectura {

    //Objeto encargado de la lectura línea por línea desde un fichero.
    private LineaFicherosLectura fichero = null;

    //Constructor que inicializa la lectura del fichero indicado.
    public RegistroFicherosLectura(String fichero1) throws Exception {
        fichero = new LineaFicherosLectura(fichero1);
    }

    //Método que verifica si quedan registros por leer en el fichero.
    public boolean hayRegistros() throws Exception {
        return fichero.quedanLineas();
    }

    //Método que realiza la lectura de un registro desde el fichero.
    public Registro lectura() throws Exception {
        Registro registro = new Registro(); //Crea un nuevo objeto Registro.
        Linea linea = fichero.lectura(); //Lee una línea del fichero.
        registro.LineaToRegistro(linea); //Convierte la línea leída en un registro.

        return registro;
    }

    //Método que cierra el fichero después de la lectura.
    public void cierre() throws Exception {
        fichero.cierre();
    }
}
