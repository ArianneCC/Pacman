import java.util.ArrayList;
import java.util.Arrays;

public class Fantasma {
    int posFila;
    int posCol;
    char casillaAnterior = ' ';

    public Fantasma(int posFila, int posCol) {
        this.posFila = posFila;
        this.posCol = posCol;
    }

    private boolean dentroTablero(int fila, int col, Tablero tablero) {
        return fila >= 0 && fila < tablero.numFilaTablero
                && col >= 0 && col < tablero.numColTablero;
    }

    private ArrayList<int[]> buscarCasillas(Tablero tablero, Pacman pacman) {
        int[][] anteriorFila = new int[tablero.numFilaTablero][tablero.numColTablero];
        int[][] anteriorCol = new int[tablero.numFilaTablero][tablero.numColTablero];
        boolean[][] visitado = new boolean[tablero.numFilaTablero][tablero.numColTablero];

        ArrayList<int[]> cola = new ArrayList<>();
        cola.add(new int[]{posFila, posCol});

        visitado[posFila][posCol] = true;

        int[] movimientosFila = {-1, 1, 0, 0};
        int[] movimientosCol = {0, 0, -1, 1};

        for (int i = 0; i < cola.size(); i++) {
            int[] actual = cola.get(i);

            if (actual[0] == pacman.posFila && actual[1] == pacman.posCol) {
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nuevaFila = actual[0] + movimientosFila[d];
                int nuevaCol = actual[1] + movimientosCol[d];

                if (dentroTablero(nuevaFila, nuevaCol, tablero)
                        && !visitado[nuevaFila][nuevaCol]
                        && tablero.consultarCasilla(nuevaFila, nuevaCol) != '#') {

                    visitado[nuevaFila][nuevaCol] = true;

                    anteriorFila[nuevaFila][nuevaCol] = actual[0];
                    anteriorCol[nuevaFila][nuevaCol] = actual[1];

                    cola.add(new int[]{nuevaFila, nuevaCol});
                }
            }
        }

        int fila = pacman.posFila;
        int col = pacman.posCol;

        while (fila != posFila || col != posCol) {
            int filaAnterior = anteriorFila[fila][col];
            int colAnterior = anteriorCol[fila][col];

            fila = filaAnterior;
            col = colAnterior;
        }

        return cola;
    }

    public boolean mover(char tecla, Tablero tablero, Pacman pacman){

        int nuevaFila = posFila;
        int nuevaCol = posCol;

        switch (tecla) {
            case 'W' -> nuevaFila--;
            case 'S' -> nuevaFila++;
            case 'A' -> nuevaCol--;
            case 'D' -> nuevaCol++;
        }

        if (nuevaFila >= 0 && nuevaFila < tablero.numFilaTablero &&
                nuevaCol >= 0 && nuevaCol < tablero.numColTablero) {

            if (nuevaFila == pacman.posFila &&
                    nuevaCol == pacman.posCol) {
                return false;
            }

            if (tablero.esTransitable(nuevaFila, nuevaCol)) {
                tablero.tablero[posFila][posCol] = casillaAnterior;

                casillaAnterior = tablero.consultarCasilla(nuevaFila, nuevaCol);

                posFila = nuevaFila;
                posCol = nuevaCol;
                return true;
            }
        }

        return false;
    }
}