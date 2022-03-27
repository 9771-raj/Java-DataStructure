package Recursion;

import java.util.ArrayList;

public class maze_problem {
    public static void main(String[] args) {
        int ans=maze_soln(3,3);
        System.out.println(ans);
        print_path("",3,3);
        System.out.println(return_path("",3,3));
        System.out.println(return_path_withDiagonal("",3,3));
    }
    // Number of path
    public static int maze_soln(int r,int c){
        if(r==1||c==1){
            return 1;
        }
        int left=maze_soln(r-1,c);
        int right=maze_soln(r,c-1);
        return left+right;
    }

    //Print all its path
    public static void print_path(String str,int r,int c){
        if(r==1&&c==1){
            System.out.println(str);
            return;
        }
        if(r>1){
            print_path(str+"D",r-1,c);
        }
        if(c>1){
            print_path(str+"R",r,c-1);
        }
    }

    //Returning ArrayList
    public static ArrayList<String> return_path(String str,int r,int c){
        if(r==1&&c==1){
            ArrayList<String> ans=new ArrayList<>();
            ans.add(str);
            return ans;
        }
        ArrayList<String> list=new ArrayList<>();
        if(r>1){
            list.addAll(return_path(str+"D",r-1,c));
        }
        if(c>1){
            list.addAll(return_path(str+"R",r,c-1));
        }
        return list;
    }

    //Including Diagonal
    public static ArrayList<String> return_path_withDiagonal(String str,int r,int c){
        if(r==1&&c==1){
            ArrayList<String> ans=new ArrayList<>();
            ans.add(str);
            return ans;
        }
        ArrayList<String> list=new ArrayList<>();
        if(r>1 && c>1){
            list.addAll(return_path_withDiagonal(str+"D",r-1,c-1));
        }
        if(r>1){
            list.addAll(return_path_withDiagonal(str+"V",r-1,c));
        }
        if(c>1){
            list.addAll(return_path_withDiagonal(str+"H",r,c-1));
        }
        return list;
    }

}
