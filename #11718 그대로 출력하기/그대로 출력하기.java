import java.util.Scanner;

public class Main { //나라사랑 가천사랑 동기사랑 !!!화티이!!!
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (s.hasNextLine()) { // 입력이 끝날 때까지 반복한다
            String string = s.nextLine();
            System.out.println(string); // 입력받은 줄 그대로 무한리필집마냥 출력한다.
        }

        s.close(); //닫기
    }
}