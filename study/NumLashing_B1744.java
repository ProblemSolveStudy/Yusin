package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Num {
	int n;
	List<Integer> list1 = new ArrayList<>();
	List<Integer> list2 = new ArrayList<>();

	Num(int n, List<Integer> list1,List<Integer> list2) {
		this.n = n;
		this.list1 = list1;
		this.list2 = list2;
	}

	public int num() {
		int result = 0;
		Collections.sort(list1,Collections.reverseOrder()); // 양수는 내림차순으로 정렬해서 계산해야해서
		Collections.sort(list2);							// 음수는 오름차순으로 정렬해서 계산해야해서
		for(int i=0;i<list1.size();)
		{
			if(list1.size()%2!=0&&i==list1.size()-1)
			{
				result += list1.get(i);
				i++;
			}	
			else if(list1.get(i)==1||list1.get(i+1)==1)
			{
				result+=list1.get(i);
				result+=list1.get(i+1);
				i+=2;
			}
			else
			{
				result += (list1.get(i)*list1.get(i+1));
				i+=2;
			}
		}
		for(int i=0;i<list2.size();)
		{
			if(list2.size()%2!=0&&i==list2.size()-1)
			{
				result += list2.get(i);
				i++;
			}
			else
			{
				result += (list2.get(i)*list2.get(i+1));
				i+=2;
			}
		}
		return result;
	}
}


public class NumLashing_B1744 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		List<Integer> list1 = new ArrayList<>(); //양수만 저장하는 리스트
		List<Integer> list2 = new ArrayList<>(); //음수만 저장하는 리스트
		
		int num1=0;
		for (int i = 0; i < n; i++)
		{
			num1=Integer.parseInt(bf.readLine());
			if(num1>0) 
			list1.add(num1);
			else
			list2.add(num1);
		}
		Num num = new Num(n, list1,list2);
		System.out.println(num.num());
	}
}
