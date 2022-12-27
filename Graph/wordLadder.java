package Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
    A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words
    beginWord -> s1 -> s2 -> ... -> sk such that:
    Every adjacent pair of words differs by a single letter.
    Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
    sk == endWord
    Given two words, beginWord and endWord, and a dictionary wordList,
    return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.\
    Approach - BFS, minimum shortest path
*/
public class wordLadder {
    public static void main(String[] args) {

    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return f(beginWord,endWord,wordList);
    }
    private static int check(String s1,String s2){
        int count=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                count++;
            }
        }
        return count;
    }
    private static int f(String start, String end, List<String> bank){
        boolean[] visited=new boolean[bank.size()];
        Queue<String> q=new LinkedList<>();
        q.add(start);
        int ans=1;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                String gene=q.poll();
                if(gene.equals(end)){
                    return ans;
                }
                for(int i=0;i<bank.size();i++){
                    if(visited[i]==true) continue;
                    if(check(bank.get(i),gene)==1){
                        q.add(bank.get(i));
                        visited[i]=true;
                    }
                }
            }
            ans++;
        }
        return 0;
    }
}
