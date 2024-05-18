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

    public Player(int id, ConsoleInput consoleInput){
        this.id = id;
        ships = new ArrayList<>();
        shipFactory = new ShipFactory();
        playerBoard = new Board();
        shootingBoard = new Board();
        assignShips(consoleInput);  // Pass the ConsoleInput object to the method
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
            ship.update();
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
    private void assignShips(ConsoleInput input){
        System.out.println("\n>> Player " + id + ", please select your ships.");
        for (int i = 0; i < 5; i++) {  // Assuming there are 5 ships to be assigned
            String shipType = input.getShipType();
            this.ships.add(shipFactory.getShip(shipType));
        }
    }
}