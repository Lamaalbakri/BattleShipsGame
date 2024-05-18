import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Group 5
 *  Design Patterns Project
 */
public class ShipPart
{
    private List<Observer> observers = new ArrayList<>();
    private int status;
    private char sign;

    public static final int ALIVE = 0;
    public static final int HIT = 1;
    public static final int SUNK = 2;

    public ShipPart(){
        this.status = ALIVE;
        this.sign = '@';
    }

    public void markAsHit(){
        status = HIT;
        sign = '!';
        notifyObservers();
    }

    public void markAsSunk(){
        this.status = SUNK;
        this.sign = 'X';
        notifyObservers();
    }
    
    public void attach(Observer observer){
        observers.add(observer);
    }
    
    public void detach(Observer observer){
        observers.remove(observer);
    }
    
    private void notifyObservers(){
        for(Observer observer : observers){
            observer.update();
        }
    }

    public int getStatus(){
        return status;
    }

    public char getSign(){
        return sign;
    }
}