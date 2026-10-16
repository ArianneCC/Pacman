void main() {

    char tecla;

    Pacman pacman = new Pacman(2, 20);
    Fantasma fantasma = new Fantasma(1, 1);
    Tablero tablero = new Tablero(20, 36);
    tablero.inicializar();
    tablero.crearLaberinto();
    tablero.colocarPacman(pacman);

    fantasma.casillaAnterior = tablero.consultarCasilla(
            fantasma.posFila, fantasma.posCol);

    tablero.colocarFantasma(fantasma);
    boolean gameOver = false;

    do {
        tecla = IO.readln("Movimiento: W = ⬆️  S = ⬇️  A = ⬅️ D = ➡️\n" +
                "Para salir pulsa 'X'\n").toUpperCase().charAt(0);

        if (tecla != 'X') {
            // Guardamos las posiciones actuales
            int filaPacmanAnterior = pacman.posFila;
            int colPacmanAnterior = pacman.posCol;

            // Intentamos mover a Pac-Man
            boolean seMovio = pacman.mover(tecla, tablero, fantasma);

            if (pacman.chocoConFantasma) {
                gameOver = true;
                IO.println("GAME OVER");
            }

            if (gameOver) {
                break;
            }

            if (seMovio) {
                tablero.tablero[filaPacmanAnterior][colPacmanAnterior] = ' ';
                tablero.colocarPacman(pacman);
            }

            fantasma.mover('D', tablero, pacman);
            tablero.colocarFantasma(fantasma);
        }

        tablero.mostrar();
        IO.println("Puntos: " + pacman.getPuntos());

    } while (tecla != 'X');
}