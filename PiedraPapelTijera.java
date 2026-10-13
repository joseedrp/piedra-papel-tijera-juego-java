import java.util.Random;
import java.util.Scanner;

public class PiedraPapelTijera {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random aleatorio = new Random();

        int puntosJugador = 0;
        int puntosMaquina = 0;

        System.out.print("¿Cuántas rondas quieres jugar? ");
        int rondas = teclado.nextInt();

        for (int ronda = 1; ronda <= rondas; ronda++) {
            System.out.println("\nRonda " + ronda);
            System.out.println("1. Piedra");
            System.out.println("2. Papel");
            System.out.println("3. Tijera");
            System.out.print("Elige una opción: ");
            int jugador = teclado.nextInt();

            if (jugador < 1 || jugador > 3) {
                System.out.println("Opción no válida. Se repite la ronda.");
                ronda--;
                continue;
            }

            int maquina = aleatorio.nextInt(3) + 1;
            String[] opciones = {"", "Piedra", "Papel", "Tijera"};

            System.out.println("Tú: " + opciones[jugador]);
            System.out.println("Máquina: " + opciones[maquina]);

            if (jugador == maquina) {
                System.out.println("Empate.");
            } else if ((jugador == 1 && maquina == 3)
                    || (jugador == 2 && maquina == 1)
                    || (jugador == 3 && maquina == 2)) {
                System.out.println("¡Ganas esta ronda!");
                puntosJugador++;
            } else {
                System.out.println("Gana la máquina esta ronda.");
                puntosMaquina++;
            }
        }

        System.out.println("\nResultado final:");
        System.out.println("Tus puntos: " + puntosJugador);
        System.out.println("Puntos de la máquina: " + puntosMaquina);

        if (puntosJugador > puntosMaquina) {
            System.out.println("¡Has ganado la partida!");
        } else if (puntosJugador < puntosMaquina) {
            System.out.println("La máquina ha ganado la partida.");
        } else {
            System.out.println("La partida ha terminado en empate.");
        }

        teclado.close();
    }
}
