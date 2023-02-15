package sample1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class atm {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		//조건 : 사람은 1번부터 n번까지 번호가 매겨져 있으며, i번 사람이 돈을 인출하는데 걸리는 시간은 Pi분
		int n=Integer.parseInt(bf.readLine()); //입력값 정수로 변환하여 n에 저장(대기인원)
		int[] time = new int[n]; //입력값 만큼의 배열 생성(대기인원의 걸리는 시간을 각각 저장하기위한 배열)
		StringTokenizer st = new StringTokenizer(bf.readLine()," "); // StringTokenizer를 통해 띄어쓰기로 구분해 값저장(문자열)
		for(int i=0;i<n;i++)
		{
			time[i]=Integer.parseInt(st.nextToken()); //StringTokenizer를 통해 구분되어 있는 값을 하나씩 배열에 저장
		}
		System.out.println(waitingtime(n,time));
		bf.close();
	}
	public static int waitingtime(int num, int[] time)
	{
		Arrays.sort(time); //최솟값을 찾기 위해 오름차순으로 정렬
		int result=0,sum=0; //result = 최종적으로 출력할 최솟값 sum = i가 대기해야하는 시간 
		for(int i=0;i<num;i++)
		{
			for(int k=0;k<=i;k++) //i번째에 있는 사람의 대기시간을 구하는 for문
				sum+=time[k]; 
			result+=sum;
			sum=0; //다음 대기시간을 구하기위해 초기화
		}
		return result;
	}
}