import java.util.Scanner;

public class Main{ //가천대 컴공 20학번 화이팅~~
    public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            int n = s.nextInt();
            double[] arr=new double[n]; //소수점까지 나오게하려면 실수인 double형으로 선언
            for(int i =0; i<n; i++){
                arr[i] = s.nextInt();
            }
            double max = arr[0];

        for(int i =0; i<n; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i]/max*100; //사기치는 로직
        }

        double sum =0;
        for (int i = 0; i < n; i++) {
            sum = sum +arr[i];
        }
        System.out.println(sum/n); //새로운 평균 구하기 ㅋㅋ
        }
}
