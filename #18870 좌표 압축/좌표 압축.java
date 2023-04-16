import java.util.*;
import java.io.*;

public class Main{ // 박두지 화이팅!!! 갓천대 컴공 화이팅!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        int[] arr = new int[t];
        int[] arr2 = new int[t];
        Map<Integer, Integer> map = new HashMap<>();//중복된 자표는 같은 순위를 갖기 위해 Map을 구현
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < t; i++) { //좌표를 받음
            arr[i] = arr2[i]=Integer.parseInt(st.nextToken());
            
        }
        
        Arrays.sort(arr); //압축을 위해 정렬

        int cnt = 0;
        for (int i : arr) {
            if (!map.containsKey(i)) {
                map.put(i, cnt++);
            }
        }

        StringBuilder sb = new StringBuilder();
        
        for (int key : arr2) {
            int ranking = map.get(key);    
            sb.append(ranking).append(' ');
        }
        System.out.println(sb);
    }
}
