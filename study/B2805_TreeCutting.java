package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Tree_Cutting {
    private int n, m, result;
    private int[] arr;

    Tree_Cutting() throws IOException {
        B2805_TreeCutting.st = new StringTokenizer(B2805_TreeCutting.bf.readLine(), " ");
        n = Integer.parseInt(B2805_TreeCutting.st.nextToken());
        m = Integer.parseInt(B2805_TreeCutting.st.nextToken());
        ArrMake();
        treecutting();
        OutPut();
    }

    private void treecutting() {
        int s = 0, e = arr[n - 1];
        while (s <= e) {
            int mid = (s + e) / 2;                  //이분 탐색을 위한 식
            long temp = 0;
            for (int i = n - 1; i >= 0; i--) {      //잘린 통나무의 길이를 측정하기위해
                if (arr[i] - mid > 0)               //잘린 통나무가 -로 떨어진다는건 자를 수 있는 통나무가 없기 때문
                    temp += arr[i] - mid;           //잘린통나무 길이저장
                else
                    break;                          //오름차순으로 정렬했기때문에 값이 -로 떨어지면 굳이 포문을 더 수행 할 필요가 없음
            }
            if (temp < m) e = mid - 1;              //잘린 통나무의 길이가 원하는 길이보다 작으면
            else {
                result = mid;                       //출력값은 mid가 됨
                s = mid + 1;                        //시작을 가운데보다 1높게 잡는다
            }
        }
    }

    private void ArrMake() throws IOException {
        arr = new int[n];
        B2805_TreeCutting.st = new StringTokenizer(B2805_TreeCutting.bf.readLine(), " ");
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(B2805_TreeCutting.st.nextToken());
        Arrays.sort(arr);
    }

    private void OutPut() {
        System.out.println(result);
    }
}

public class B2805_TreeCutting {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        Tree_Cutting tree_cutting = new Tree_Cutting();
        bf.close();
    }
}
