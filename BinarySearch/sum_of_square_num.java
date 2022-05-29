package BinarySearch;

import java.util.Scanner;

public class sum_of_square_num {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long c=sc.nextLong();
        if (c==1){
            System.out.println("true");
        }
        long left=0;
        long right=(long)Math.sqrt(c);
        while (left<=right){
            long sum=left*left+right*right;
            if (sum==c){
                System.out.println(left +" "+right);
                break;
            }
            else if (sum>c){
                  right--;
            }
            else{
                left++;
            }
        }
    }
}
