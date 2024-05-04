/**
 *
 * @author Group 5
 *  Design Patterns Project
 */
public class Spot
{
    private boolean empty;
    private ShipPart shipPart;
    private SpotFlyweight sign;

    public Spot(){
        this.empty = true;
        this.sign = SpotFlyweightFactory.getSpotSign(' '); 
        this.shipPart = null;
    }

    public boolean isEmpty(){
        return empty;
    }

    public void setEmpty(boolean empty){
        this.empty = empty;
    }

    public char getSign(){
        return sign.getSign();
    }

    // Set the sign of this spot to '0' using the flyweight factory
    public void setMissSign(){
        this.sign = SpotFlyweightFactory.getSpotSign('0');
    }

    public void setShipPart(ShipPart shipPart){
        this.shipPart = shipPart;
    }

    public ShipPart getShipPart(){
        return shipPart;
    }
}