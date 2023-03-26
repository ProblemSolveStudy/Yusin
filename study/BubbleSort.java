package ag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Bubble_Sort {
    private int n, temp;
    private int[] arr;

    Bubble_Sort() throws IOException {                      //오름차순 기준으로 정렬
        n = Integer.parseInt(BubbleSort.bf.readLine());
        arr = new int[n];
        ArrMake();
        // 시간 복잡도 O(n^2)
        for (int i = n - 1; i > 0; i--) {                   //배열갯수-1 ~ 0까지 반복
            for (int j = 0; j < i; j++) {                   // j번째 j+1번째의 값이 크기 순이 아니면 교환
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        OutPut();
    }

    private void ArrMake() throws IOException {
        BubbleSort.st = new StringTokenizer(BubbleSort.bf.readLine(), " ");
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(BubbleSort.st.nextToken());
    }

    private void OutPut() {                                                     //버블정렬의 과정
        for (int i = 0; i < n; i++)                                             //1. 첫번째 자료와 두번째 자료를, 두번째 자료와 세번째 자료를, 세번째와 네번째를,
            System.out.print(arr[i] + " ");                                     //... 이런 식으로 (마지막-1)번째 값와 마지막 값를 비교하여 교환하면서 값를 정리한다.
        System.out.println();                                                   //2. 1회전을 수행하고 나면 가장 큰 값이 맨 뒤로 이동하므로 2회전에서는 맨 끝에 있는 자료는 정렬에서 제외되고,
    }                                                                           //2회전을 수행하고 나면 끝에서 두번째 값까지는 정렬에서 제외된다.
}                                                                               //이렇게 정렬을 1회전 수행할 때마다 정렬에서 제외되는 데이터가 하나씩 늘어난다.

public class BubbleSort {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));//버블정렬의 장단점
    static StringTokenizer st;                                                      //장점 : 구현이 매우 간단하다

    public static void main(String[] args) throws IOException {                     //단점 : 1.순서에 맞지 않은 요소를 인접한 요소와 교환한다.
        Bubble_Sort bubble_sort = new Bubble_Sort();                                //      2.하나의 요소가 가장 왼쪽에서 가장 오른쪽으로 이동하기 위해서는 배열에서 모든 다른 요소들과 교환해야한다.
        bf.close();                                                                 //      3.특히 특정 요소가 최종 정렬 위치에 이미 있는 경우라도 교환되는 일이 일어난다.
    }
}
