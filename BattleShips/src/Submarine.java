/**
 *
 * @author Group 5
 *  Design Patterns Project
 */
public class Submarine extends Ship
{
    public Submarine(){
        super(3, new ShipPart());
    }

    @Override
    public String toString(){
        return "Submarine";
    }
}