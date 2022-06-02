package BinaryTree;
 // Both Brute Force and Efficient approach
public class diameter_tree {
    static class pair{
        int ht;
        int dia;
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.left.left=new TreeNode(7);

        int dia=Diameter(root);
        System.out.println(dia);
        System.out.println("-------");
        pair p=Diameter_modified(root);
        System.out.println(p.dia);
    }

    private static int Diameter(TreeNode root) {
        if (root==null){
            return -1;           // path between two leaf nodes
        }
        int op1=Diameter(root.left);
        int op2=Diameter(root.right);
        int op3=Height(root.left)+Height(root.right)+2;

        return Math.max(op1,Math.max(op2,op3));
    }

    private static int Height(TreeNode root) {
        if (root==null) return -1;

        return Math.max(Height(root.left),Height(root.right))+1;
    }

    // optimal version of finding diameter of tree O(n)
    private static pair Diameter_modified(TreeNode root){
        if (root==null){
            pair p=new pair();
            p.ht=-1;
            p.dia=0;
            return p;
        }
        pair left_pair=Diameter_modified(root.left);
        pair right_pair=Diameter_modified(root.right);

        pair mp=new pair();
        mp.ht=Math.max(left_pair.ht,right_pair.ht)+1;

        int tes=left_pair.ht+right_pair.ht+2;

        mp.dia=Math.max(tes,Math.max(left_pair.dia,right_pair.dia));
        return mp;

    }

}
