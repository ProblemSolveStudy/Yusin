import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    private int x;
    private int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

class Apt {
    private Queue<Node> q = new LinkedList<>();
    private int n, result = 0;
    private int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    private boolean[][] check;
    private int[][] arr;
    private List<Integer> list = new ArrayList<>();

    Apt() throws IOException {
        this.n = Integer.parseInt(Main.bf.readLine());
        this.check = new boolean[n][n];
        this.arr = new int[n][n];
        ArrMake();
        bfs();
        OutPut();
    }

    void bfs() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0 || check[i][j])
                    continue;
                q.add(new Node(i, j));
                check[i][j] = true;
                result++;
                int cnt = 0;
                while (!q.isEmpty()) {
                    Node node = q.poll();
                    int x = node.getX();
                    int y = node.getY();
                    for (int k = 0; k < 4; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                            if (arr[nx][ny] == 1 && !check[nx][ny]) {
                                q.add(new Node(nx, ny));
                                arr[nx][ny] = arr[x][y] + 1;
                                check[nx][ny] = true;
                                ++cnt;
                            }
                        }
                    }
                }
                list.add(cnt + 1);
            }
        }

    }

    void ArrMake() throws IOException {
        for (int i = 0; i < n; i++) {
            String str = Main.bf.readLine();
            for (int j = 0; j < n; j++)
                arr[i][j] = str.charAt(j) - '0';
        }
    }

    void OutPut() {
        System.out.println(result);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }
}

public class B2667_Apt {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        Apt apt = new Apt();
        bf.close();
    }
}
