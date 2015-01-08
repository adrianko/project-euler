import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/**
 * In the 20×20 grid below, four numbers along a diagonal line have been marked
 * in red.
 *
 * The product of these numbers is 26 × 63 × 78 × 14 = 1788696.
 *
 * What is the greatest product of four adjacent numbers in the same direction
 * (up, down, left, right, or diagonally) in the 20×20 grid?
 */
public class Problem11 {

    public static void main(String[] args) {
        TreeSet<Integer> products = new TreeSet<Integer>();
        int[][] grid = readFile(System.getProperty("user.dir")
                + "/external/problem11.txt");

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j <= 16; j++) {
                products.add(grid[i][j] * grid[i][j + 1] * grid[i][j + 2] * grid[i][j + 3]);
            }
        }

        for (int i = 0; i <= 16; i++) {
            for (int j = 0; j < 20; j++) {
                products.add(grid[i][j] * grid[i + 1][j] * grid[i + 2][j] * grid[i + 3][j]);
            }
        }

        for (int i = 0; i <= 16; i++) {
            for (int j = 0; j <= 16; j++) {
                products.add(grid[i][j] * grid[i + 1][j + 1] * grid[i + 2][j + 2] * grid[i + 3][j + 3]);
            }
        }

        for (int i = 3; i < 20; i++) {
            for (int j = 0; j <= 16; j++) {
                products.add(grid[i][j] * grid[i - 1][j + 1] * grid[i - 2][j + 2] * grid[i - 3][j + 3]);
            }
        }

        System.out.println(products.last());
    }

    public static int[][] readFile(String file) {
        int[][] grid = new int[20][20];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] numbers = line.split("\\s");
                int j = 0;
                for (String n : numbers) {
                    grid[i][j] = Integer.parseInt(n);
                    j++;
                }
                i++;
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return grid;
    }

}
