import java.util.TreeSet;

/**
 * The cube, 41063625 (345^3), can be permuted to produce two other cubes: 
 * 56623104 (384^3) and 66430125 (405^3). In fact, 41063625 is the smallest cube 
 * which has exactly three permutations of its digits which are also cube.
 * 
 * Find the smallest cube for which exactly five permutations of its digits are 
 * cube.
 */
public class Problem62 {
	
	public static TreeSet<Long> permutations = new TreeSet<>();
	
	public static void main(String[] args) {
		int count = 0;
		long i = 2L;
		TreeSet<Long> singlePermutations = new TreeSet<>();

		while(count < 5) {
			count = 0;
			permutations.clear();
			singlePermutations.clear();

			permutate("", String.valueOf((long) Math.pow(i,  3)));
			
			for(long p : permutations) {
				if(String.valueOf(p).length() < 
						String.valueOf(permutations.last()).length()) {
					continue;
				}
				
				String pS = String.valueOf(Math.cbrt(p));
				
				if(pS.substring(Math.max(pS.length() - 2, 0)).equals(".0")) {
					singlePermutations.add(p);
					count++;
				}
			}
			
			i++;
		}
		
		System.out.println(singlePermutations.first());
	}
	
	public static void permutate(String start, String end) {
		if(end.length() == 1) {
			permutations.add(Long.valueOf(start + end));
		} else {
			for(int i = 0; i < end.length(); i++) {
				permutate(start + end.charAt(i), 
						end.substring(0, i) + end.substring(i + 1));
			}
		}
	}

}