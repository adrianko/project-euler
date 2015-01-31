import java.util.TreeSet;

/**
 * A unit fraction contains 1 in the numerator. The decimal representation of
 * the unit fractions with denominators 2 to 10 are given:
 *
 * 1/2 = 0.5 
 * 1/3 = 0.(3) 
 * 1/4 = 0.25 
 * 1/5 = 0.2 
 * 1/6 = 0.1(6) 
 * 1/7 = 0.(142857) 
 * 1/8 = 0.125 
 * 1/9 = 0.(1) 
 * 1/10 = 0.1
 *
 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be
 * seen that 1/7 has a 6-digit recurring cycle.
 *
 * Find the value of d < 1000 for which 1/d contains the longest recurring cycle
 * in its decimal fraction part.
 */
public class Problem26 {

	public static void main(String[] args) {
		int maxLen = 0;
		int ans = 0;

		for (int n : primeSieve(1000).descendingSet()){
			int j = 1;

			for (int i = 0; i < n; i++) {
				j = (j * 10) % n;
			}

			int k = j;
			int len = 0;

			do {
				j = (j * 10) % n;
				len++;
			} while (j != k);

			if (len > maxLen) {
				ans = n;
				maxLen = len;
			}
		}

		System.out.println(ans);
	}

	public static TreeSet<Integer> primeSieve(int limit) {
		boolean[] numberList = new boolean[limit + 1];

		for(int i = 2; i <= limit; i++) {
			numberList[i] = true;
		}

		for(int i = 2; i * i <= limit; i++) {
			if(numberList[i]) {
				for(int j = i; i * j <= limit; j++) {
					numberList[i * j] = false;
				}
			}
		}

		TreeSet<Integer> primeList = new TreeSet<Integer>();
		for(int i = 2; i <= limit; i++) {
			if(numberList[i]) {
				primeList.add(i);
			}
		}

		return primeList;

	}

}