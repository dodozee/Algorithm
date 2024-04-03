import java.io.*;
import java.util.*;

public class Main { //bfs + prime 찾기 
    static boolean[] isNotPrime = new boolean[10001];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//입력
        StringBuilder sb = new StringBuilder();
        StringTokenizer st ;

        int t = Integer.parseInt(br.readLine());
        checkPrime();

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int origin = Integer.parseInt(st.nextToken());
            int answer = Integer.parseInt(st.nextToken());

            sb.append(bfs(origin, answer)).append('\n');
        }

        System.out.println(sb);



    }

    private static String bfs(int origin, int answer) {
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();

        map.put(origin, 0);//시작점
        q.add(origin);

        while (!q.isEmpty()) {
            int pos = q.poll();
            int count = map.get(pos);

            if(pos == answer){
                return String.valueOf(count);
            }

            int[] pNum = {pos/ 1000, (pos % 1000) / 100, (pos % 100) / 10, pos % 10}; // 각 자리수를 배열로 만듬

            for (int i = 0; i < 4; i++) {//각 자리수에 대해
                for (int j = 0; j < 10; j++) { // 0~9까지
                    if (i == 0 && j == 0) continue; // 천의 자리수는 0이 될 수 없음

                    int tmp = pNum[i]; // 현재 자리수의 값
                    pNum[i] = j; // j로 변경
                    int next = changePassword(pNum); // 변경된 값
                    pNum[i] = tmp; // 원래대로

                    if(!isNotPrime[next] && !map.containsKey(next)){//소수이고 방문하지 않았다면
                        map.put(next, count + 1);
                        q.add(next);
                    }
                }
            }
        }
        return "Impossible";
    }

    private static int changePassword(int[] pNum) {
        int num = 0;
        for (int i = 0; i < 4; i++) {
            num += pNum[i] * Math.pow(10, 3 - i);// 각 자리수를 합쳐서 숫자로 만듬
        }
        return num;
    }

    private static void checkPrime() {
        for (int i = 2; i < 10000; i++) {
            if (!isNotPrime[i]) { // 소수인 경우
                for (int j = i * 2; j < 10000; j += i) { // 소수의 배수들은 소수가 아님
                    isNotPrime[j] = true;
                }
            }
        }
    }

}
