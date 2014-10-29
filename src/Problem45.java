import java.util.TreeSet;

/**
 * Triangle, pentagonal, and hexagonal numbers are generated by the following
 * formulae:
 *
 * Triangle	 	Tn=n(n+1)/2	 	1, 3, 6, 10, 15, ...
 * Pentagonal	Pn=n(3n−1)/2	1, 5, 12, 22, 35, ...
 * Hexagonal	Hn=n(2n−1)	 	1, 6, 15, 28, 45, ...
 *
 * It can be verified that T285 = P165 = H143 = 40755.
 *
 * Find the next triangle number that is also pentagonal and hexagonal.
 */
public class Problem45 {

    public static void main(String[] args) {
        TreeSet<Long> t = new TreeSet<Long>();
        TreeSet<Long> p = new TreeSet<Long>();
        TreeSet<Long> h = new TreeSet<Long>();

        for(long n = 1; n <= 100000; n++) {
            t.add((n * (n + 1)) / 2);
            p.add((n * ((3 * n) - 1)) / 2);
            h.add(n * ((2 * n) - 1));
        }

        for(long n : h) {
            if(p.contains(n) && t.contains(n) && n > 40755L) {
                System.out.println(n);
            }
        }
    }

}