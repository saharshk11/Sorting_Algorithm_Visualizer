import java.util.Arrays;

public class Insertion_Sort extends Sorting_Algorithm{
    private int length;
    private String name;
    private long comparisons;

    public Insertion_Sort(int length){
        this.length = length;
        name = "Insertion Sort";
        comparisons = 0;
    }

    public int[] sort(int[] arr){
        comparisons = 0;
        for(int i = 1; i < arr.length; i++){
            int position = i;
            while(position > 0 && arr[position-1] > arr[position]){
                switchPosition(arr, position, position-1);
                position--;
                comparisons++;
            }
            comparisons++;
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
