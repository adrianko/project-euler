import java.util.Arrays;

/**
 * It can be seen that the number, 125874, and its double, 251748, contain
 * exactly the same digits, but in a different order.
 *
 * Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x,
 * contain the same digits.
 */
public class Problem52 {

    public static void main(String[] args) {
        boolean found = false;
        int i = 0;

        while(!found) {
            i++;
            found = true;

            char[] iC = Integer.toString(i).toCharArray();
            Arrays.sort(iC);
            String iS = String.valueOf(iC);

            for(int j = 2; j <= 6; j++) {
                char[] d = Integer.toString(j * i).toCharArray();
                Arrays.sort(d);
                String p = String.valueOf(d);

                if(!iS.equals(p)) {
                    found = false;
                    break;
                }
            }
        }

        System.out.println(i);

    }

}
