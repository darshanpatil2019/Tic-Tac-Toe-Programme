public class TicTacToeGame {
    public static void createBoard() {
        char[] array = new char[10];

        for (int i = 1; i <= 10; i++) {
            array[i] = ' ';
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe Game");
        createBoard();
    }

}

