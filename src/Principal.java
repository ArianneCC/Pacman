void main() {

    char tecla;

    Pacman pacman = new Pacman(2, 20);
    Tablero tablero = new Tablero(10, 36);
    tablero.inicializar();
    tablero.crearLaberinto();
    tablero.colocarPacman(pacman);


    do {
        tecla = IO.readln("Movimiento: W = ⬆️  S = ⬇️  A = ⬅️ D = ➡️\n" +
                "Para salir pulsa 'X'\n").toUpperCase().charAt(0);

        if (tecla != 'X') {
            tablero.borrarPacman(pacman);
            pacman.mover(tecla, tablero);
            tablero.colocarPacman(pacman);
        }

        tablero.mostrar();

    } while (tecla != 'X');
}