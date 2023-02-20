package b;

import java.util.*;
import java.io.*;

public class GasStation {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		long city[] = new long[n - 1];
		long gasst[] = new long[n];
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < city.length; i++)
			city[i] = Long.parseLong(st.nextToken()); //각 주유소마다의 거리
		st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < gasst.length; i++)
			gasst[i] = Long.parseLong(st.nextToken()); //주유소의 기름 가격
		System.out.println(gasstation(city, gasst));
	}

	public static long gasstation(long[] city, long[] gas) {
		long result = 0;
		long min = gas[0];
		for (int i = 0; i < city.length; i++) {
			if (gas[i] < min) // 기름값이 제일 적은것 을 찾기위함
				min = gas[i];
			result += (min * city[i]);
		}
		return result;
	}
}
