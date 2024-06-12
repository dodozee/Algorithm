import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
   
    static int t,n;
    static int arr[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        t = Integer.parseInt(br.readLine());
        
        while(t>0) {
            t--;
            n = Integer.parseInt(br.readLine());
            int min = Integer.MAX_VALUE;
            arr = new int[n];
            String[] t = br.readLine().split(" ");
            for(int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(t[i]);
            }
            
            int ans[] = new int[n];
            
            Arrays.sort(arr);
            
            int left = 0;
            int right = n-1;
            
            
            
            for(int i=0; i<n; i++) {
                if(i%2!=0) {
                    ans[left] = arr[i];
                    left+=1;
                }
                else {
                    ans[right] = arr[i];
                    right-=1;
                }
            }
            
            int mini = Math.abs(ans[0]-ans[n-1]);

            for(int i=1; i<n; i++) {
                mini = Math.max(mini, Math.abs(ans[i]-ans[i-1]));
            }
            
            System.out.println(mini);
        }
        
    }
}