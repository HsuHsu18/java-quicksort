import java.util.*;

public class HybridQuickSort {
    
    static final int CUTOFF = 10;

    public static void main(String[] args) {
        int[] sizes = {1, 2, 3, 4, 5, 6, 7};
        Random rand = new Random();

        for (int size : sizes) {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = rand.nextInt(size);
            }

            long start = System.currentTimeMillis();
            hybridQuickSort(arr, 0, arr.length - 1);
            long end = System.currentTimeMillis();

            System.out.println("Hybrid Sort | Size: " + size + " | Time: " + (end - start) + " ms");
        }
    }

    public static void hybridQuickSort(int[] arr, int low, int high) {
        if (high - low < CUTOFF) {
            insertionSort(arr, low, high);
        } else {
            int pivotIndex = partition(arr, low, high);
            hybridQuickSort(arr, low, pivotIndex - 1);
            hybridQuickSort(arr, pivotIndex + 1, high);
        }
    }

    public static void insertionSort(int[] arr, int low, int high) {
        for(int i = low + 1; i <= high; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= low && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1]; 
        arr[i + 1] = arr[high]; 
        arr[high] = temp;
        
        return i + 1;
    }
}
