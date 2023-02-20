package b;

import java.util.*;
import java.io.*;

public class GasStation {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());	//이해 못함 연구 필요
		long city[] = new long[n - 1];
		long gasst[] = new long[n];
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < city.length; i++)
			city[i] = Long.parseLong(st.nextToken());
		st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < gasst.length; i++)
			gasst[i] = Long.parseLong(st.nextToken());
		System.out.println(gasstation(city, gasst));
	}

	public static long gasstation(long[] city, long[] gas) {
		long result = 0;
		long min = gas[0];
		for (int i = 0; i < city.length; i++) {
			if (gas[i] < min)
				min = gas[i];
			result += (min * city[i]);
		}
		return result;
	}
}
