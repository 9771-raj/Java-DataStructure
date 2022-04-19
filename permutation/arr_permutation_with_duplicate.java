package permutation;
import java.util.*;
public class arr_permutation_with_duplicate {
    public static void main(String[] args) {
        int[] nums={1,2,2,2};
        List<List<Integer>> result=new ArrayList<>();
        solution(nums,result,0);
        System.out.println(result);

    }
    public static void solution(int[] nums,List<List<Integer>> result,int index){
        //base case
        if(nums.length==index){
            List<Integer> a=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                a.add(nums[i]);
            }
            if(!result.contains(a)){
                result.add(new ArrayList<>(a));
            }
            return;
        }

        for(int i=index;i<nums.length;i++){
            swap(nums,i,index);
            solution(nums,result,index+1);
            swap(nums,i,index);
        }
    }
    public static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
