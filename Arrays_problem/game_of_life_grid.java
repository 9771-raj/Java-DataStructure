package Arrays_problem;
import java.util.*;
public class game_of_life_grid {
    public static void main(String[] args) {
        int[][] grid={
                {0,1,0},{0,0,1},{1,1,1},{0,0,0}
        };
        int[][] update=new int[grid.length][grid[0].length];
        /*
        * Any live cell with fewer than two live neighbors dies as if caused by under-population.
            Any live cell with two or three live neighbors lives on to the next generation.
            Any live cell with more than three live neighbors dies, as if by over-population.
            Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
          */
        int n=grid.length;
        int m=grid[0].length;
        int count0=0;
        int count;

    }
}
