package Recursion;
import java.util.*;
public class combination_sum {
    public static void main(String[] args) {
        int[] arr={2,3,5};
        int target=8;
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> store=new ArrayList<>();

        solution(arr,0,target,store,result);
        System.out.println(result);
    }

    private static void solution(int[] arr, int index, int target, List<Integer> store, List<List<Integer>> result) {
        if(target==0){
            result.add(new ArrayList<>(store));
            return;
        }
        if(index==arr.length){
            return;
        }
        if(arr[index]<=target){
            store.add(arr[index]);
            solution(arr,index,target-arr[index],store,result);
            store.remove(store.size()-1);
        }
        solution(arr,index+1,target,store,result);
    }
}
