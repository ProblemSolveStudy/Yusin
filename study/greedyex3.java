package b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class greedyex3 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		/*String n= bf.readLine();
		int arr[] = new int[n.length()];
		for(int i=0;i<arr.length;i++)
			arr[i]=n.charAt(i)-'0';
		int result=0;
		for(int i=0;i<arr.length;i++) //내가 푼것
		{
			if(arr[i]>1&&result>1)
				result*=arr[i];
			else
				result+=arr[i];
		}
		System.out.println(result);*/
		
		String n = bf.readLine();
		int result = n.charAt(0)-'0';
		for(int i=1;i<n.length();i++)
		{
			int num=n.charAt(i)-'0'; //나동빈씨가 푼것 엄청 간결하고 필요한것만 딱딱 적음
			if(num<=1||result<=1)result+=num; // 간소화를 연습해야 할 필요성을 느낌
			else result*=num; //배열을 선언후 굳이 배열에 값을 넣은후 다시 검사를 할 필요가 없음
		}					  //변수 하나 선언해서 그값을 넣고 비교하고 해도 가능했었음
		System.out.println(result); // 쓸데없는 메모리 낭비가 많음
	}

}