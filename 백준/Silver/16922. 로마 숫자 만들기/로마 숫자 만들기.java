import java.io.*;
import java.util.List;

public class Main {
    static int ans;
    static boolean[] checkBool = new boolean[1001];
    static int[] numbers = {1, 5, 10, 50};


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        backtracking(0, n, 0, 0);

        System.out.print(ans);
    }
    private static void backtracking(int sum, int n, int depth, int index){
        if(depth == n){
            if (!checkBool[sum]){
                checkBool[sum] = true;
                ans++;
            }
            return;

        }
        for(int i = index; i < 4; i++){
            backtracking(sum + numbers[i], n, depth+1, i);
        }
    }
}