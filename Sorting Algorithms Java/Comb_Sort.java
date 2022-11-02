import java.util.Arrays;

public class Comb_Sort extends Sorting_Algorithm{
    private int length;
    private String name;
    private long comparisons;

    public Comb_Sort(int length){
        this.length = length;
        name = "Comb Sort";
        comparisons = 0;
    }

    public int[] sort(int[] arr){
        comparisons = 0;
        int gap = arr.length;
        double shrink_factor = 1.3;
        boolean sorted = false;
        while(!sorted){
            gap /= shrink_factor;
            if(gap <= 1){
                gap = 1;
                sorted = true;
            }
            for(int i = 0; i+gap < arr.length; i++){
                if(arr[i] > arr[i+gap]){
                    switchPosition(arr, i, i+gap);
                    sorted = false;
                }
                comparisons++;
            }
        }
        return arr;
    }

    public void generateRandom(boolean show){
        System.out.println(name);
//        create shuffled list
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
