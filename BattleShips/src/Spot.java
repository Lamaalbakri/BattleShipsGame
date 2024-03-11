/**
 *
 * @author Group 5
 *  Design Patterns Project
 */

public class Spot
{
    private boolean empty;
    private char sign;
    private ShipPart shipPart;

    public Spot(){
        this.empty = true;
        this.sign = ' ';
        this.shipPart = null;
    }

    public boolean isEmpty(){
        return empty;
    }

    public void setEmpty(boolean empty){
        this.empty = empty;
    }

    public char getSign(){
        return sign;
    }

    public void setMissSign(){
        this.sign = '0';
    }

    public void setShipPart(ShipPart shipPart){
        this.shipPart = shipPart;
    }

    public ShipPart getShipPart(){
        return shipPart;
    }
}