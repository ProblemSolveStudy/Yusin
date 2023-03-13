import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    private int x;
    private int y;

    Node(int x, int y) {
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

class TestCase {
    private int n;

    TestCase(int n) throws IOException {
        this.n = n;
        test();
    }

    void test() throws IOException {
        for (int i = 0; i < n; i++) {
            B1012_NapaCabbage.st = new StringTokenizer(B1012_NapaCabbage.bf.readLine(), " ");
            NapaCabbage napacabbage = new NapaCabbage
                    (Integer.parseInt(B1012_NapaCabbage.st.nextToken()),
                            Integer.parseInt(B1012_NapaCabbage.st.nextToken()),
                            Integer.parseInt(B1012_NapaCabbage.st.nextToken()));
            napacabbage.ArrMake();
            napacabbage.bfs();
            napacabbage.OutPut();
        }

    }
}

class NapaCabbage {
    private Queue<Node> q = new LinkedList<>();
    private int m, n, k, result = 0;
    private int[][] arr;
    private int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    private boolean[][] check;

    NapaCabbage(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.arr = new int[m][n];
        this.check = new boolean[m][n];
    }

    void ArrMake() throws IOException {
        for (int i = 0; i < k; i++) {
            B1012_NapaCabbage.st = new StringTokenizer(B1012_NapaCabbage.bf.readLine());
            int a = Integer.parseInt(B1012_NapaCabbage.st.nextToken());
            int b = Integer.parseInt(B1012_NapaCabbage.st.nextToken());
            arr[a][b] = 1;
        }
    }

    void bfs() {
        for(int i=0 ; i<m;i++)
        {
            for(int j=0; j<n;j++)
            {
                if(arr[i][j]==0||check[i][j])
                    continue;
                q.add(new Node(i,j));
                check[i][j]=true;
                result++;
                while(!q.isEmpty())
                {
                    Node node = q.poll();
                    int x=node.getX();
                    int y=node.getY();
                    for(int k=0;k<4;k++)
                    {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if(nx>=0&&ny>=0&&nx<m&&ny<n)
                        {
                            if(arr[nx][ny]==1&&!check[nx][ny])
                            {
                                check[nx][ny]=true;
                                q.add(new Node(nx,ny));
                            }
                        }
                    }
                }
            }
        }
    }

    void OutPut() {
        System.out.println(result);
    }
}

public class B1012_NapaCabbage {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        TestCase testcase = new TestCase(Integer.parseInt(bf.readLine()));
        bf.close();
    }
}
