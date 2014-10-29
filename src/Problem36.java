/**
 * The decimal number, 585 = 1001001001 (binary), is palindromic in both bases.
 * Find the sum of all numbers, less than one million, which are palindromic in
 * base 10 and base 2.
 * (Please note that the palindromic number, in either base, may not include
 * leading zeros.)
 */
public class Problem36 {

    public static void main(String[] args) {
        int total = 0;
        for(int i = 1; i < 1000000; i++) {
            String n = String.valueOf(i);
            String b = Integer.toBinaryString(i);

            if(new StringBuffer(n).reverse().toString().equals(n)
            && new StringBuffer(b).reverse().toString().equals(b)) {
                total += i;
            }
        }

        System.out.println(total);

    }



}
