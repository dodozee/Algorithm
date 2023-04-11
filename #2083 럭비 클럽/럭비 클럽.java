import java.util.Scanner;

public class Main {//박두지 화이팅!!! 갓천대 화이팅!!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            String name = scanner.next();
            int age = scanner.nextInt();
            int weight = scanner.nextInt();
            
            if (name.equals("#") && age == 0 && weight == 0) {
                break;  // 입력 종료
            }
            
            String category = (age > 17 || weight >= 80) ? "Senior" : "Junior";
            System.out.println(name + " " + category);
        }
        
        scanner.close();
    }
}
