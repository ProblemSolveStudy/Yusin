package b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class rope {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(bf.readLine());
		Integer rope[] = new Integer[n];
		for(int i=0;i<n;i++)
			rope[i]=Integer.parseInt(bf.readLine());
		System.out.println(weight(rope));
	}
	public static int weight(Integer rope[])
	{
		int result=0;
		Arrays.sort(rope, Collections.reverseOrder()); //내림차순 정렬
		for(int i=0;i<rope.length;i++)
		{
			if(rope[i]*(i+1)>result) // 나올수 있는 경우의 수 중에서 제일 큰값을 찾아내는 조건
				result=(rope[i]*(i+1));// 제일 큰값을 저장
		}
		return result;
	}
}
