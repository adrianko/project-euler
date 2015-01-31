import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * For a number written in Roman numerals to be considered valid there are basic 
 * rules which must be followed. Even though the rules allow some numbers to be 
 * expressed in more than one way there is always a "best" way of writing a 
 * particular number.
 * 
 * For example, it would appear that there are at least six ways of writing the 
 * number sixteen:
 * 
 * IIIIIIIIIIIIIIII
 * VIIIIIIIIIII
 * VVIIIIII
 * XIIIIII
 * VVVI
 * XVI
 * 
 * However, according to the rules only XIIIIII and XVI are valid, and the last 
 * example is considered to be the most efficient, as it uses the least number 
 * of numerals.
 * 
 * The 11K text file, roman.txt (right click and 'Save Link/Target As...'), 
 * contains one thousand numbers written in valid, but not necessarily minimal, 
 * Roman numerals; see About... Roman Numerals for the definitive rules for this 
 * problem.
 * 
 * Find the number of characters saved by writing each of these in their minimal 
 * form.
 * 
 * Note: You can assume that all the Roman numerals in the file contain no more 
 * than four consecutive identical units.
 */
public class Problem89 {
    
    public static Map<String, Integer> numeralConversion;
    static {
        Map<String, Integer> pop = new LinkedHashMap<>();
        pop.put("M", 1000);
        pop.put("CM", 900);
        pop.put("D", 500);
        pop.put("CD", 400);
        pop.put("C", 100);
        pop.put("XC", 90);
        pop.put("L", 50);
        pop.put("XL", 40);
        pop.put("X", 10);
        pop.put("IX", 9);
        pop.put("V", 5);
        pop.put("IV", 4);
        pop.put("I", 1);
        numeralConversion = pop;
    }

    public static Map<Character, ArrayList<Character>> following;
    static {
        Map<Character, ArrayList<Character>> pop = new HashMap<>();
        pop.put('I', new ArrayList<>(Arrays.asList('V', 'X')));
        pop.put('X', new ArrayList<>(Arrays.asList('L', 'C')));
        pop.put('C', new ArrayList<>(Arrays.asList('D', 'M')));
        following = pop;
    }
    
    public static void main(String[] args) {

    }
    
    public static int parseNumeral(String n) {
        int total = 0;

        for (int i = 0; i < n.toCharArray().length; i++) {
            String current = String.valueOf(n.charAt(i));

            switch(current) {
                case "I":
                    if ((i + 1) < n.toCharArray().length) {
                        String next = String.valueOf(n.charAt(i + 1));

                        if (next.equals("V") || next.equals("X")) {
                            total -= numeralConversion.get(current);
                        } else {
                            total += numeralConversion.get(current);
                        }
                    } else {
                        total += numeralConversion.get(current);
                    }
                    break;
                case "X":
                    if ((i + 1) < n.toCharArray().length) {
                        String next = String.valueOf(n.charAt(i + 1));

                        if (next.equals("L") || next.equals("C")) {
                            total -= numeralConversion.get(current);
                        } else {
                            total += numeralConversion.get(current);
                        }
                    } else {
                        total += numeralConversion.get(current);
                    }
                    break;
                case "C":
                    if ((i + 1) < n.toCharArray().length) {
                        String next = String.valueOf(n.charAt(i + 1));

                        if (next.equals("D") || next.equals("M")) {
                            total -= numeralConversion.get(current);
                        } else {
                            total += numeralConversion.get(current);
                        }
                    } else {
                        total += numeralConversion.get(current);
                    }
                    break;
                default:
                    total += numeralConversion.get(current);
                    break;
            }
        }

        return total;
    }

    public static String createNumeral(int number) {
        String numeral = "";

        while (number > 0) {
            for (Map.Entry<String, Integer> pair : numeralConversion.entrySet()) {
                if (pair.getValue() <= number) {
                    numeral += pair.getKey();
                    number -= pair.getValue();
                    break;
                }
            }
        }

        return numeral;
    }

    public static Stream<String> readFile(String filename) throws IOException {
        return Files.lines(Paths.get(filename));
    }
    
}