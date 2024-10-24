/**
 * 
 * @author London Paris
 *
 */
import java.util.*;
import java.io.*;

public class LargeInteger extends HasState implements Relatable, Serializable {
    private int[] num;
    private int  digitCount;
    private final int arraySize = 23;

    /**
     * No-argument constructor
     */
    public LargeInteger() {
        this.num = new int[arraySize];
        num[0] = 0;
        this.digitCount = 1;
    }

    public LargeInteger(String numberStr) {
        if (numberStr == null || numberStr.isEmpty()) {
            throw new LargeIntegerNumberFormatException("Empty or null string");
        }
        if (numberStr.length() > arraySize) {
            throw new LargeIntegerNumberFormatException("Number too large (max 23 digits");
        }

        for (char c: numberStr.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new LargeIntegerNumberFormatException("Invalid character in number");
            }
        }

        num = new int[arraySize];
        digitCount = numberStr.length();

        // Store digits in reverse
        for (int i = 0; i < digitCount; i++) {
            num[i] = numberStr.charAt(digitCount - 1 - i) - '0';
        }
    }

    /**
     * Returns the number of digits in this LargeInteger
     * @return the digit count
     */
    public int digitCount() {
        return digitCount;
    }

    /**
     * Converts the LargeInteger to its string representation
     * @return String representation of the number
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = digitCount - 1; i >= 0; i--) {
            result.append(num[i]);
        }
        return result.toString();
    }

    public LargeInteger add(LargeInteger other) {
        int maxLength = Math.max(this.digitCount, other.digitCount);
        int carry = 0;
        LargeInteger result = new LargeInteger();
        result.digitCount = 0;

        for (int i = 0; i < maxLength || carry > 0; i++) {
            int sum = carry;
            if (i < this.digitCount) sum += this.num[i];
            if (i < other.digitCount) sum += other.num[i];

            if (i >= arraySize) {
                throw new LargeIntegerOverflowException("Result exceeds maximum length");
            }

            result.num[i] = sum % 10;
            carry = sum / 10;
            result.digitCount++;
        }

        return result;
    }

    /**
     * Creates a deep copy of this LargeInteger
     * @return a new LargeInteger with the same value
     */
    @Override
    public Object clone() {
        LargeInteger copy = new LargeInteger();
        copy.digitCount = this.digitCount;
        copy.num = new int[arraySize];
        System.arraycopy(this.num, 0, copy.num, 0, arraySize);
        return copy;
    }

    // Relatable interface implementations
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof LargeInteger)) return false;
        LargeInteger otherNum = (LargeInteger) other;

        if (this.digitCount != otherNum.digitCount) return false;

        for (int i = 0; i < digitCount; i++) {
            if (this.num[i] != otherNum.num[i]) return false;
        }
        return true;
    }

    @Override
    public boolean isGreater(Object other) {
        if (!(other instanceof LargeInteger)) return false;
        LargeInteger otherNum = (LargeInteger) other;

        if (this.digitCount != otherNum.digitCount) {
            return this.digitCount > otherNum.digitCount;
        }

        for (int i = digitCount - 1; i >= 0; i--) {
            if (this.num[i] != otherNum.num[i]) {
                return this.num[i] > otherNum.num[i];
            }
        }
        return false;
    }

    @Override
    public boolean isLess(Object other) {
        if (!(other instanceof LargeInteger)) return false;
        return !equals(other) && !isGreater(other);
    }
}

