import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * A permutation is an ordered arrangement of objects. For example, 3124 is one
 * possible permutation of the digits 1, 2, 3 and 4. If all of the permutations
 * are listed numerically or alphabetically, we call it lexicographic order. The
 * lexicographic permutations of 0, 1 and 2 are:
 *
 * 012   021   102   120   201   210
 *
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4,
 * 5, 6, 7, 8 and 9?
 */
public class Problem24 {

    static TreeSet<Long> permutations = new TreeSet<Long>();

    public static void main(String[] args) {

        ArrayList<Integer> possibles = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        perm(possibles);

        int i = 0;
        for (long f : permutations) {
            if (String.valueOf(f).length() == 10 ||
                    (String.valueOf(f).length() == 9
                            && !String.valueOf(f).contains("0"))
                    ) {
                i++;

                if (i == 1000000) {
                    System.out.println(f);
                }
            }
        }

    }

    public static void perm(ArrayList<Integer> a) {
        ArrayList<Integer> sub = new ArrayList<Integer>();
        perm(sub, a);
    }

    public static void perm(ArrayList<Integer> sub, ArrayList<Integer> a) {
        int size = a.size();
        if (size == 0) {
            permutations.add(compress(sub));
        } else {
            permutations.add(compress(sub));

            for (int i = 0; i < size; i++) {
                ArrayList<Integer> ab = new ArrayList<Integer>(sub);
                ab.add(a.get(i));

                ArrayList<Integer> bc = new ArrayList<Integer>(a);
                bc.remove(i);

                perm(ab, bc);
            }
        }
    }

    public static long compress(ArrayList<Integer> sub) {
        if (sub.size() == 0) {
            return 0L;
        }

        String num = "";
        for (int i : sub) {
            num += String.valueOf(i);
        }

        return Long.parseLong(num);
    }

}
