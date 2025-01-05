import java.util.*;

public class Main {
    static int N;
    static Queue<String> Q[];
    static Queue<String> T = new LinkedList<String>();
    
	public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Q = new LinkedList[N];
        for (int i=0; i<N; i++) {
            Q[i] = new LinkedList<String>();
        }
        sc.nextLine();
        for (int i=0; i<N; i++) {
            String str = sc.nextLine();
            String s[] = str.split(" ");
            for (int j=0; j<s.length; j++) {
                Q[i].add(s[j]);
            }
        }
        String tmp = sc.nextLine();
        String t[] = tmp.split(" ");
        for (int i=0; i<t.length; i++) {
            T.add(t[i]);
        }
	
        while (!T.isEmpty()) {
            String word = T.poll();
            boolean found = false;
            for (int i=0; i<N; i++) {
                if (word.equals(Q[i].peek())) {
                    Q[i].poll();
                    found = true;
                }
            }
            if (!found) { 
                System.out.println("Impossible");
                return;
            }
        }
        for (int i=0; i<N; i++) { 
            while(!Q[i].isEmpty()) {
                System.out.println("Impossible");
                return;
            }
        }
        System.out.println("Possible");
	}
}