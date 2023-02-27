package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class numlist2 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //어떤 자료구조형이여도 문제가 없음

		int n = Integer.parseInt(bf.readLine());							
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		while (st.hasMoreTokens())
			list.add(Integer.parseInt(st.nextToken()));
		list2.add(list.get(0));
		int lengthoflst = 1; 
		for (int i = 1; i < n; i++) {
			int key = list.get(i);

			if (list2.get(lengthoflst - 1) < key) {
				lengthoflst++;
				list2.add(lengthoflst-1, key);
			} else {
				int lo = 0;						//이분검색법
				int hi = lengthoflst;
				while (lo < hi) { 				//Low가High보다 작을때 반복
					int mid = (lo + hi) / 2;	// mid는 중간값을 저장함
					if (list2.get(mid) < key)	// 중간값이 키보다 크면 왼쪽을 버림
						lo = mid + 1;
					else						//중간값이 키보다 작으면 오른쪽을 버림
						hi = mid;
				}								//여기까지
				list2.set(lo, key);				//마지막에 add가 아닌 set(대치)를 하는 이유는 조건이 만족하지 않는 상태가 될 수 도 있는 경우 10 20 30 15가 주어진다고 가정하면
			}									//10 15 30이 나오는대 실제로는 10 20 30의 값이 출력되어야 맞기 때문이다.
		}										//어차피 이문제는 길이를 출력하는 거기 때문에 안에 내용물보다는 최대한 많은 값을 넣어야 하기 때문에 안에는 최대한 작은수가 오는게 더 좋은 조건이다.
		System.out.println(lengthoflst);		// 그러므로 길이를 구하는거에 한에서는 이분탐색을 사용하여서 풀어야한다.
	}
}
