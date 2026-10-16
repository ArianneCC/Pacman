public class Tablero {

    int numFilaTablero;
    int numColTablero;
    char[][] tablero;


    public Tablero(int numFilaTablero, int numColTablero) {
        this.numFilaTablero = numFilaTablero;
        this.numColTablero = numColTablero;
        tablero = new char[numFilaTablero][numColTablero];
    }

    public void inicializar() {
        //Recorremos el array asignando a cada posicion un caracter
        for (int fila = 0; fila < numFilaTablero; fila++) {
            for (int col = 0; col < numColTablero; col++) {
                tablero[fila][col] = '#';

                if (fila == 0 || fila == numFilaTablero - 1 ||
                        col == 0 || col == numColTablero - 1) {
                    tablero[fila][col] = '#';
                } else {
                    tablero[fila][col] = '-';
                }
            }
        }
    }

    public void mostrar() {
        for (int fila = 0; fila < numFilaTablero; fila++) {
            for (int col = 0; col < numColTablero; col++) {
                IO.print(tablero[fila][col]);
            }
            IO.println("");
        }
    }

    public void colocarPacman(Pacman pacman) {
        tablero[pacman.posFila][pacman.posCol] = 'P';
    }

    public void borrarPacman(Pacman pacman) {
        tablero[pacman.posFila][pacman.posCol] = '-';
    }

    public boolean esTransitable(int fila, int col) {
        return tablero[fila][col] != '#';
    }

    public void ponerPared(int fila, int col) {
        tablero[fila][col] = '#';
    }

    public void crearLaberinto() {
        for (int col = 3; col < 10; col++) {
            ponerPared(5, col);
        }
    }

}
