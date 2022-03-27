package DP;

public class kadanes_algo {
    public static void main(String[] args) {
        int[] arr={3,4,5,6,-2,-9,-6,3,7,-4,8};
        int csum=arr[0];
        int osum=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(csum>0){
                csum+=arr[i];
            }
            else{
                csum=arr[i];
            }
            if(csum>osum){
                osum=csum;
            }
        }
        System.out.println(osum);
    }
}
