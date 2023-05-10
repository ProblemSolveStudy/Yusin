package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B138_LV6 {
    static final int INF = 987654321;
    public static int n, m;
    public static int[][] graph;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n + 1][n + 1];
        int result = INF;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                graph[i][j] = INF;
                if (i == j)
                    graph[i][j] = 0;
            }
        }
        //간선의 방향이 양방향이어야 함
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }
        //플로이드 와샬 알고리즘
        for (int i = 1; i <= n; i++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    //최단경로 초기화
                    if (graph[a][b] > graph[a][i] + graph[i][b])
                        graph[a][b] = graph[a][i] + graph[i][b];
                }
            }
        }
        int idx = -1;
        //가장 작은 인덱스를 탐색
        for (int i = 1; i <= n; i++) {
            int total = 0;
            for (int j = 1; j <= n; j++)
                total += graph[i][j];
            if (result > total) {
                result = total;
                idx = i;
            }
        }

        System.out.println(idx);
        bf.close();
    }
}
