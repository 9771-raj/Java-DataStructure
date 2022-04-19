package Recursion;
import java.util.*;
public class rat_in_maze {
    public static void main(String[] args) {
        int[][] maze={
                {1,1,0,1,1},
                {0,1,0,1,1},
                {1,1,1,1,1},
                {0,1,0,1,1},
                {1,1,0,1,1}
        };
        // 1 -> traceable 0 -> not traceable
        // go only in down or right direction
        ArrayList<String> path=new ArrayList<>();
        find_path(maze,0,0,path,"");
        System.out.println(path);
    }

    private static void find_path(int[][] maze, int x, int y, ArrayList<String> path, String s) {
        if (x==maze.length-1 && y==maze[0].length-1){
            path.add(s);
            return;
        }
        if (x<maze.length && y<maze[0].length && maze[x][y]==0){
            return;
        }
        if (x<maze.length){
            find_path(maze,x+1,y,path,s+"D");
        }
        if (y<maze[0].length){
            find_path(maze,x,y+1,path,s+"R");
        }
    }
}
