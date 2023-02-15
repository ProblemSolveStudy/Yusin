package b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class coin {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(bf.readLine(), " "); // StringTokenizer로 띄어쓰기를 구분하여 저장
		int n = Integer.parseInt(st.nextToken());// StringTokenizer 구분하여 저장한걸 넣어줌
		int k = Integer.parseInt(st.nextToken());//                위와 동일
		Integer[] time = new Integer[n]; //받은갯수 만큼의 int형객체배열생성(Integer) 
		//Integer로 선언하는 이유 배열을 내림차순으로 정렬 할려고 할 때 Collections.reverseOrder() 사용을 할려면
		//객체배열로 선언해야하기 때문

		for (int i = 0; i < n; i++)
			time[i] = Integer.parseInt(bf.readLine()); // 입력받은 수를 배열에 저장
		Arrays.sort(time, Collections.reverseOrder()); // 배열을 내림차순으로 저장하는 함수 Collections.reverseOrder()
		System.out.println(coin(k, time));
		bf.close();
	}

	public static int coin(int num, Integer[] time) {
		int result = 0;
		for (int i = 0; i < time.length; i++) {
			while (num >= time[i]) { //num파라미터가 입력받은 값으로 나누어야하는대 넘보다 클경우 나눠지지 않는 불상사를 막기위해
				if (num < time[i]) //num파라미터가 입력받은 값으로 나누다가 num이 더 작아지면 나눌수 없기 때문에 조건을 줘서
					break;//while을 탈출 할 수 있게 만든다
				num -= time[i]; //나눌때 /로 나눌경우 카운트가 제대로 안되는 걸 막기위해 뺄때마다 카운트하여 출력하게 하기위함
				result += 1; //카운트값 (나눈횟수)
			}
		}
		return result;
	}
}
