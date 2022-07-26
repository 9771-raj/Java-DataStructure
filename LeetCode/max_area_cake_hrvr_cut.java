package LeetCode;
import java.util.*;
public class max_area_cake_hrvr_cut {
    public static void main(String[] args) {
        int[] hr={3};
        int[] vr={3};
        int row=5;
        int col=4;
        int ans=maxArea(row,col,hr,vr);
        System.out.println(ans);
    }
    // work for all test cases
    public static int maxArea(int row, int col, int[] hr, int[] vr) {
        Arrays.sort(hr);
        Arrays.sort(vr);
        int maxh=0;
        int maxv=0;
        maxh=Math.max(hr[0],row-hr[hr.length-1]); // first and last max cut
        maxv=Math.max(vr[0],col-vr[vr.length-1]);
        for(int i=1;i<hr.length;i++){
            maxh=Math.max(maxh,(hr[i]-hr[i-1]));  // max row cut
        }
        for(int i=1;i<vr.length;i++){
            maxv=Math.max(maxv,(vr[i]-vr[i-1]));   // max col cut
        }
        return (int)((long)maxv * maxh % 1000000007);

    }

    // first my approach       pass 52/56 testcases
    public static int approach(int row,int col,int[] hr,int[] vr){
        Arrays.sort(hr);
        Arrays.sort(vr);
        HashSet<Integer> row_cut=new HashSet<>();
        HashSet<Integer> col_cut=new HashSet<>();
        row_cut.add(hr[0]);
        for (int i = 1; i < hr.length; i++) {
            row_cut.add(hr[i]-hr[i-1]);
        }
        row_cut.add(row-hr[hr.length-1]);

        col_cut.add(vr[0]);
        for (int i = 1; i < vr.length; i++) {
            col_cut.add(vr[i]-vr[i-1]);
        }
        col_cut.add(col-vr[vr.length-1]);
        System.out.println(row_cut+" "+col_cut);

        int max=0;
        for (Integer i:row_cut){
            for (Integer j:col_cut){
                max=Math.max(max,i*j);
            }
        }
        System.out.println(max);
        return max;
    }
}
