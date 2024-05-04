import java.util.List;

/**
 *
 * @author Group 5
 *  Design Patterns Project
 */

public class Game
{
    private static Game game = null;
    private final Player player1;
    private final Player player2;
    private boolean gameIsRunning;
    private final ConsoleView consoleView;
    private final ConsoleInput consoleInput;

    private Game(){
        consoleView = new ConsoleView();
        consoleInput = new ConsoleInput();
        player1 = new Player(1, consoleInput);
        player2 = new Player(2, consoleInput);
        gameIsRunning = true;
    }
    // This method returns an instance of the 'Game' class
    public static Game getGame(){
        if(game == null){
            game = new Game(); // Creates a new instance 
        }
        return game;
    }
    
    public void startGame(){
        //Set Ships for players
        playerSetsShips(player1);
        playerSetsShips(player2);

        Player player = player1;
        while(gameIsRunning){
            Coordinates coordinates;
            Board enemyBoard = getAnotherPlayer(player).getPlayerBoard();
            Board playerBoard = player.getPlayerBoard();
            Board shootingBoard = player.getShootingBoard();
            Player enemyPlayer = getAnotherPlayer(player);

            consoleView.printMessage(player.toString());
            consoleView.printBoard(playerBoard);
            consoleView.printBoard(shootingBoard);
            coordinates = consoleInput.getCoordinates();
            if(enemyBoard.isHit(coordinates)){
                enemyBoard.getSpot(coordinates).getShipPart().markAsHit();
                enemyPlayer.checkPlayerShips();
                shootingBoard.markHit(coordinates, enemyBoard);
            } 
            else{
                shootingBoard.markMiss(coordinates);
            }

            doesEnemyLose(enemyPlayer);
            if(gameIsRunning){
                consoleView.printBoard(playerBoard);
                consoleView.printBoard(shootingBoard);
                consoleInput.pressAnyKeyToContinue();
                player = getAnotherPlayer(player);
            } 
            else{
                consoleView.printBoard(shootingBoard);
                consoleView.printCongratulations(player);
            }
        }
    }

    private void doesEnemyLose(Player enemyPlayer){
        if(enemyPlayer.getShips().isEmpty()){
            gameIsRunning = false;
        }
    }

    private Player getAnotherPlayer(Player player){
        return player.equals(player1) ? player2 : player1;
    }

    private void playerSetsShips(Player player){
        Coordinates coordinates;
        Orientation orientation;
        List<Spot> validSpots;

        consoleView.printMessage(player.toString());
        for (Ship ship : player.getShips()) {
            consoleView.printMessage("Place your " + ship + "! Size: " + ship.getSize());
            consoleView.printBoard(player.getPlayerBoard());
            coordinates = consoleInput.getCoordinates();
            consoleView.askForOrientation();
            orientation = consoleInput.getOrientation();
            validSpots = player.getPlayerBoard().getSpotsForShip(ship.getSize(), orientation, coordinates);
            player.placeShip(ship, validSpots);
        }
        consoleView.printBoard(player.getPlayerBoard());
        consoleInput.pressAnyKeyToContinue();
    }
}