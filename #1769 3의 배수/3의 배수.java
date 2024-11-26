import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        confirm(N);
    }

    public static void confirm(String N){
        int cnt =0;

        while(true){
            if(N.length()==1) 
                break;

            long sum=0;

            for(int i=0;i< N.length();i++){
                sum+=Long.parseLong(String.valueOf(N.charAt(i)));
            }
            cnt++;
            N=String.valueOf(sum);
        }

        System.out.println(cnt);
        if(Long.parseLong((N))%3==0){
            System.out.println("YES");
        }else{
            System.out.print("NO");
        }

    }

}
