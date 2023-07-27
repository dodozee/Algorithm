import java.util.*;
import java.io.*;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,String> hashMap = new HashMap<>(){{
            put("black","0");
            put("brown", "1");
            put("red", "2");
            put("orange", "3");
            put("yellow", "4");
            put("green", "5");
            put("blue", "6");
            put("violet", "7");
            put("grey", "8");
            put("white", "9");
        }};  
        String colorA = br.readLine();
        String colorB = br.readLine();
        String colorC = br.readLine();
        long answer = Long.parseLong(hashMap.get(colorA) + hashMap.get(colorB));
        answer *= Math.pow(10.0, (double) Integer.parseInt(hashMap.get(colorC)));
        System.out.print(answer);
    }
}