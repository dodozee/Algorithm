import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int endTime = 0;
        int arr[][] = new int[n][2];

        for(int i=0; i< n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1,o2)-> o1[0]-o2[0]);
        
        for(int i=0;i<n;i++){
            if(endTime < arr[i][0]){
                endTime= arr[i][0]+arr[i][1];
            }
            else
                endTime += arr[i][1];
        }
        bw.write(endTime+"");
        bw.flush();
        
    }
}