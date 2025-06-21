import java.io.*;

public class Main {
    static boolean[] primeArray = new boolean[1000001];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        findPrime();

        int T = Integer.parseInt(br.readLine()); 
        
        for(int i = 0; i < T; i++){
        
            int N  = Integer.parseInt(br.readLine()); 

            int partitionCount = 0; 

            if(N % 2 == 0 && N != 0) { 
                for (int j = 2; j <= N / 2; j++) {
                    if (!primeArray[j]) { 
                        if (!primeArray[N - j]) {
                            partitionCount++;
                        }
                    }
                }
                bw.write(partitionCount + "\n");
            }else{
                bw.write(0 + " \n");
            }
        }

        br.close();

        bw.flush();
        bw.close();
    }
    
    static void findPrime(){
        primeArray[0] = primeArray[1] = true;

        for (int i = 2; i < primeArray.length; i++) {

            if (primeArray[i] == false) {

                for (int j = 2; i * j < primeArray.length; j++) {
                    primeArray[i * j] = true;
                }
            }

        }
    }
}