import java.util.Arrays;

public class Merge_Sort extends Sorting_Algorithm {
    private int length;
    private String name;
    private long comparisons = 0;

    public Merge_Sort(int length){
        this.length = length;
        name = "Merge Sort";
    }

    private void mergeSort(int[] arr, int start, int end){
        if(start < end){
            int middle = (start + end)/2;
            mergeSort(arr, start, middle);
            mergeSort(arr, middle+1, end);
            merge(arr, start, middle, end);
        }
    }

    private void merge(int[] arr, int start, int middle, int end){
        int[] mergedTemp = new int[end-start+1];
        int mergedI = 0;
        int left = start;
        int right = middle+1;
        while(left <= middle && right <= end){
            if(arr[left] < arr[right]){
                mergedTemp[mergedI] = arr[left];
                mergedI++;
                left++;
            } else {
                mergedTemp[mergedI] = arr[right];
                mergedI++;
                right++;
            }
            comparisons++;
        }
        comparisons++;
        while(left <= middle){
            mergedTemp[mergedI] = arr[left];
            mergedI++;
            left++;
        }
        while(right <= end){
            mergedTemp[mergedI] = arr[right];
            mergedI++;
            right++;
        }
        for(int i = 0, j = start; j <= end; i++, j++){
            arr[j] = mergedTemp[i];
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
        mergeSort(arr, 0, arr.length-1);
        long endTime = System.currentTimeMillis();
        if(show){
            System.out.println(Arrays.toString(arr));
        }
        System.out.printf("%.5f seconds\n", (endTime-startTime)/1000.0);
        System.out.println("Comparisons: " + comparisons + "\n");
    }
}
