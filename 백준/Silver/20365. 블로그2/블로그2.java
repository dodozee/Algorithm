 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;
 
public class Main {
	private static int N, M, Q, K, X;
    private static char[] arr;
    private static char[] colored;
    private static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        arr = new char[N];
        arr = st.nextToken().toCharArray();
 
        char before ='X';
        int redCnt = 0, blueCnt = 0;
        for(int i=0; i<N; i++) {
        	if(arr[i] != before) {
        		if(arr[i] == 'R') redCnt += 1;
        		else if(arr[i] == 'B') blueCnt += 1;
        		before = arr[i];
        	}
        }
        
        answer = Math.min(redCnt, blueCnt) + 1;
        System.out.println(answer);
    }
    
}