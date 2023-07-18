import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int k = scanner.nextInt();
            if (k == 0)
                break;

            int[] set = new int[k];
            for (int i = 0; i < k; i++) {
                set[i] = scanner.nextInt();
            }

            ArrayList<Integer> combination = new ArrayList<>();
            printCombinations(set, combination, 0, 0);
            System.out.println();
        }
    }

    private static void printCombinations(int[] set, ArrayList<Integer> combination, int index, int count) {
        if (count == 6) {
            for (int num : combination) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        if (index == set.length) {
            return;
        }

        combination.add(set[index]);
        printCombinations(set, combination, index + 1, count + 1);
        combination.remove(combination.size() - 1);
        printCombinations(set, combination, index + 1, count);
    }
}
