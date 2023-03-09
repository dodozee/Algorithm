import java.util.Scanner;

public class Main{ //가천대 컴공 20학번 화이팅~~
    public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            int n = s.nextInt(); //바구니 갯수!
            int m = s.nextInt(); // 역순으로 바꿀 횟수!
            int[] arr=new int[n];
            for(int i=0;i<n;i++)
                arr[i]=(i+1);

            for(int c = 0; c< m; c++) { // m번 바꾼다.
                int i = (s.nextInt() - 1);
                int j = (s.nextInt() - 1);
                while (j > i) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    j--;
                    i++;
                }
            }
            for(int i=0; i<n;i++) {
                System.out.print(arr[i]+" ");
            }
        }
    }

