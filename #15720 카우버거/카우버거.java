import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    Integer[] burger = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
        .toArray(Integer[]::new);
    Integer[] side = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
        .toArray(Integer[]::new);
    Integer[] drink = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
        .toArray(Integer[]::new);

    int min = burger.length;
    min = Math.min(min, side.length);
    min = Math.min(min, drink.length);

    Comparator<Integer> comparator = Collections.reverseOrder();
    Arrays.sort(burger, comparator);
    Arrays.sort(side, comparator);
    Arrays.sort(drink, comparator);

    int resultBeforeDiscount = 0;
    int result = 0;
      
    for (int i = 0; i < min; i++) {
      int calc = 0;
      calc += burger[i];
      calc += side[i];
      calc += drink[i];
      resultBeforeDiscount += calc;
      result += (int) (calc * 0.9);
    }

    for (int i = min; i < burger.length; i++) {
      resultBeforeDiscount += burger[i];
      result += burger[i];
    }
    for (int i = min; i < side.length; i++) {
      resultBeforeDiscount += side[i];
      result += side[i];
    }
    for (int i = min; i < drink.length; i++) {
      resultBeforeDiscount += drink[i];
      result += drink[i];
    }
    System.out.println(resultBeforeDiscount);
    System.out.println(result);
  }
}