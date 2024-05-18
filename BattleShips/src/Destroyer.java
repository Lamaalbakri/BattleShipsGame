/**
 *
 * @author Group 5
 *  Design Patterns Project
 */
public class Destroyer extends Ship
{
    public Destroyer(){
        super(2, new ShipPart());
    }

    @Override
    public String toString(){
        return "Destroyer";
    }
}