package b;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class number {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(bf.readLine());
		System.out.println(MaxNumber(n));
	}
	public static long MaxNumber(long n)
	{
		long result=0;
		long i=0,temp=1;
		while(n>i)
		{
			i+=temp; // int로 프로그래밍시 입력값이 int의 최댓값을 넘기때문에 long을 사용하여 프로그래밍해야함
			if(n<i)break; //원래 코드 n<i+temp였는대 +temp를 추가하면 long값을 넘어가서 오류가 일어나서  
			temp++; //result값을 -1시키는 코드로 변환
			result=temp;
		}
		return result-1;
	}
}
