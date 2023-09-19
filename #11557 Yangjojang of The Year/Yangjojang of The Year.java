import java.util.Scanner;

public class Main {//박두지 화이팅!!!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); 

        for (int testCase = 0; testCase < t; testCase++) {
            int n = scanner.nextInt();
            scanner.nextLine(); 

            String maxSchool = "";
            int maxAmount = -1;

            for (int i = 0; i < n; i++) {
                String[] input = scanner.nextLine().split(" ");
                String school = input[0];
                int amount = Integer.parseInt(input[1]);

                if (amount > maxAmount) {
                    maxAmount = amount;
                    maxSchool = school;
                }
            }

            System.out.println(maxSchool);
        }

        scanner.close();
    }
}
