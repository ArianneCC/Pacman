public class Pacman {

    int posFila;
    int posCol;
    private int puntos = 0;
    boolean chocoConFantasma = false;

    public Pacman(int posFila, int posCol) {
        this.posFila = posFila;
        this.posCol = posCol;
    }

    public boolean mover(char tecla, Tablero tablero, Fantasma fantasma){
        int nuevaFila = posFila;
        int nuevaCol = posCol;
        int contador = 0;
        chocoConFantasma = false;

        switch (tecla) {
            case 'W' -> nuevaFila--;
            case 'S' -> nuevaFila++;
            case 'A' -> nuevaCol--;
            case 'D' -> nuevaCol++;
        }

        if (nuevaFila == fantasma.posFila &&
                nuevaCol == fantasma.posCol) {
            chocoConFantasma = true;
            return false;
        }

        if (nuevaFila >= 0 && nuevaFila < tablero.numFilaTablero &&
                nuevaCol >= 0 && nuevaCol < tablero.numColTablero) {

            if (tablero.esTransitable(nuevaFila, nuevaCol)) {
                char casillaDestino = tablero.consultarCasilla(nuevaFila, nuevaCol);

                if (casillaDestino == '·') puntos++;
                else if (casillaDestino == '○') puntos += 20;

                posFila = nuevaFila;
                posCol = nuevaCol;
                return true;
            }
        }
        return false;
    }

    public int getPuntos() {
        return puntos;
    }

}
