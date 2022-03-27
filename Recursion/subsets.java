package Recursion;
import java.util.*;
public class subsets {
    public static void main(String[] args) {
        int[] arr={1,2,1};
        List<List<Integer>> ans=new ArrayList<>();
        solution(arr,0,new ArrayList<>(),ans);
        System.out.println(ans);
    }

    private static void solution(int[] arr,int i,ArrayList<Integer> store,List<List<Integer>> ans) {

        if(i==arr.length){
            if(!ans.contains(store)){
                ans.add(new ArrayList<>(store));
            }

            return;
        }
        store.add(arr[i]);
        solution(arr,i+1,store,ans);
        store.remove(store.size()-1);

        solution(arr,i+1,store,ans);
    }
}
