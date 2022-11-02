import java.util.Random;

public class Sorting_Algorithm {
    public int[] shuffle(int length){
        int[] arr = new int[length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = i+1;
        }
        int[] answer = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            int add = new Random().nextInt(arr.length);
            while(arr[add] == 0){
                add = new Random().nextInt(arr.length);
            }
            answer[i] = arr[add];
            arr[add] = 0;
        }
        return answer;
    }

    public int[] switchPosition(int[] arr, int pos1, int pos2){
        int hold = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = hold;
        return arr;
    }
}
