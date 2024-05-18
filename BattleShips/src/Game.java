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
    private Command currentCommand;
    private Player currentPlayer;

    private Game() {
        consoleView = new ConsoleView();
        consoleInput = new ConsoleInput();
        player1 = new Player(1, consoleInput);
        player2 = new Player(2, consoleInput);
        gameIsRunning = true;
        currentPlayer = player1; // Initialize the current player
    }

    public static Game getGame() {
        if (game == null) {
            game = new Game(); // Creates a new instance
        }
        return game;
    }

    public void startGame() {
        // Set Ships for players
        playerSetsShips(player1);
        playerSetsShips(player2);

        while (gameIsRunning) {
            Coordinates coordinates;
            Board enemyBoard = getAnotherPlayer(currentPlayer).getPlayerBoard();
            Board playerBoard = currentPlayer.getPlayerBoard();
            Board shootingBoard = currentPlayer.getShootingBoard();
            Player enemyPlayer = getAnotherPlayer(currentPlayer);

            consoleView.printMessage(currentPlayer.toString());
            consoleView.printBoard(playerBoard);
            consoleView.printBoard(shootingBoard);
            coordinates = consoleInput.getCoordinates();

            Command shootCommand = new ShootCommand(enemyPlayer, coordinates, enemyBoard, shootingBoard, currentPlayer);
            executeCommand(shootCommand);

            if (gameIsRunning) {
                consoleView.printBoard(playerBoard);
                consoleView.printBoard(shootingBoard);
                consoleInput.pressAnyKeyToContinue();
                currentPlayer = getAnotherPlayer(currentPlayer);
            } else {
                consoleView.printBoard(shootingBoard);
                consoleView.printCongratulations(currentPlayer);
            }
        }
    }

    public void executeCommand(Command command) {
        currentCommand = command;
        currentCommand.execute();
        // Check if the enemy player has lost after executing the command
        doesEnemyLose(getAnotherPlayer(currentPlayer));
    }

    private void doesEnemyLose(Player enemyPlayer) {
        if (enemyPlayer.getShips().isEmpty()) {
            gameIsRunning = false;
        }
    }

    private Player getAnotherPlayer(Player player) {
        return player.equals(player1) ? player2 : player1;
    }

    private void playerSetsShips(Player player) {
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

            Command placeShipCommand = new PlaceShipCommand(player, ship, validSpots);
            executeCommand(placeShipCommand);
        }

        consoleView.printBoard(player.getPlayerBoard());
        consoleInput.pressAnyKeyToContinue();
    }

    public boolean isGameRunning() {
        return gameIsRunning;
    }

    public void setGameIsRunning(boolean gameIsRunning) {
        this.gameIsRunning = gameIsRunning;
    }
}