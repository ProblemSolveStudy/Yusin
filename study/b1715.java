package algorithm;

import java.io.*;
import java.util.PriorityQueue;

public class b1715 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int n= Integer.parseInt(bf.readLine());
		for(int i=0;i<n;i++)
			pq.add(Integer.parseInt(bf.readLine()));
		int sum=0;
		while(pq.size() > 1)
		{
			int temp1 = pq.poll();
			int temp2 = pq.poll();
			
			sum+=temp1+temp2;
			pq.add(temp1+temp2);
		}
		System.out.println(sum);
	}
}