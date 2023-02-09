package sample1;

import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int h=Integer.MIN_VALUE;
		int c=Integer.MIN_VALUE;
		int a[]= new int[n];
		int b[]= new int[n];
		int cnt=0;
		for(int i=0;i<n;i++)
		{
			a[i]=(int) sc.nextInt();
			b[i]=(int) sc.nextInt();
			if(h<a[i])h=a[i];
			if(c<b[i])c=b[i];
		}

		int[][] s = new int[h+10][c+10];
		
		for(int i=0;i<n;i++)
		{
			for(int j=a[i];j<a[i]+10;j++)
			{
				for(int k=b[i];k<b[i]+10;k++)
				{
					s[j][k]=1;
				}
			}
		}
		for(int j=0;j<h+10;j++)
		{
			for(int k=0;k<c+10;k++)
			{
				if(s[j][k]==1)
					cnt++;
			}
		}
		System.out.println(cnt);
	}
}