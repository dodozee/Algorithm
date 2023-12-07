import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!!
    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numberString = br.readLine();
        int sum = 0;

        char[] charArray = numberString.toCharArray();
        Arrays.sort(charArray);
        int length = charArray.length;

        StringBuilder reverseNum = new StringBuilder();
        for (int i = length - 1; i >= 0; i--) {
            int digit = charArray[i] - '0';
            sum += digit;
            reverseNum.append(digit);
        }

        if (charArray[0] != '0' || sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(reverseNum.toString());
    }
}
