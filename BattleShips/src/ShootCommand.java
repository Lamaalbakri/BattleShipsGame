/**
 *
 * @author Group 5
 *  Design Patterns Project
 */
public class ShootCommand implements Command
{
    private final Player enemyPlayer;
    private final Coordinates coordinates;
    private final Board enemyBoard;
    private final Board shootingBoard;
    private final Player player;

    public ShootCommand(Player enemyPlayer, Coordinates coordinates, Board enemyBoard, Board shootingBoard, Player player){
        this.player = player;
        this.coordinates = coordinates;
        this.enemyBoard = enemyBoard;
        this.shootingBoard = shootingBoard;
        this.enemyPlayer = enemyPlayer;
    }

    @Override
    public void execute(){
        if(enemyBoard.isHit(coordinates)){
            enemyBoard.getSpot(coordinates).getShipPart().markAsHit();
            enemyPlayer.checkPlayerShips();
            shootingBoard.markHit(coordinates, enemyBoard);
        } else{
            shootingBoard.markMiss(coordinates);
        }
    }
}