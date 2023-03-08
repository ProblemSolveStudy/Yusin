import java.io.*;
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

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }

}

class Bfs {
    int n, m;
    int cnt = Integer.MIN_VALUE;
    int[][] arr;
    int[] nx = {-1, 1, 0, 0};
    int[] ny = {0, 0, -1, 1};

    Bfs(int n, int m, int[][] arr) {
        this.n = n;
        this.m = m;
        this.arr = arr;
    }

    public int bfs() {
        while (!B7576_Tomato.q.isEmpty()) {
            Node node = B7576_Tomato.q.poll();

            int x = node.getX();
            int y = node.getY();

            for (int i = 0; i < 4; i++) {
                int nx = x + this.nx[i];
                int ny = y + this.ny[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (arr[nx][ny] == 0) {
                        B7576_Tomato.q.add(new Node(nx, ny));                           //익을 수 있는 토마토라면 갯수를 증가시킨다.
                        arr[nx][ny] = arr[x][y] + 1;                                    //그리고 그노드정보를 큐에 넣는다
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0)                                                     //하나라도 0이 있으면 익지 않는다는 것이기 때문에 0일경우는 -1로 출력하여 익지 않는다고 알려준다.
                    return -1;
                cnt = Math.max(cnt, arr[i][j]);                                         //카운트에는 가진값이 최소경로를 출력해줘야 하기 때문이다.
            }
        }
        if (cnt == 1)
            return 0;
        return cnt - 1;
    }
}

public class B7576_Tomato {
    static Queue<Node> q = new LinkedList<Node>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1)                                                    //익어있는 토마토정보(노드)를 큐에 저장
                    q.add(new Node(i, j));
            }
        }
        Bfs bfs = new Bfs(n, m, arr);
        System.out.println(bfs.bfs());
    }
}
