/**
 * Take the number 192 and multiply it by each of 1, 2, and 3:
 *
 * 192 × 1 = 192
 * 192 × 2 = 384
 * 192 × 3 = 576
 *
 * By concatenating each product we get the 1 to 9 pandigital, 192384576. We
 * will call 192384576 the concatenated product of 192 and (1,2,3)
 *
 * The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4,
 * and 5, giving the pandigital, 918273645, which is the concatenated product
 * of 9 and (1,2,3,4,5).
 *
 * What is the largest 1 to 9 pandigital 9-digit number that can be formed as
 * the concatenated product of an integer with (1,2, ... , n) where n > 1?
 */
public class Problem38 {

    public static void main(String[] args) {
        int largest = 0;

        for(int j = 1; j <= 10000; j++) {
            String pandigital = "";
            int i = 0;

            while (pandigital.length() < 9) {
                pandigital += String.valueOf(j * (++i));
            }

            if (pandigital.length() == 9) {
                boolean valid = true;
                for(int k = 1; k <= 9; k++) {
                    if(!pandigital.contains(Integer.toString(k))) {
                        valid = false;
                        break;
                    }
                }

                if(valid) {
                    if(Integer.parseInt(pandigital) > largest) {
                        largest = Integer.parseInt(pandigital);
                    }
                }

            }
        }

        System.out.println(largest);
    }

}
