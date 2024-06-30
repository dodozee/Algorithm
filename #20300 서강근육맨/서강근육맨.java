import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long [] weight = new long[n];
        
        for(int i=0; i<n; i++){
            weight[i] = sc.nextLong();
        }
        
        Arrays.sort(weight);
        long maximum = 0;
        
        if(n%2==0){
            for(int i=0; i<n/2; i++){
                maximum = Math.max(maximum,weight[i]+weight[n-1-i]);
            }
        }else{
            maximum = weight[n-1];
            
            for(int i=0; i<(n-1)/2; i++){
                maximum = Math.max(maximum, weight[i]+weight[n-2-i]);
            }
        }

        System.out.println(maximum);
    }
}