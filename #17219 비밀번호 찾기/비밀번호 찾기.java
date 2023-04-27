import java.io.*;
import java.util.*;

class Main { //박두지 화이팅!!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, String> map = new HashMap<>();

        for(int i=0; i<n ; i++){ // 사이트, 비밀번호 map에 넣기
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            String password = st.nextToken();
            map.put(site, password);
        }

        for (int i = 0; i < m; i++) {
            String site = br.readLine();
            sb.append(map.get(site)).append("\n");

        }

        System.out.println(sb);
    }
}