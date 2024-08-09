
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        int answer = str.length();

        for (int i = 0; i < str.length(); i++) {
            if(isPalindrome(str.substring(i))){
                break;
            }
            answer++;
        }
        System.out.println(answer);
    }
    private static boolean isPalindrome(String str){//
        int start = 0;
        int last = str.length() - 1;
        while (start <= last) {
            if (str.charAt(start) != str.charAt(last)) {
                return false;
                
            }
                start++;
                last--;
        }
        return true;
    }
}