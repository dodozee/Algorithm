import java.io.*;
import java.util.*;

public class Main { //2시간 걸리다 //나라사랑 가천사랑 동기사랑 !!!화티잉!!!!!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());// 가고싶은 방 n번 적기!

        int num = 1;
        int cnt = 1; // cnt를 0 으로하니까 1을 집어넣었을때 -1이 나와 실패하였다....
        while (num < n) { 
            num = num + cnt*6;  //수학식으로 해석하여 바꾸면 1부터 시작하여 6배수가 누적으로 더해지는 것을 표현했다. 1->7->19->37->69...
            cnt++;
        }
        System.out.println(cnt);
    }
}
