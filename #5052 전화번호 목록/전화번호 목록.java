import java.util.*;

public class Main {//박두지 화이팅!!!
    static boolean checkConsistency(String[] phoneNumbers) {
        Arrays.sort(phoneNumbers);  // 문자열을 오름차순 정렬

        for (int i = 0; i < phoneNumbers.length - 1; i++) {
            if (phoneNumbers[i+1].startsWith(phoneNumbers[i])) {
                return false;  // 다음 번호가 현재 번호의 접두어이면 일관성 없음
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String[] phoneNumbers = new String[n];

            for (int i = 0; i < n; i++) {
                phoneNumbers[i] = sc.next();
            }

            if (checkConsistency(phoneNumbers)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}
