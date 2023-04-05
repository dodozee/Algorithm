import java.util.Scanner;

public class Main {//갓천대 화이팅!! 박두지 화이팅!!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int youngest = sc.nextInt(); // 가장 어린 아이의 나이 입력
        int middle = sc.nextInt(); // 중간 아이의 나이 입력
        int oldest = middle + (middle - youngest); // 산술 연산을 이용하여 가장 나이 많은 아이의 나이 계산
        System.out.println(oldest); // 가장 어린 아이와 중간 아이의 나이로부터 계산된 가장 나이 많은 아이의 나이 출력
        sc.close();
    }
}
