import java.util.*;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];
        for (int i = 0; i < 5; i++) {
            numbers[i] = sc.nextInt();
        }
        for (int j=0;j<5;j++){
            for (int i = 0; i < 4; i++) {
                if(numbers[i]>numbers[i+1]){
                    int tmp = numbers[i];
                    numbers[i] = numbers[i+1];
                    numbers[i+1] = tmp;
                    for (int num : numbers) {
                        System.out.print(num+" ");
                    }
                    System.out.println();
                }
            }
        }
    }
}