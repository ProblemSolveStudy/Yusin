package algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class b1049 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		/*StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] line = new int[m][2];

		for (int i = 0; i < line.length; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			line[i][0] = Integer.parseInt(st.nextToken());
			line[i][1] = Integer.parseInt(st.nextToken());
		}

		int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE, result = 0;
		for (int i = 0; i < line.length; i++) {
			if (min1 > line[i][0])
				min1 = line[i][0];
			if (min2 > line[i][1])
				min2 = line[i][1];
		}
		while (n > 0) {
			if (min1 < min2 * n) {
				n -= 6;
				result += min1;
			} else {
				result += min2;
				n-=1;
			}
		}
		System.out.println(result);*/
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE, result = 0;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			min1 = Integer.min(num1, min1);
			min2 = Integer.min(num2,min2);
		}
		while (n > 0) {
			if (min1 < min2 * n&&min1*(n/6)<min2*n) { //정상 출력되었느나 반례가 있었음 로직문제
				result += min1;	//12 2
				n-=6;			//20 4
			} else {			//15 2    이것에 대한 값이 27로 출력됨 원래 결과 24가 정답 
				result += min2*n; //조건값이 낱개 곱하기 전체를 입력하면 어쩔수 없이 패키지가격보다 클 가능성이 다분함 하지만 패키지는 6개로 구성되어있어 문제가 발생함
				break;			// 그래서 조건값에 패키지최솟값*(n/6)<낱개최솟값*n 이 패키지를 사고 낱개를 구매하는것보다 낱개만 구매했을때 더 낮은가격을 찾게끔 만들어서 값을 출력해냄
			}
		}
		System.out.println(result);
	}
}