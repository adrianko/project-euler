import java.math.BigInteger;

/**
 * The Fibonacci sequence is defined by the recurrence relation:
 *
 * Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
 *
 * Hence the first 12 terms will be:
 *
 * 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144
 *
 * The 12th term, F12, is the first term to contain three digits.
 *
 * What is the first term in the Fibonacci sequence to contain 1000 digits?
 */
public class Problem25 {

    public static void main(String[] args) {
        BigInteger t1 = BigInteger.valueOf(2L);
        BigInteger t2 = BigInteger.ONE;
        BigInteger c = BigInteger.ZERO;
        int i = 3;

        while (c.toString().length() < 1000) {
            i++;
            c = t1.add(t2);
            t2 = t1;
            t1 = c;
        }

        System.out.println(i);
    }

}
