package practica_final;

public class RegistroFicherosEscritura {
    //Objeto para manejar la escritura en archivos.
    private LineaFicherosEscritura fichero = null;
    
    //Constructor que inicializa el objeto para escritura en un archivo especificado.
    public RegistroFicherosEscritura(String fichero1) throws Exception {
        fichero = new LineaFicherosEscritura(fichero1);
    }
    
    //Constructor que permite especificar si se debe añadir al archivo existente o sobrescribirlo.
    public RegistroFicherosEscritura(String fichero1, boolean adicion) throws Exception {
        fichero = new LineaFicherosEscritura(fichero1, adicion);
    }
    
    //Método para escribir un registro en el archivo.
    public void escritura(Registro registro) throws Exception {
        fichero.escritura(registro.RegistroToLinea());
    }
    
    //Método para escribir un salto de línea en el archivo.
    public void escrituraSaltoDeContacto() throws Exception {
        fichero.escrituraSaltoDeLinea();
    }
    
    //Método para cerrar el archivo.
    public void cierre() throws Exception {
        fichero.cierre();
    }
}
