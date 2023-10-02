import java.io.*;
 
public class Main {//박두지 화이팅!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String string;
        
        while ((string = br.readLine()) != null) {
            int small = 0;  //소문자 개수
            int capital = 0;   //대문자 개수
            int number = 0;  //숫자 개수
            int space = 0;  //공백 개수
            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                if (c == ' ') space++;
                if (Character.isUpperCase(c)) capital++;
                if (Character.isLowerCase(c)) small++;
                if (Character.isDigit(c)) number++;
            }
            sb.append(small + " " + capital + " " + number + " " + space + "\n");
        }
        System.out.print(sb);
    }
}
