package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class SickKnight {								//클래스로 객체를 생성후 메소드를 불러오는 형식의 방식을 공부하는중
	
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
			return 1;							//높이가 1일경우 움직일 수가 없어서 시작지점이 끝이다.
		else if(n==2)							//높이가 2일경우 최대 4번이상 못움직이므로 Min으로 더 작은값을 찾는다. 2,3번으로밖에 못움직이기때문이다.
			return Math.min(4, (m+1)/2);		//+1을한뒤 /2를 하는 이유는 소수점이 나올경우 인트값으로 하면 소수점자리는 다 버리기때문에 +1하고 나눈다.
		else if(m<7) 							//높이가 7이하 일경우는 최대 4이므로 높이가 2일경우랑 비슷한 조건을 준다.
			return Math.min(4, m);				
		else
			return m-2;							//높이가 7이상일경우 1~4번까지 하고 넓이가 1씩 증가하는 방법으로 할 경우 넓이값 -2하면 값을 구할 수 있다.
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
