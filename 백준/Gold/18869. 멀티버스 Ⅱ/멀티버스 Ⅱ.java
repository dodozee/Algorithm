import java.io.*;
import java.util.*;

public class Main{

    private static int N, M;
    private static int answer;
    private static List<List<Integer>> Spaces = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            List<Integer> space = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            for(int j=0; j<N; j++){
                int planet = Integer.parseInt(st.nextToken());
                set.add(planet);
                space.add(planet);
            }

            List<Integer> clone = new ArrayList<>(set);
            Collections.sort(clone);

            for(int j=0; j<N; j++){
                int idx = Collections.binarySearch(clone, space.get(j));

                space.set(j, idx);
            }
            Spaces.add(space);
        }

        for(int i=0; i<M; i++){
            for(int j=i+1; j<M; j++){
                if(Arrays.equals(Spaces.get(i).toArray(), Spaces.get(j).toArray())) answer++;
            }
        }

        System.out.println(answer);


        br.close();
        bw.flush();
        bw.close();
    }

}