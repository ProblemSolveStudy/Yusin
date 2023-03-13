import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
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

class FindingAnArea {
    private int m, n, k, result = 0, x1, x2, y1, y2;
    private int[][] arr;
    private boolean[][] check;
    private int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    private Queue<Node> q = new LinkedList<>();
    private PriorityQueue fq = new PriorityQueue();

    FindingAnArea() throws IOException {
        B2583_FindingAnArea.st = new StringTokenizer(B2583_FindingAnArea.bf.readLine(), " ");
        m = Integer.parseInt(B2583_FindingAnArea.st.nextToken());
        n = Integer.parseInt(B2583_FindingAnArea.st.nextToken());
        k = Integer.parseInt(B2583_FindingAnArea.st.nextToken());
        arr = new int[n][m];
        check = new boolean[n][m];
        for (int i = 0; i < k; i++)
            ArrMake();
        bfs();
        OutPut();
    }

    private void OutPut() {
        System.out.println(result);
        while (!fq.isEmpty())
            System.out.print(fq.poll() + " ");
    }

    private void bfs() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != 0 || check[i][j])
                    continue;
                q.add(new Node(i, j));
                check[i][j]=true;
                int cnt = 0;
                result++;
                while (!q.isEmpty()) {
                    Node node = q.poll();
                    int x = node.getX();
                    int y = node.getY();
                    for (int k = 0; k < 4; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                            if (arr[nx][ny] == 0 && !check[nx][ny]) {
                                q.add(new Node(nx, ny));
                                arr[nx][ny] = arr[x][y] + 1;
                                check[nx][ny] = true;
                                cnt++;
                            }
                        }
                    }
                }
                fq.add(cnt+1);
            }
        }
    }

    private void ArrP() throws IOException {
        B2583_FindingAnArea.st = new StringTokenizer(B2583_FindingAnArea.bf.readLine(), " ");
        x1 = Integer.parseInt(B2583_FindingAnArea.st.nextToken());
        x2 = Integer.parseInt(B2583_FindingAnArea.st.nextToken());
        y1 = Integer.parseInt(B2583_FindingAnArea.st.nextToken());
        y2 = Integer.parseInt(B2583_FindingAnArea.st.nextToken());
    }

    private void ArrMake() throws IOException {
        ArrP();
        for (int i = x1; i < y1; i++) {
            for (int j = x2; j < y2; j++) {
                arr[i][j] = 1;
            }
        }
    }
}

public class B2583_FindingAnArea {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        FindingAnArea fa = new FindingAnArea();
        bf.close();
    }
}
