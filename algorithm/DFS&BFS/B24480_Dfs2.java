package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Dfs2 {
    private int cnt, n, m, v;
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    private int[] check;

    Dfs2() throws IOException {
        B24480_Dfs2.st = new StringTokenizer(B24480_Dfs2.bf.readLine(), " ");
        n = Integer.parseInt(B24480_Dfs2.st.nextToken());
        m = Integer.parseInt(B24480_Dfs2.st.nextToken());
        v = Integer.parseInt(B24480_Dfs2.st.nextToken());
        for (int i = 0; i <= n; i++)
            list.add(new ArrayList<Integer>());
        check = new int[n + 1];
        ArrMake();
        for (int i = 1; i < list.size(); i++) {
            Collections.sort(list.get(i), Collections.reverseOrder());
        }
        cnt = 1;
        dfs(v);
        OutPut();
    }

    private void OutPut() {
        for (int i = 1; i < check.length; i++)
            sb.append(check[i]).append("\n");
        System.out.println(sb);
    }


    private void ArrMake() throws IOException {
        for (int i = 0; i < m; i++) {
            B24480_Dfs2.st = new StringTokenizer(B24480_Dfs2.bf.readLine(), " ");
            int a = Integer.parseInt(B24480_Dfs2.st.nextToken());
            int b = Integer.parseInt(B24480_Dfs2.st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
    }

    private void dfs(int v) {
        check[v] = cnt;
        for (int i = 0; i < list.get(v).size(); i++) {
            if (check[list.get(v).get(i)] == 0) {
                cnt++;
                dfs(list.get(v).get(i));
            }
        }
    }
}


public class B24480_Dfs2 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        Dfs2 dfs2 = new Dfs2();
        bf.close();
    }
}
