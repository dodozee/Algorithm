import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static HashMap<String, HashMap<String, Integer>> doubleMap = new HashMap<>();
    static String[] mbtis = {
            "ISTJ", "ISFJ", "INFJ", "INTJ",
            "ISTP", "ISFP", "INFP", "INTP",
            "ESTP", "ESFP", "ENFP", "ENTP",
            "ESTJ", "ESFJ", "ENFJ", "ENTJ"
    };

    static int mbtiDistance(String a, String b) {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                result++;
            }
        }
        return result;
    }

    static int mbtiTripleDistance(String a, String b, String c) {
        return doubleMap.get(a).get(b) + doubleMap.get(a).get(c) + doubleMap.get(b).get(c);
    }

    public static void main(String[] args) throws IOException {
        // 두 사람의 관계를 먼저 초기화
        for (String a : mbtis) {
            doubleMap.put(a, new HashMap<>());
            HashMap<String, Integer> map = doubleMap.get(a);
            for (String b : mbtis) {
                map.put(b, mbtiDistance(a, b));
            }
        }

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int arrSize = Integer.parseInt(br.readLine());
            if (arrSize >= 48) {
                sb.append(0).append("\n");
                br.readLine();
                continue;
            }
            String[] inputMbtis = br.readLine().split(" ");

            int result = Integer.MAX_VALUE;
            for (int i = 0; i < inputMbtis.length; i++) {
                for (int j = i + 1; j < inputMbtis.length; j++) {
                    for (int k = j + 1; k < inputMbtis.length; k++) {
                        int sum = mbtiTripleDistance(inputMbtis[i], inputMbtis[j], inputMbtis[k]);
                        result = Math.min(sum, result);
                    }
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}