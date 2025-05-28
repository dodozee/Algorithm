import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[][] star = new int[12][2];

        List<List<Integer>> connect = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            connect.add(new ArrayList<>());
        }

        for (int i = 0; i < 12; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            star[i][0] = x;
            star[i][1] = y;
            connect.get(x).add(y);
            connect.get(y).add(x);
        }

        int[] line = new int[12];
        for (int i = 0; i < 12; i++) {
            line[star[i][0] - 1] += 1;
            line[star[i][1] - 1] += 1;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            if (line[i] == 3) {
                list.add(i + 1);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            int s = list.get(i);
            List<Integer> connectedStar = connect.get(s);

            int connectLine = 0;
            for (int j = 0; j < connectedStar.size(); j++) {
                connectLine += line[connectedStar.get(j) - 1];
            }

            if (connectLine == 6) {
                System.out.println(s);
            }
        }
    }
}

