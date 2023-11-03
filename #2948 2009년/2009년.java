import java.util.*;
 
public class Main {//박두지 화이팅!!
	public static void main(String[] args) throws Exception{
		Scanner s = new Scanner(System.in);
		int d = s.nextInt(), m=s.nextInt(), ans=0;
		int [] day = new int[] {0,0,31,28,31,30,31,30,31,31,30,31,30,31};
		String [] seven = { "Wednesday", "Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday"};
		for(int i=0;i<=m;i++)
			ans+=day[i];
		ans+=d;
		System.out.println(seven[ans%7]);
	}
}