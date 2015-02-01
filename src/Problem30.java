/**
 * Surprisingly there are only three numbers that can be written as the sum of 
 * fourth powers of their digits:
 * 
 * 1634 = 1^4 + 6^4 + 3^4 + 4^4
 * 8208 = 8^4 + 2^4 + 0^4 + 8^4
 * 9474 = 9^4 + 4^4 + 7^4 + 4^4
 * 
 * As 1 = 1^4 is not a sum it is not included.
 * 
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 * 
 * Find the sum of all the numbers that can be written as the sum of fifth 
 * powers of their digits.
 */
public class Problem30 {

    public static void main(String[] args) {
        int total = 0;

        for (int i = 2; i <= (int) (Math.pow(9, 5) * 5); i++) {
            char[] digits = String.valueOf(i).toCharArray();
            int sum = 0;

            for (char d : digits) {
                sum += Math.pow(Character.getNumericValue(d), 5);
            }

            if (sum == i) {
                total += i;
            }
        }

        System.out.println(total);
    }

}