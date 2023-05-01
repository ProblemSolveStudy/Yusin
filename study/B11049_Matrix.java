package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11049_Matrix {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(bf.readLine());
        int dp[][] = new int[n][n];
        int data[] = new int[n + 1];
        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            data[i] = a;
            data[i + 1] = b;
        }
        for (int i = 2; i < n + 1; i++) { // 구간 간격
            for (int j = 0; j < n - i + 1; j++) { // 구간 시작점 j (0~n-i)) (i이기 때문에 구간의 시작 행렬은 0~ n-i까지 가능하다)
                dp[j][j + i - 1] = Integer.MAX_VALUE;
                for (int k = j; k < j + i - 1; k++) { // 중간 지점 k (j~ j+i-1)) (해당 구간의 곱셈 연산의 최솟값을 구한다.)
                    int value = dp[j][k] + dp[k + 1][j + i - 1] + (data[j] * data[k + 1] * data[j + i]);    // (j ~ k), (k+1 ~ j+i-1)의 행렬의 곱셈 연산 최솟값을 더해준다.
                    // (j ~ j+i-1)행렬의 곱셈이 이루어지면서 새로운 값을 더해준다.
                    dp[j][j + i - 1] = Math.min(dp[j][j + i - 1], value);
                }
            }
        }
        System.out.println(dp[0][n - 1]);
    }
}
