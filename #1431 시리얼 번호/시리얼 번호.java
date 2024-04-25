import java.io.*;
import java.util.*;


/**
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        solution(arr);


        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void solution(String[] arr) {
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                if (o1.length() == o2.length()) { // 길이가 같을때
                    int sum1 = 0;
                    int sum2 = 0;
                    for (int i = 0; i < o1.length(); i++) {
                        if (o1.charAt(i) >= '0' && o1.charAt(i) <= '9' ) {
                            sum1 += Integer.parseInt(String.valueOf(o1.charAt(i)));
                        }
                    }

                    for (int i = 0; i < o2.length(); i++) {
                        if (o2.charAt(i) >= '0' && o2.charAt(i) <= '9' ) {
                            sum2 += Integer.parseInt(String.valueOf(o2.charAt(i)));
                        }
                    }

                    if (sum1 == sum2) {
                        return o1.compareTo(o2);// 사전순
                    }else{
                        return sum1 - sum2;// 숫자의 합
                    }
                }else{
                   return o1.length() - o2.length();// 길이
                }
            }
        });
    }


}