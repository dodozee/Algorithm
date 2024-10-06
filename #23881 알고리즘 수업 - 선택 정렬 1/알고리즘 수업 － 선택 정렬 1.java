import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int i;
        int maxIndex =0;
        int count = 0;

        for (i = n - 1; i > 0; i--) {
            maxIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                if(arr[j] > arr[maxIndex]){
                    maxIndex = j;
                }
            }
            if (maxIndex == i) {
                continue;
            }
            count++;

            if (count == k) {
                break;
            }

            swap(arr, maxIndex, i);

        }

        if (count < k) {
            System.out.println(-1);
        }else {
            System.out.println(arr[i] + " " + arr[maxIndex]);
        }
    }
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}


