package problems;
// making the string palindrome at most removal of one character
// LeetCode validPalindrome 2

public class valid_palindrome2 {
    public static void main(String[] args) {
        String s="abcccccccbda";
        int i=0;
        int j=s.length()-1;
        while (i<j){
            if (s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }
            else{
                String str=s.substring(0,i)+s.substring(i+1,s.length());
                String str2=s.substring(0,j)+s.substring(j+1,s.length());
                if (isvalid(str)){
                    System.out.println("valid");
                    break;
                }
                else if (isvalid(str2)){
                    System.out.println("valid");
                    break;
                }
                else{
                    System.out.println("not valid");
                    break;
                }
            }
        }
    }
    private static boolean isvalid(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
