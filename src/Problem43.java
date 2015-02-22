import java.util.HashSet;
import java.util.Set;

/**
 * The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some order,
 * but it also has a rather interesting sub-string divisibility property.
 *
 * Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:
 *
 * d2 d3 d4 = 406 is divisible by 2
 * d3 d4 d5 = 063 is divisible by 3
 * d4 d5 d6 = 635 is divisible by 5
 * d5 d6 d7 = 357 is divisible by 7
 * d6 d7 d8 = 572 is divisible by 11
 * d7 d8 d9 = 728 is divisible by 13
 * d8 d9 d10 = 289 is divisible by 17
 *
 * Find the sum of all 0 to 9 pandigital numbers with this property.
 */
public class Problem43 {

    public static void main(String[] args) {
        Set<String> digits = permutate("0123456789");
        Set<Long> total = new HashSet<>();

        for (String s : digits) {
            if (getDigits(s, 2) % 2 != 0) continue;
            if (getDigits(s, 3) % 3 != 0) continue;
            if (getDigits(s, 4) % 5 != 0) continue;
            if (getDigits(s, 5) % 7 != 0) continue;
            if (getDigits(s, 6) % 11 != 0) continue;
            if (getDigits(s, 7) % 13 != 0) continue;
            if (getDigits(s, 8) % 17 != 0) continue;

            total.add(Long.parseLong(s));
        }

        long result = total.stream().reduce(0L, (a, b) -> a + b);
        System.out.println(result);
    }

    public static int getDigits(String s, int start) {
        return Integer.parseInt(s.substring(start - 1, start + 2));
    }

    public static Set<String> permutate(String str) {
        return permutate("", str, new HashSet<>());
    }

    private static Set<String> permutate(String prefix, String str, Set<String> perms) {
        if (str.length() == 0) {
            perms.add(prefix);
        }

        for (int i = 0; i < str.length(); i++) {
            permutate(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1), perms);
        }

        return perms;
    }

}