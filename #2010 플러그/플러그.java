
import java.util.*;

public class Main {//박두지 화이팅!!
	public static void main(String[] args) {
		
		int sum = 0;
		
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		for(int i=0; i<count; i++) {
			int num = sc.nextInt();
			sum+=num;
		}
		System.out.println(sum-(count-1));
	}
}