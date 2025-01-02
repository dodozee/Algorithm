import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
  public static HashMap<String, String> makeMorseMap() {
    HashMap<String, String> map = new HashMap<>();
    map.put(".-", "A");
    map.put("-...", "B");
    map.put("-.-.", "C");
    map.put("-..", "D");
    map.put(".", "E");
    map.put("..-.", "F");
    map.put("--.", "G");
    map.put("....", "H");
    map.put("..", "I");
    map.put(".---", "J");
    map.put("-.-", "K");
    map.put(".-..", "L");
    map.put("--", "M");
    map.put("-.", "N");
    map.put("---", "O");
    map.put(".--.", "P");
    map.put("--.-", "Q");
    map.put(".-.", "R");
    map.put("...", "S");
    map.put("-", "T");
    map.put("..-", "U");
    map.put("...-", "V");
    map.put(".--", "W");
    map.put("-..-", "X");
    map.put("-.--", "Y");
    map.put("--..", "Z");
    map.put(".----", "1");
    map.put("..---", "2");
    map.put("...--", "3");
    map.put("....-", "4");
    map.put(".....", "5");
    map.put("-....", "6");
    map.put("--...", "7");
    map.put("---..", "8");
    map.put("----.", "9");
    map.put("-----", "0");
    map.put("--..--", ",");
    map.put(".-.-.-", ".");
    map.put("..--..", "?");
    map.put("---...", ":");
    map.put("-....-", "-");
    map.put(".--.-.", "@");
    return map;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int count = Integer.parseInt(br.readLine());
    String[] split = br.readLine().split(" ");
    HashMap<String, String> map = makeMorseMap();

    StringBuilder s = new StringBuilder();
    for (String value : split) {
      s.append(map.get(value));
    }
    System.out.println(s.toString());
  }
}