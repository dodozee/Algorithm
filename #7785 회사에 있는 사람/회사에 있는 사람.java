import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        HashSet<String> hm = new HashSet<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String key = st.nextToken(); 
            String value = st.nextToken(); 

            if(value.equals("enter")){
                hm.add(key);
            }else if(value.equals("leave")){
                hm.remove(key);
            }
        }


        ArrayList<String> list = new ArrayList<String>(hm);
        Collections.sort(list);

        for(int i = list.size()-1;  i >= 0; i--){
            bw.write(list.get(i) + "\n");
        }

        bw.flush();
    }

}