import java.util.*;
import java.io.*;


public class Main {//박두지 화이팅!!!
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder statementString = new StringBuilder();

        List<Integer> integerList = new ArrayList<>();
        String string;
        while ((string = br.readLine()) != null) {
            statementString.append(string);
        }

        StringTokenizer st = new StringTokenizer(statementString.toString(), ",");
        while (st.hasMoreTokens()) {
            integerList.add(Integer.valueOf(st.nextToken()));
        }

        System.out.println(integerList.stream().mapToInt(Integer::intValue).sum());
        br.close();
    }

}
