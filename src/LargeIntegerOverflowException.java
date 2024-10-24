/**
 * 
 * @author London Paris
 *
 */

/**
 * LargeIntegerOverflowException
 * Exception thrown when arithmetic operations on LargeIntegers
 * results in numbers that exceed the maximum allowed length (23 digits).
 */
public class LargeIntegerOverflowException extends RuntimeException {
    public LargeIntegerOverflowException(String message) {
        super(message);
    }
}
