/**
 *
 * @author Group 5
 *  Design Patterns Project
 */
public class Cruiser extends Ship
{
    public Cruiser(){
        super(3, new ShipPart());
    }

    @Override
    public String toString(){
        return "Cruiser";
    }
}