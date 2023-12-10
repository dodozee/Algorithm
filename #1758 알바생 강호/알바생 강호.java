import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr, Comparator.reverseOrder()); 

        long answer = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] - i <= 0) {
                break;
            }
            answer += arr[i] - i;
        }

        bw.write(answer + "\n");
        bw.flush();
    }

}