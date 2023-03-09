import java.io.*;

public class Main{ //가천대 컴공 20학번 화이팅~~
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());//readLine() 메서드는 String이 return 자료형이라 문자를 숫자로 변환하려면
        //Integer.parseInt()를 사용하자!
        String a = br.readLine();

        int sum =0;

        for(int i =0; i < n; i++){
            sum = sum + a.charAt(i)-'0'; //chatAt()는 아스키코드 값을 변환하기 때문에 -'0'을 해줘야한다! 그래야지 숫자값과 동일
        }
        System.out.println(sum);


    }
}