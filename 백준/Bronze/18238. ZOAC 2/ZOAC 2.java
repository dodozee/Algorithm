import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        // 입력
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String input = "A" + br.readLine();

        // 출력
        final int result = IntStream.range(1, input.length()).map(i -> {
            int rhs = Math.max(input.charAt(i), input.charAt(i - 1));
            int lhs = Math.min(input.charAt(i), input.charAt(i - 1));
            final int lDis = rhs - lhs;
            final int rDis = 'Z' - rhs + lhs - 'A' + 1;
            return Math.min(lDis, rDis);
        }).sum();

        System.out.print(result);
    }
}
