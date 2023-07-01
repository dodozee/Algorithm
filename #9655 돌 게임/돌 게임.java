import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[1001];
        list[1] = 1;
        list[2] = 2;
        list[3] = 1;
        for (int i = 4; i < n+1; i++) {
            list[i] = Math.min(list[i-1],list[i-3]) + 1;
        }
        if (list[n] % 2 == 0) {
            System.out.print("CY");
        } else {
            System.out.print("SK");
        }
    }
}