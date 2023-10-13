import java.util.Scanner;

public class Main {//박두지 화이팅!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 각 이동 시간 입력
        int homeToSchool = scanner.nextInt();
        int schoolToPCBang = scanner.nextInt();
        int pcbangToAcademy = scanner.nextInt();
        int academyToHome = scanner.nextInt();
        
        // 총 이동 시간 계산 (초 단위)
        int totalSeconds = homeToSchool + schoolToPCBang + pcbangToAcademy + academyToHome;
        
        // 분과 초로 변환
        int totalMinutes = totalSeconds / 60;
        int remainingSeconds = totalSeconds % 60;
        
        // 결과 출력
        System.out.println(totalMinutes);
        System.out.println(remainingSeconds);
    }
}
