import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class ConnectingElement
{
    private int n,m,result=0;
    private int[][] arr;
    private int[] dx = {-1,1,0,0},dy = {0,0,-1,1};
    private boolean[] check;
    ConnectingElement() throws IOException {
        Main.st = new StringTokenizer(Main.bf.readLine()," ");
        n = Integer.parseInt(Main.st.nextToken());
        m = Integer.parseInt(Main.st.nextToken());
        arr = new int[n+1][n+1];
        check = new boolean[n+1];
        ArrMake();
        for(int i=1;i<=n;i++) {
            if(!check[i]) {
                dfs(i);
                result++;
            }
        }
        OutPut();
    }

    private void OutPut() {
        System.out.println(result);
    }

    private void ArrMake() throws IOException {
        for(int i = 0; i <m;i++)
        {
            Main.st = new StringTokenizer(Main.bf.readLine()," ");
            int a = Integer.parseInt(Main.st.nextToken());
            int b = Integer.parseInt(Main.st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }
    }
    private void dfs(int v)
    {
        check[v]=true;
        for(int i=0;i<=n;i++)
        {
            if(arr[v][i]==1&&!check[i])
                dfs(i);
        }
    }
}
public class B11724_ConnectingElement {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        ConnectingElement ce = new ConnectingElement();
        bf.close();
    }
}
