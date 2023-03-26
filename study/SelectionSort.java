package ag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Selection_Sort {
    private int n, temp, least;
    private int[] arr;

    Selection_Sort() throws IOException {                               //오름차순 기준으로 정렬
        n = Integer.parseInt(SelectionSort.bf.readLine());                  //제자리 정렬 알고리즘의 하나
        arr = new int[n];
        ArrMake();
        // 시간 복잡도 O(n^2)
        for (int i = 0; i < n - 1; i++) {                          // 마지막 숫자는 자동정렬 되므로 배열최대 갯수-1이 된다.
            least = i;

            for (int j = i + 1; j < n; j++) {                      //최솟값을 탐색하는 포문
                if (arr[j] < arr[least])
                    least = j;
            }
            if (i != least) {                                      //최솟값이 본인이면 값을 치환하지 않음
                temp = arr[i];
                arr[i] = arr[least];
                arr[least] = temp;
            }
        }
        Output();
    }

    private void ArrMake() throws IOException {
        SelectionSort.st = new StringTokenizer(SelectionSort.bf.readLine(), " ");
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(SelectionSort.st.nextToken());
    }

    private void Output() {                                             //선택정렬의 과정
        for (int i = 0; i < n; i++)                                     //1. 주어진 배열 중에서 최솟값을 검색한다.
            System.out.print(arr[i] + " ");                             //2. 그 값을 맨 앞에 위차한 값과 교체한다.
        System.out.println();                                           //3. 맨 처음 위치를 뺀 배열을 같은 방법으로 교체한다.
    }                                                                   //4. 하나의 원소만 남을 때까지 위의 방법을 반복한다.
}

public class SelectionSort {                                                        //선택정렬의 장단점
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));//장점 : 자료 이동 횟수가 미리 결정된다.
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {                     //단점 : 1.안정성을 만족하지 않는다.
        Selection_Sort selection_sort = new Selection_Sort();                       //      2.즉, 값이 같은 레코드가 있는 경우에 상대적인 위치가 변경될 수 있다.
        bf.close();
    }
}
