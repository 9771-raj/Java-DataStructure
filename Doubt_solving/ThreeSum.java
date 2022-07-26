package Doubt_solving;
import java.util.*;
public class ThreeSum {
    public static void main(String[] args) {
        List<List<Integer>> result=new ArrayList<>();
        int[] arr={50,30,40,10,10,20,40,20,60,80,90};
        Arrays.sort(arr);
        result=calling(arr,100);
        System.out.println(result);
    }

    private static List<List<Integer>> calling(int[] arr, int target) {
        List<List<Integer>> res=new ArrayList<>();
        int n=arr.length;
        if(n<3){
            return res;
        }
        for (int i = 0; i < n-2 ; i++) {
            if (i!=0 && arr[i]==arr[i-1]) continue;
            int val1=arr[i];
            int targ=target-val1;
            List<List<Integer>> ans=solution(arr,i+1,n-1,targ);

            for(List<Integer> l:ans){
                l.add(val1);
                res.add(l);
            }
        }
        return res;
    }

    private static List<List<Integer>> solution(int[] arr,int start,int end, int target) {
        int left=start;
        int right=end;
        List<List<Integer>> result=new ArrayList<>();
        while (left<right){
            if (start!=left && arr[left]==arr[left-1]){
                left++;
                continue;
            }
            int sum=arr[left]+arr[right];
            if (sum==target){
                List<Integer> d=new ArrayList<>();
                d.add(arr[left]);
                d.add(arr[right]);
                result.add(d);
                left++;
                right--;
            }
            else if (sum>target){
                right--;
            }
            else{
                left++;
            }
        }
        return result;

    }
}
