import java.io.*;
import java.util.*;

 
public class Main {//박두지 화이팅!!
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
 
		int T = Integer.parseInt(br.readLine());	
 
		while (T --> 0) {
			
			HashMap<String, Integer> map = new HashMap<>();	// <종류, 개수>
			
			int N = Integer.parseInt(br.readLine());	// 입력받는 옷의 개수
			
			while (N --> 0) {
				st = new StringTokenizer(br.readLine(), " ");
				st.nextToken();	// 옷 이름은 필요 없고 종류만 필요함
				
				String kind = st.nextToken();	// 옷 종류 
 
				if (map.containsKey(kind)) {//해당 옷이 있을 경우 값 + 1을 시킨 후 저장.
					map.put(kind, map.get(kind) + 1);
				} 
				else {
					map.put(kind, 1);
				}
			}
 
			int result = 1;
 
			/**
			 * 미착용을 고려하여 각 종류별 옷의 개수에 +1 해준 값을 곱함
			 */
			for (int val : map.values()) {
				result *= (val + 1);
			}
			// 알몸인 상태가 있으므로 최종값에 -1함
			sb.append(result - 1).append('\n');
		}
		System.out.println(sb);
	}
 
}