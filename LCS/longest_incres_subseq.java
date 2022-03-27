package LCS;

public class longest_incres_subseq {
    public static void main(String[] args) {
        int[] arr={0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        int ans=long_incr_subseq(arr,0,arr.length,Integer.MIN_VALUE);
        System.out.println(ans);

    }

    private static int long_incr_subseq(int[] arr,int i,int n,int prev){
        if(i==n) return 0;
        int excl=long_incr_subseq(arr,i+1,n,prev);
        int incl=0;
        if(arr[i]>prev){
            incl=1+long_incr_subseq(arr,i+1,n,arr[i]);
        }
        return Math.max(incl,excl);
    }


}
