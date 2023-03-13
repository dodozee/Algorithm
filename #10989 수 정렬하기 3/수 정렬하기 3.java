import java.io.*;
import java.util.Arrays;

public class Main {//갓천댓~~ 두지코딩~~
    public static void main(String args[]) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i=0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr); //자바 라이브러리에서 제공하는 정렬 메서드를 사용했다.
        StringBuilder result = new StringBuilder(); //StringBuilder는 객체를 생성하고 append()메서드를 사용하면 chain 방식으로 문자열을 추가한다.

        for(int i=0; i < n; i++){
            result.append(arr[i]).append('\n');//\n 없이 하니까 띄워쓰기 없이 나왔다. 그래서 숫자 append할 떄마다 해야한다!
        }
        System.out.println(result);
    }
}