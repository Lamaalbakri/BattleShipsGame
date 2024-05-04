import java.util.Scanner;

/**
 *
 * @author Group 5
 *  Design Patterns Project
*/

public class BattleshipsDemo
{
    public static void main(String[] args)
    {        
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n >>> WELCOME TO BATTLESHIPS GAME <<<" + 
                "\n1. Start Game" +
                "\n2. Exit");
        int choice = scanner.nextInt();
        
        switch(choice){
            case 1:
                GameMaker gameMaker = new GameMaker();
                gameMaker.startGame();
                break;
            case 2:
                System.exit(0);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }
    }
}