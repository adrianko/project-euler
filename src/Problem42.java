import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten triangle numbers are:
 *
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 *
 * By converting each letter in a word to a number corresponding to its alphabetical position and adding these values we
 * form a word value. For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number
 * then we shall call the word a triangle word.
 *
 * Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common
 * English words, how many are triangle words?
 */
public class Problem42 {

    public static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        try {
            Map<Integer, Set<String>> scores = new HashMap<>();

            for (String w : readFile("external/problem42.txt").collect(Collectors.toList()).toString().split(",")) {
                String word = w.replaceAll("(\\[|\\]|\")", "").trim().toLowerCase();
                int score = 0;

                for (char c : word.toCharArray()) {
                    score += alphabet.indexOf(c) + 1;
                }

                if (!scores.containsKey(score)) {
                    scores.put(score, new HashSet<>());
                }

                scores.get(score).add(word);
            }

            TreeSet<Integer> requiredScores = new TreeSet<>(scores.keySet());
            TreeSet<Integer> triangles = new TreeSet<>();
            triangles.add(1);
            int n = 2;

            while (triangles.last() <= requiredScores.last()) {
                triangles.add((int) ((0.5 * n) * (n + 1)));
                n++;
            }

            int total = triangles.stream().mapToInt(t -> scores.containsKey(t) ? scores.get(t).size() : 0).sum();
            System.out.println(total);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Stream<String> readFile(String filename) throws IOException {
        return Files.lines(Paths.get(filename));
    }
}