package BinarySearch;

import java.util.Arrays;

public class kth_smallestPair {
    public static void main(String[] args) {
        int[] nums={1,6,1};
        int ans=smallestDistancePair(nums,3);
        System.out.println(ans);
    }
    private static boolean check(int[] nums,int mid,int k){
        int total=0;
        int j=0,n=nums.length;
        for(int i=0;i<n;i++){
            while(j<n && nums[j]-nums[i]<=mid)j++;
            j--;
            total+=(j-i);
        }
        return total>=k;
    }
    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l=0;
        int r=nums[nums.length-1]-nums[0];
        while(l<r){
            int mid=l+(r-l)/2;
            if(check(nums,mid,k)){
                r=mid;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
}
