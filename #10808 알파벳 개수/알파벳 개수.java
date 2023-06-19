import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String word = s.nextLine();

        int[] counts = new int[26];

        char[] wordArray = word.toCharArray();
        for (char ch : wordArray) {
            int index = ch -'a';
            counts[index]++;
        }

        for (int count : counts) {
            System.out.print(count + " ");
        }
    }
}