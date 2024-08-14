import java.io.*;

public class Main {
        static final String smileFace = ":-\\)";
        static final String sadFace = ":-\\(";
        static final String NONE = "none";
        static final String HAPPY = "happy";
        static final String SAD = "sad";
        static final String UNSURE = "unsure";
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
       

        int happyCount = str.split(smileFace, -1).length - 1;
        int sadCount = str.split(sadFace, -1).length - 1;

        String emotion = NONE;
        if (happyCount > 0 || sadCount > 0) {
            if (happyCount > sadCount) {
                emotion = HAPPY;
            } else if (happyCount < sadCount) {
                emotion = SAD;
            } else {
                emotion = UNSURE;
            }
        }
        
        System.out.print(emotion);
    }

  

}
