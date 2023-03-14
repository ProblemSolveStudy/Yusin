package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class DFS3{
    private int n,m,r,cnt=0;
    private ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    private int[] check;
    private StringBuilder sb = new StringBuilder();

    DFS3() throws IOException{
        B24481_DFS3.st = new StringTokenizer(B24481_DFS3.bf.readLine()," ");
        n = Integer.parseInt(B24481_DFS3.st.nextToken());
        m = Integer.parseInt(B24481_DFS3.st.nextToken());
        r = Integer.parseInt(B24481_DFS3.st.nextToken());
        for(int i = 0 ; i<=n;i++)
            list.add(new ArrayList<Integer>());
        check = new int[n+1];
        for (int i = 0; i < check.length; i++)
            check[i]=-1;
        ArrMake();
        for(int i=1;i< list.size();i++)
            Collections.sort(list.get(i));
        dfs(r,0);
        OutPut();
    }

    private void dfs(int v,int cnt) {
        check[v] = cnt;
        for(int i = 0;i<list.get(v).size();i++)
        {
            int Arrnum = list.get(v).get(i);
            if(check[Arrnum]==-1) {
                dfs(Arrnum,cnt+1);
            }
        }

    }

    private void ArrMake() throws IOException {
        for(int i = 0; i<m;i++) {
            B24481_DFS3.st = new StringTokenizer(B24481_DFS3.bf.readLine(), " ");
            int a = Integer.parseInt(B24481_DFS3.st.nextToken());
            int b = Integer.parseInt(B24481_DFS3.st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

    }

    private void OutPut() {
        for(int i=1;i<=n;i++)
        {
            sb.append(check[i]).append("\n");
        }
        System.out.println(sb);
    }
}


public class B24481_DFS3 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        DFS3 dfs3 = new DFS3();
        bf.close();
    }
}
