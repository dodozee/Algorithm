import java.io.*;
/* 전 문제와 똑같이아이디어가 바로 떠올라 로직을 구상한 뒤 접근했는데
    전 문제는 코드가 비교적 더 길고 은근 복잡했는데
    어려운 건 없어 쉬웠다.
*/
public class Main {//갓천댓~~ 두지코딩~~
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] arr = str.split("");
        int count=0;

        for (int i = 0; i < arr.length/2; i++) {
            if (arr[i].equals(arr[arr.length - i - 1])) {
                count++;
            }
        }
        if (count == arr.length / 2) {
            System.out.println("1");
        } else System.out.println("0");
    }
}