import java.io.*;
import java.util.StringTokenizer;

class Virus{

    private int[][] arr;
    private int x;
    private int y;
    private int result = 0;

    private boolean[] check;
    Virus(int n,int m)
    {
        this.x = n;
        this.y = m;
        this.arr = new int[n+1][n+1];
        this.check = new boolean[n+1];
    }
    void dfs(int v)
    {
        this.check[v]=true;
        result++;
        for(int i =1 ; i<=this.x;i++)
        {
            if(this.arr[v][i]==1&&!check[i]) {
                this.dfs(i);
            }
        }
    }
    void arrMake() throws IOException {
        for(int i = 0;i<y;i++)
        {
            StringTokenizer st = new StringTokenizer(B2606_Virus.bf.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            this.arr[a][b] = this.arr[b][a] = 1;
        }
    }
    int outPut(){
        return this.result;
    }
}

public class B2606_Virus {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        Virus vi = new Virus(Integer.parseInt(bf.readLine()),Integer.parseInt(bf.readLine()));
        vi.arrMake();
        vi.dfs(1);
        System.out.println(vi.outPut()-1);
        bf.close();
    }
}