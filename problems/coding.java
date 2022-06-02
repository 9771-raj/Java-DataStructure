package problems;
import java.util.*;
public class coding {
    public static void main(String[] args) {
        int test_case=1;
        ArrayList<String> str1=new ArrayList<>();


        ArrayList<String> str2=new ArrayList<>();
        ArrayList<String> str3=new ArrayList<>();
        str1.add("1");
        str1.add("2");
        str1.add("3");
        str2.add("1");str2.add("2");str2.add("3");
        str3.add("1");str3.add("2");str3.add("3");

        ArrayList<Integer> arr1=string_to_int(str1);
        ArrayList<Integer> arr2=string_to_int(str2);
        ArrayList<Integer> arr3=string_to_int(str3);

        boolean ans=solution(arr1,arr2,arr3);
        if (ans){
            System.out.println("yes");
        }
        else {
            System.out.println("no");
        }


    }

    private static boolean solution(ArrayList<Integer> arr1, ArrayList<Integer> arr2, ArrayList<Integer> arr3) {
        boolean flag1=false;
        boolean flag2=false;
        boolean flag3=false;
        for (int i = 0; i < arr1.size(); i++) {
            if (arr1.get(i)>arr2.get(i)){
                return false;
            }
            if (arr2.get(i)>arr3.get(i)){
                return false;
            }
            if (arr1.get(i)==arr2.get(i) && arr2.get(i)==arr3.get(i)){
                if (i==1){
                    flag1=true;
                }
                if (i==2){
                    flag2=true;
                }
                if (i==3){
                    flag3=true;
                }
            }

        }
        if (flag1 && flag2 && flag3){
            return false;
        }
        return true;
    }

    public static ArrayList<Integer> string_to_int(ArrayList<String> str){
        ArrayList<Integer> arr=new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            arr.add(Integer.parseInt(str.get(i)));
        }
        return arr;
    }
}
