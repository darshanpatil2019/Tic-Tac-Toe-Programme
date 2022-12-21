import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static Scanner sc = new Scanner(System.in);
    private static char[] boardArray = new char[10];
    private static char player1Choice;
    private static char player2Choice;

    public static void initiateBoard() { //board initialization - uc1
        for (int i = 1; i <= 9; i++) {
            boardArray[i] = ' ';
        }
    }

    public static void playerChoice() { //getting user inputs - uc2
        System.out.println("Enter Player 1 choice (X / O) : ");
        char choice = sc.next().toUpperCase().charAt(0);

        if (choice == 'X') {
            player1Choice = choice;
            player2Choice = 'O';
        } else if (choice == 'O') {
            player1Choice = choice;
            player2Choice = 'X';
        } else {
            System.out.println("You Have Entered the Wrong Choice !!");
            playerChoice();
        }
    }

    public static void showBoard() {  // ShowBoard method to display the current board
        System.out.println(" ----------- ");
        System.out.println("| " + boardArray[1] + " | " + boardArray[2] + " | " + boardArray[3] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + boardArray[4] + " | " + boardArray[5] + " | " + boardArray[6] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + boardArray[7] + " | " + boardArray[8] + " | " + boardArray[9] + " |");
        System.out.println(" ----------- ");
    }

    private static void getUserInput(int i) {
        System.out.println("Player " + i + " Enter the Position for Your Symbol :"); //Method to get user input
        int position = sc.nextInt();
        if (i % 2 == 0) {
            boardArray[position] = 'O';
        } else {
            boardArray[position] = 'X';
        }
    }

    private static boolean checkFreePosition(int enteredPosition) {
        if (enteredPosition < 1 || enteredPosition > 9) {
            System.out.println("Please Enter the position between 1 to 9 only");
            return false;
        } else if (boardArray[enteredPosition] != '_') {
            System.out.println("Entered Location Contain Symbol.Please Enter Another Location.");
            return false;
        } else {
            return true;
        }
    }

    private static int flipToss() {
        Random toss = new Random();
        int tossValue = toss.nextInt(2) + 1;
        return tossValue;
    }

    private static void gamePlay(int tossValue) {
        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) {
                if (tossValue == 2) {
                    getUserInput(1);
                } else {
                    getUserInput(2);
                }
            } else {
                getUserInput(tossValue);
            }
            showBoard();
        }
    }

    public static void main(String[] args) {
        initiateBoard();
        playerChoice();
        showBoard();
        int tossValue = flipToss();
        gamePlay(tossValue);

    }
}