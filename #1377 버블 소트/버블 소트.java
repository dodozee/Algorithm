import java.io.*;
import java.util.*;

/*
분석
1. n개의 숫자를 받음 그리고 버블 정렬을 하는데 몇 번만에 정렬이 완료되는지 출력하면 됨.

 */
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node[] arr = new Node[n];
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            arr[i] = new Node(value, i);
        }

        Arrays.sort(arr);

        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i].index - i);//예) 지금 3번 째로 있는 값이 원래 5번째 있었음. 그러면 5 - 3 = 2로 2번째로 이동했다는 뜻.
        }

        System.out.println(max + 1);

    }
}
class Node implements Comparable<Node>{
    int value;
    int index;

    public Node(int value, int index){
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }

}