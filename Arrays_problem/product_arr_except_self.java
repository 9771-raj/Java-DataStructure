package Arrays_problem;
import java.util.Arrays;
public class product_arr_except_self {
    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        int[] output=new int[arr.length];
        Arrays.fill(output,1);
        for (int i = 1; i < arr.length; i++) {
            output[i]=arr[i-1]*output[i-1];
        }
        int r=1;
        for (int i=arr.length-1;i>=0;i--){
            output[i]=r*output[i];
            r*=arr[i];
        }
        System.out.println(Arrays.toString(output));
    }
}
