import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        while (true) {
            String str = s.nextLine();
            if(str.equals("END")) break;

            if (canFormWithMagnets(str))
                System.out.println(str);//중복이 없는 경우 출력

        }

        s.close();
    }

    private static boolean canFormWithMagnets(String phrase) {
        HashSet<Character> letters = new HashSet<>();

        for (char c : phrase.toCharArray()) {
            if (c != ' ') {
                if (letters.contains(c)) {
                    return false;
                }
                letters.add(c);
            }
        }
        return true;
    }
}