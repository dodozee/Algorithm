import java.util.Scanner;

public class Main{ //가천대 컴공 20학번 화이팅~~

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int [] arr = new int[10];
        int count=0;
        int same=0;

        for (int i=0; i<arr.length; i++) {
            arr[i]=(s.nextInt()%42);
        }

        for (int i=0; i<arr.length; i++) { // 이중 for문을 만들어서 하나씩 비교한다. 
            //성능은 확실히 떨어질거같아 중복을 제거해주는 set으로 해도될거같다.
            same=0;
            for(int j=i+1; j<arr.length;j++) {//앞서 비교했던 것은 또 반복해서 비교할 필요가 없어서 j=i+1로 한다.
                if(arr[i]==arr[j]) {
                    same++;
                }
            }
            if(same==0) {
                count++;
            }
        }
        System.out.println(count); //
    }
}
