import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    private int x;
    private int y;
    Node(int x,int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class SafetiZone{
    private int n,result=0,cnt=0;
    private int[][] arr;
    private boolean[][] check;
    private int[] dx = {-1,1,0,0},dy = {0,0,-1,1};
    SafetiZone() throws IOException {
        this.n = Integer.parseInt(Main.bf.readLine());
        this.arr = new int[n][n];
        this.check = new boolean[n][n];
        ArrMake();
        for(int i = 0 ;i<100;i++) {
            this.check = new boolean[n][n];
            result = Math.max(result, bfs(i));
        }
        OutPut();
    }

    private void OutPut() {
        System.out.println(result);
    }

    private void ArrMake() throws IOException {
        for(int i = 0 ; i<n;i++)
        {
            Main.st = new StringTokenizer(Main.bf.readLine()," ");
            for(int j = 0 ; j<n;j++)
                arr[i][j] = Integer.parseInt(Main.st.nextToken());
        }
    }

    private int bfs(int l){
        cnt=0;
        Queue<Node> q = new LinkedList<>();
        for(int i = 0 ; i<n ; i++)
        {
            for(int j = 0 ; j<n ; j++)
            {
                if(arr[i][j]<=l||check[i][j])
                    continue;
                q.add(new Node(i,j));
                cnt++;
                check[i][j]=true;
                while (!q.isEmpty())
                {
                    Node node = q.poll();
                    int x = node.getX();
                    int y = node.getY();
                    for(int k=0;k<4;k++)
                    {
                        int nx = x+dx[k];
                        int ny = y+dy[k];
                        if(nx>=0&&ny>=0&&nx<n&&ny<n)
                        {
                            if(arr[nx][ny]>l&&!check[nx][ny])
                            {
                                q.add(new Node(nx,ny));
                                check[nx][ny]=true;
                            }
                        }
                    }
                }
            }
        }
        return cnt;
    }
}
public class B2468_SafetiZone {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        SafetiZone sz = new SafetiZone();
        bf.close();
    }
}
