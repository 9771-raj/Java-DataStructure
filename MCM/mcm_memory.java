package MCM;

public class mcm_memory {
    static int[][] memory;
    public static void main(String[] args) {
        int[] arr={10,30,5,60};
        memory=new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                memory[i][j]=-1;
            }
        }
        int ans=mcm_memo(arr,1,arr.length-1);
        System.out.println(ans);
    }

    private static int mcm_memo(int[] arr, int i, int j) {
        if(i>=j) return 0;
        if(memory[i][j]!=-1) return memory[i][j];
        int min=Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp_ans=mcm_memo(arr,i,k)+mcm_memo(arr,k+1,j)+arr[i-1]*arr[k]*arr[j];
            if(min>temp_ans){
                min=temp_ans;
            }
        }
        return memory[i][j]=min;
    }
}
