import java.util.Scanner;
import java.io.*;

public class Main{ //가천대 컴공 20학번 화이팅~~
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        String str1 = s.next();
        String str2 = s.next();

        StringBuffer sb1 = new StringBuffer(str1); //StringBuffer 클래스의 객체는 그 값을 변경 할수 있고 추가도 할수 있는 가변객체이다. String은 불변객체이기 때문에 문자열 자체를 바로 수정할 수 없다.
        StringBuffer sb2 = new StringBuffer(str2);
        str1 = sb1.reverse().toString();// StringBuffer 가변객체의 특성으로 문자열을 역순으로 재배열 할 수 있다.
        str2 = sb2.reverse().toString();

        int num1 = Integer.parseInt(str1);
        int num2 = Integer.parseInt(str2);

        int result = num1>num2 ? num1:num2;
        System.out.println(result);



    }
}
