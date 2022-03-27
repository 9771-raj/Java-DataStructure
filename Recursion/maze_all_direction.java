package Recursion;

public class maze_all_direction {
    public static void main(String[] args) {
        boolean[][] maze={{true,true,true},{true,true,true},{true,true,true}};
        all_path("",maze,0,0);
    }

    private static void all_path(String str, boolean[][] maze, int r, int c) {
        if(r==maze.length-1 && c==maze[0].length-1){
            System.out.println(str);
            return;
        }
        if(maze[r][c]==false){
            return;
        }
        maze[r][c]=false; // so don't go back from that path
        if(r<maze.length-1){
            all_path(str+"D",maze,r+1,c);
        }
        if(c<maze[0].length-1){
            all_path(str+"R",maze,r,c+1);
        }
        if(r>0){
            all_path(str+"U",maze,r-1,c);
        }
        if(c>0){
            all_path(str+"L",maze,r,c-1);
        }
        maze[r][c]=true;   // after coming from that function call we undo our changes that we make
    }
}
