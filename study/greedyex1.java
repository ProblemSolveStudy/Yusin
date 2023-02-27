package b;

import java.io.*;

public class greedyex1 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n= Integer.parseInt(bf.readLine());
		int coin[] = {500,100,50,10};
		int cnt=0;
		for(int i=0;i<coin.length;i++)
		{
			cnt+=n/coin[i];
			n%=coin[i];
		}
		System.out.println(cnt);
	}

}
