package LeetCode;

public class concat_binary {
    public static void main(String[] args) {
        int ans=concatenatedBinary(12);
        System.out.println(ans);
    }
    public static int concatenatedBinary(int n) {
        String str="";
        for(int i=1;i<=n;i++){
            str+=Integer.toBinaryString(i);
        }
        System.out.println(str);


        int ans=0;
        int x = 1;
        for(int i=str.length()-1;i>=0;i--){
            if(str.charAt(i) == '1'){
                ans+=x;
                ans %= 1000000007;
            }

            x  = (2 * x) % 1000000007;

        }
        return ans;

    }
}

