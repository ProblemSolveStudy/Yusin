package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Eat {
    private int n, m, t;
    private Integer[] a, b;

    Eat() throws IOException {
        t = Integer.parseInt(B7795_Eat.bf.readLine());
        for (int i = 0; i < t; i++) {
            ArrMake();
            EatorEaten();
        }
    }

    private void ArrMake() throws IOException {
        B7795_Eat.st = new StringTokenizer(B7795_Eat.bf.readLine(), " ");
        n = Integer.parseInt(B7795_Eat.st.nextToken());
        m = Integer.parseInt(B7795_Eat.st.nextToken());
        a = new Integer[n];
        b = new Integer[m];
        B7795_Eat.st = new StringTokenizer(B7795_Eat.bf.readLine(), " ");
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(B7795_Eat.st.nextToken());
        B7795_Eat.st = new StringTokenizer(B7795_Eat.bf.readLine(), " ");
        for (int i = 0; i < m; i++)
            b[i] = Integer.parseInt(B7795_Eat.st.nextToken());
        Arrays.sort(b);                                                         //B배열을 비교하면 되기에 비만 정렬을함
    }

    public void EatorEaten() {                                                  //A배열을 B배열을 비굫는대 2분법을 사용해서 비교해야함(시간초과 오류로 인해서)
        int result = 0;
        for (int i = 0; i < n; i++) {
            int l = 0, h = m - 1, cnt = 0;
            while (l <= h) {
                int mid = (l + h) / 2;
                if (b[mid] < a[i]) {                                            //B배열을 정렬해놨기에 가능한 조건이다.
                    l = mid + 1;                                                //B배열의 비교하는 값보다 A의 값이 클경우만 증가시킨다.
                    cnt = mid + 1;
                } else {
                    h = mid - 1;
                }
            }
            result += cnt;                                                      //카운트가 집계되고 계산해야하는대 처음에 while안에 넣어놔서 값이 이상한 값이 나왔었음
        }
        System.out.println(result);
    }

}

public class B7795_Eat {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        Eat eat = new Eat();
        bf.close();
    }
}
