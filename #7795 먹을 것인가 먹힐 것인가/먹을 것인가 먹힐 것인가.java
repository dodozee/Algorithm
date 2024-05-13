import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            int[] Asize = new int[A];
            int[] Bsize = new int[B];
            
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < A; j++){
                Asize[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int k=0; k<B; k++) {
                Bsize[k] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(Asize);
            Arrays.sort(Bsize);
            int count = 0;
            for(int j=0; j<Asize.length; j++){
                for(int k=0; k<Bsize.length; k++){
                    if(Asize[j]<=Bsize[k]) {
                        break;
                    }
                    else
                        count++;
                }
            }
            System.out.println(count);
        }
    }
}