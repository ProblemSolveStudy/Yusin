package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class SickKnight {
	
	int n;
	int m;
	public SickKnight(int n, int m)
	{
		this.n = n;
		this.m = m;
	}
	public int sickknight()
	{
		if(n==1)
			return 1;
		else if(n==2)
			return Math.min(4, (m+1)/2);
		else if(m<7)
			return Math.min(m, 4);
		else
			return m-2;
	}
}
public class Sick_knight {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		SickKnight sk = new SickKnight(n,m);
		System.out.println(sk.sickknight());
	
	}
}
