import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;


public class Main {
    public static void main(String[] args) throws IOException {
        /*
        순서대로 강의 번호, 강의 시작 시간, 강의 종료 시간
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Time> timeList = new ArrayList<>();
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            timeList.add(new Time(a, b, c));
        }
        Collections.sort(timeList);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int max = 1;

        for (int i = 0; i < n; i++) {
            while(!pq.isEmpty() && pq.peek() <= timeList.get(i).start) {
                pq.poll();
            }
            pq.offer(timeList.get(i).end);
            max = Math.max(max, pq.size());

        }

        System.out.println(max);

    }

}

class Time implements Comparable<Time> {
    int num;//강의 번호
    int start;//강의 시작 시간
    int end;//강의 종료 시간


    public Time(int num, int start, int end) {
        this.num = num;
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(Time o) {
        if (this.start == o.start) {
            return this.end - o.end;
        }
        return this.start - o.start;//음수가 나온다면 this가 앞으로 간다.=오름차순
    }

}