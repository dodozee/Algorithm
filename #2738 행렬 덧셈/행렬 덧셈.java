import java.io.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException{ //갓천대 화이팅! 이길여 총장님 오래사세요!
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();

        int[][] arr1 = new int[n][m];
        int[][] arr2 = new int[n][m];
        int[][] result = new int[n][m];
    

        for(int i = 0; i < arr1.length; i++){
            for (int j = 0; j < arr1[i].length; j++) {
                arr1[i][j] = Integer.parseInt(s.next());

            }
        }
        for(int i = 0; i < arr2.length; i++){
            for (int j = 0; j < arr2[i].length; j++) {
                arr2[i][j] = Integer.parseInt(s.next());

            }
        }

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                result[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
