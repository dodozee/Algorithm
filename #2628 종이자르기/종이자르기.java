import java.io.*;
import java.util.*;


/**
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        boolean[] widthArr = new boolean[width];
        boolean[] heightArr = new boolean[height];

        int n = Integer.parseInt(br.readLine());

        while (n > 0) {
            st = new StringTokenizer(br.readLine());
            int wh = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());

            if (wh == 0) {
                heightArr[index] = true;
            }

            if (wh == 1) {
                widthArr[index] = true;
            }

            n--;
        }

        int max_width = 0;
        int tmp = 0;
        for (int i = 0; i < width; i++) {
            if(widthArr[i]){
                max_width = Math.max(max_width, tmp);
                tmp = 1;
            } else{
                tmp++;
            }
        }

        max_width = Math.max(max_width, tmp);

        tmp = 0;
        int max_height = 0;

        for (int i = 0; i < height; i++) {
            if(heightArr[i]){
                max_height = Math.max(max_height, tmp);
                tmp = 1;
            }else{
                tmp++;
            }
        }
        
        max_height = Math.max(max_height, tmp);

        System.out.println(max_width * max_height);



    }

}