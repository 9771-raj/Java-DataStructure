package problems;

public class practice {
    public static void main(String[] args) {
        String str="vadodara";
        String encrypt="";
        int len=str.length();
        int remain=len%3;
        int exchange=len/3;
        int n=0;
        for (int i = 0; i < exchange; i++) {
            encrypt=encrypt+str.charAt(n+2)+str.charAt(n+1)+str.charAt(n);
            n+=3;
        }
        if(remain==1){
            encrypt=encrypt+str.charAt(len-1);
        }
        if(remain==2){
            encrypt=encrypt+str.charAt(len-1)+str.charAt(len-2);
        }
        System.out.println(encrypt);
        String result="";
        int count=0;
        for (int i = 0; i < len; i++) {
            int ascii_a='a'+0; //97         Add 0 to any character to find its ascii value
            int ascii_z='z'+0; //122
            int val=((encrypt.charAt(i)+0)-ascii_a)%25;
            //System.out.println( val);
            char new_ch=(char) (ascii_z-val);
            result=result+new_ch;
        }
        System.out.println(result);
        for (int i = 0; i < len; i++) {
            char ch=result.charAt(i);
            for (int j = i+1; j < len; j++) {
                char data=result.charAt(j);
                if(ch+0 > data+0){
                    count++;
                }
            }
        }
        System.out.println(count);

    }
}
