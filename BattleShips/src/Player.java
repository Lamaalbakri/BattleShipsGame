import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 *
 * @author Group 5
 *  Design Patterns Project
 */

public class Player
{
    private final List<Ship> ships;
    private final Board playerBoard; 
    private final Board shootingBoard;
    private final ShipFactory shipFactory;
    private final int id;

    public Player(int id){
        ships = new ArrayList<>();
        shipFactory = new ShipFactory(); // Initializes the shipFactory variable by creating a new instance of the 'ShipFactory' class.
        playerBoard = new Board();
        shootingBoard = new Board();
        this.id = id;
        assignShips();
    }

    public void placeShip(Ship ship, List<Spot> validSpots){
        if (validSpots.size() == ship.getSize()) {
            ship.setShipParts(validSpots);
            playerBoard.setBoardSpotEmpty(validSpots);
        }
    }

    public List<Ship> getShips(){
        return ships;
    }

    public Board getPlayerBoard(){
        return playerBoard;
    }

    public Board getShootingBoard(){
        return shootingBoard;
    }

    public void checkPlayerShips(){
        for(Ship ship : ships){
            ship.checkShipPartStatus();
        }
        removeSunkShip();
    }

    @Override
    public String toString(){
        return "Player " + id;
    }

    private void removeSunkShip(){
        try{
            Ship ship = ships.stream()
                    .filter(Ship::isSunk)
                    .findAny()
                    .orElse(null);
            ships.remove(ship); // TODO if(ship != null) {ships.remove(ship);}
        } 
        catch(NoSuchElementException ignored) {}
    }
    
    /**
      This method uses the factory pattern to create ship objects using the shipFactory instance
      and adds them to a collection called ships.
    */
    private void assignShips(){ 
        this.ships.add(shipFactory.getShip("Carrier")); // size 5
        this.ships.add(shipFactory.getShip("Battleship")); // size 4
        this.ships.add(shipFactory.getShip("Cruiser")); // size 3
        this.ships.add(shipFactory.getShip("Submarine")); // size 3
        this.ships.add(shipFactory.getShip("Destroyer")); // size 2
    }
}