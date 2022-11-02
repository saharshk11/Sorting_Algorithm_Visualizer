import java.util.Arrays;

public class Selection_Sort extends Sorting_Algorithm{
    private int length;
    private String name;
    private long comparisons;

    public Selection_Sort(int length){
        this.length = length;
        name = "Selection Sort";
        comparisons = 0;
    }

    public int[] sort(int[] arr){
        comparisons = 0;
        for(int i = 0; i < arr.length-1; i++){
            int smallest = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] <= arr[smallest]){
                    smallest = j;
                }
                comparisons++;
            }
            arr = switchPosition(arr, i, smallest);
        }
        return arr;
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
        System.out.println("Comparisons: " + comparisons + "\n");
    }
}
