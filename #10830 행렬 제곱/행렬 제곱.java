import java.io.*;
import java.math.BigInteger;
import java.util.*;
/*      박두지 화이팅!! 갓천대 화이팅!!!
[문제접근]
아침에 풀었던 제곱 1627번이랑 비슷한 로직이라서 pow()메서드를 만들고하면 되는거라 머리속에 전체적인 그림을 그리는건 오래 걸리지 않았다.
단지, 재귀적으로 접근해야한다는걸 인식하고 나서부터 코드를 짜는게 힘들었다.(약한부분)

이해를 돕고자 메모장에 적었다.
행렬에서의 지수법칙의 예
M^100 = M^50*M^50
      = M^50 * (M^25 * M^25)
      = M^50 * (M^25 * M^12*M^12*M) ---이렇게 분해가 가능하다. 이 점에대해서는 재귀메서드로 돌릴 것이다.
      = ...(이렇게 하다보면 M으로 조합가능하다)

[주의할 점]
지수의 입력값이 100,000,000,000 이라서 long 타입을 받아야한다.
재귀가 흘러가는 매커니즘 정도만 이해한거같아 뭔가 느낌적으로만 알아서
사실 영 불안하다. 재귀적 접근 문제를 많이 풀어보면서
좀 더 익숙해야할거같다.

*/

public class Main {
    static int n;
    static int[][] square; // 처음 원본 배열(행렬)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

       square = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {

                square[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] square2 = pow(square, b);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(square2[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);


    }

    public static int[][] pow(int[][] square, long exponential) { //재귀적으로 분할 정복하는 방식

        // 지수가 1일 경우 원시 이기에 리턴하면된다.
        if (exponential == 1) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                   square[i][j] = square[i][j]%1000; // 지수가 1일 때는 pow 과정에서 원본 행렬이 바로 나올 수 있는데 1000으로 나눈 나머지 값으로 출력을 해라고 해서 지금 전처리(?)해준다.
                }
            }
            return square; //들어오자말자 원본은 내보내는 용도 그리고 재귀메서드의의 끝에 도달하면 콜 한곳으로 리턴하는 곳.
        }

        // 지수를 절반씩 재귀식으로 계속 쪼개면서 결국 원본행렬을 만날때까지 구한다. 그리고 return 조건을 나면 return 하면서 돌아온다.
        int[][] halfExp = pow(square, exponential / 2);//recursive 한 것. 계속 지수를 반씩 나눈다.

        halfExp = multiply(halfExp,halfExp); //반토막씩 난 행렬의 곱

        if (exponential % 2 == 1) { //지수가 홀수인 경우
            halfExp = multiply(halfExp,square);//지수의 반인 행렬 곱하기 원본행렬
        }
        return halfExp;
    }

    static int[][] multiply(int[][] square1, int[][]  square2 ){
        int[][] square3 = new int[n][n]; //행렬끼리 곱한걸 옮길 행렬

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    square3[i][j] += square1[i][k] * square2[k][j] ; //앞에 행렬은 열을 하나씩 이동하면서 뒤에 있는 행과 1대1씩 매칭하면서 곱하고 더한다.
                    square3[i][j] = square3[i][j]%1000; //행렬끼리 곱할때마다 나머지 연산해야한다는 것을 까먹고 처음엔 틀렸다...
                }
            }
        }

        return square3;
    }
}





