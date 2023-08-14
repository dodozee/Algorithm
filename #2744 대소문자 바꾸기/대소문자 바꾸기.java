import java.util.Scanner;

public class Main {//박두지 화이팅!!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        
        StringBuilder result = new StringBuilder(); // 변환된 결과를 저장할 StringBuilder
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // 대문자인 경우 소문자로 변환, 소문자인 경우 대문자로 변환
            if (Character.isUpperCase(c)) {
                result.append(Character.toLowerCase(c));
            } else {
                result.append(Character.toUpperCase(c));
            }
        }
        
        System.out.println(result);
        sc.close();
    }
}
