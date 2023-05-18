import java.util.Scanner;

public class Main {//박두지
        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                int N = scanner.nextInt(); // 사람의 수 입력
                scanner.nextLine(); // 개행 문자 제거

                // 친구 정보를 저장할 2차원 배열
                char[][] friends = new char[N][N];

                // 친구 정보 입력 받기
                for (int i = 0; i < N; i++) {
                        String line = scanner.nextLine();
                        for (int j = 0; j < N; j++) {
                                friends[i][j] = line.charAt(j);
                        }
                }

                int maxFriends = 0; // 가장 많은 2-친구 수 저장 변수

                // 각 사람의 2-친구 수 계산
                for (int i = 0; i < N; i++) {
                        int count = 0; // 2-친구 수 저장 변수

                        for (int j = 0; j < N; j++) {
                                if (i == j) continue; // 자기 자신은 제외

                                // A와 B가 친구거나, A와 C가 친구이고 B와 C가 친구인 경우
                                if (friends[i][j] == 'Y' || isMutualFriend(friends, i, j)) {
                                        count++;
                                }
                        }

                        // 가장 많은 2-친구 수 업데이트
                        maxFriends = Math.max(maxFriends, count);
                }

                System.out.println(maxFriends);
        }

        // A와 C가 친구이고 B와 C가 친구인지 확인하는 메소드
        private static boolean isMutualFriend(char[][] friends, int personA, int personB) {
                for (int i = 0; i < friends.length; i++) {
                        if (friends[personA][i] == 'Y' && friends[personB][i] == 'Y') {
                                return true;
                        }
                }
                return false;
        }
}
