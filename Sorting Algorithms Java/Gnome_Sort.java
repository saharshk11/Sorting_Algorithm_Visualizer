import java.util.Arrays;

public class Gnome_Sort extends Sorting_Algorithm{
    private int length;
    private String name;
    private long comparisons;

    public Gnome_Sort(int length){
        this.length = length;
        name = "Gnome Sort";
        comparisons = 0;
    }

    public int[] sort(int[] arr){
        comparisons = 0;
        for(int i = 1; i < arr.length; i++){
            for(int j = i; j > 0; j--){
                if(arr[j-1] > arr[j]){
                    switchPosition(arr, j, j-1);
                }
                comparisons++;
            }
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
