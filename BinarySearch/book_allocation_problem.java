package BinarySearch;
import java.util.ArrayList;
import java.util.Arrays;
public class book_allocation_problem {
    public static void main(String[] args) {
        int[] arr={10,20,30,40}; // number of pages in ith book
        int n=4; // number of book
        int m=2; // number of students

        int left=0;
        int sum=0;
        for (int i = 0; i < n; i++) {
            sum+=arr[i];
        }
        int right=sum;
        int ans=Integer.MIN_VALUE;

        while (left<=right){
            int mid=left+(right-left)/2;
            if (isPossible(arr,mid,n,m)){
                ans=mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        System.out.println(ans);

    }

    private static boolean isPossible(int[] arr,int mid, int n, int m) {
        int count=1;
        int num=0;
        int sum=0;
        for (int i = 0; i < n; i++) {
            if (sum+arr[i]<=mid){
                sum+=arr[i];
            }
            else{
                count++;
                if (count>m || arr[i]>mid){
                    return false;
                }
                sum=arr[i];
            }
        }
        return true;
    }
}
