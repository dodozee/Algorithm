import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int n;
    static int[] m;
    static Map<Integer, Ingredient> ingredients;

    static int answer;
    static List<Integer> choose;
    static List<Integer> answerChoose;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        m = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            m[i] = Integer.parseInt(st.nextToken());
        }

        ingredients = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            ingredients.put(i, new Ingredient(p, f, s, v, cost));
        }

        answer = Integer.MAX_VALUE;
        choose = new ArrayList<>();
        dfs(0, 0, 0, 0, 0, 0);


        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(answer);
        for (int number : answerChoose) {
            System.out.print(number+1 + " ");
        }


    }

    public static void dfs(int stage, int sumP, int sumF, int sumS, int sumV, int sumCost) {

        if (sumCost > answer) {
            return;
        }

        if(sumP >= m[0] && sumF >= m[1] && sumS >= m[2] && sumV >= m[3]) {
            if (answer > sumCost) {
                answer = sumCost;
                answerChoose = new ArrayList<>();
                answerChoose.addAll(choose);
            }
            return;
        }

        if (stage >= n) {
            return;
        }

        choose.add(stage);
        Ingredient ingredient = ingredients.get(stage);
        dfs(stage + 1,
                sumP + ingredient.p,
                sumF + ingredient.f,
                sumS + ingredient.s,
                sumV + ingredient.v,
                sumCost + ingredient.cost);
        choose.remove(Integer.valueOf(stage));

        dfs(stage + 1, sumP, sumF, sumS, sumV, sumCost);
    }

    public static class Ingredient {

        int p;
        int f;
        int s;
        int v;
        int cost;

        Ingredient(int p, int f, int s, int v, int cost) {
            this.p = p;
            this.f = f;
            this.s = s;
            this.v = v;
            this.cost = cost;
        }

    }

}