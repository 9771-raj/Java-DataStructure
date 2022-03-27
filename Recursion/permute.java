package Recursion;

public class permute {
    public static void main(String[] args) {
        String str="abc";
        solution(str.toCharArray(),0);
    }

    private static void solution(char[] str, int index) {
        if(index==str.length-1){
            System.out.println(String.valueOf(str));
            return;
        }
        for (int i = index; i < str.length; i++) {
            swap(str,index,i);
            solution(str,index+1);
            swap(str,index,i);
        }
    }

    private static void swap(char[] str, int index, int i) {
        char temp=str[i];
        str[i]=str[index];
        str[index]=temp;
    }
}
