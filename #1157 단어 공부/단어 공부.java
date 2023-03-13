import java.io.*;

public class Main {//갓천댓~~ 두지코딩~~
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String STR = str.toUpperCase();
        int[] alphabet = new int[26];

        int max = 0;
        int cnt =0;

        for (int i = 0; i < STR.length(); i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (STR.charAt(i) - 'A' == j) {
                    alphabet[j]++; //알파벳 순서대로의 배열에 count 역할을 한다.
                }
            }
        }

        for (int i = 0; i < alphabet.length; i++) {
            max = Math.max(alphabet[i], max); //max와 alphabet 배열에 저장된 숫자와 비교 후 max값 출력
        }
        for (int i = 0; i < alphabet.length; i++){
            if(max==alphabet[i]) cnt++;
        }
        for (int i = 0; i < alphabet.length; i++){
            if (max == alphabet[i] && cnt == 1) {
                System.out.println((char) ('A' + i));
            } else if (max == alphabet[i] && cnt > 1) {
                System.out.println("?"); //최대 빈도수 문자들이 2개이상이면 ? 나옴
                break; //처음에 break 안걸어줬는데 안걸어주니 물음표가 여러개 생긴다. 꼭 걸어줘야한다.
                
            }
        }
    }
}