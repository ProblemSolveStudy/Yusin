package b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NewRecruits {
	//조건 어느한쪽이 더 작은수면 안됨 그래서 어느한쪽을 오름차순으로 정렬후 큰 수를 찾아서 카운트
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		for(int i=0;i<T;i++)
		{
			int N = Integer.parseInt(bf.readLine());
			int newrecruits[][] = new int[N][2];
			for(int j=0;j<N;j++)
			{
				StringTokenizer st = new StringTokenizer(bf.readLine()," ");
				newrecruits[j][0]=Integer.parseInt(st.nextToken());
				newrecruits[j][1]=Integer.parseInt(st.nextToken());
			}
			System.out.println(Passer(newrecruits));
		}
	}
	public static int Passer(int[][] arr)
	{
		int result=0,temp=Integer.MAX_VALUE;
		Arrays.sort(arr , (e1,e2)->{ //왼쪽 값을 오름차순 정렬후 오른쪽값을 비교
			if(e1[0]==e2[0])
				return e1[1]-e2[1];
			else
				return e1[0]-e2[0];
		});
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i][1]<temp) // 오른쪽값이 입력된 값 보다 클경우 값을 변경함
			{
				temp=arr[i][1];
				result++;
			}
		}
		return result;
	}

}
