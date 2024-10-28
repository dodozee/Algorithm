
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    static int[] parents;
    static ArrayList<Integer>[] party;
    public static void main(String[] args) throws IOException, InterruptedException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken()); //진실을 아는 사람의 수
        
        int[] truePeople = new int[k];

        for (int i = 0; i < k; i++) {
            truePeople[i] = Integer.parseInt(st.nextToken());
        } //진실을 아는 사람들 저장

        parents = new int[n + 1];
        party = new ArrayList[m];

        for (int i = 0; i < m; i++) {
            party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());//파티에 오는 사람들
            int partySize = Integer.parseInt(st.nextToken());
            for (int j = 0; j < partySize; j++) {
                party[i].add(Integer.parseInt(st.nextToken()));//각 파티 그룹에 속한 사람들
            }
        }

        for (int i = 0; i <= n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int first = party[i].get(0);//파티의 첫번째 사람
            for (int j = 1; j < party[i].size(); j++) {
                union(first, party[i].get(j));
            }//파티에 있는 사람들을 union
        }
        
        
        //parents 배열을 순회하며 진실을 아는 사람들과 다른 집합으로 분류되어 있다면 해당 사람들의 개수를 더해서 출력하면 됨.
        
        int count = 0;
        for (int i = 0; i < m; i++) {
            int leader = party[i].get(0);
            boolean flag = true;
            for (int j = 0; j < k; j++) {
                if (isItSameSet(leader, truePeople[j])) {
                    flag = false;
                    break;
                }
            }
            if(flag) count++;
        }
        System.out.println(count);

    }
    
    private static int find(int x) {
        if(parents[x] == x) 
            return x;
        return parents[x] = find(parents[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {//x와 y가 다른 집합에 속해있다면
            parents[y] = x; //y의 부모를 x로 설정(즉, y가 x의 집합에 속하게 됨)
        }
    }

    private static boolean isItSameSet(int x, int y) {//x와 y가 같은 집합에 속해있는지 확인
        if(find(x) == find(y))
            return true;
        else return false;
        
    }
}


