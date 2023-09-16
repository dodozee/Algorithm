import java.util.*;

public class Main {//박두지 화이팅!
       public static void main(String[] args) {
           
		Scanner s = new Scanner(System.in);
           
		int scenario=1;
		while(true) {
			String AB=" ";
			int n = s.nextInt();
			if(n==0) break;
			
			s.nextLine();
			String[] name=new String[n];
			for(int i=0; i<n;i++) {
				name[i]=s.nextLine();
			}
			ArrayList<String> k = new ArrayList<String>();
			for(int i=0;i<2*n-1;i++) {
				String num=s.next();
				if(k.contains(num))
					k.remove(num);
				else
					k.add(num);
				AB = s.nextLine();
			}
			int tmp = Integer.parseInt(k.get(0));
			System.out.println(scenario+" "+name[tmp-1]);
			scenario++;
		}
	}
}
