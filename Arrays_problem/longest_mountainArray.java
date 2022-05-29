package Arrays_problem;

public class longest_mountainArray {
    public static void main(String[] args) {
        int[] arr={2,1,4,7,3,2,5};
        int res=0;
        int n=arr.length;
        for (int i = 1; i < n; i++) {
            int count=1;
            // increasing sequence
            int j=i;
            boolean flag=false;
            while (j<n && arr[j]>arr[j-1]){
                count++;
                j++;
            }
            // decreasing sequence

            while (i!=j && j<n && arr[j]<arr[j-1]){
                count++;
                j++;
                flag=true;
            }
            // maximize
            if (i!=j && flag && count>2){
                res=Math.max(res,count);
                j--;
            }

        }
        System.out.println(res);
    }
}
