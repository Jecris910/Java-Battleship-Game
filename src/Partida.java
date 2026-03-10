
package practica_final;

public class Partida {
    //Jugador 1 de la partida.
    private Jugador jugador1;
    //Jugador 2 de la partida (opcional en partidas de un solo jugador).
    private Jugador jugador2;

    //Constructor para partidas de un solo jugador.
    public Partida(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    //Constructor para partidas de dos jugadores.
    public Partida(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }
}
