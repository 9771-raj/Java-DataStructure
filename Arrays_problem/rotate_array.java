package Arrays_problem;
import java.util.Arrays;
public class rotate_array {
    public static void main(String[] args) {
        int k=4;
        int[] arr={1,2,3,4,5,6,7};
//        int len=arr.length;
//        for (int i = len-1; i>k-1; i--) {
//            int temp=arr[i];
//            System.out.println(temp);
//            for (int j = 0; j < len-1; j++) {
//                int t=arr[j];
//                arr[j]=arr[j+1];
//                arr[j+1]=t;
//            }
//            //arr[0]=temp;
//
//        }
//        System.out.println(Arrays.toString(arr));
        //////////////

        k=k%arr.length;
        solution(arr,0,arr.length-1);
        solution(arr,k,arr.length-1);
        solution(arr,0,k-1);
        System.out.println(Arrays.toString(arr));
    }

    // recursion approach
    public static void solution(int[] arr,int c,int b){
        while (c<b){
            int temp=arr[c];
            arr[c]=arr[b];
            arr[b]=temp;
            c++;
            b--;
        }
    }
}
