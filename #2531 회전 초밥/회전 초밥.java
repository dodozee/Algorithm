import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] eating = new int[d+1];	
        eating[c] = 3001;	
        int[] dish = new int[N];
        int count = 1;	
        for(int i=0; i < N ;i++)
            dish[i] = Integer.parseInt(br.readLine());
        for(int i=0; i < k ;i++){
            int sushiId = dish[i];
            if(eating[sushiId]==0)
                count++;
            eating[sushiId]++;
        }
        int max = count;
        for(int i=0;i<N-1;i++){
            int s_id = dish[i];	
            int e_id = dish[i+k<N ? i+k : (i+k) % N];	
            if(--eating[s_id] == 0)		
                count--;
            if(++eating[e_id] == 1)	
                count++;
            max = Math.max(max, count);	
        }
        bw.write(String.valueOf(max));	
        bw.flush();		
    }
}

