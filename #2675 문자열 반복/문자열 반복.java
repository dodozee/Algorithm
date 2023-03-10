import java.util.StringTokenizer;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{ //갓천대 화이팅!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 몇 개 테스트할껀지 받는다.

        for (int i = 0; i < n; i++) { // 테스트 개수만큼 반복
            st = new StringTokenizer(br.readLine() + " ");
            int r = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            
            for(int j=0; j < s.length(); j++){  //첫글자부터 글자수 끝까지 간다.
                for (int k = 0; k < r; k++) { // 여기서 r은 한글자당 반복횟수.
                    System.out.print(s.charAt(j));
                }
            }
            System.out.println();
        }
    }
}