package divide_conquere;
import java.util.*;       // merge two sorted array
public class merge_sort {
    public static void main(String[] args) {
        int[] ans=merge_two_sort(new int[]{1,3,4,22},new int[]{9,10,12});
        System.out.println(Arrays.toString(ans));

    }
    public static int[] merge_two_sort(int[] first,int[] second){
        int[] ans=new int[first.length+second.length];
        int i=0,j=0,k=0;
        while(i<first.length && j< second.length){
            if(first[i]>=second[j]){
                ans[k]=second[j];
                j++;
                k++;
            }
            else if(first[i]<second[j]){
                ans[k]=first[i];
                i++;
                k++;
            }
        }
        while(i< first.length){
            ans[k]=first[i];
            i++;
            k++;
        }
        while(j< second.length){
            ans[k]=second[j];
            j++;
            k++;
        }
        return ans;
    }
}
