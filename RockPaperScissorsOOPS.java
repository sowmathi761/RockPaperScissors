import java.util.*;

class Game {
    private Scanner scn;
    private String[] availableMoves = {"Rock", "Paper", "Scissors"};
    private Random random;

    public Game() {
        scn = new Scanner(System.in);
        random = new Random();
    }

    // Method to get computer move
    private String getComputerMove() {
        return availableMoves[random.nextInt(availableMoves.length)];
    }

    // Method to get user move
    private String getUserMove() {
        String userMove;
        while (true) {
            System.out.println("Please choose your move from these available moves : 'Rock' 'Paper' 'Scissors' ");
            System.out.println("Enter the move you chose : ");
            userMove = scn.nextLine();

            if (userMove.equals("Rock") || userMove.equals("Paper") || userMove.equals("Scissors")) {
                System.out.println();
                break;
            }
            System.out.println();
            System.out.println("Invalid Move!!");
            System.out.println("Please enter the move from the available moves only!");
            System.out.println();
        }
        return userMove;
    }

    // Method to decide winner
    private void decideWinner(String userMove, String computerMove) {
        System.out.println("Computer chose : " + computerMove);

        if (userMove.equals(computerMove)) {
            System.out.println("Its a tie!");
        } else if (userMove.equals("Rock")) {
            if (computerMove.equals("Paper")) {
                System.out.println("Computer won!");
                System.out.println("Better luck next time!");
            } else {
                System.out.println("You won!");
                System.out.println("Congratulations!");
            }
        } else if (userMove.equals("Paper")) {
            if (computerMove.equals("Rock")) {
                System.out.println("You won!");
                System.out.println("Congratulations!");
            } else {
                System.out.println("Computer won!");
                System.out.println("Better luck next time!");
            }
        } else if (userMove.equals("Scissors")) {
            if (computerMove.equals("Paper")) {
                System.out.println("You won!");
                System.out.println("Congratulations!");
            } else {
                System.out.println("Computer won!");
                System.out.println("Better luck next time!");
            }
        }
    }

    // Method to ask play again
    private boolean playAgain() {
        String playAgain;
        System.out.println();
        System.out.println("Do you want to play again? ");
        while (true) {
            System.out.println("Type 'yes' or 'no' ");
            playAgain = scn.nextLine();
            if (playAgain.equalsIgnoreCase("yes") || playAgain.equalsIgnoreCase("no")) {
                System.out.println();
                System.out.println("*****************************************************************************");
                System.out.println();
                break;
            }
            System.out.println();
            System.out.println("Invalid Input");
            System.out.println();
        }
        return playAgain.equalsIgnoreCase("yes");
    }

    // Method to start the game
    public void start() {
        while (true) {
            String computerMove = getComputerMove();
            System.out.println("Computer has chosen its move.");
            System.out.println();
            System.out.println("Now it's your turn to choose. Good Luck!");
            System.out.println();

            String userMove = getUserMove();
            decideWinner(userMove, computerMove);

            if (!playAgain()) {
                break;
            }
        }
    }
}

public class RockPaperScissor {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
