import java.util.*;

public class QuickSort {
    // public ArrayList<ArrayList<Integer>> weekLists = new ArrayList<>();
    public int[] sizes = {1, 2, 3, 4, 5, 6, 7};
    public ArrayList<ArrayList<Integer>> weekLists = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> weekListsRand = new ArrayList<>();

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        qs.randArrGen();
        // qs.arrPr();
        qs.timeTst();
        // System.out.print("Sorted Version: ");
        // qs.randArrGenSorted();
        qs.arrPr();

    }
    public void timeTst(){
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < weekLists.size(); i++) {
            ArrayList<Integer>list = weekLists.get(i);
            quicksort(list,0 ,list.size() - 1);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("total time: " + (endTime - startTime) + "ms");

        } 


        public void randArrGen(){
        Random random = new Random();
        weekLists.clear();
        for (int i = 0; i < sizes.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            // ArrayList<Integer> listRand = new ArrayList<>();
            for (int j = 0; j < sizes[i]; j++) {
                list.add(random.nextInt(5000 - 1000 + 1) + 1000); // Generate random values
                // list.add(random.nextInt(sizes));
            }
            // long startTime = System.currentTimeMillis();
            quicksort(list,0 ,list.size() - 1);
            // long endTime = System.currentTimeMillis();
            // System.out.println(endTime - startTime);
            weekLists.add(list);
            // weekListsRand.add(listRand);

        } 
    }


    public void arrPr(){
        // ArrayList<Integer> list = weekLists.get(i);
        for(int i = 0; i < weekLists.size(); i ++){
            ArrayList<Integer> list = weekLists.get(i);
            for(int j = 0; j < list.size(); j++){
                System.out.println(list.get(j) + "");
        }
        System.out.println("\n");
    }
}
// public void timeTst(){
    // long startTime = System.currentTimeMillis();
    // for(int i = 0; i < weekLists.size(); i++){

    // }



    public void quicksort(ArrayList<Integer> arr,  int low, int high) {

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(low);
        stack.push(high);
        while(!stack.isEmpty()){
            high = stack.pop();
            low = stack.pop();
            int p = partition(arr, low, high);
            if(p - 1 > low){
                stack.add(low);
                stack.add(p - 1);
            }
            if(p + 1 < high){
                stack.add(p + 1);
                stack.add(high);
            }
        }
    }
 
    private static int partition(ArrayList<Integer> arr, int low, int high) {
        int pivot = arr.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr.get(j) <= pivot) {
                i++;
                // int temp = arr.get(i); 
                // arr.get[i] = arr[j]; 
                // arr[j] = temp;
                Collections.swap(arr, i, j);
            }
        }
        // int temp = arr[i + 1]; 
        // arr[i + 1] = arr[high]; 
        // arr[high] = temp;
        Collections.swap(arr, i + 1, high);
        
        return i + 1;
    }
}
