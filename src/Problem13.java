import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

/**
 * Work out the first ten digits of the sum of the following one-hundred
 * 50-digit numbers.
 */
public class Problem13 {

    public static void main(String[] args) {
        List<BigInteger> numbers = readNumberFile(System.getProperty("user.dir")
                + "/external/problem13.txt");
        BigInteger total = new BigInteger("0");

        for (BigInteger i : numbers) {
            total = total.add(i);
        }

        String str_total = total.toString();
        System.out.println(str_total.substring(0, 10));
    }

    public static List<BigInteger> readNumberFile(String file) {
        List<BigInteger> numbers = new LinkedList<BigInteger>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                numbers.add(new BigInteger(line));
            }

            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return numbers;
    }

}
