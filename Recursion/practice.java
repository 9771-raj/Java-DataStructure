package Recursion;
import java.util.*;
public class practice {
    public static void main(String[] args) {
        String str="hel";
        //sub_revision(str,"");
//        int[] arr={1,2,3};
//        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
//        all_subset(arr,0,new ArrayList<>(),ans);
//        System.out.println(ans);

//        String[] arr={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
//        String digits="23";
//        ArrayList<String> ans=letter_combination(arr,digits,"");
//        System.out.println(ans);
//        int count=letter_combination_count(arr,digits,"");
//        System.out.println(count);
//
//        // combination target sum, dice roll
//        int target=5;
//
//        target_sum("",target);
        // combination sum
        int[] arr={1,2,3,4};
        int target=5;
        find_all_combination(0,arr,target,new ArrayList<>());



    }

    private static void find_all_combination(int index,int[] arr, int target,ArrayList<Integer> store) {
        if (target==0){
            System.out.println(store);
            return;
        }
        if (index==arr.length) return;

        if (arr[index]<=target){
            store.add(arr[index]);
            find_all_combination(index,arr,target-arr[index],store);
            store.remove(store.size()-1);

        }
        find_all_combination(index+1,arr,target,store);
    }

    private static void target_sum(String s, int target) {
        if (target==0){
            System.out.println(s);
            return;
        }
        for (int i = 1; i <=6 && i<=target; i++) {
            target_sum(s+i,target-i);
        }
    }

    // recursion return arraylist
    private static ArrayList<String> letter_combination(String[] arr, String digits,String up) {
        if (digits.isEmpty()){
            ArrayList<String> a=new ArrayList<>();
            a.add(up);
            return a;
        }
        int digit=digits.charAt(0)-'0';
        ArrayList<String> b=new ArrayList<>();
        String str= arr[digit];
        for (int i = 0; i < str.length(); i++) {
            char ch=str.charAt(i);
            b.addAll(letter_combination(arr,digits.substring(1),up+ch));
        }
        return b;
    }
    // recursion return counting of total combination in answer list
    private static int letter_combination_count(String[] arr, String digits,String up) {
        if (digits.isEmpty()){
            return 1;
        }
        int digit=digits.charAt(0)-'0';
        String str=arr[digit];
        int count=0;
        for (int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            count+=letter_combination_count(arr,digits.substring(1),ch+up);
        }
        return count;

    }

    private static void sub_revision(String str,String ans){
        if (str.length()==0){
            System.out.println(ans);
            return;
        }
        char ch=str.charAt(0);
        sub_revision(str.substring(1),ch+ans);
        sub_revision(str.substring(1),ans);

    }

    private static void all_subset(int[] arr,int i,ArrayList<Integer> spike,ArrayList<ArrayList<Integer>> store){
        if (i==arr.length){
            store.add(new ArrayList<>(spike));
            return;
        }
        spike.add(arr[i]);
        all_subset(arr,i+1,spike,store);
        spike.remove(spike.size()-1);
        all_subset(arr,i+1,spike,store);
    }




}
