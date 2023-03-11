import java.io.*;
import java.util.Arrays;

public class Main { //나라사랑 가천사랑 동기사랑 !!!화티이!!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());

        String[] arr1;
        int[] arr2 = new int[n];
        String str = br.readLine();

        arr1 = str.split(" "); //" "스페이스 구간으로 쪼개서 String 배열에 저장하기

        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = Integer.parseInt(arr1[i]); // String 배열에 있는 문자형 숫자를 숫자형으로 바꾸는 과정
        }
        Arrays.sort(arr2); //Arrays 클래스로 간편하게 정렬하기~ 오름차순으로 정리하는게 포인트다.
        int sum = 0;
        int result =0;
        for(int i=0; i<arr2.length; i++) {
           sum = sum + arr2[i];
           result +=sum;
//         로그 찍는 용!!!   System.out.println("i번 째 : " + i + " result :" +result);
        }
        System.out.print(result);
    }
}
