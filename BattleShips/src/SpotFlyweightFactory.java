import java.util.HashMap;

/**
 *
 * @author Group 5
 *  Design Patterns Project
 */
public class SpotFlyweightFactory
{
    private static final HashMap<Character, SpotFlyweight> signs = new HashMap<>();
    
    public static SpotFlyweight getSpotSign(char sign)
    {
        SpotFlyweight spotSign = signs.get(sign); // Get the existing SpotFlyweight if it exists

        if(spotSign == null){
            spotSign = new SpotFlyweight(sign); // Create a new SpotFlyweight if not found
            signs.put(sign, spotSign); // Put the new SpotFlyweight in the hash map
          
        }
        return spotSign;
    }
}