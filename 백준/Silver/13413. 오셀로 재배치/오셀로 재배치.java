import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Main().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tcCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < tcCount; i++) {
            int arrayLength = Integer.parseInt(br.readLine());
            int result = 0;

            StringBuilder before = new StringBuilder(br.readLine());
            StringBuilder after = new StringBuilder(br.readLine());

            for (int j = 0; j < arrayLength; j++) {
                if (before.charAt(j) != after.charAt(j)) {
                    boolean check = false;
                    for (int x = j + 1; x < arrayLength; x++) {
                        if (before.charAt(j) != before.charAt(x)) {
                            if (before.charAt(x) != after.charAt(x)) {
                                char temp = before.charAt(j);
                                before.setCharAt(j, before.charAt(x));
                                before.setCharAt(x, temp);
                                check = true;
                                break;
                            }
                        }
                    }

                    if (!check) {
                        before.setCharAt(j, after.charAt(j));
                    }

                    result++;
                }
            }
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}