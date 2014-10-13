import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 *
 * What is the sum of the digits of the number 21000?
 */
public class Problem16 {

    public static void main(String[] args) {
        BigInteger power = new BigDecimal(Math.pow(2, 1000)).toBigInteger();

        int total = 0;
        for (char d : power.toString().toCharArray()) {
            total += Character.getNumericValue(d);
        }

        System.out.println(total);
    }

}
