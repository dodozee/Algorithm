import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String[] handle = new String[n];
        for(int i=0; i<n; i++){
            handle[i]=br.readLine();
        }

        System.out.println(solution(handle, k));
    }

    public static String solution(String[] handle, int k){
        Arrays.sort(handle);
        return handle[k-1];
    }
}