import java.util.ArrayList;
import java.util.Arrays;

public class Shell_Sort extends Sorting_Algorithm{
    private int length;
    private String name;
    private long comparisons;

    public Shell_Sort(int length){
        this.length = length;
        name = "Shell Sort";
        comparisons = 0;
    }

    public int[] sort(int[] arr){
        comparisons = 0;
//        sort array
        ArrayList<Integer> gap_sequence = new ArrayList<>();
        for(int power = 1, add = 2*(arr.length/((int)Math.pow(2, power+1)))+1; add != 1; power++, add = 2*(arr.length/((int)Math.pow(2, power+1)))+1){
            gap_sequence.add(add);
        }
        gap_sequence.add(1);
        for(int gap: gap_sequence){
            for(int i = gap; i < arr.length; i++){
                int temp = arr[i];
                int j;
                for(j = i; j >= gap && arr[j-gap] > temp; j -= gap){
                    arr[j] = arr[j-gap];
                    comparisons++;
                }
                comparisons++;
                arr[j] = temp;
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
