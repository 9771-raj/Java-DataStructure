package BinaryTree;
import java.util.*;
// https://practice.geeksforgeeks.org/problems/sum-of-the-longest-bloodline-of-a-tree/1
public class sumOfLongRootToLeafPath {
    static int max_len=0;
    static int max_sum=Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.right.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.left.left=new TreeNode(0);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.left.left=new TreeNode(7);
        root.right.left.left.left=new TreeNode(7);

        int len=0;
        int sum=0;
        sum_OfLongRootToLeafPath(root,sum,len);
        System.out.println(max_sum);
    }

    private static void sum_OfLongRootToLeafPath(TreeNode root, int sum, int len) {
        if(root==null){
            if (len>max_len){
                max_len=len;
                max_sum=sum;
                //System.out.println(max_sum);
            }
            else if (max_len==len){
               // System.out.println(max_sum);
                max_sum=Math.max(max_sum,sum);
            }
            return;
        }
        sum=sum+root.data;
        sum_OfLongRootToLeafPath(root.left,sum,len+1);
        sum_OfLongRootToLeafPath(root.right,sum,len+1);

    }


}
