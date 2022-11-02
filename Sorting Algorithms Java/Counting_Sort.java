import java.util.Arrays;

public class Counting_Sort extends Sorting_Algorithm{
    private int length;
    private String name;

    public Counting_Sort(int length){
        this.length = length;
        this.name = "Counting Sort";
    }

    public int[] sort(int[] arr, int min, int max){
        if(min < 0){
            for(int i = 0; i < arr.length; i++){
                arr[i] += -min;
            }
            max += -min;
            min = 0;
        }
        int[] count = new int[max+1];
        for(int i = 0; i < arr.length; i++){
            count[arr[i]]++;
        }
        for(int i = 1; i < count.length; i++){
            count[i] += count[i-1];
        }
        int[] sorted = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            sorted[count[arr[i]]-1] = arr[i];
            count[arr[i]]--;
        }
        return sorted;
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
        arr = sort(arr, 1, length);
        long endTime = System.currentTimeMillis();
        if(show){
            System.out.println(Arrays.toString(arr));
        }
        System.out.printf("%.5f seconds\n", (endTime-startTime)/1000.0);
    }
}
