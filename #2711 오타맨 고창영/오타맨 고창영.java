import java.util.Scanner;

public class Main {//박두지 화이팅!!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        for (int i = 0; i < T; i++) {
            String[] input = sc.nextLine().split(" ");
            int typoLocation = Integer.parseInt(input[0]);
            String sentence = input[1];

            String correctedSentence = removeTypo(typoLocation, sentence);
            System.out.println(correctedSentence);
        }

        sc.close();
    }

    public static String removeTypo(int typoLocation, String sentence) {
        // Remove the character at the typo location
        return sentence.substring(0, typoLocation - 1) + sentence.substring(typoLocation);
    }
}
