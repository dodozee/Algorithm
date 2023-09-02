import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {//박두지 화이팅!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] letterCount = new int[26]; // 알파벳 소문자 개수를 저장할 배열

        String line;
        while ((line = br.readLine()) != null) {
            line = line.toLowerCase(); // 모든 문자를 소문자로 변환
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if ('a' <= c && c <= 'z') { // 알파벳인 경우에만 처리
                    int index = c - 'a'; // 알파벳 'a'부터 'z'까지의 인덱스 계산
                    letterCount[index]++;
                }
            }
        }

        int maxCount = 0;
        for (int count : letterCount) {
            maxCount = Math.max(maxCount, count);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (letterCount[i] == maxCount) {
                char letter = (char) ('a' + i); // 인덱스를 알파벳으로 변환
                result.append(letter);
            }
        }

        System.out.println(result.toString());
    }
}
