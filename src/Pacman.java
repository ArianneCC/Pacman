public class Pacman {

    int posFila;
    int posCol;

    public Pacman(int posFila, int posCol) {
        this.posFila = posFila;
        this.posCol = posCol;
    }

    public void mover(char tecla, Tablero tablero) {
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

            if (tablero.esTransitable(nuevaFila, nuevaCol)) {
                posFila = nuevaFila;
                posCol = nuevaCol;
            }
        }
    }
}
