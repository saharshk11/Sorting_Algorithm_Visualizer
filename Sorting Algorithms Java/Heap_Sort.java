import java.util.Arrays;

public class Heap_Sort extends Sorting_Algorithm{
    private int length;
    private String name;
    private long comparisons;

    public Heap_Sort(int length){
        this.length = length;
        name = "Heap Sort";
        comparisons = 0;
    }

    public int[] sort(int[] arr){
        comparisons = 0;
        int n = arr.length;
        for(int i = n/2-1; i>= 0; i--){
            heapify(arr, n, i);
        }
        for(int i = n-1; i >= 0; i--){
            arr = switchPosition(arr, i, 0);
            heapify(arr, i, 0);
        }
        return arr;
    }

    private void heapify(int[] arr, int n, int i){
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if(l < n && arr[l] > arr[largest]){
            largest = l;
        }
        if(r < n && arr[r] > arr[largest]){
            largest = r;
        }
        comparisons += 2;
        if(largest != i) {
            arr = switchPosition(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    public void generateRandom(boolean show){
        System.out.println(name);
//        create shuffled array
        int[] arr = shuffle(length);
        if(show){
            System.out.println(Arrays.toString(arr));
        }

//        sort array
        long startTime = System.currentTimeMillis();
        arr = sort(arr);
        long endTime = System.currentTimeMillis();
        if(show){
            System.out.println(Arrays.toString(arr));
        }
        System.out.printf("%.5f seconds\n", (endTime-startTime)/1000.0);
        System.out.println("Array Accesses: " + comparisons + "\n");
    }
}