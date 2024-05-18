/**
 *
 * @author Group 5
 *  Design Patterns Project
 */
public class Carrier extends Ship
{
    public Carrier(){
        super(5, new ShipPart());
    }

    @Override
    public String toString(){
        return "Carrier";
    }
}