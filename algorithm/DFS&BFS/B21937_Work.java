package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Work {
    private int n, m, w, result = 0;
    private ArrayList<ArrayList<Integer>> list=new ArrayList<>();
    private boolean[] check;

    Work() throws IOException {
        B21937_Work.st = new StringTokenizer(B21937_Work.bf.readLine(), " ");
        n = Integer.parseInt(B21937_Work.st.nextToken());
        for(int i = 0 ; i<=n;i++)
            list.add(new ArrayList<Integer>());
        m = Integer.parseInt(B21937_Work.st.nextToken());
        check = new boolean[n + 1];
        ArrMake();
        dfs(w);
        OutPut();
    }

    private void dfs(int w) {
        check[w] = true;
        for (int i = 0;i<list.get(w).size(); i++) {
            if (!check[list.get(w).get(i)]) {
                result++;
                dfs(list.get(w).get(i));
            }
        }
    }

    private void ArrMake() throws IOException {
        for (int i = 0; i < m; i++) {
            B21937_Work.st = new StringTokenizer(B21937_Work.bf.readLine(), " ");
            int a = Integer.parseInt(B21937_Work.st.nextToken());
            int b = Integer.parseInt(B21937_Work.st.nextToken());
            list.get(b).add(a);
        }
        w = Integer.parseInt(B21937_Work.bf.readLine());
    }

    private void OutPut() {
        System.out.println(result);
    }
}

public class B21937_Work {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        Work work = new Work();
        bf.close();
    }
}
