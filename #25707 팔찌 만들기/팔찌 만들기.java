import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.valueOf(br.readLine());
        ArrayList<Long> arr=new ArrayList<>();

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr.add(Long.valueOf(st.nextToken()));
        }
        Collections.sort(arr, Collections.reverseOrder());
        long answer=Math.abs(arr.get(0)-arr.get(1))+Math.abs(arr.get(arr.size()-1)- arr.get(arr.size()-2));
        for(int i=0; i<arr.size()-2; i++){
            answer+=(arr.get(i)-arr.get(i+2));
        }
        bw.write(answer+"");
        bw.flush();
    }
}
