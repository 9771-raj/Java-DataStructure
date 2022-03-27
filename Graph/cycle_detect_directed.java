package Graph;
import java.util.*;
public class cycle_detect_directed {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(1).add(5);
        graph.get(2).add(3);
        graph.get(2).add(4);
        graph.get(3).add(7);
        graph.get(7).add(6);
        graph.get(6).add(3);
        graph.get(5).add(4);
        boolean[] visited=new boolean[graph.size()];
        boolean[] extra=new boolean[graph.size()];

        for (int i = 0; i < 6; i++) {
            boolean ans=false;
            if(visited[i]==false){
                 ans=check_cycle(i,graph,visited,extra);
            }
            if (ans==true){
                System.out.println("Cycle present");
                break;
            }

        }


    }

    private static boolean check_cycle(int start,ArrayList<ArrayList<Integer>> graph,boolean[] visited,boolean[] extra) {
        visited[start]=true;
        extra[start]=true;
        for (Integer i:graph.get(start)){
            if (visited[i]==false){
                if (check_cycle(i,graph,visited,extra)==true){
                    return true;
                }
            }
            else if(extra[i]==true){
                return true;
            }
        }
        extra[start]=false;
        return false;
    }
}
