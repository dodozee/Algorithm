import java.io.*;
import java.util.StringTokenizer;
public class Main {

    public static void main(String[] args) throws IOException {// 갓천대 컴공 화이팅~~ // 입력스트림이 null일 때 장애를 대비하기 위해 예외처리

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //프롬프트로 받을 스트림리더를 객체로 만들어 입력버퍼로 넘긴다.
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//똑같은 로직


        int n = Integer.parseInt(br.readLine());// 입력은 readLine()으로 받는다.

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            //문자열을 구분시켜주는 토크니저 변수를 생성하고 토근(구획문자)를 " " 띄워쓰기로 구분짓는다.
            bw.write((Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()))+ "\n");
            //nextToken()으로 구분시켜준 문자열을 Integer로 변환시킨 후 더해준 다음 개행시킨다.
        }
        br.close(); //입력 버퍼를 닫아준다.

        bw.flush(); //출력 버퍼를 비운다.
        bw.close(); //출력 버퍼를 닫는다!!!

    }
}