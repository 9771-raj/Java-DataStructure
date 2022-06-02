package BinaryTree;
import java.util.*;
public class lowest_common_ancestor {

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

        int num1=3;
        int num2=6;
        ArrayList<Integer> arr1=new ArrayList<>();
        ArrayList<Integer> arr2=new ArrayList<>();
        find_path(root,num1,arr1);
        find_path(root,num2,arr2);
        System.out.println(arr1);
        System.out.println(arr2);

        // lowest common ancestor
        int lca=-1;
        for (int i = 0; i < Math.min(arr1.size(), arr2.size()); i++) {
            if (arr1.get(i)==arr2.get(i)){
                lca=arr1.get(i);
            }
            else{
                break;
            }
        }
        System.out.println(lca);


    }

    private static boolean find_path(TreeNode root, int num,ArrayList<Integer> arr) {
        if(root==null){
            return false;
        }
        arr.add(root.data);
        if (root.data==num){
            return true;
        }
        if (find_path(root.left,num,arr) || find_path(root.right,num,arr)){
            return true;
        }
        arr.remove(arr.size()-1);
        return false;

    }
}
