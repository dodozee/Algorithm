import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int [][] wList;
    static int[][][] dpList;
    static int dfs(int visited, int price, int from, int sum, int n)
    {
        int res = sum;
        int compSum;
        if (dpList[from][visited][price] != 0)
        {
            return dpList[from][visited][price];
        }
        for (int i = 0; i < n; i++)
        {
            if ((visited | (1 << i)) != visited  & price <= wList[from][n - 1 - i]) 
            {
                if (res < (compSum = dfs(visited | (1 << i), wList[from][n  - 1 - i], n - 1 - i, sum + 1, n)))
                {
                    res = compSum;
                }
            }
        }
        dpList[from][visited][price] = res;
        return res;
    }

    public static void main(String[] args) {

        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            n = Integer.parseInt(br.readLine());
            wList = new int[n][n];
            dpList = new int[n][1 << n][10];
            for (int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                {
                    wList[i][j] = br.read() - '0';
                }
                br.read();      
            }
            System.out.println(dfs(1 << (n - 1), 0, 0, 1, n));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}