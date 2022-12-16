import java.util.Scanner;

public class TicTacToe {

    static Scanner sc = new Scanner(System.in);
    private static char[] boardArray = new char[10];
    private static char player1Choice;
    private static char player2Choice;

    public static void initiateBoard() { //board initialization - uc1
        for (int i = 1; i <= boardArray.length; i++) {
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

    public static void main(String[] args) {
        initiateBoard();
        playerChoice();
    }
}