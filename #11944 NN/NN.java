import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str=br.readLine();
        
        String a=str.split(" ")[0];
        String b=str.split(" ")[1];
        
        String s="";

        for(int i=0;i<Integer.parseInt(a);i++){
            s+=a;
            if(s.length()>=Integer.parseInt(b)){
                bw.write(s.substring(0,Integer.parseInt(b)));
                break;
            }

        }

        if(s.length()<Integer.parseInt(b)){
            bw.write(s);
        }

        bw.flush();

    }

}