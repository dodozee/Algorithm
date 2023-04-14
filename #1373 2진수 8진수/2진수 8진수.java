import java.util.*;
import java.io.*;

public class Main{//박두지 화이팅!!! 갓천대 화이팅!!!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binary = sc.nextLine();

        sc.close();

        StringBuilder sb = new StringBuilder();
        int length = binary.length();
        int remainder = length % 3;
        if(remainder !=0){ //3의 배수로 딱 안맞아 떨어질때
            binary = "0".repeat(3 - remainder) + binary;//주어진 2진수를 3자리씩 끊어서 8진수로 변환하며, 남은 자리수가 3의 배수가 아닐 경우 맨 앞에 0을 채움
            length = binary.length();
        }

        for (int i = 0; i < length; i += 3) {
            int octal = (binary.charAt(i) - '0') * 4
                    + (binary.charAt(i + 1) - '0') * 2
                    + (binary.charAt(i + 2) - '0');
            sb.append(octal);
        }

        System.out.println(sb);
    }
}