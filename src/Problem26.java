import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A unit fraction contains 1 in the numerator. The decimal representation of
 * the unit fractions with denominators 2 to 10 are given:
 *
 * 1/2	= 	0.5
 * 1/3	= 	0.(3)
 * 1/4	= 	0.25
 * 1/5	= 	0.2
 * 1/6	= 	0.1(6)
 * 1/7	= 	0.(142857)
 * 1/8	= 	0.125
 * 1/9	= 	0.(1)
 * 1/10	= 	0.1
 *
 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be
 * seen that 1/7 has a 6-digit recurring cycle.
 *
 * Find the value of d < 1000 for which 1/d contains the longest recurring cycle
 * in its decimal fraction part.
 */
public class Problem26 {

    public static void main(String[] args) {
        Map<Integer, BigDecimal> fractions = new HashMap<Integer, BigDecimal>();

        for (int i = 2; i <= 1000; i++) {
            fractions.put(i, BigDecimal.valueOf(i).pow(-1, new MathContext(1000)));
        }

        //fractions.put(1, BigDecimal.valueOf(0.0001234567567567567567567));
        int allMax = 0;
        for (Map.Entry<Integer, BigDecimal> p : fractions.entrySet()) {
            String decimal = p.getValue().toString().substring(2);

            int max = 0;
            for (int i = 0; i < decimal.length(); i++) {
                String decimalSub = decimal.substring(i);
                String repeat = "";

                for (char c : decimalSub.toCharArray()) {
                    repeat += c;

                    Pattern pattern = Pattern.compile(repeat);
                    Matcher m = pattern.matcher(decimalSub);
                    for (int j = repeat.length(); j <= Math.floor(decimalSub.length() / repeat.length()); j += repeat.length()) {
                        if ((i + j) < decimalSub.length()) {
                            if (m.find(i + j)) {
                                if (max < repeat.length()) {
                                    max = repeat.length();
                                }
                            }
                        }
                    }
                }
            }

            System.out.println("Max length: " + max);
            if (allMax < max) {
                allMax = max;
            }
        }

        System.out.println(allMax);
    }

}
