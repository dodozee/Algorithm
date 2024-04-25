import java.io.*;
import java.sql.Array;
import java.util.*;


/**
 *
 */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> cranes = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            cranes.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());

        List<Integer> boxes = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }

        cranes.sort(Collections.reverseOrder());
        boxes.sort(Collections.reverseOrder());

        if(cranes.get(0) < boxes.get(0)){
            System.out.println(-1);
            return;
        }

        int days = 0;

        while (!boxes.isEmpty()) {
            int boxNum = 0;
            int craneNum = 0;

            while(craneNum <n){
                if (boxNum == boxes.size()) { // 모든 박스를 옮겼다면
                    break;
                } else if (cranes.get(craneNum) >= boxes.get(boxNum)) {
                    boxes.remove(boxNum);
                    craneNum++;
                }else{
                    boxNum++;
                }
            }
            days++;

        }

        System.out.println(days);

    }
}