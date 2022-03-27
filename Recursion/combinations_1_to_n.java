package Recursion;

import java.util.ArrayList;
import java.util.List;

public class combinations_1_to_n {
    public static void main(String[] args) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> store=new ArrayList<>();
        int n=5;
        int k=3;
        solution(n,k,1,store,result);
        System.out.println(result);
    }

    private static void solution(int n, int k,int start, List<Integer> store, List<List<Integer>> result) {
        if(store.size()==k){
            result.add(new ArrayList<>(store));
            return;
        }
        for(int i=start;i<=n;i++){
            store.add(i);
            solution(n,k,i+1,store,result);
            store.remove(store.size()-1);
        }

    }
}
