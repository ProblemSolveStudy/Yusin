package b;

import java.util.*;
import java.io.*;
import java.math.*;

public class meeting1 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		
		int n=Integer.parseInt(bf.readLine());//라인으로 안할 경우 엔터도 입력값으로 들어가서 문제가 생김
		int[][] time = new int[n][2];
		
		for(int i=0;i<n;i++)
		{
			StringTokenizer st = new StringTokenizer(bf.readLine()," ");
			time[i][0]=Integer.parseInt(st.nextToken());
			time[i][1]=Integer.parseInt(st.nextToken());
		}
		System.out.println(meetingroom(n,time));
		bf.close();
	}
	public static int meetingroom(int num, int[][] time)
	{
		int result=0;
		int temp=0;
		Arrays.sort(time,(e1,e2)->{ //람다식으로 간소화시켜 두번째 배열을 기준으로잡고
			if(e1[1]==e2[1]) //내림차순으로 정렬하기 위한 식 e1[0]==e2[0]일경우 첫번째 배열 기준
				return e1[0]-e2[0];
			else
				return e1[1]-e2[1];
		});
		for(int i=0;i<num;i++)
		{
			if(temp<=time[i][0]) // 첫번째 배열의 값보다 크거나 같을 경우
			{
				temp=time[i][1]; // 끝나는 방의 값을 넣어서 조건 검색을 위한것
				result++; // 두번째 방에 값을 넣는대 예시에서 값은  4,7,11,14가 들어가면서 4가 출력된다.
			}             
		}
		return result;
	}
}