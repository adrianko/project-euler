import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

/**
 * The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.
 *
 * Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
 */
public class Problem48 {

    public static void main(String[] args) {
        List<BigInteger> totals = new LinkedList<BigInteger>();

        for(Integer i = 1; i <= 1000; i++) {
            totals.add(new BigInteger(i.toString()).pow(i));
        }

        BigInteger total = BigInteger.valueOf(0);
        for(BigInteger t : totals) {
            total = total.add(t);
        }

        String totalStr = total.toString();
        System.out.println(totalStr.substring(totalStr.length() - 10));
    }

}
