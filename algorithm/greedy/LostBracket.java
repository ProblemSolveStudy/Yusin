package b;

import java.util.*;
import java.io.*;

public class LostBracket {

	public static void main(String[] args) throws IOException {
		
		System.out.println(lostbracket());
	}
	public static int lostbracket() throws IOException
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int result = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(bf.readLine(),"-"); //-기준으로 자름
		
		while(st.hasMoreTokens())
		{
			int temp=0;
			
			StringTokenizer st2 = new StringTokenizer(st.nextToken(),"+"); //자른값을 +기준으로 다시 자름
			
			while(st2.hasMoreTokens())
				temp+=Integer.parseInt(st2.nextToken()); // 자른 모든 값을 더함
			
			if(result==Integer.MAX_VALUE) //본인이 생각하기엔 특정값을 넣지 않는 이유는 뒤에 똑같은 값이 나올경우 문제가 생기기 때문인거 같음
				result=temp; //첫번째 값을넣어줌
			else
				result-=temp; // 두번째 값부터 빼기 시작함
		}
		return result;
	}
}
