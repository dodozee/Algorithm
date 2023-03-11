import java.io.*;
import java.util.Scanner;
public class Main { //나라사랑 가천사랑 동기사랑 !!!화티잉!!!!!!
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          String[] arr1;//문자열를 담을 배열 생성!  뭔가 char형을 만들어야할거같지만 split 함수가 String을 반환해서 편하다!
         String str = br.readLine();
        int n = Integer.parseInt(br.readLine());
        arr1 = str.split(""); //문자열 입력 받은거 한글자씩 기준으로 하나씩 쪼개서 넣어줌
        System.out.println(arr1[n - 1]);
    }
}