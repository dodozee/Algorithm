import java.io.*;

public class Main extends Exception {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        int length = str.length();
        int colone = 0;
        int underBar = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

             if (ch == '_'){
                underBar++;
            }
            
            if (ch == ':'){
                colone++;
            }

        }
           

        int answer = length + colone + (underBar * 5);

        sb.append(answer);
        System.out.println(sb.toString());
    }
}