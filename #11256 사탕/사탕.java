import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        final int NUMBER_OF_TESTCASE = Integer.parseInt(br.readLine());
        
        for(int k=0;k<NUMBER_OF_TESTCASE;k++){
            st = new StringTokenizer(br.readLine());
            int CANDY_NUMBER = Integer.parseInt(st.nextToken());
            int BOX_NUMBER = Integer.parseInt(st.nextToken());
            int boxSize[] = new int [BOX_NUMBER];
            for(int i=0;i<BOX_NUMBER;i++) {
                st = new StringTokenizer(br.readLine());
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());
                boxSize[i] = num1 * num2;
            }

            Arrays.sort(boxSize);
            int answer = 0;
            for(int i=BOX_NUMBER-1;i>-1;i--) {
                answer++;
                CANDY_NUMBER-=boxSize[i];
                if(CANDY_NUMBER < 1) {
                    break;
                }
            }


            sb.append(answer);
            sb.append("\n"); 
        }
        bw.write(sb.toString());
        bw.flush();
    
        
    }

    
}