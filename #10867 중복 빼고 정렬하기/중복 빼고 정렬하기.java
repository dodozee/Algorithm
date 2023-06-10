import java.util.*;

public class Main{ // 박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        Set<Integer> sets = new HashSet<>();

        for (int i = 0; i < N; i++) {
            int number = s.nextInt();
            sets.add(number);
        }

        List<Integer> sortedNumbers = new ArrayList<>(sets);
        Collections.sort(sortedNumbers);

        for (int number : sortedNumbers) {
            System.out.print(number + " ");
        }
    }
}