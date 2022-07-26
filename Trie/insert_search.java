package Trie;
import java.util.*;

public class insert_search {
    public static class Trie{
        private class Node{
            Node[] childs=new Node[26];
            boolean isEnd;
        }
        final private Node root;
        public Trie(){
            root=new Node();
        }

        // insert in trie
        public void insertion(String str){
            Node curr=root;
            for (int i = 0; i < str.length(); i++) {
                char ch=str.charAt(i);
                if (curr.childs[ch-'a']==null){
                    curr.childs[ch-'a']=new Node();
                }
                curr=curr.childs[ch-'a'];
            }
            curr.isEnd=true;
        }

        // search in trie
        public boolean search(String str){
            Node curr=root;
            for (int i=0;i<str.length();i++){
                char ch=str.charAt(i);
                if (curr.childs[ch-'a']==null) return false;
                curr=curr.childs[ch-'a'];
            }
            return curr.isEnd;
        }

        // starts with in trie
        public boolean startswith(String str){
            Node curr=root;
            for (int i = 0; i < str.length(); i++) {
                char ch=str.charAt(i);
                if (curr.childs[ch-'a']==null) return false;
                curr=curr.childs[ch-'a'];
            }
            return true;
        }

    }
    public static void main(String[] args) {
        Trie t=new Trie();
        String[] arr={"apple","appe","ape"};
        for (String s:arr){
            t.insertion(s);
        }
        System.out.println(t.search("app"));
        System.out.println(t.startswith("app"));

    }
    
}
