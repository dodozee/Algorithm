import java.util.*;
import java.io.*;

public class Main {//박두지 화이팅!!!
    static char[] king, rock;
    static int n;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        king = stk.nextToken().toCharArray(); rock = stk.nextToken().toCharArray(); n = Integer.parseInt(stk.nextToken());
        for(int i=0; i<n; i++) {
            
            String cmd = br.readLine();
            char[] next_king = move(cmd, king);
            if(inRange(next_king)){ 
                if(next_king[0]==rock[0] && next_king[1]==rock[1]){ 
                    char[] next_rock = move(cmd,rock);
                    if(inRange(next_rock)){ 
                        king = next_king;
                        rock = next_rock;
                    }
                    else    continue; 
                }
                else{ 
                    king = next_king;
                }
            }
            else    continue;
        }

        bw.write(String.valueOf(king[0]) + String.valueOf(king[1]) + "\n");
        bw.write(String.valueOf(rock[0]) + String.valueOf(rock[1]));
        bw.close();
    }

    static Boolean inRange(char[] a){
        if(a[0]<'A' || a[0]>'H' || a[1]<'1' || a[1]>'8')    return false;
        else return true;
    }

    static char[] move(String cmd, char[] target){
        char[] result = target.clone();
        switch(cmd){
            case "R":
                result[0]++;
                break;
            case "L":
                result[0]--;
                break;
            case "B":
                result[1]--;
                break;
            case "T":
                result[1]++;
                break;
            case "RT":
                result[0]++;    result[1]++;
                break;
            case "LT":
                result[0]--;    result[1]++;
                break;
            case "RB":
                result[0]++;    result[1]--;
                break;
            case "LB":
                result[0]--;    result[1]--;
        }
        return result;
    }
}