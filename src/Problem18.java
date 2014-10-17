import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
        ArrayList<ArrayList<Integer>> rows = readFile(System.getProperty("user.dir")
                + "/external/problem18.txt");
        List<Integer> paths = new ArrayList<Integer>();

        for(int i = (rows.size() - 1); i >= 0; i--) {
            ArrayList<Integer> totalList = new ArrayList<Integer>();

            for(int j = 0; j < (rows.get(i).size() - 1); j++) {
                totalList.add(rows.get(i).get(j) + rows.get(i-1).get(j));
                totalList.add(rows.get(i).get(j+1) + rows.get(i-1).get(j));
            }

            ArrayList<Integer> nextRow = new ArrayList<Integer>();

            for(int t = 0; t < totalList.size(); t += 2) {
                if(totalList.get(t) >= totalList.get(t+1)) {
                    nextRow.add(totalList.get(t));
                } else {
                    nextRow.add(totalList.get(t+1));
                }
            }

            if(i != 0) {
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

            while((line = br.readLine()) != null) {
                ArrayList<Integer> r = new ArrayList<Integer>();
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
