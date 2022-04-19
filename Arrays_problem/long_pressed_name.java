package Arrays_problem;
import java.util.*;
public class long_pressed_name {
    public static void main(String[] args) {
        String name="saeed";
        String typed="ssaaeeddx";
        boolean ans=solution(name,typed);
        System.out.println(ans);
    }
    public static boolean solution(String name, String typed){
        int i=0;
        int j=0;
        while (i<name.length() && j<typed.length()){
            char ch=name.charAt(i);
            char ch2=typed.charAt(j);
            if (ch==ch2){
                 i++;
                 j++;
            }
            else if (i>0 && name.charAt(i-1)==typed.charAt(j)){
                j++;
            }
            else {
                return false;
            }
        }
        while (j<typed.length()){
            if (name.charAt(i-1)!=typed.charAt(j)) return false;
            j++;
        }
        return i<name.length()?false:true;
    }
}
