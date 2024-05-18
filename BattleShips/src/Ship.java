import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Group 5
 *  Design Patterns Project
 */
public abstract class Ship extends Observer
{
    private final int size;
    private boolean sunk;
    private final List<ShipPart> shipParts;


    public Ship(int size, ShipPart shipPart){
        this.size = size;
        this.sunk = false;
        this.shipParts = new ArrayList<>();
        shipPart.attach(this);
    }

    public int getSize(){
        return size;
    }

    public void setShipParts(List<Spot> spots){
        for(Spot spot : spots){
            ShipPart shipPart = new ShipPart();
            shipParts.add(shipPart);
            spot.setShipPart(shipPart);
        }
    }
    
    @Override
    public void update(){
        if(shipParts.stream().noneMatch(part -> (part.getStatus() == ShipPart.ALIVE))){
            for(ShipPart part : shipParts){
                if(part.getStatus() != ShipPart.SUNK){
                    part.markAsSunk();
                }
            }
            this.sunk = true;
        }
    }

    public boolean isSunk(){
        return sunk;
    }
}