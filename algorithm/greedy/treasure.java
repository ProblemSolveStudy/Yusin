package b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class treasure {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int a[]= new int [n];
		Integer b[]= new Integer [n];
		StringTokenizer st = new StringTokenizer(bf.readLine()," ");
		for(int i=0; i<n;i++)
		{
			a[i]=Integer.parseInt(st.nextToken());
		}
		 st = new StringTokenizer(bf.readLine()," ");
		for(int i=0; i<n;i++)
		{
			
			b[i]=Integer.parseInt(st.nextToken());
		}
		System.out.println(treasure1(n,a,b));
	}
	public static int treasure1(int num,int arr1[],Integer arr2[])
	{
		int result=0;
		Arrays.sort(arr1); //오름차순
		Arrays.sort(arr2,Collections.reverseOrder());//내림차순
		for(int i=0;i<num;i++)
		{
			result+=arr1[i]*arr2[i];
		}
		return result;
	}
}
