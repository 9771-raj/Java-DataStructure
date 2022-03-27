package MCM;

public class recursionMcm {
    public static void main(String[] args) {
        int[] arr={10,30,5,60};
        int ans=mcm_recursive(arr,1,arr.length-1);
        System.out.println(ans);
    }

    private static int mcm_recursive(int[] arr, int i, int j) {
        if(i>=j) return 0;
        int min=Integer.MAX_VALUE;
        for (int k = i; k <= j-1; k++) {
            int temp_ans=mcm_recursive(arr,i,k)+mcm_recursive(arr,k+1,j)+arr[i-1]*arr[k]*arr[j];
            if(min>temp_ans){
                min=temp_ans;
            }
        }
        return min;
    }

}
