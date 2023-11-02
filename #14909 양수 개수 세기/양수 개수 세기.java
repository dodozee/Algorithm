import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 공백을 기준으로 정수를 배열로 읽어옴
        String[] input = scanner.nextLine().split(" ");
        
        int count = 0; // 양의 정수 개수를 저장할 변수
        
        for (String numStr : input) {
            int num = Integer.parseInt(numStr);
            
            if (num > 0) {
                count++;
            }
        }
        
        System.out.println(count);
    }
}
