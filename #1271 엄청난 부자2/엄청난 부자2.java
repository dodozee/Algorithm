import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main{ //두지~~~ 화이팅!! 가천 컴공화이팅!!
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        BigInteger x = s.nextBigInteger(); //10^100은 0이 100개가 붙기 때문에 int나 long의 범위를 한참 벗어나는 너무 나도 큰수이다.
        BigInteger y = s.nextBigInteger();

        System.out.println(x.divide(y));
        System.out.println(x.remainder(y));

    }
}