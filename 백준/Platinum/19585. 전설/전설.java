import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        TrieNode(){
            children=new TrieNode[26];
            isEnd=false;
        }
    }

    static class Trie {
        TrieNode root;

        Trie(){
            this.root=new TrieNode();
        }
    }

    static StringBuilder sb=new StringBuilder();
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Set<String> nicknames =new HashSet<>();
    static Trie colorTrie =new Trie();

    public static void main(String[] args)throws IOException {
        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++){
            String s=br.readLine();
            TrieNode temp= colorTrie.root;
            for(char c:s.toCharArray()){
                if(temp.children[c-'a']==null){
                    temp.children[c-'a']=new TrieNode();
                }
                temp=temp.children[c-'a'];
            }
            temp.isEnd=true;
        }
        for(int i=0;i<m;i++){
            nicknames.add(br.readLine());
        }
        int q=Integer.parseInt(br.readLine());

        for(int i=0;i<q;i++){
            String s=br.readLine();
            if(isValid(s)) {
                sb.append("Yes").append("\n");
            } else {
                
                sb.append("No").append("\n");
            }
        }
        System.out.print(sb);
    }

    static boolean isValid(String s) {
        TrieNode temp = colorTrie.root;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(temp.children[c-'a'] == null) {
                return false;
            }
            temp = temp.children[c-'a'];
            if(temp.isEnd && nicknames.contains(s.substring(i+1))) {
                return true;
            }
        }
        return false;
    }
}