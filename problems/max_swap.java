package problems;
import java.util.*;
public class max_swap {
    public static void main(String[] args) {
        int[] arr1={3,5,1,2,3};
        int[] arr2={3,6,3,3,4};
        int count=0;
        count=swapping(arr1,arr2);
        System.out.println(count);
    }
    private static int swapping(int[] arr1,int[] arr2){
        int count=0;
        int[] num1=arr1;
        int[] num2=arr2;

        for (int i = 0; i < arr1.length-1; i++) {
            if(arr1[i]==arr1[i+1]){
                continue;
            }
            else if(arr1[i]==arr2[i+1]){
                count++;
                int temp=arr1[i+1];
                arr1[i+1]=arr2[i+1];
                arr2[i+1]=temp;
            }
            else{
                break;
            }
        }
        HashSet<Integer> hash=new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            hash.add(arr1[i]);
        }
        if(hash.size()==1){
            return count;
        }
        else{
            arr1=num2;
            arr2=num1;
            System.out.println(Arrays.toString(arr1));
            System.out.println(Arrays.toString(arr2));
            for (int i = 0; i < arr1.length-1; i++) {
                if(arr1[i]==arr1[i+1]){
                    continue;
                }
                else if(arr1[i]==arr2[i+1]){
                    count++;
                    int temp=arr1[i+1];
                    arr1[i+1]=arr2[i+1];
                    arr2[i+1]=temp;
                }
                else{
                    break;
                }
            }
        }
        HashSet<Integer> hash1=new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            hash1.add(arr1[i]);
        }
        if(hash1.size()==1){
            return count;
        }
        else{
            return -1;
        }
    }
}
