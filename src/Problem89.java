import java.util.*;

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
    
    public static Map<Character, Integer> numeralConversion;
    static {
        Map<Character, Integer> pop = new LinkedHashMap<>();
        pop.put('M', 1000);
        pop.put('D', 500);
        pop.put('C', 100);
        pop.put('L', 50);
        pop.put('X', 10);
        pop.put('V', 5);
        pop.put('I', 1);
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
        System.out.println(parseNumeral("XXXXVIIII"));
        System.out.println(parseNumeral("XIV"));
        System.out.println(createNumeral(14));
    }
    
    public static int parseNumeral(String n) {
        int total = 0;

        for (int i = 0; i < n.toCharArray().length; i++) {
            char current = n.charAt(i);

            if (current == 'I') {
                if ((i + 1) < n.toCharArray().length) {
                    char next = n.charAt(i + 1);

                    if (next == 'V' || next == 'X') {
                        total -= numeralConversion.get(current);
                    } else {
                        total += numeralConversion.get(current);
                    }
                } else {
                    total += numeralConversion.get(current);
                }
            } else if (current == 'X') {
                if ((i + 1) < n.toCharArray().length) {
                    char next = n.charAt(i + 1);

                    if (next == 'L' || next == 'C') {
                        total -= numeralConversion.get(current);
                    } else {
                        total += numeralConversion.get(current);
                    }
                } else {
                    total += numeralConversion.get(current);
                }
            } else if (current == 'C') {
                if ((i + 1) < n.toCharArray().length) {
                    char next = n.charAt(i + 1);

                    if (next == 'D' || next == 'M') {
                        total -= numeralConversion.get(current);
                    } else {
                        total += numeralConversion.get(current);
                    }
                } else {
                    total += numeralConversion.get(current);
                }
            } else {
                total += numeralConversion.get(current);
            }
        }

        return total;
    }

    public static String createNumeral(int number) {
        String numeral = "";

        while (number > 0) {
            for (Map.Entry<Character, Integer> pair : numeralConversion.entrySet()) {
                if (number == 4) {
                    numeral += "IV";
                    number -= number;
                } else if (number == 9) {
                    numeral += "IX";
                    number -= number;
                } else if (number == 40) {
                    numeral += "XL";
                    number -= number;
                } else if(number == 90) {
                    numeral += "XC";
                    number -= number;
                } else if (number == 400) {
                    numeral += "CD";
                    number -= number;
                } else if (number == 900) {
                    numeral += "CM";
                    number -= number;
                } else if (pair.getValue() <= number) {
                    numeral += pair.getKey().toString();
                    number -= pair.getValue();
                }
            }
        }

        return numeral;
    }
    
}