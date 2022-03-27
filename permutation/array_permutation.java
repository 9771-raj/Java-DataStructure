package permutation;
import java.util.*;             // permutation without duplicate in array
public class array_permutation {
    public static void main(String[] args) {
        int[] arr={1,2,3};
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> comb=new ArrayList<>();
        solution(arr,0,comb,result);
        System.out.println(result);
    }

    private static void solution(int[] arr, int index, List<Integer> comb, List<List<Integer>> result) {
        if(index==arr.length-1){
            ArrayList<Integer> a=new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                a.add(arr[i]);
            }
            result.add(new ArrayList<>(a));
            //System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr,index,i);
            solution(arr,index+1,comb,result);
            swap(arr,index,i);
        }
    }

    private static void swap(int[] arr, int index, int i) {
        int temp=arr[i];
        arr[i]=arr[index];
        arr[index]=temp;
    }
}
