import java.io.*;
import java.util.*;


public class Main{//박두지 화이팅!
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String word = s.nextLine();

        int len = word.length();
        int start = 0;
        int end = Math.min(10, len);

        while (start < len) {
            System.out.println(word.substring(start, end));
            start +=10;
            end = Math.min(start+10, len);
        }
    }
}

