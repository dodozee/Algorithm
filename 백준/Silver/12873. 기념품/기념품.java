import java.util.LinkedList;
import java.util.Scanner;

public class Main{
	static int getDel(int i, int mod) {
		int ans=i;
	    ans*=i;
	    ans%=mod;
	    ans*=i;
	    return ans%mod;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> queue = new LinkedList<>();
		int N = sc.nextInt();

		for (int i = 1; i < N + 1; i++)
			queue.add(i);
		int bf=0;
		

		for (int i = 1; i < N; i++) {
			int delNum = (bf+getDel(i,queue.size())-1)%queue.size(); // 인덱스
			if (delNum < 0)
				delNum +=queue.size();
			queue.remove(delNum);
			
			for (int j = 0; j < delNum; j++) {
				queue.add(queue.poll());
			}
		}
		System.out.println(queue.poll());
	}

}