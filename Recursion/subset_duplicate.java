package Recursion;
import java.util.*;
public class subset_duplicate {
    public static void main(String[] args) {
        int[] nums={1,2,2};
        List<List<Integer>> ans=new ArrayList<>();
        subsetDuplicate(0,nums,ans,new ArrayList<>());
        System.out.println(ans);
    }

    private static void subsetDuplicate(int index, int[] nums, List<List<Integer>> ans, ArrayList<Object> store) {

        ans.add(new ArrayList(store));

        for (int i=index;i<nums.length;i++){
            if (i> index && nums[i]==nums[i-1]){
                continue;
            }
            store.add(nums[i]);
            subsetDuplicate(i+1,nums,ans,store);
            store.remove(store.size()-1);

        }

    }
}
