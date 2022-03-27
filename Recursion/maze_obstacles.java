package Recursion;

public class maze_obstacles {
    public static void main(String[] args) {
        boolean[][] maze={{true,true,true},{true,false,true},{true,true,true}};
        find_path("",maze,0,0);
    }

    private static void find_path(String str,boolean[][] maze,int r,int c) {
        if(r==maze.length-1&& c==maze[0].length-1){
            System.out.println(str);
            return;
        }
        if(maze[r][c]==false){
            return;
        }

        if(r<maze.length-1){
            find_path(str+"D",maze,r+1,c);
        }
        if(c<maze[0].length-1){
            find_path(str+"R",maze,r,c+1);
        }
    }

}
