/**
 *
 * @author Group 5
 *  Design Patterns Project
 */

// ShipFactory class that implements a factory method pattern.
public class ShipFactory 
{
    public Ship getShip(String shipType)
    {
        if(shipType.equals("Battleship")){
            return new Battleship();
        }
        else if(shipType.equals("Carrier")){
            return new Carrier();
        }
        else if(shipType.equals("Destroyer")){
            return new Destroyer();
        }
        else if(shipType.equals("Cruiser")){
            return new Cruiser();
        }
        else if(shipType.equals("Submarine")){
            return new Submarine();
        }
        else{
            throw new IllegalArgumentException("Invalid ship type: " + shipType);
        }
    }
}