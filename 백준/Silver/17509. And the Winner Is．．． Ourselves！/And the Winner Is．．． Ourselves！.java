import java.io.*;
import java.util.*;

/**
 * 입력: 11줄, 각 줄에 "solvingTime penalty" (예: "15 1")
 * 출력: 총 시간 = (누적 풀이시간들의 합) + (20 * penalty 합)
 */
public class Main {

    private static final int N = 11;

    public static void main(String[] args) throws Exception {
        List<Record> records = readRecords(N);
        int answer = calculateTotal(records);

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(Integer.toString(answer));
        }
    }

    private static List<Record> readRecords(int n) throws IOException {
        List<Record> list = new ArrayList<>(n);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                // 혹시 공백/빈 줄이 섞이면 다음 유효 라인을 읽도록 처리
                while (line != null && line.trim().isEmpty()) {
                    line = br.readLine();
                }
                if (line == null) break;

                StringTokenizer st = new StringTokenizer(line);
                int time = Integer.parseInt(st.nextToken());
                int penalty = Integer.parseInt(st.nextToken());

                list.add(new Record(time, penalty));
            }
        }

        return list;
    }

    private static int calculateTotal(List<Record> records) {
        // solvingTime 오름차순 정렬
        records.sort(Comparator.comparingInt(r -> r.time));

        int total = 0;
        int cumulative = 0;
        int penaltySum = 0;

        for (Record r : records) {
            cumulative += r.time;
            total += cumulative;
            penaltySum += r.penalty;
        }

        total += 20 * penaltySum;
        return total;
    }

    private static class Record {
        final int time;
        final int penalty;

        Record(int time, int penalty) {
            this.time = time;
            this.penalty = penalty;
        }
    }
}
