import java.util.TreeSet;

/**
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Problem4 {

    public static void main(String[] args) {
        TreeSet<Integer> palindromes = new TreeSet<Integer>();

        for (int i = 999; i >= 100; i--) {
            for (int j = 999; j >= 100; j--) {
                Integer t = i * j;
                Integer tR = Integer.parseInt(
                        String.valueOf(
                                new StringBuilder(t.toString()).reverse()
                        )
                );

                if (t.equals(tR)) {
                    palindromes.add(t);
                }
            }
        }

        System.out.println(palindromes.last());
    }

}
