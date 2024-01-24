import java.io.*;
import java.util.*;
import java.util.Map.Entry;
public class Main {
	static int sum = 0;
	static String result = "";
	static int N, M;
	static String[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new String[N];
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine();
		}

		DNA();

		System.out.println(result);
		System.out.println(sum);

	} 
	static private void DNA() {
		char ch = ' '; 
		int maximum; 

		for(int i=0; i<M; i++) {
			HashMap<Character, Integer> map = new HashMap<>();
			maximum = 0;

			for(int j=0; j<N; j++) {	
				String str = arr[j];

				map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
			}
			
			Iterator<Entry<Character, Integer>> it = map.entrySet().iterator();

			while(it.hasNext()) {
				Entry<Character, Integer> entrySet = (Entry<Character, Integer>)it.next();
				int value = entrySet.getValue();
				char key =  entrySet.getKey();

				if( maximum < value ) {
					maximum = value;
					ch = key;
				}
				else if(maximum == value) {
					char temp = key;

					int num1 = Character.getNumericValue(ch);
					int num2 = Character.getNumericValue(temp);

					if(num1 > num2) {
						ch = temp;
					}
				}
			}

			sum += N - maximum;
			result += ch;
		}
	} 
}