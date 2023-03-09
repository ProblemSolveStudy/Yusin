import java.io.*;
import java.util.*;

class Node {
    private int x;
    private int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }
}

class Painting {
    private Queue<Node> q = new LinkedList<>();
    private int n, m, cnt = 0, result=0;
    private int[][] arr;
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    private boolean[][] check;

    Painting(int n, int m) {
        this.n = n;
        this.m = m;
        this.arr = new int[n][m];
        this.check = new boolean[n][m];
    }

    void ArrMake() throws IOException {
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(B1926_Painting.bf.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }


    void bfs() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j]==0||check[i][j])
                    continue;
                q.add(new Node(i,j));
                check[i][j]=true;
                cnt++;
                int temp=0;
                while (!q.isEmpty()) {
                    Node node = q.poll();
                    temp++;
                    int x = node.getX();
                    int y = node.getY();
                    for (int k = 0; k < 4; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                            if (arr[nx][ny] == 1 && !check[nx][ny]) {
                                q.add(new Node(nx, ny));
                                check[nx][ny] = true;
                            }
                        }
                    }
                }
                result = Math.max(temp,result);
            }
        }
    }

    void OutPut() {
        System.out.println(cnt);
        System.out.println(result);
    }
}

public class B1926_Painting {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        Painting painting = new Painting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        painting.ArrMake();
        painting.bfs();
        painting.OutPut();
        bf.close();
    }
}