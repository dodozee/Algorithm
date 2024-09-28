
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> plus = new ArrayList<>();
    static ArrayList<Integer> minus = new ArrayList<>();
    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int max = -1;

        boolean check = false; // 양수인지 음수인지 체크

        // 입력받은 수들을 양수와 음수로 나누어 저장
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());

            if(Math.abs(n) > max){
                max = Math.abs(n);
                check = n > 0;
            }

            // 양수
            if (n > 0) {
                plus.add(n);
            } else {
                minus.add(n);
            }
        }

        Collections.sort(plus);
        Collections.sort(minus, Collections.reverseOrder());// 음수는 내림차순으로 정렬

        int answer = 0;

        if(check) {// 양수가 더 큰 경우
            answer += minusSearch(false); // 음수 탐색
            answer += plusSearch(true); // 양수 탐색
        }else{
            answer += minusSearch(true); // 음수 탐색
            answer += plusSearch(false); // 양수 탐색
        }

        bw.write(answer + "");//""하는 이유는 int형을 string으로 변환하기 위함
        bw.flush();//남아있는 데이터를 모두 출력시킴
        bw.close();//스트림을 닫음
        br.close();//스트림을 닫음
    }

    static int plusSearch(boolean check){
        int c = plus.size() % M; // M으로 나눈 나머지
        int sum = 0;
        // M으로 나눈 나머지가 0이 아닌 경우
        if (c != 0) {
            if (plus.size() / M > 0) {
                sum = plus.get(c-1)*2;//
            }else
                sum = plus.get(c-1);
        }
        if (plus.size() / M > 0) {
            int count = 0;
            for (int i = c; i < plus.size(); i++) {
                count++;
                if (count == M) {
                    count = 0;
                    if (i == plus.size() - 1) {
                        sum += plus.get(i);
                    } else {
                        sum += plus.get(i) * 2;
                    }
                }
            }

        }
        if (!check && !plus.isEmpty()) {
            sum += plus.get(plus.size() - 1);
        }
        return sum;
    }

    static int minusSearch(boolean check){
        int c = minus.size() % M;
        int sum = 0;
        if (c != 0) {
            if (minus.size() / M > 0) {
                sum = minus.get(c-1)*2;
            }else
                sum = minus.get(c-1);
        }
        if (minus.size() / M > 0) {
            int count = 0;
            for (int i = c; i < minus.size(); i++) {
                count++;
                if (count == M) {
                    count = 0;
                    if (i == minus.size() - 1) {
                        sum += minus.get(i);
                    } else {
                        sum += minus.get(i) * 2;
                    }
                }
            }
        }
        if (!check && !minus.isEmpty()) {
            sum += minus.get(minus.size() - 1);
        }
        return Math.abs(sum);
    }
}