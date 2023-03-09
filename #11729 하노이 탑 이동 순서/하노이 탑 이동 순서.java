import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // static 매서드를 사용하기 위해서 static으로 정의.
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());//숫자로 변환한다
        bw.write((int) Math.pow(2, n) - 1 + "\n");
        hanoiTop(n, 1, 3, 2);
        bw.flush();
    }

    static void hanoiTop(int n, int start, int to, int from) throws IOException {
        if (n == 1) {
            bw.write(String.format("%d %d \n", start, to));
            //bw.write(start +" "+to+ "\n");
            return;
        }
        hanoiTop(n - 1, start, from, to);  //재귀함수
        bw.write(String.format("%d %d \n", start, to));
        hanoiTop(n - 1, from, to, start); //재귀함수
    }
}
