import java.io.*;
import java.util.*;

public class Main {

	static final int SIZE = 26;
	static class TrieNode{
		boolean output;
		Map<Character, TrieNode> child = new HashMap<>();
		TrieNode fail;
		public TrieNode() {}
		
		public void insert(String word) {
			TrieNode curNode = this;
			for(int i=0; i<word.length(); i++) {
				char c = word.charAt(i);
				
				curNode.child.putIfAbsent(c, new TrieNode());
				curNode = curNode.child.get(c);
				
				if(i== word.length()-1) {
					curNode.output = true;
				}
			}
		}
		
		public void computeFailFunc() {
			Queue<TrieNode> q = new LinkedList<>();
			this.fail = this;
			q.add(this);
			
			while(!q.isEmpty()) {
				TrieNode cur = q.poll();
				for(int i=0; i<SIZE; i++) {
					char c = (char)(i+97);
					
					TrieNode nxt = cur.child.get(c);
					if(nxt ==null) continue;
					
					if(cur == this) { 
						nxt.fail = this;
					}else { 
						TrieNode failLinkNode = cur.fail;
						while(failLinkNode!=this && failLinkNode.child.get(c) == null) {
							failLinkNode = failLinkNode.fail;
						}
						if(failLinkNode.child.get(c) != null) {
							failLinkNode = failLinkNode.child.get(c);
						}
						nxt.fail = failLinkNode;
					}
					
					if(nxt.fail.output) {
						nxt.output =true;
					}
					q.add(nxt);
				}
			}
		}
		public boolean ahoCorasick(String word) {
			TrieNode curNode = this;
			for(int i=0; i<word.length(); i++) {
				char c = word.charAt(i);
				while(curNode != this && curNode.child.get(c) ==null) {
					curNode = curNode.fail;
				}
				if(curNode.child.get(c)!=null) {
					curNode = curNode.child.get(c);
				}
				
				if(curNode.output) {
					return true;
				}
			}
			return false;
			
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		TrieNode trieSet = new TrieNode();
		for(int i=0; i<n; i++) {
			trieSet.insert(br.readLine());
		}
		
		trieSet.computeFailFunc();
		
		StringBuilder sb = new StringBuilder();
		int q = Integer.parseInt(br.readLine());
		for(int i=0; i<q; i++) {
			if(trieSet.ahoCorasick(br.readLine())) {
				sb.append("YES\n");
			}else {
				sb.append("NO\n");
			}
		}
		System.out.println(sb.toString());
	}
}