import java.util.*;

public class Main {
	static int[] temp=new int[103];
	static int n,k,max=Integer.MIN_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		n=sc.nextInt();
		k=sc.nextInt();
		
		for(int i=0;i<n;i++)
			temp[i]=sc.nextInt();
		
		for(int i=0;i<=n-k;i++) {
			int sum=0;
			for(int j=0;j<k;j++)
				sum+=temp[i+j];
			
			if(sum>max)
				max=sum;
		}
		System.out.println(max);
	}

}