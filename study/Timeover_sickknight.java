package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*class Sickknight {					//반례도 존재 할 것 같음 
	int n;								//모든 조건값을 찾다보니 시간이 초과된다.
	int m;
	int a = 0;
	int b = 0;
	int cnt = 1;

	Sickknight(int n, int m) {
		this.n = n;
		this.m = m;
	}

	public int sickKnight() {
		if (n <= 1)
			return cnt;
		else if (n > 1) {
			while (true) {
				if (a + 2 < n && b + 1 < m) {
					b += 1;
					a += 2;
					cnt++;
				} else if (a - 2 < n && a - 2 >= 0 && b + 1 < m) {
					b += 1;
					a -= 2;
					cnt++;
				} else if (a + 1 < n && b + 2 < m) {
					a += 1;
					b += 2;
					cnt++;
				} else if (a - 1 < n && a - 1 >= 0 && b + 2 < m) {
					b += 2;
					a -= 1;
					cnt++;
				} else
					break;
			}
		}
		if (cnt > 4) {
			a = 0;
			b = 0;
			cnt = 1;
			if (a + 2 <= n && b + 1 <= m) {
				cnt = 1;
				b = 0;
				a = 0;
				a += 2;
				b += 1;
				cnt++;
			} else
				return cnt;
			if (a + 1 <= n && b + 2 <= m) {
				a += 1;
				b += 2;
				cnt++;
			} else
				return cnt;
			if (b + 2 <= m && a - 1 <= n) {
				a -= 1;
				b += 2;
				cnt++;
			} else
				return cnt;
			if (a - 2 <= n && b + 1 <= m) {
				a -= 2;
				b += 1;
				cnt++;
			} else
				return cnt;
			while (true) {
				if (a + 2 < n && b + 1 < m) {
					b += 1;
					a += 2;
					cnt++;
				} else if (a - 2 < n && a - 2 >= 0 && b + 1 < m) {
					b += 1;
					a -= 2;
					cnt++;
				} else if (a + 1 < n && b + 2 < m) {
					a += 1;
					b += 2;
					cnt++;
				} else if (a - 1 < n && a - 1 >= 0 && b + 2 < m) {
					b += 2;
					a -= 1;
					cnt++;
				} else
					break;
			}
		}
		return cnt;
	}
}

public class Timeover_sickknight {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Sickknight sickknight = new Sickknight(n, m);
		System.out.println(sickknight.sickKnight());
	}
}*/
