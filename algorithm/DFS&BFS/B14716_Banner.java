import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int x;
    int y;
    Node(int x , int y)
    {
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

class Banner{
    Queue<Node> q = new LinkedList();
    int m,n,result=0;
    boolean[][] check;
    int[][] arr;
    int[] dx = {-1,1,0,0,-1,-1,1,1},dy = {0,0,-1,1,-1,1,-1,1};

    Banner() throws IOException {
        B14716_Banner.st = new StringTokenizer(B14716_Banner.bf.readLine()," ");
        m = Integer.parseInt(B14716_Banner.st.nextToken());
        n = Integer.parseInt(B14716_Banner.st.nextToken());
        arr = new int[m][n];
        check = new boolean[m][n];
        ArrMake();
        bfs();
        OutPut();
    }

    private void bfs() {
        for(int i = 0;i<m;i++) {
            for (int j = 0; j < n; j++)
            {
                if(arr[i][j]==0||check[i][j])
                    continue;
                q.add(new Node(i,j));
                check[i][j]=true;
                result++;
                while(!q.isEmpty()) {
                    Node node = q.poll();
                    check[i][j] = true;
                    int x = node.getX();
                    int y = node.getY();
                    for (int k = 0; k < 8; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                            if (arr[nx][ny] == 1 && !check[nx][ny]) {
                                q.add(new Node(nx, ny));
                                check[nx][ny] = true;
                            }
                        }
                    }
                }
            }
        }

    }

    private void OutPut() {
        System.out.println(result);
    }

    private void ArrMake() throws IOException {
        for(int i=0;i<m;i++) {
            B14716_Banner.st = new StringTokenizer(B14716_Banner.bf.readLine(), " ");
            for(int j=0;j<n;j++)
                arr[i][j] = Integer.parseInt(B14716_Banner.st.nextToken());
        }

    }
}

public class B14716_Banner {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        Banner banner = new Banner();
        bf.close();
    }
}
