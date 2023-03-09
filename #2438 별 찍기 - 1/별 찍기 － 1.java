import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {// 갓천대 컴공 화이팅~~ // 입력스트림이 null일 때 장애를 대비하기 위해 예외처리

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer n= Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++ ){
            bw.write("*");
            }
            bw.write("\n");
        }
        br.close(); //입력 버퍼를 닫아준다.
        bw.flush(); //출력 버퍼를 비운다.
        bw.close(); //출력 버퍼를 닫는다!!!

    }
}