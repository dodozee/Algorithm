import java.util.Scanner;

public class Main {//박두지 화이팅!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 사용자로부터 성적 입력 받기
        String grade = scanner.nextLine();

        // 평점 계산
        double result = calculateGrade(grade);

        // 결과 출력
        if (result != -1) {
            System.out.println(result);
        } else {
            System.out.println("올바른 성적을 입력해주세요.");
        }
    }

    public static double calculateGrade(String grade) {
        switch (grade) {
            case "A+":
                return 4.3;
            case "A0":
                return 4.0;
            case "A-":
                return 3.7;
            case "B+":
                return 3.3;
            case "B0":
                return 3.0;
            case "B-":
                return 2.7;
            case "C+":
                return 2.3;
            case "C0":
                return 2.0;
            case "C-":
                return 1.7;
            case "D+":
                return 1.3;
            case "D0":
                return 1.0;
            case "D-":
                return 0.7;
            case "F":
                return 0.0;
            default:
                return -1;  // 잘못된 성적 입력 시 -1 반환
        }
    }
}
           
