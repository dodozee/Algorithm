import java.util.Arrays;
import java.util.Scanner;

public class Main {//박두지 화이팅!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 스킬 레벨 입력
        int[] skillLevels = new int[4];
        for (int i = 0; i < 4; i++) {
            skillLevels[i] = scanner.nextInt();
        }

        // 스킬 레벨을 오름차순으로 정렬
        Arrays.sort(skillLevels);

        // 두 팀의 스킬 레벨 합계 계산
        int team1Sum = skillLevels[0] + skillLevels[3];
        int team2Sum = skillLevels[1] + skillLevels[2];

        // 두 팀의 스킬 레벨 차이 계산
        int skillDifference = Math.abs(team1Sum - team2Sum);

        System.out.println(skillDifference);

        scanner.close();
    }
}
