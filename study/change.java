package b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class change {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(bf.readLine());
		System.out.println(changemoney(n));
	}
	public static int changemoney(int change)
	{
		int count=0;
		int temp = 1000;
		int money[] = {500,100,50,10,5,1}; 
		for(int i=0;i<money.length;i++)
		{
			while(change<temp)
			{
				if(temp>money[i]&&temp-money[i]>=change) // 이 조건 이였으나 temp-money[i]>=change이것만 있어도 동작가능
				{ 										 // 조건에 대해서 조금더 공부가 필요함
					temp-=money[i];						 // 그리디 매커니즘은 큰수에서 하나씩 줄여나가는 방식이 많음
					count++;
				}
				else
					break;
			}
		}
		return count;
	}
}
