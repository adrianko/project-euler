import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file
 * containing over five-thousand first names, begin by sorting it into
 * alphabetical order. Then working out the alphabetical value for each name,
 * multiply this value by its alphabetical position in the list to obtain a name
 * score.
 *
 * For example, when the list is sorted into alphabetical order, COLIN, which
 * is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN
 * would obtain a score of 938 × 53 = 49714.
 *
 * What is the total of all the name scores in the file?
 */
public class Problem22 {

    public static void main(String[] args) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        List<String> names = readFile(System.getProperty("user.dir")
                + "/external/problem22.txt");
        List<String> namesSorted = new ArrayList<String>(names);
        Collections.sort(namesSorted);
        long score = 0;

        for (String name : namesSorted) {
            int wordScore = 0;

            for (char letter : name.toCharArray()) {
                wordScore += (alphabet.indexOf(letter) + 1);
            }

            wordScore *= (namesSorted.indexOf(name) + 1);
            score += wordScore;
        }

        System.out.println(score);
    }

    public static List<String> readFile(String file) {
        List<String> names = new LinkedList<String>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            String[] namesSplit = line.split(",");

            for (String n : namesSplit) {
                String nameClean = n.replaceAll("\"", "");
                names.add(nameClean);
            }

            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return names;
    }

}
