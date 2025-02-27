import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N=Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int result=0;

        if(N==1){
            result = 0;   
        }else if(x == 1 && y == 1 || x == 1 && y==N || x == N && y == 1 || x == N && y == N){
            result = 2;
        }else if(x == 1 || x == N || y == 1 || y == N){
            result = 3;
        }else{
            result = 4;
        }

        System.out.print(result);

        br.close();
    }
}