package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Dfs1 {
    private int cnt, n, m, v;
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    private int[] check;
    Dfs1() throws IOException {
        B24479_Dfs1.st = new StringTokenizer(B24479_Dfs1.bf.readLine(), " ");
        n = Integer.parseInt(B24479_Dfs1.st.nextToken());
        m = Integer.parseInt(B24479_Dfs1.st.nextToken());
        v = Integer.parseInt(B24479_Dfs1.st.nextToken());
        for(int i = 0 ; i<=n;i++)
            list.add(new ArrayList<Integer>());
        check = new int[n + 1];
        ArrMake();
        for(int i = 1; i<list.size();i++)
        {
            Collections.sort(list.get(i));
        }
        cnt=1;
        dfs(v);
        OutPut();
    }

    private void OutPut() {
        for(int i=1 ; i<check.length;i++)
            sb.append(check[i]).append("\n");
        System.out.println(sb);
    }


    private void ArrMake() throws IOException {
        for (int i = 0; i < m; i++) {
            B24479_Dfs1.st = new StringTokenizer(B24479_Dfs1.bf.readLine(), " ");
            int a = Integer.parseInt(B24479_Dfs1.st.nextToken());
            int b = Integer.parseInt(B24479_Dfs1.st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
    }

    private void dfs(int v) {
        check[v]=cnt;
        for (int i = 0; i<list.get(v).size(); i++) {
            if (check[list.get(v).get(i)]==0) {
                cnt++;
                dfs(list.get(v).get(i));
            }
        }
    }
}

public class B24479_Dfs1 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        Dfs1 dfs = new Dfs1();
        bf.close();
    }
}
