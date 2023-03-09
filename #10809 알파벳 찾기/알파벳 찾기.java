import java.io.*;

public class Main{ //가천대 컴공 20학번 화이팅~~
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[26]; //소문자 알파벳 갯수 길이의 배열 생성
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;// 디폴트로 -1로 모두 입력
        }
        String st = br.readLine();

        for (int i = 0; i < st.length(); i++) {//단어 길이만큼 반복한다.
            char ch = st.charAt(i);
            if (arr[ch - 97] == -1) { //'a'는 아스키 코드로 97이다.
                arr[ch - 97] = i;
            }
        }
            for (int i = 0; i < 26; i++) {
                System.out.print(arr[i] + " ");

        }
    }
}
