package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Arr {
	int num;
	int num1;

	Arr(int num2, int num3) {
		this.num = num2;
		this.num1 = num3;
	}
}

class Input {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	public int out() throws IOException {
		int num = Integer.parseInt(bf.readLine());
		return num;
	}

	public Arr[] out(int num) throws IOException {
		Arr[] arr = new Arr[num];
		for (int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			arr[i] = new Arr(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		return arr;
	}
}

class LectureTour1 {
	Input input = new Input();

	public long Out() throws IOException {
		long result = 0;
		int num = input.out();
		Arr[] arr = input.out(num);
		Arrays.sort(arr, (e1, e2) -> {
			if (e1.num == e2.num)
				return e2.num1 - e1.num1;
			else
				return e2.num - e1.num;
		});
		boolean[] check = new boolean[10001];
		for (int i = 0; i < num; i++) {
			for (int j = arr[i].num1; j >= 1; j--) {
				if (!check[j]) {
					check[j] = true;
					result += arr[i].num;
					break;
				}
			}
		}
		return result;
	}

}

public class LectureTour {

	public static void main(String[] args) throws IOException {
		LectureTour1 lecturetour1 = new LectureTour1();
		System.out.println(lecturetour1.Out());
	}
}
