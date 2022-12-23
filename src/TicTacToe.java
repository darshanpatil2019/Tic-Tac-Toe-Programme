import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static Scanner sc = new Scanner(System.in);
    private static char[] boardArray = new char[10];
    private static char player1Choice, player2Choice;
    private static int player1Play = 1;

    private static void initializeBoard() {
        for (int i = 1; i < 10; i++) {
            boardArray[i] = '_';
        }
    }

    private static void setPlayingSymbol() {
        while (player1Choice != 'X' && player1Choice != 'O') {
            System.out.println("Player 1, Please Select the Symbol for Play :- X or O");
            player1Choice = sc.next().charAt(0);
            switch (player1Choice) {
                case 'X':
                    player2Choice = 'O';
                    System.out.println("Player 1 Selected " + player1Choice + " Symbol");
                    System.out.println("Player 2 Selected " + player2Choice + " Symbol");
                    break;
                case 'O':
                    player2Choice = 'X';
                    System.out.println("Player 1 Selected " + player1Choice + " Symbol");
                    System.out.println("Player 2 Selected " + player2Choice + " Symbol");
                    break;
                default:
                    System.out.println("Please Select the Symbol From X or O only");
                    break;
            }
        }
    }

    public static void showBoard() {  // ShowBoard method to display the current board
        //System.out.println(" ----------- ");
        System.out.println("| " + boardArray[1] + " | " + boardArray[2] + " | " + boardArray[3] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + boardArray[4] + " | " + boardArray[5] + " | " + boardArray[6] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + boardArray[7] + " | " + boardArray[8] + " | " + boardArray[9] + " |");
        //System.out.println(" ----------- ");
    }

    private static void setPlayChance() {
        if (player1Play == 1) {
            player1Play = 0;
        } else {
            player1Play = 1;
        }
    }

    private static void playGame() {
        if (player1Play == 1) {
            getUseInput(1, player1Choice);
        } else {
            getUseInput(2, player2Choice);
        }
        setPlayChance();
    }

    private static void getUseInput(int playerNo, char symbol) {

        int playerPosition;
        System.out.println("Player " + playerNo + " Please Enter the Position for Your Play :");
        playerPosition = sc.nextInt();
        if (checkFreePosition(playerPosition)) {
            boardArray[playerPosition] = symbol;
        } else {
            playGame();
            setPlayChance();
        }
    }

    private static boolean checkFreePosition(int enteredPosition) {
        if (enteredPosition < 1 || enteredPosition > 9) {
            System.out.println("Please Enter the Position between 1 to 9 only");
            return false;
        } else if (boardArray[enteredPosition] != '_') {
            System.out.println("Entered Location Contain Symbol. Please Enter Another Location");
            return false;
        } else {
            return true;
        }
    }

    private static void flipToss() {
        Random tossValue = new Random();
        int toss = tossValue.nextInt(2) + 1;
        if (toss == 1) {
            player1Play = 1;
            System.out.println("Player 1 Won the Toss");
        } else {
            player1Play = 0;
            System.out.println("Player 2 Won the Toss");
        }
    }

    private static boolean checkWin() {
        if (checkDraw()) {
            System.out.println("The Game is Draw as there is no any location for Player Symbol");
            showBoard();
            return true;
        } else {
            if (checkDiagonal() || checkColumnWin() || checkRowWin()) {
                if (player1Play == 0) {
                    System.out.println("Player 1 WON THE GAME!");
                } else {
                    System.out.println("Player 2 WON THE GAME!");
                }
                showBoard();
                return true;
            }
        }
        return false;
    }

    private static boolean checkDraw() {
        boolean flag = true;
        for (int i = 1; i <= 9; i++) {
            if (boardArray[i] == '_') {
                flag = false;
            }
        }
        return flag;
    }

    private static boolean checkDiagonal() {
        if (!(boardArray[1] == '_') && boardArray[1] == boardArray[5] && boardArray[1] == boardArray[9]
                || !(boardArray[3] == '_') && boardArray[3] == boardArray[5] && boardArray[3] == boardArray[7]) {
            return true;
        }
        return false;
    }

    private static boolean checkRowWin() {
        for (int i = 1; i < boardArray.length; i += 3) {
            if (!(boardArray[i] == '_') && boardArray[i] == boardArray[i + 1] && boardArray[i] == boardArray[i + 2]) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkColumnWin() {
        for (int i = 1; i <= 3; i++) {
            if (!(boardArray[i] == '_') && boardArray[i] == boardArray[i + 3] && boardArray[i] == boardArray[i + 6]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println("Welcome to Tic Tac Toe Game");
        char userChoice;
        //Play the Game till Win or Draw
        do {
            initializeBoard(); //Set the new Game
            setPlayingSymbol(); //Set the Symbol for Play
            showBoard(); // Showing the Initial Board
            flipToss(); // Flip the Toss for Player's Chancce
            while(!checkWin()) {
                playGame();
                showBoard();
            }
            System.out.println("Do you want to Play Again? (Y/N) :");
            userChoice = sc.next().charAt(0);
        } while(userChoice == 'Y');
    }
}

