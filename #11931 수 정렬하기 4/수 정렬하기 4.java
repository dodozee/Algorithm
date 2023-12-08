import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!!!
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        Integer arr[] = new Integer[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr, Collections.reverseOrder());
		
		for (Integer i : arr) 
			bw.write(i+"\n"); 
            
        bw.flush();
    }
}