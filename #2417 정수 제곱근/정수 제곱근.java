import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long answer = 0;
        
        long start = 0;
        long left = 0;
    	long right = n;
    	
    	while(left <= right) {
    		long middle = (left + right) / 2;
    		if( Math.pow( middle, 2) >= n) {
    			answer = middle;
    			right = middle - 1;
    		}
    		else if(Math.pow(middle, 2) < n){
    			left = middle + 1;
    		}
    	}
        
        System.out.println(answer);
    }

   
}