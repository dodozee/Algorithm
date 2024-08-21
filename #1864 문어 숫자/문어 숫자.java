import java.io.*;
import java.util.ArrayList;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            String s = br.readLine();
            ArrayList<Character> charlist = new ArrayList<Character>();
            
            for(int i = s.length()-1; i >= 0 ; i--) {  
                if(s.charAt(i) == '#') {
                    return;
                }
                charlist.add(s.charAt(i));
            }
            
            int res = 0;
            
            for(int i = 0; i < charlist.size(); i++) {
 
                switch(charlist.get(i)) {
                case '-':
                    res += 0;
                    break;
                case '(':
                    res += 2 * Math.pow(8, i);
                    break;
                case '@':
                    res += 3 * Math.pow(8, i);
                    break;
                case '?':
                    res += 4 * Math.pow(8, i);
                    break;
                case '>':
                    res += 5 * Math.pow(8, i);
                    break;
                case '&':
                    res += 6 * Math.pow(8, i);
                    break;
                case '%':
                    res += 7 * Math.pow(8, i);
                    break;
                case '/':
                    res += -1 * Math.pow(8, i);
                    break;
                default:    
                    res += Math.pow(8, i);
                    break;
                }
            }
            System.out.println(res);
        }
 
    }
 
}
 