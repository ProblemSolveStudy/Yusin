package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class DFS4{
    private int n,m,r,cnt=0;
    private int[] check;
    private ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    private StringBuilder sb  = new StringBuilder();

    DFS4()throws IOException{
        B24482_DFS4.st = new StringTokenizer(B24482_DFS4.bf.readLine()," ");
        n = Integer.parseInt(B24482_DFS4.st.nextToken());
        m = Integer.parseInt(B24482_DFS4.st.nextToken());
        r = Integer.parseInt(B24482_DFS4.st.nextToken());
        check = new int[n+1];
        for(int i =0 ; i<=n;i++)
        {
            check[i]=-1;
            list.add(new ArrayList<Integer>());
        }
        ArrMake();
        for(int i = 0;i< list.size();i++)
            Collections.sort(list.get(i),Collections.reverseOrder());
        dfs(r,0);
        OutPut();
    }

    private void dfs(int v, int cnt) {
        check[v]=cnt;
        for(int i=0;i<list.get(v).size();i++)
        {
            int Arrnum = list.get(v).get(i);
            if(check[Arrnum]==-1)
            {
                dfs(Arrnum,cnt+1);
            }
        }
    }

    private void ArrMake() throws IOException {
        for(int i = 0 ; i < m ; i++ )
        {
            B24482_DFS4.st = new StringTokenizer(B24482_DFS4.bf.readLine()," ");
            int a = Integer.parseInt(B24482_DFS4.st.nextToken());
            int b = Integer.parseInt(B24482_DFS4.st.nextToken());
            list.get(b).add(a);
            list.get(a).add(b);
        }
    }

    private void OutPut() {
        for(int i = 1 ; i < check.length;i++)
        {
            sb.append(check[i]).append("\n");
        }
        System.out.println(sb);
    }
}


public class B24482_DFS4 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        DFS4 dfs4 = new DFS4();
        bf.close();
    }
}
