import java.io.*;
public class Main{
	static int MOD = 1000000007;	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long N = Long.parseLong(br.readLine());
        if(N==0)	
        	bw.write(0 + "\n");
        else {		
            long[][] arr = {{1,1},{1,0}};
            long[][] result = arrPow(arr, N);	
            bw.write((result[1][0] % MOD) + "\n");	
        }
        bw.flush();		
        bw.close();
        br.close();
    }
    public static long[][] arrPow(long[][] A, long N){
    	if(N==1)
    		return A;
    	
    	long[][] temp = arrPow(A,N/2);
    	
    	if(N%2==0) {	//계수가 짝수일 때
    		return arrMul(temp,temp);
    	}else {		//계수가 홀수일 때
    		return arrMul(arrMul(temp, temp), A);
    	}
    }
    public static long[][] arrMul(long[][] A, long[][] B){
    	long[][] temp = new long[2][2];
    	for(int i=0;i<2;i++) {
    		for(int j=0;j<2;j++) {
    			for(int k=0;k<2;k++) {
    				temp[i][j] += A[i][k] * B[k][j];
    				temp[i][j] %= MOD;
    			}
    		}
    	}
    	return temp;
    }
}