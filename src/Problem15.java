import java.util.*;

/**
 * Starting in the top left corner of a 2×2 grid, and only being able to move
 * to the right and down, there are exactly 6 routes to the bottom right corner.
 * <p/>
 * How many such routes are there through a 20×20 grid?
 */
public class Problem15 {

    public static void main(String[] args) {

        int gridSize = 20;
        HashMap<Integer, LinkedList<Long>> sequences = new HashMap<Integer, LinkedList<Long>>();
        sequences.put(1, new LinkedList<Long>());
        sequences.get(1).add(1L);

        for (int i = 2; i <= gridSize; i++) {
            LinkedList<Long> currentSequence = new LinkedList<Long>();
            long lastTerm = 1;
            currentSequence.add(1L);

            for (int j = 1; j < (i - 1); j++) {
                long newTerm = sequences.get((i - 1)).get(j) + lastTerm;
                currentSequence.add(newTerm);
                lastTerm = newTerm;
            }

            long lastTotal = 0;
            for (long e : sequences.get((i - 1))) {
                lastTotal += e;
            }

            currentSequence.add(2 * lastTotal);
            sequences.put(i, currentSequence);
        }

        long gridTotal = 0;
        for (long e : sequences.get(gridSize)) {
            gridTotal += e;
        }
        gridTotal *= 2;

        System.out.println(gridTotal);
    }

}
