/**
 * The sum of the squares of the first ten natural numbers is,
 *
 * 1^2 + 2^2 + ... + 10^2 = 385
 *
 * The square of the sum of the first ten natural numbers is,
 *
 * (1 + 2 + ... + 10)^2 = 55^2 = 3025
 *
 * Hence the difference between the sum of the squares of the first ten natural
 * numbers and the square of the sum is 3025 − 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first one hundred
 * natural numbers and the square of the sum.
 */
public class Problem6 {

    public static void main(String[] args) {
        long sum = 0L;
        long total = 0L;
        long diff = 0L;

        for (int i = 1; i <= 100; i++) {
            sum += Math.pow(i, 2);
            total += i;
        }

        total = (long) Math.pow(total, 2);
        diff = total - sum;

        System.out.println(diff);
    }

}