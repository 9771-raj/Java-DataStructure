package Recursion;
import javax.swing.*;
import java.util.*;
public class subsequence_target_sum {
    public static void main(String[] args) {
        int[] arr={1,2,1,3,1};
        int target=3;
        f(0,arr,new ArrayList<>(),target,0);
        //System.out.println("one answer -");
        //one_answer(0,arr,new ArrayList<>(),target,0);
        int ans=counting(arr,0,target,0);
        System.out.println(ans);
    }

    // printing all target subsequences
    static void f(int ind  ,int a[]  ,ArrayList<Integer> list,  int k,int sum){
        if(ind==a.length){
            if(k==sum){
                System.out.println(list);
            }
            return ;
        }
        //take
        list.add(a[ind]);
        sum+=a[ind];
        f(ind+1,a,list,k,sum);

        list.remove(list.size() - 1);
        sum-=a[ind];
        f(ind+1,a,list,k,sum);

    }
    //
    // technique for printing only one answer
    static boolean one_answer(int ind,int a[],ArrayList<Integer> list,int k,int sum){
        if (ind==a.length) {
            if (k==sum){
                System.out.println(list);
                return true;
            }
            else return false;
        }
        list.add(a[ind]);
        sum+=a[ind];
        if (one_answer(ind+1,a,list,k,sum)==true){
            return true;
        }
        list.remove(list.size() - 1);
        sum-=a[ind];
        if (one_answer(ind+1,a,list,k,sum)==true){
            return true;
        }
        return false;
    }

    // returning count

    static int counting(int[] arr,int i,int target,int sum){
        if (i==arr.length){
            if (target==sum) return 1;
            else return 0;
        }
        sum+=arr[i];
        int l=counting(arr,i+1,target,sum);
        sum-=arr[i];
        int r=counting(arr,i+1,target,sum);
        return l+r;
    }

}
