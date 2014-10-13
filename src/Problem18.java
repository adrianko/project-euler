import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * By starting at the top of the triangle below and moving to adjacent numbers
 * on the row below, the maximum total from top to bottom is 23.
 *
 *    3
 *   7 4
 *  2 4 6
 * 8 5 9 3
 *
 * Find the maximum total from top to bottom of the triangle
 *
 * NOTE: As there are only 16384 routes, it is possible to solve this problem
 * by trying every route. However, Problem 67, is the same challenge with a
 * triangle containing one-hundred rows; it cannot be solved by brute force,
 * and requires a clever method! ;o)
 */
public class Problem18 {

    public static void main(String[] args) {
        List<LinkedList<Integer>> rows = readFile(System.getProperty("user.dir")
                + "/external/problem18.txt");
        List<Long> paths = new LinkedList<Long>();
        for(LinkedList<Integer> row : rows) {
            List<Integer> rowPath = new LinkedList<Integer>();
            for(int j : row) {
                
            }
        }
    }

    public static List<LinkedList<Integer>> readFile(String file) {
        List<LinkedList<Integer>> rows = new LinkedList<LinkedList<Integer>>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while((line = br.readLine()) != null) {
                LinkedList<Integer> r = new LinkedList<Integer>();
                String[] numbers = line.split("\\s");
                for(String n : numbers) {
                    r.add(Integer.parseInt(n));
                }
                rows.add(r);
            }
            br.close();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }

        return rows;
    }

}
