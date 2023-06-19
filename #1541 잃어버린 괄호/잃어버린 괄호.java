import java.io.*;
import java.util.*;

public class Main{//박두지 화이팅!!
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String expression = s.nextLine();

        String[] subtractParts = expression.split("-");
        int result = calculateExpression(subtractParts[0]);

        for (int i = 1; i < subtractParts.length; i++) {
            result -= calculateExpression(subtractParts[i]);
        }

        System.out.println(result);
    }

    private static int calculateExpression(String expression) {
        String[] addParts = expression.split("\\+");

        int sum =0;

        for (String part : addParts) {
            sum += Integer.parseInt(part);
        }

        return sum;

    }
}