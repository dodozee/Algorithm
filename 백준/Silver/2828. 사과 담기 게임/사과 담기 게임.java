import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(br.readLine());
        int answer = 0;	
        int start = 1, end = M;	
        for(int i=0;i<j;i++){
            int apple = Integer.parseInt(br.readLine());
            if(start > apple){		
                answer += start - apple;	
                end -= start - apple;	
                start = apple;		
            }else if(end < apple){	
                answer += apple - end;	
                start += apple - end;	
                end = apple;	
            }
        }
        bw.write(answer + "");		
        bw.flush();		
        bw.close();
        br.close();
    }
}