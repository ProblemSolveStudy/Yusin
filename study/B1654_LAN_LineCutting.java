package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class LAN_LineCutting {
    private int[] arr;
    private int k, n;
    private long result = 0;

    LAN_LineCutting() throws IOException {
        B1654_LAN_LineCutting.st = new StringTokenizer(B1654_LAN_LineCutting.bf.readLine(), " ");
        k = Integer.parseInt(B1654_LAN_LineCutting.st.nextToken());
        n = Integer.parseInt(B1654_LAN_LineCutting.st.nextToken());
        ArrMake();
        linecutting();
        OutPut();
    }

    private void linecutting() {
        long s = 1, e = arr[k - 1];                     //제출시 자꾸 런타임에러 by zero에러가 떠서 1로 선언함
        while (s <= e) {                                //나머지는 나무자르기와 비슷한 매커니즘이지만 -가 /로만 바뀌었음
            long mid = (s + e) / 2;
            long temp = 0;
            for (int i = k - 1; i >= 0; i--) {
                if (arr[i] / mid > 0)
                    temp += arr[i] / mid;
                else
                    break;
            }
            if (temp < n) e = mid - 1;
            else {
                result = mid;
                s = mid + 1;
            }
        }
    }

    private void ArrMake() throws IOException {
        arr = new int[k];
        for (int i = 0; i < k; i++)
            arr[i] = Integer.parseInt(B1654_LAN_LineCutting.bf.readLine());
        Arrays.sort(arr);
    }

    private void OutPut() {
        System.out.println(result);
    }

}

public class B1654_LAN_LineCutting {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        LAN_LineCutting LAN_lineCutting = new LAN_LineCutting();
        bf.close();
    }
}
