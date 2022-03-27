package Recursion;
import java.util.*;
public class flood_fill {
    public static void main(String[] args) {
        int[][] maze={{0,0,1,0,0},{0,1,0,0,0},{0,0,0,0,0},{1,0,0,0,0}};
        boolean[][] visited=new boolean[maze.length][maze[0].length];
        flodfilling(maze,0,0,visited,"");

    }

    private static void flodfilling(int[][] maze, int row, int col, boolean[][] visited,String psf) {

        if(row<0 ||col<0||row== maze.length||col==maze[0].length||maze[row][col]==1||visited[row][col]==true){
            return;
        }
        if(row== maze.length-1 && col==maze[0].length-1){
            System.out.println(psf);
            return;
        }

        visited[row][col]=true;
        flodfilling(maze,row-1,col,visited,psf+"T");
        flodfilling(maze,row+1,col,visited,psf+"D");
        flodfilling(maze,row,col+1,visited,psf+"R");
        flodfilling(maze,row,col-1,visited,psf+"L");
    }
}
