/**
 * 
 * @author London Paris
 *
 */

/**
 * LargeIntegerNumberFormatException
 * Exception thrown when a string cannot be converted to a LargeInteger
 * due to invalid format, length, or content.
 */
public class LargeIntegerNumberFormatException extends RuntimeException {
    public LargeIntegerNumberFormatException(String message) {
        super(message);
    }
}
