/**
 *
 * @author Group 5
 *  Design Patterns Project
 */
public class Battleship extends Ship 
{
    public Battleship(){
        super(4, new ShipPart());
    }

    @Override
    public String toString(){
        return "Battleship";
    }
}