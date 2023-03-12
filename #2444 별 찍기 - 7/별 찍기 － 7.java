import java.io.*;
import java.util.Scanner;
public class Main { //나라사랑 가천사랑 동기사랑 !!!화티잉!!!!!!
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        for (int i = 0; i <n-1; i++) {
            for(int j=i;j<n-1;j++){
                System.out.print(" ");
            }
            for (int j = 0; j < i * 2 + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i=n-1; i>=0; i--){
            for (int j = n - 1; j > i; j--) {
                System.out.print(" ");
            }
            for(int j = i * 2 +1; j >0; j--) {
                System.out.print("*");
            }
            System.out.println();

        }

    }
}