import java.util.*;
import java.io.*;
/* 박두지 파이팅!!! 갓천대 컴공 파이팅!!
[풀이 과정]

 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 집합 A 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<Integer> setA = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }

        // 집합 B 입력 받기
        HashSet<Integer> setB = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            setB.add(Integer.parseInt(st.nextToken()));
        }

        // 대칭 차집합 구하기
        HashSet<Integer> symmetricDiff = new HashSet<>(setA);
        symmetricDiff.addAll(setB);
        HashSet<Integer> tmp = new HashSet<>(setA);
        tmp.retainAll(setB);
        symmetricDiff.removeAll(tmp);

        // 결과 출력
        System.out.println(symmetricDiff.size());
    }
}
