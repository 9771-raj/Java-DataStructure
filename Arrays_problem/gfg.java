package Arrays_problem;

import java.util.Arrays;

public class gfg {
    public static void main(String[] args) {
        int[] arr={1,9,3,10,4,20,2};
        int a=findLongestConseqSubseq(arr,arr.length);
        System.out.println(a);
    }
    static int findLongestConseqSubseq(int arr[], int N)
    {
        Arrays.sort(arr);
        //int i=0;
        int j=arr.length-1;
        int max_len=1;
        int ans=1;
        for(int i=1;i<N;i++){
            if(arr[i]-arr[i-1]==1){
                max_len++;
                ans=Math.max(ans,max_len);
            }
            else{
                max_len=1;
            }

        }
        return ans;
    }
}
