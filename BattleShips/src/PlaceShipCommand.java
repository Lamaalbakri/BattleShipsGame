import java.util.List;

/**
 *
 *  @author Group 5
 *  Design Patterns Project
 */
public class PlaceShipCommand implements Command
{
    private final Player player;
    private final Ship ship;
    private final List<Spot> validSpots;

    public PlaceShipCommand(Player player, Ship ship, List<Spot> validSpots){
        this.player = player;
        this.ship = ship;
        this.validSpots = validSpots;
    }

    @Override
    public void execute(){
        player.placeShip(ship, validSpots);
    }
}