import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Group 5
 *  Design Patterns Project
 */
public class Board
{ 
    private final Spot[][] spotArray;

    public Board(){
        spotArray = new Spot[10][10];
        initBoard();
    }

    public Spot[][] getSpotArray(){
        return spotArray;
    }

    public void setBoardSpotEmpty(List<Spot> spots){
        for(Spot spot : spots){
            spot.setEmpty(false);
        }
    }

    public List<Spot> getSpotsForShip(int shipSize, Orientation orientation, Coordinates coordinates){
        List<Spot> validSpots = new ArrayList<>();
        switch(orientation){
            case EAST:
                for(int i = 0; i < shipSize; i++){
                    if(this.getSpotArray()[coordinates.getX()][coordinates.getY() + i].isEmpty()){
                        validSpots.add(this.getSpotArray()[coordinates.getX()][coordinates.getY() + i]);
                    }
                }
                break;
            case WEST:
                for(int i = 0; i < shipSize; i++){
                    if(this.getSpotArray()[coordinates.getX()][coordinates.getY() - i].isEmpty()){
                        validSpots.add(this.getSpotArray()[coordinates.getX()][coordinates.getY() - i]);
                    }
                }
                break;
            case NORTH:
                for(int i = 0; i < shipSize; i++){
                    if (this.getSpotArray()[coordinates.getX() - i][coordinates.getY()].isEmpty()){
                        validSpots.add(this.getSpotArray()[coordinates.getX() - i][coordinates.getY()]);
                    }
                }
                break;
            case SOUTH:
                for(int i = 0; i < shipSize; i++){
                    if (this.getSpotArray()[coordinates.getX() + i][coordinates.getY()].isEmpty()) {
                        validSpots.add(this.getSpotArray()[coordinates.getX() + i][coordinates.getY()]);
                    }
                }
                break;
        }
        return validSpots;
    }

    public Spot getSpot(Coordinates coordinates){
        return spotArray[coordinates.getX()][coordinates.getY()];
    }

    public void markHit(Coordinates coordinates, Board enemyBoard){
        spotArray[coordinates.getX()][coordinates.getY()] = enemyBoard.getSpotArray()[coordinates.getX()][coordinates.getY()];
    }

    public boolean isHit(Coordinates coordinates){
        return !spotArray[coordinates.getX()][coordinates.getY()].isEmpty();
    }

    public void markMiss(Coordinates coordinates){
        spotArray[coordinates.getX()][coordinates.getY()].setMissSign();
    }

    private void initBoard(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                spotArray[i][j] = new Spot();
            }
        }
    }
}