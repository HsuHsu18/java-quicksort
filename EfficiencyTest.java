import java.util.*;

public class EfficiencyTest {

    public static void main(String[] args) {
        int[] sizes = {1, 2, 4, 5, 6, 7};

        for (int size : sizes) {
            System.out.println("\nTesting list size: " + size);
            int[] random = generateRandom(size);
            int[] sorted = Arrays.copyOf(random, size);
            Arrays.sort(sorted);
            int[] reversed = reverseCopy(sorted);

            testCase("Random", random);
            testCase("Sorted", sorted);
            testCase("Reversed", reversed);
        }
    }

    public static void testCase(String type, int[] array) {
        long total = 0;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            int[] copy = Arrays.copyOf(array, array.length);
            // long startTime = System.currentTimeMillis();
            QuickSort.quicksort(copy, 0, copy.length - 1);
            long endTime = System.currentTimeMillis();
            total += (endTime - startTime);
        }
        System.out.println(type + " average time: " + (total) + " ms");
    }

    public static int[] generateRandom(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }
        return array;
    }

    public static int[] reverseCopy(int[] array) {
        int[] reversed = new int[array.length];
        for (int i = 0; i < array.length / 2; i++) {
            reversed[i] = array[array.length - 1 - i];
        }
        return reversed;
    }
}
