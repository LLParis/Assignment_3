/**
 * 
 * @author London Paris
 *
 */
import java.util.*;


public class Polymorphic {
    
    public static boolean isSorted(Relatable[] objArray)
    {
        if (objArray == null || objArray.length < 1) {
            return true;
        }
        for (int i = 0; i < objArray.length - 1; i++) {
            if (objArray[i].isGreater(objArray[i + 1])) {
                return false;
            }
        }
    }
    
}
