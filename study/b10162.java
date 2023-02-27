package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b10162 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		int arr[][] = new int[3][2];
		arr[0][0]=300;
		arr[1][0]=60;
		arr[2][0]=10;
		for(int i=0;i<arr.length;i++)
		{
			while(0<t)
			{
				if(t/arr[i][0]!=0)
				{
					t-=arr[i][0];
					arr[i][1]++;
				}
				else
				{
					break;
				}
			}
			if(i==2&&t!=0)
			{
				System.out.println(-1);
				return;
			}
		}
		for(int i=0;i<arr.length;i++)
		System.out.print(arr[i][1] + " ");
	}
}
