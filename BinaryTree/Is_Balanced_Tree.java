package BinaryTree;
  // A tree is balanced if Math.abs(Height(root.left)-Height(root.right))<=1 for all nodes
public class Is_Balanced_Tree {
    static class pair{
        boolean bal;
        int ht;
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.left.left=new TreeNode(0);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.left.left=new TreeNode(7);
        root.right.left.left.left=new TreeNode(7);
        TreeNode temp=root;
        Boolean ans=is_balancedTree(root);
        System.out.println(ans);
        System.out.println("--------------");
        pair ans2=isBalanced_tree(root);
        System.out.println(ans2.bal);

    }

      private static Boolean is_balancedTree(TreeNode root) {
          if (root==null){
              return true;
          }
          Boolean left=is_balancedTree(root.left);
          Boolean right=is_balancedTree(root.right);
          int ht_left=Height(root.left);
          int ht_right=Height(root.right);
          if (Math.abs(ht_left-ht_right)<=1 && left && right){
              return true;
          }
          return false;
      }
      private static int Height(TreeNode root) {
          if (root==null) return 0;

          return Math.max(Height(root.left),Height(root.right))+1;
      }

      // optimal approach for is balanced tree

      private static pair isBalanced_tree(TreeNode root){
        if (root==null){
            pair p=new pair();
            p.bal=true;
            p.ht=0;
            return p;
        }
        pair left=isBalanced_tree(root.left);
        pair right=isBalanced_tree(root.right);

        pair mp=new pair();
        mp.bal=Math.abs(left.ht-right.ht)<=1 && left.bal && right.bal;

        mp.ht=Math.max(left.ht,right.ht)+1;

        return mp;

      }
  }
