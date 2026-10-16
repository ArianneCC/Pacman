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
                    tablero[fila][col] = '·';
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

    public void colocarFantasma(Fantasma fantasma) {
        fantasma.casillaAnterior = consultarCasilla(
                fantasma.posFila, fantasma.posCol);
        tablero[fantasma.posFila][fantasma.posCol] = 'F';
    }

    public void borrarPacman(Pacman pacman) {
        tablero[pacman.posFila][pacman.posCol] = ' ';
    }

    public boolean esTransitable(int fila, int col) {
        return tablero[fila][col] != '#';
    }

    public void ponerPared(int fila, int col) {
        tablero[fila][col] = '#';
    }

    public void crearLaberinto() {
        // Paredes horizontales con aberturas
        for (int col = 4; col < 15; col++) {
            if (col != 9) {
                ponerPared(4, col);
            }
        }

        for (int col = 20; col < 32; col++) {
            if (col != 26) {
                ponerPared(9, col);
            }
        }

        // Paredes verticales con aberturas
        for (int fila = 6; fila < 16; fila++) {
            if (fila != 11) {
                ponerPared(fila, 8);
            }
        }

        for (int fila = 3; fila < 13; fila++) {
            if (fila != 7) {
                ponerPared(fila, 27);
            }
        }

        ponerPildora(2, 5);
        ponerPildora(15, 30);
        ponerPildora(17, 12);
    }

    public char consultarCasilla(int fila, int col) {
        return tablero[fila][col];
    }

    public void ponerPildora(int fila, int col) {
        tablero[fila][col] = '○';
    }
}
