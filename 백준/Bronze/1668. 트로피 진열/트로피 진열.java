import java.io.*;
import java.util.StringTokenizer;
 
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int N = Integer.parseInt(st.nextToken());  
        int result_left = 1;
        int result_right = 1;
        int max_left = 0;
        int max_right = 0;
        int height[] = new int[N];
 
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            height[i] = Integer.parseInt(st.nextToken());
        }
 
        for(int i = 0; i < N-1; i++){
            if(max_left < height[i])
                max_left = height[i];
 
            if(max_left < height[i+1]){
                result_left++;
                max_left = height[i+1];
            }
        }
 
        for(int i = N-1; i > 0; i--){
            if(max_right < height[i])
                max_right = height[i];
 
            if(max_right < height[i-1]){
                result_right++;
                max_right = height[i-1];
            }
        }
        System.out.println(result_left + "\n" + result_right);
    }

}