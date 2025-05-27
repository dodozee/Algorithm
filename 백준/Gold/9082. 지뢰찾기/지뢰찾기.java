import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();

        for(int i=0; i<row; i++) {
            int column = sc.nextInt();
            int[] firstRow = Arrays.stream(sc.next().split("")).mapToInt(Integer::parseInt).toArray();
            String[] secondRow = sc.next().split("");
            int answer = 0;

            for(int j=0; j<column; j++) {
                if (j == 0 && firstRow[j] != 0 && firstRow[j+1] != 0) {
                    firstRow[j] -= 1;
                    firstRow[j+1] -= 1;
                    answer++;
                } else if (j == (column - 1) && firstRow[j - 1] != 0 && firstRow[j] != 0) {
                    firstRow[j-1] -= 1;
                    firstRow[j] -= 1;
                    answer++;
                } else if (1 <= j && j <= (column-2) && firstRow[j - 1] != 0 && firstRow[j] != 0 && firstRow[j + 1] != 0) {
                    firstRow[j-1] -= 1;
                    firstRow[j] -= 1;
                    firstRow[j+1] -= 1;
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }
}
