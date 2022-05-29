package Recursion;
import java.util.*;
public class comb_sum2 {     // brute force
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        ArrayList<Integer> arr=new ArrayList<>();
        int[] data={10,1,2,7,6,1,5};
        Arrays.sort(data);
        int target=8;
        solution(data,0,target,arr,result);
        System.out.println(result);
      //optimal
        ArrayList<ArrayList<Integer>> result2=new ArrayList<>();
        ArrayList<Integer> arr2=new ArrayList<>();
        solution2(data,0,target,arr2,result2);
        System.out.println(result2);
    }

    private static void solution(int[] data,int index, int target, ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> result) {

        if (target==0){
            if (!result.contains(arr)){
                result.add(new ArrayList<>(arr));
            }

            return;
        }
        if (index==data.length){
            return;
        }
        if (data[index]<=target){
            arr.add(data[index]);
            solution(data,index+1,target-data[index],arr,result);
            arr.remove(arr.size()-1);
        }
        solution(data,index+1,target,arr,result);
    }

    private static void solution2(int[] data,int index, int target, ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> result) {

        if (target==0){
                result.add(new ArrayList<>(arr));
            return;
        }
        for (int i = index; i < data.length; i++) {
            if (i>index && data[i]==data[i-1]){
                continue;
            }
            if (data[i]>target){
                break;
            }
            arr.add(data[i]);
            solution2(data,index+1,target-data[i],arr,result);
            arr.remove(arr.size()-1);
        }
    }
}
