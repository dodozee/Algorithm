import java.io.*;
public class Main { //나라사랑 가천사랑 동기사랑 !!!화티잉!!!!!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();//문자열 받음
        int sum =0;//총 시간을 구해줄 변수
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) { //switch문으로 sum에 더해준다. String의 변수.charAt(index)하면 배열 인덱스에 해당하는 위치의 문자가 나온다~
                case 'A':
                case 'B':
                case 'C':
                    sum = sum+3;
                    break;
                case 'D':
                case 'E':
                case 'F':
                    sum = sum+4;
                    break;
                case 'G':
                case 'H':
                case 'I':
                    sum = sum+5;
                    break;
                case 'J':
                case 'K':
                case 'L':
                    sum = sum+6;
                    break;
                case 'M':
                case 'N':
                case 'O':
                    sum = sum+7;
                    break;
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                    sum = sum+8;
                    break;
                case 'T':
                case 'U':
                case 'V':
                    sum = sum+9;
                    break;
                default:  //나머지 W,X,Y,Z는 default를 사용하여 10초를 더해준다.
                    sum = sum+10;
                    break;
            }
        }
        System.out.println(sum);
    }
}

