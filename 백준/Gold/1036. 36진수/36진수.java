import java.io.*;
import java.util.*;

public class Main {
    static class Info implements Comparable<Info>{
        int idx;
        int[] vals;

        public Info(int idx, int[] vals){
            this.idx = idx;
            this.vals = vals;
        }

        @Override
        public int compareTo(Info o) {
            for(int i=54;i>=0;i--){
                if(this.vals[i] > o.vals[i]){
                    return -1;
                }else if(this.vals[i] < o.vals[i]){
                    return 1;
                }
            }
            return 0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        
        List<Info> infos = new ArrayList<>();
        for(int i=0;i<36;i++){
            infos.add(new Info(i, new int[55]));
        }

        for(int i=0;i<N;i++) {
            words[i] = br.readLine().trim();
            int len = words[i].length();
            for(int j=0;j<len;j++){
                char c = words[i].charAt(j);
                if(c >= 'A'){
                    infos.get(c-'A'+10).vals[len - j - 1] += 'Z' - c;
                }else{		
                    int temp = Character.getNumericValue(c);
                    infos.get(temp).vals[len - j - 1] += 35 - temp;
                }
            }
        }

        for(Info info : infos){
            for(int i=0;i<55;i++){
                if(info.vals[i] >= 36){
                    info.vals[i+1] += info.vals[i] / 36;
                    info.vals[i] %= 36;
                }
            }
        }

        int K = Integer.parseInt(br.readLine());
        Collections.sort(infos);
        Set<Integer> change = new HashSet<>();
        for(int i=0;i<K;i++){
            change.add(infos.get(i).idx);
        }

        for(int changeVal : change){
            String c;
            if(changeVal >= 10){
                c = String.valueOf((char)(changeVal - 10 + 'A'));
            }else{
                c = String.valueOf((char)(changeVal + '0'));
            }
            for(int i=0;i<N;i++){
                words[i] = words[i].replaceAll(c, "Z");
            }
        }

        int[] result = new int[55];
        for(int i=0;i<N;i++){
            int len = words[i].length();
            for(int j=0;j<len;j++){
                int temp;
                if(words[i].charAt(j) >= 'A'){
                    temp = words[i].charAt(j) - 'A' + 10;
                }else{
                    temp = Character.getNumericValue(words[i].charAt(j));
                }
                result[len - j - 1] += temp;
            }
        }

        for(int i=0;i<55;i++){
            if(result[i] >= 36){
                result[i+1] += result[i] / 36;
                result[i] %= 36;
            }
        }
        boolean flag = false;
        for(int i=54;i>=0;i--){
            if(result[i] == 0 && !flag){
                continue;
            }
            flag = true;
            if(result[i] >= 10){
                bw.write(String.valueOf((char)(result[i] - 10 + 'A')));
            }else{
                bw.write(String.valueOf(result[i]));
            }
        }
        if(!flag){
            bw.write("0");
        }
        bw.flush();	
        bw.close();
        br.close();
    }
}