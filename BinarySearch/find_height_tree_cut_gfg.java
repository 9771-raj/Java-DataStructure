package BinarySearch;
import java.util.*;
public class find_height_tree_cut_gfg {
    public static void main(String[] args) {
        int[] arr={2,3,6,2,4};
        int N=arr.length;
        int K=4;
        Arrays.sort(arr);
        int ans=solution(arr,N,K);
        System.out.println(ans);

    }

    private static int solution(int[] arr, int N, int K) {
        int i=0;
        int j=N-1;
        while (i<=j){
            int mid=i+(j-i)/2;
            if (isPossible(mid,arr,K)){
                return mid;
            }
            else{
                i=mid+1;
            }
        }
        return -1;
    }

    private static boolean isPossible(int mid, int[] arr, int k) {
        int sum=0;
        for (int i=0;i< arr.length;i++){
            if (arr[i]>=mid){
                sum+=(arr[i]-mid);
            }
        }

        return sum==k;
    }
}
