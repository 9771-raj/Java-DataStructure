package problems;

public class training {
    public static void main(String[] args) {
        String s="abcd";
        String t="abcde";
        char ch=0;
        System.out.println(ch);
        for(char chs:s.toCharArray()){
            ch^=chs;
        }

        for(char chs:t.toCharArray()){
            ch^=chs;
        }
        System.out.println(ch);
    }
}
