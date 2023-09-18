import java.util.HashMap;
import java.util.Scanner;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word1 = scanner.nextLine();
        String word2 = scanner.nextLine();
        scanner.close();

        HashMap<Character, Integer> counts = new HashMap<>();

        for (char c : word1.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        int removalCount = 0;

        for (char c : word2.toCharArray()) {
            if (counts.containsKey(c) && counts.get(c) > 0) {
                counts.put(c, counts.get(c) - 1);
            } else {
                removalCount++;
            }
        }

        for (int count : counts.values()) {
            removalCount += count;
        }

        System.out.println(removalCount);
    }
}
