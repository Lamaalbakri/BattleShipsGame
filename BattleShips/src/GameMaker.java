/**
 *
 * @author Group 5
 *  Design Patterns Project
 */

// Facade Class
public class GameMaker
{
    private Game game;

    public GameMaker(){
        game = Game.getGame();
    }

    public void startGame(){
        game.startGame();
    }
}