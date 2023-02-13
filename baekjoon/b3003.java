package b;
import java.util.Scanner;
public class b3003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] ches = {1,1,2,2,2,8};
		int[] need= {0,0,0,0,0,0};
		for(int i=0;i<=5;i++)
			need[i]=sc.nextInt();
		for(int i=0;i<need.length;i++)
		System.out.print(ches[i]-need[i]+" ");
	}

}
