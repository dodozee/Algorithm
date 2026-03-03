import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int M=Integer.parseInt(st.nextToken());
        int N=Integer.parseInt(st.nextToken());

        int[] snack=new int[N];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            snack[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(snack);

        int left=1;
        int right=snack[N-1];

        while(left<=right){
            int mid=(left+right)/2;

            int cnt=0;
            for(int i=0;i<N;i++){
                if(snack[i]>=mid){
                    cnt+=snack[i]/mid;
                }
            }

            if(cnt>=M){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }

        System.out.println(right);
    }
}