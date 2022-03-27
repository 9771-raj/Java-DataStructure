package Generic_tree;
import java.util.*;


public class generic_tree {
    static class generic_node{
        int val;
        ArrayList<generic_node> children=new ArrayList<>();
    }

    public static void main(String[] args) {
        int[] arr={10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        generic_node root=build_tree(arr);
        display(root);
        int size=tree_size(root);
        System.out.println("size of tree = "+size);
        int max;
        max=maximum(root);
        System.out.println("Maximum = "+max);
        int height=height(root);
        System.out.println(height);
        //preorder traversal
        System.out.print("preorder traversal = "+root.val+" ");
        preorder(root);
        levelorder(root);

    }

    private static void levelorder(generic_node root) {

    }

    private static void preorder(generic_node root) {
        for (generic_node child:root.children){
            System.out.print(child.val+" ");
            preorder(child);
        }
    }

    private static int height(generic_node root) {
        int ht=-1; // wrt edges  // if we want to height wrt node then ht=0
        for(generic_node child:root.children){
            int ch=height(child);
            ht=Math.max(ht,ch);
        }
        return ht+1;
    }

    private static int maximum(generic_node root) {
        int max=Integer.MIN_VALUE;
        for(generic_node child:root.children){
            int cmax=maximum(child);
            max=Math.max(cmax,max);
        }
        return Math.max(root.val,max);
    }

    private static int tree_size(generic_node root) {  // total number of node in the generic tree
        int s=0;
        for(generic_node child:root.children){
            int sc=tree_size(child);
            s=s+sc;
        }
        return s+1;
    }

    private static void display(generic_node root) {
        String str=root.val+"->";
        for(generic_node child:root.children){

            str+=child.val+", ";
        }
        str+=".";
        System.out.println(str);
        for(generic_node child:root.children){
            display(child);
        }
    }

    private static generic_node build_tree( int[] arr) {
        generic_node root=new generic_node();
        Stack<generic_node> stack=new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==-1){
                stack.pop();
            }else {
                generic_node t=new generic_node();
                t.val=arr[i];
                if(stack.size()>0){
                    stack.peek().children.add(t);
                }else{
                    root=t;
                }
                stack.push(t);
            }
        }
        return root;

    }
}
