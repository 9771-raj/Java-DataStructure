package BinarySearch;

import java.util.Scanner;
/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        for (int p=0;p<test ;p++ ){
            int len=sc.nextInt();
            String str=sc.next();

            if(checkPalindrome(str)){
                System.out.println(0);
            }
            else{
                int i=0;
                int j=len-1;

                int count=0;
                while(i<=j){
                    if(str.charAt(i)!=str.charAt(j)){
                        count++;
                        int a=Integer.valueOf(str.charAt(i));
                        int b=Integer.valueOf(str.charAt(j));
                        int xor=a^b;
                        System.out.println("xor "+xor);
                        // str.charAt(i)=(char)xor;
                        // str.charAt(j)=(char)xor;

                        str = str.substring(0, i) + xor + str.substring(i + 1);
                        str = str.substring(0, j) + xor + str.substring(j + 1);
                        System.out.println("string "+str);
                        if(checkPalindrome(str)){
                            System.out.println(" count " +count);
                            break;
                        }
                        i++;
                        j--;

                    }
                    else{
                        i++;
                        j--;
                    }

                }
                count=0;
            }

        }

    }

    private static boolean checkPalindrome(String str){
        int start=0;
        int end=str.length()-1;
        while(start<=end){
            if(str.charAt(start)!=str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
