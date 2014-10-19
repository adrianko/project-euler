import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * By starting at the top of the triangle below and moving to adjacent numbers
 * on the row below, the maximum total from top to bottom is 23.
 *
 * 3
 * 7 4
 * 2 4 6
 * 8 5 9 3
 *
 * Find the maximum total from top to bottom in triangle.txt (right click
 * and 'Save Link/Target As...'), a 15K text file containing a triangle with
 * one-hundred rows.
 *
 * NOTE: This is a much more difficult version of Problem 18. It is not
 * possible to try every route to solve this problem, as there are 299
 * altogether! If you could check one trillion (1012) routes every second it
 * would take over twenty billion years to check them all. There is an efficient
 * algorithm to solve it. ;o)
 */
public class Problem67 {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> rows = readFile(System.getProperty("user.dir")
                + "/external/problem67.txt");

        for (int i = (rows.size() - 1); i >= 0; i--) {
            ArrayList<Integer> totalList = new ArrayList<Integer>();

            for (int j = 0; j < (rows.get(i).size() - 1); j++) {
                totalList.add(rows.get(i).get(j) + rows.get(i - 1).get(j));
                totalList.add(rows.get(i).get(j + 1) + rows.get(i - 1).get(j));
            }

            ArrayList<Integer> nextRow = new ArrayList<Integer>();

            for (int t = 0; t < totalList.size(); t += 2) {
                if (totalList.get(t) >= totalList.get(t + 1)) {
                    nextRow.add(totalList.get(t));
                } else {
                    nextRow.add(totalList.get(t + 1));
                }
            }

            if (i != 0) {
                rows.set((i - 1), nextRow);
            }
        }

        System.out.println(rows.get(0).get(0));
    }

    public static ArrayList<ArrayList<Integer>> readFile(String file) {
        ArrayList<ArrayList<Integer>> rows = new ArrayList<ArrayList<Integer>>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                ArrayList<Integer> r = new ArrayList<Integer>();
                String[] numbers = line.split("\\s");
                for (String n : numbers) {
                    r.add(Integer.parseInt(n));
                }
                rows.add(r);
            }

            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return rows;
    }

}
