package algorithm;

import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class In
{
	public List<Integer> sysin(List<Integer> list) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String num = new String(bf.readLine());
		for(int i=1;i<=num.length();i++)
			list.add(num.charAt(num.length()-i)-'0');
		Collections.sort(list);
		return list;
	}
}

class Print{
	public void print(int n)
	{
			System.out.println(-1);
		return;
	}
	public void print(List<Integer> list)
	{
		for(int i=0;i<list.size();i++)
			System.out.print(list.get(i));
		return;
	}
}

class Fucking30{
	public void f30() throws IOException {
		In in = new In();
		List<Integer> list = new ArrayList<>();
		list = in.sysin(list);
		int sum= 0;
		for(int i =0;i<list.size();i++)
		{
			int cnt=10;
			if(i!=0)
			sum+=(list.get(i)*cnt);
			else
				sum+=list.get(i);
			cnt*=10;
		}
		Print pt = new Print();
		Collections.sort(list,Collections.reverseOrder());
		if(sum%30==0)
			pt.print(list);
		else
			pt.print(0);
	}
}

public class num30 {
	
	public static void main(String[] args) throws IOException {
		Fucking30 f30 = new Fucking30();
		f30.f30();
	}
}
