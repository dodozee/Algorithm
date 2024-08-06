import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String NEMO = "NEMO";

        while (true) {
            String findNemo = sc.nextLine();
            if (findNemo.equals("EOI") == true) {
                break;
            } else {
                findNemo = findNemo.toUpperCase();

                if (findNemo.contains(NEMO) == true) {
                    System.out.println("Found");
                } else {
                    System.out.println("Missing");
                }
            }
        }
        sc.close();
    }
}