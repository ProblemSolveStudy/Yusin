package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15486_Leave {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(bf.readLine());
        int arr[][] = new int[tc + 1][2];
        int dp[] = new int[tc + 1];
        int result = 0;
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());                   //t
            arr[i][1] = Integer.parseInt(st.nextToken());                   //p
        }
        for (int i = 0; i <= tc; i++) {                                     // 솔직히 잘 모르겠음
            result = Math.max(result, dp[i]);                               //일수를 더해서 그 일수에 값을 더해서 입력
            int nxt = i + arr[i][0];
            if (nxt <= tc) {
                dp[nxt] = Math.max(dp[nxt], result + arr[i][1]);
            }
        }
        System.out.println(dp[tc]);
        bf.close();
    }
}
