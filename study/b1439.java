package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1439 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		StringTokenizer st = new StringTokenizer(str, "1");
		StringTokenizer st1 = new StringTokenizer(str, "0");

		if (st.countTokens() < st1.countTokens())
			System.out.println(st.countTokens());
		else
			System.out.println(st1.countTokens());
	}
}
