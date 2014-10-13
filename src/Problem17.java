import java.util.HashMap;
import java.util.Map;

/**
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five,
 * then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 *
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out
 * in words, how many letters would be used?
 *
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and
 * forty-two) contains 23 letters and 115 (one hundred and fifteen) contains
 * 20 letters. The use of "and" when writing out numbers is in compliance with
 * British usage.
 *
 * 21124
 */
public class Problem17 {

    public static void main(String[] args) {
        Map<Integer, String> conversions = new HashMap<Integer, String>();
        conversions.put(1, "one");
        conversions.put(2, "two");
        conversions.put(3, "three");
        conversions.put(4, "four");
        conversions.put(5, "five");
        conversions.put(6, "six");
        conversions.put(7, "seven");
        conversions.put(8, "eight");
        conversions.put(9, "nine");
        conversions.put(10, "ten");
        conversions.put(11, "eleven");
        conversions.put(12, "twelve");
        conversions.put(13, "thirteen");
        conversions.put(14, "fourteen");
        conversions.put(15, "fifteen");
        conversions.put(16, "sixteen");
        conversions.put(17, "seventeen");
        conversions.put(18, "eighteen");
        conversions.put(19, "nineteen");
        conversions.put(20, "twenty");
        conversions.put(30, "thirty");
        conversions.put(40, "forty");
        conversions.put(50, "fifty");
        conversions.put(60, "sixty");
        conversions.put(70, "seventy");
        conversions.put(80, "eighty");
        conversions.put(90, "ninety");
        conversions.put(100, "hundred");
        conversions.put(1000, "thousand");

        String total = "";

        for (int i = 1; i <= 1000; i++) {
            String iS = String.valueOf(i);

            if (i <= 20) {
                total += conversions.get(i);
            } else if (i > 20 && i < 100) {
                total += conversions.get(Integer.parseInt(iS.charAt(0) + "0"));

                if (Character.getNumericValue(iS.charAt(1)) > 0) {
                    total += conversions.get(Character.getNumericValue(
                            iS.charAt(1)));
                }
            } else if (i >= 100 && i < 1000) {
                total += conversions.get(Character.getNumericValue(
                        iS.charAt(0)));
                total += conversions.get(100);

                if (Character.getNumericValue(iS.charAt(1)) > 0) {
                    total += "and";

                    if (conversions.containsKey(Integer.parseInt(iS.charAt(1) +
                            "" + iS.charAt(2)))) {
                        total += conversions.get(Integer.parseInt(iS.charAt(1)
                                + "" + iS.charAt(2)));
                    } else {
                        total += conversions.get(Integer.parseInt(iS.charAt(1)
                                + "0"));

                        if (Character.getNumericValue(iS.charAt(2)) > 0) {
                            if (Character.getNumericValue(iS.charAt(1)) == 0) {
                                total += "and";
                            }
                            total += conversions.get(Character.getNumericValue(
                                    iS.charAt(2)));
                        }
                    }
                } else if (Character.getNumericValue(iS.charAt(2)) > 0) {
                    total += "and";

                    if (conversions.containsKey(Character.getNumericValue((
                            iS.charAt(2))))) {
                        total += conversions.get(Character.getNumericValue((
                                iS.charAt(2))));
                    }
                }


            } else if (i >= 1000 && i < 10000) {
                total += conversions.get(Character.getNumericValue(
                        iS.charAt(0)));
                total += conversions.get(1000);
            }

        }

        System.out.println(total.length());
    }

}
