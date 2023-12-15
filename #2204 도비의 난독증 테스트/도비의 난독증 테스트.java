import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!
    public static void main(String [] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringBuilder sb = new StringBuilder();
        
        while(true){
            String num = br.readLine();
            if(num.equals("0")){
                break;
            }
            
            List<String> words = new ArrayList<>();
            for(int i=0; i < Integer.parseInt(num); i++){
                words.add(br.readLine());
            }
            
            words.sort(String::compareToIgnoreCase);
            System.out.println(words.get(0));
        }
    }
}