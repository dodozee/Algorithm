import java.math.BigInteger;
import java.util.*;
import java.io.*;
 
 
 
public class Main {
 
    static int t;
    static int [] table;
    
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String p = br.readLine();
 
        table = new int [p.length()];
 
        System.out.println(KMP(s,p));
 
    }
 
    
 
    private static void makeTable(String p){
        int n = p.length();
 
        int idx=0;
 
        for(int i=1; i<n; i++){
            while(idx>0 && p.charAt(i)!=p.charAt(idx)){
                idx= table[idx-1];
            }
 
            if(p.charAt(i)==p.charAt(idx)){
                idx++;
                table[i]=idx;
            }
        }
    }
    
    private static int KMP(String s, String p){
        makeTable(p);
        int sLength=s.length();
        int pLength=p.length();
 
        int idx =0;
 
        for(int i=0; i<sLength; i++){
            while(idx>0 && s.charAt(i) != p.charAt(idx)){
                idx=table[idx-1];
            }
            if(s.charAt(i)==p.charAt(idx)){
                if(idx==pLength-1){
                    idx=table[idx];
                    return 1;
                }
                else{
                    idx+=1;
                }
            }
        }
        return 0;
    }
 
}