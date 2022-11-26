import java.util.Arrays;
import java.util.Scanner;

public class GameOfLife {

    int numOfGenerations = 1;
    int neighborCount = 0;
    String[][] currentBoard = new String[10][10];
    String[][] nextBoard = new String[10][10];

    public void startGame() throws InterruptedException {
        System.out.println("Welcome to the Game of Life. How many generations would you like to play at most?: ");
        Scanner keyboard = new Scanner(System.in);
        numOfGenerations = Integer.parseInt(keyboard.next());
        System.out.println("Please input the initial state of the world one character \"X\" or \"-\" at a time separated by spaces.");
//        System.out.println("Example:\n" +
//                "X - - - X X - - - X\n" +
//                "X X - - - - - - X X\n" +
//                "X - X - - - - X - X\n" +
//                "X - - X - - X - - X\n" +
//                "X - - - X X - - - X\n" +
//                "X - - - X X - - - X\n" +
//                "X - - X - - X - - X\n" +
//                "X - X - - - - X - X\n" +
//                "X X - - - - - - X X\n" +
//                "X - - - X X - - - X\n");


        // Initialize current and next boards
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                currentBoard[i][j] = keyboard.next();
                nextBoard[i][j] = currentBoard[i][j];
            }
        }
        System.out.println("");

        // Generation Changes
        for (int x = 0; x < numOfGenerations; x++) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {

                    neighborCount = 0;

                    if (i > 0) {
                        if (currentBoard[i - 1][j].equals("X")) neighborCount++;
                    }
                    if (i > 0 && j < 9) {
                        if (currentBoard[i - 1][j + 1].equals("X")) neighborCount++;
                    }
                    if (j < 9) {
                        if (currentBoard[i][j + 1].equals("X")) neighborCount++;
                    }
                    if (i < 9 && j < 9) {
                        if (currentBoard[i + 1][j + 1].equals("X")) neighborCount++;
                    }
                    if (i < 9) {
                        if (currentBoard[i + 1][j].equals("X")) neighborCount++;
                    }
                    if (i < 9 && j > 0) {
                        if (currentBoard[i + 1][j - 1].equals("X")) neighborCount++;
                    }
                    if (j > 0) {
                        if (currentBoard[i][j - 1].equals("X")) neighborCount++;
                    }
                    if (i > 0 && j > 0) {
                        if (currentBoard[i - 1][j - 1].equals("X")) neighborCount++;
                    }

                    if ((neighborCount > 3) || (neighborCount < 2)) {
                        nextBoard[i][j] = "-";
                    } else if (neighborCount == 3) {
                        nextBoard[i][j] = "X";
                    }
                }
            }

            if (Arrays.deepEquals(currentBoard, nextBoard)) {
                System.out.println("Things got quiet in the Game of Life at step " + x + ".");
                break;
            }

            // Copy nextBoard to currentBoard

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    currentBoard[i][j] = nextBoard[i][j];
                }
            }

            // Print Board
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    System.out.print(currentBoard[i][j] + " ");
                }
                System.out.println("");
            }
            System.out.println("");
            Thread.sleep(750);
        }

        System.out.println("Exiting the Game of Life.");

    }

    public static void main(String[] args) throws InterruptedException {
        GameOfLife game = new GameOfLife();
        game.startGame();
    }

/*
COPY PASTE A TEMPLATE. CHOOSE ONE 10x10 GRID

X - - - X X - - - X
X X - - - - - - X X
X - X - - - - X - X
X - - X - - X - - X
X - - - X X - - - X
X - - - X X - - - X
X - - X - - X - - X
X - X - - - - X - X
X X - - - - - - X X
X - - - X X - - - X

- - - - - - - - - -
- X X X - - - - - -
- - - - - - - - - -
- - - - - - - - - -
- - - X X X - - - -
- - - - - - - - - -
- - - - - - - - - -
- - - - - - X X X -
- - - - - - - - - -
- - - - - - - - - -

X X X X X X X X X X
X - - - - - - - - X
X - - - - - - - - X
X - - - - - - - - X
X - - - - - - - - X
X - - - - - - - - X
X - - - - - - - - X
X - - - - - - - - X
X - - - - - - - - X
X X X X X X X X X X

*/
}
