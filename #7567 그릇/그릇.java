import java.io.*;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int ans = 10;

        for (int i = 1; i < str.length(); i++){
            if (str.charAt(i) == str.charAt(i - 1)){
                ans += 5;
            }
            else{
                ans += 10;
            }
        }

        System.out.println(ans);

    }
}