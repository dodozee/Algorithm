import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[103];
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        for(int i = 0; i < 3; i++){
            int tmpa = sc.nextInt();
            int tmpb = sc.nextInt();
            for(int j = tmpa; j < tmpb; j++){
                arr[j]++;
            }
        }
        int sum = 0;
        for(int i = 0; i < 100; i++){
            if(arr[i] == 1){
                sum += a;
            }else if(arr[i] == 2){
                sum += b*2;
            }else if(arr[i] == 3){
                sum += c*3;
            }
        }
        System.out.println(sum);
    }
}