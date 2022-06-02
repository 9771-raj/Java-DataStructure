package BinaryTree;
import java.util.*;
public class path_09_sum {
     static String str="";
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.right.left=new TreeNode(5);
        root.right.right=new TreeNode(3);
        root.left.left=new TreeNode(4);

        ArrayList<String> ans=new ArrayList<>();
        solution(root,ans);
        int sum=0;
        for(int i=0;i<ans.size();i++){
            sum+=Integer.parseInt(ans.get(i));
        }
        System.out.println(sum);
    }
    public static void solution(TreeNode root,ArrayList<String> ans){
        if(root==null){
            //str=str.substring(0,str.length()-1);
            return;
        }
        str=str+root.data;
        if(root.left==null && root.right==null){
            System.out.println(str);
            ans.add(str);
            str=str.substring(0,str.length()-1);
            return;
        }

        solution(root.left,ans);
        solution(root.right,ans);
        str=str.substring(0,str.length()-1);
    }
}
