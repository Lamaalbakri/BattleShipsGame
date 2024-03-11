import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Group 5
 *  Design Patterns Project
 */

public class MainMenu
{
    public MainMenu(){
        List<String> menuOptions = new ArrayList<>();
        ConsoleView consoleView = new ConsoleView();
        ConsoleInput consoleInput = new ConsoleInput();

        menuOptions.add("Start Game");
        menuOptions.add("Exit");

        consoleView.printMenu(menuOptions);
        executeOrder(consoleInput.chooseMenuOption());
    }

    public void executeOrder(int i){
        switch(i){
            case 1:
                Game game = Game.getGame();
                game.startGame();
                break;
            case 2:
                System.exit(0);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + i);
        }
    }
}