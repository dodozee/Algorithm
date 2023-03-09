import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 바구니 갯수이다.
        int m = sc.nextInt();   // 스왑 횟수!
        
        int[] b = new int[n]; //바구니인척하는 순서 배열 생성!
        for(int i = 0; i < n; i++){   // 기존 바구니에 들어있는 공 초기값
            b[i] = i + 1;
        }

        int temp = 0;//임시 저장할 저장소!
        for(int k = 0; k < m; k++){   // 사용자가 입력한 번호의 바구니에서 공 바꿔주기
            int i = sc.nextInt();
            int j = sc.nextInt();

            temp = b[i - 1];
            b[i - 1] = b[j - 1];
            b[j - 1] = temp;
        }

        for(int i = 0; i < n; i++){   // 바구니에서 순서대로 공 빼주기
            System.out.print(b[i] + " ");
        }
    }
}