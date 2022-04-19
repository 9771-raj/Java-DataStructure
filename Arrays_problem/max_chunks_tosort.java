package Arrays_problem;
import java.util.Arrays;        // chaining technique
                              // max chunk to sort array after concatenate
public class max_chunks_tosort {
    public static void main(String[] args) {
        int[] arr={3,0,1,2,5,4,8,6,7};
        int max=Integer.MIN_VALUE;
        int chunk=0;
        for (int i=0;i< arr.length;i++){
            max=Math.max(arr[i],max );
            if (i==max){
                chunk++;
            }
        }
        System.out.println(chunk);

    }
}
