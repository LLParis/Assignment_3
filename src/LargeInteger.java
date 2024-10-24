/**
 * 
 * @author London Paris
 *
 */
import java.util.*;

/**
 * LargeIntegerNumberFormatException
 * Exception thrown when a string cannot be converted to a LargeInteger
 * due to invalid format, length, or content.
 */

public class LargeInteger 
{
    private int[] num;
    private int  digitCount;
    private final int arraySize = 23;

    /**
     * No-argument constructor
     */
    public LargeInteger() {
        this.num = new int[0];
        this.digitCount = 1;
    }

    public LargeInteger(String str) {

    }

}
