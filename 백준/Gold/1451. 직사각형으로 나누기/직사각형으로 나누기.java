import java.util.Scanner;

public class Main {
    static int n,m;
    static int[][] arr;
    static long[][] sum;

    public static void main(String[] args) {
        long answer = 0;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.nextLine();

        arr = new int[n+1][m+1];

        for(int i=1;i<=n;i++) {
            String str = " " + scanner.nextLine();
            for(int j=1;j<=m;j++) {
                arr[i][j] = str.charAt(j)-'0';
            }
        }

        sum = new long[n+1][m+1];
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + (long) arr[i][j];
            }
        }

        // case 1
        for(int i=1;i<=m-1;i++) {
            for(int j=i+1;j<=m-2;j++) {
                long r1 = area(1,1,n,i);
                long r2 = area(1,i+1,n,j);
                long r3 = area(1,j+1,n,m);
                if(answer<r1*r2*r3) {
                    answer = r1*r2*r3;
                }
            }
        }

        // case 2
        for(int i=1;i<=n-1;i++) {
            for(int j=i+1;j<=n-1;j++) {
                long r1 = area(1,1,i,m);
                long r2 = area(i+1,1,j,m);
                long r3 = area(j+1,1,n,m);
                if(answer<r1*r2*r3) {
                    answer = r1*r2*r3;
                }
            }
        }

        //case 3
        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                long r1 = area(1,1,n,i);
                long r2 = area(1,i+1,j,m);
                long r3 = area(j+1,i+1,n,m);
                if(answer<r1*r2*r3) {
                    answer = r1*r2*r3;
                }
            }
        }

        //case 4
        for(int i=1;i<n;i++) {
            for(int j=1;j<m;j++) {
                long r1 = area(1,1,i,j);
                long r2 = area(i+1,1,n,j);
                long r3 = area(1,j+1,n,m);
                if(answer<r1*r2*r3) {
                    answer = r1*r2*r3;
                }
            }
        }
        for(int i=1;i<n;i++) {
            for(int j=1;j<m;j++) {
                long r1 = area(1,1,i,m);
                long r2 = area(i+1,1,n,j);
                long r3 = area(i+1,j+1,n,m);
                if(answer<r1*r2*r3) {
                    answer = r1*r2*r3;
                }
            }
        }

        for(int i=1;i<n;i++) {
            for(int j=1;j<m;j++) {
                long r1 = area(1,1,i,j);
                long r2 = area(1,j+1,i,m);
                long r3 = area(i+1,1,n,m);
                if(answer<r1*r2*r3) {
                    answer = r1*r2*r3;
                }
            }
        }

        System.out.println(answer);
    }

    private static long area(int x1, int y1, int x2, int y2) {
        return sum[x2][y2] - sum[x2][y1-1] - sum[x1-1][y2] + sum[x1-1][y1-1];
    }
}