package b;

import java.io.*;
import java.util.StringTokenizer;

public class greedyex2 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine()," ");
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());		
		int cnt=0;
		while(N!=1)
		{
			if(N%K==0)
			{
				cnt++;
				N/=K;
			}                     //내가 짠거
			else
			{
				N-=1;
				cnt++;
			}
		}
		System.out.println(cnt);
		/*while(true)
		{
			int target = (N/K)*K;
			cnt +=(N-target);
			N = target;
			if(N<K)break; //나동빈씨가 짠거
			cnt +=1;
			N/=K;
		}
		cnt+=(N-1);
		System.out.println(cnt);*/
	}

}
